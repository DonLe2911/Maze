package test;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.rowset.CachedRowSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import libs.SQLiteDriverConnection;
import variables.Tag;

class DatabaseTest {

	private Path currentPath, filePath;
	private SQLiteDriverConnection conn;

	@BeforeEach
	void setupPaths() {
		currentPath = Paths.get(System.getProperty("user.dir"), "dbTest");
		filePath = Paths.get(currentPath.toString(), Tag.db_file);
		System.out.println("DB File: " + Tag.db_file + " Path:" + filePath.toString());
		conn = new SQLiteDriverConnection(filePath.toString());
	}

	@AfterEach
	void destructConnection() {
		conn.closeConnection();
	}

	@Test
	void tableCreationTest() {
		assertDoesNotThrow(() -> conn.createTables());
	}

	@Test
	void userTableInsertionTest() {
		tableCreationTest();
		assertTrue(!conn.insertUser(""));
		assertTrue(conn.insertUser("john"));
		assertTrue(conn.insertUser("marc"));
		assertTrue(conn.insertUser("john"));
		assertTrue(conn.insertUser("peter"));
		assertTrue(conn.insertUser("marc"));
	}

	@Test
	void leaderBoardInsertionTest() {
		tableCreationTest();
		userTableInsertionTest();
		conn.insert("john", Tag.levels[0], 345);
		conn.insert("john", Tag.levels[1], 664);
		conn.insert("john", Tag.levels[2], 2312);

		conn.insert("marc", Tag.levels[0], 241);
		conn.insert("marc", Tag.levels[1], 678);
		conn.insert("marc", Tag.levels[2], 412);

		conn.insert("peter", Tag.levels[0], 890);
		conn.insert("peter", Tag.levels[1], 1453);

		CachedRowSet res1 = conn.selectTimeForGivenUserAndLevel("john", 1);
		CachedRowSet res2 = conn.selectTimeForGivenUserAndLevel("john", 2);

		CachedRowSet res3 = conn.selectTimeForGivenUserAndLevel("marc", 1);
		CachedRowSet res4 = conn.selectTimeForGivenUserAndLevel("marc", 3);

		CachedRowSet res5 = conn.selectTimeForGivenUserAndLevel("peter", 4);
		CachedRowSet res6 = conn.selectTimeForGivenUserAndLevel("peter", 5);

		List<CachedRowSet> rowsets = Arrays.asList(res1, res2, res3, res4, res5, res6);
		List<Boolean> validEntries = rowsets.stream().map(rs -> {
			try {
				return rs.first();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}).collect(Collectors.toList());

		List<Boolean> expected = Arrays.asList(true, true, true, true, false, false);
		assertTrue(expected.equals(validEntries));

		List<CachedRowSet> validrowsets = Arrays.asList(res1, res2, res3, res4);
		List<Integer> times = validrowsets.stream().map(rs -> {
			try {
				rs.first();
				return rs.getInt(1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return -1;
		}).collect(Collectors.toList());

//		List<Integer> expectedTimes = Arrays.asList(345, 664, 241, 412);
//		System.out.println(times);
//		assertTrue(expectedTimes.equals(times));

		// check if duplicate records with better timing are reflected in the db
		conn.insert("john", Tag.levels[1], 210); // level 2
		conn.insert("marc", Tag.levels[2], 65); // level 3

		res2 = conn.selectTimeForGivenUserAndLevel("john", 2);
		res4 = conn.selectTimeForGivenUserAndLevel("marc", 3);
		List<CachedRowSet> validrowsetsNewTimes = Arrays.asList(res1, res2, res3, res4);
		List<Integer> betterTimes = validrowsetsNewTimes.stream().map(rs -> {
			try {
				rs.first();
				return rs.getInt(1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return -1;
		}).collect(Collectors.toList());

		List<Integer> expectedTimesNewTimes = Arrays.asList(345, 210, 241, 65);
		assertTrue(expectedTimesNewTimes.equals(betterTimes));
	}

	@Test
	void leaderboardSelectAllUsersCompletedAllSumTimeTest() {
		tableCreationTest();
		userTableInsertionTest();

		conn.insert("john", Tag.levels[0], 345);
		conn.insert("john", Tag.levels[1], 210);
		conn.insert("john", Tag.levels[2], 2312);

		conn.insert("marc", Tag.levels[0], 241);
		conn.insert("marc", Tag.levels[1], 678);
		conn.insert("marc", Tag.levels[2], 65);

		conn.insert("peter", Tag.levels[0], 890);
		conn.insert("peter", Tag.levels[1], 1453);

		conn.insert("mary", Tag.levels[0], 50);
		conn.insert("mary", Tag.levels[2], 100);

		conn.insert("rose", Tag.levels[0], 200);
		conn.insert("rose", Tag.levels[1], 450);
		conn.insert("rose", Tag.levels[2], 300);
		conn.insert("rose", Tag.levels[2], 180);

		CachedRowSet results = conn.selectUsersCompletedAllLevelsTimeSum();
		ResultSetMetaData colmetadata = null;
		ArrayList<HashMap<String, Object>> rows = null; // to store the rows
		try {
			colmetadata = results.getMetaData();
			List<String> columns = new ArrayList<>();
			for (int i = 1; i <= colmetadata.getColumnCount(); i++) {
				columns.add(colmetadata.getColumnName(i));
			}

			rows = new ArrayList<HashMap<String, Object>>();

			while (results.next()) {
				HashMap<String, Object> row = new HashMap<>();
				for (String col : columns) {
					Object value = results.getObject(col);
					row.put(col, value);
				}
				rows.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// check that only the user who have completed all levels are in the leaderboard
		assertEquals(3, rows.size());
		for (HashMap<String, Object> row : rows) {
			int totalTime = Integer.parseInt(row.get("totalTime").toString());

			// check that sum is indeed equal to the sum of the times of all levels
			List<Integer> allLevelsSummed = Arrays.asList(row.get("level1"), row.get("level2"), row.get("level3"))
					.stream().map(e -> Integer.parseInt(e.toString())).collect(Collectors.toList());
			int expectedSum = allLevelsSummed.stream().reduce(0, Integer::sum);
			assertEquals(expectedSum, totalTime);

			// check that user is one of those who have completed all levels
			String userid = (String) row.get("userid");
			List<String> useridsCompletedAll = Arrays.asList("john", "marc", "rose");
			assertTrue(useridsCompletedAll.stream().anyMatch(entry -> userid.equals(entry)));

		}

	}

}
