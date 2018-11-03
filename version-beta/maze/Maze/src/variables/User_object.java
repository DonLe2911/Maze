package variables;

import java.util.ArrayList;
import java.util.List;

public class User_object {
	private String bestTimeForLevel;
	private String totalTime;
	private String username;
	private List<String> timesPerLevel;
	
	public User_object() {
		this.timesPerLevel = new ArrayList<>();
	}

	public String getBestTimeForLevel() {
		return bestTimeForLevel;
	}

	public String getTotalTime() {
		return totalTime;
	}
	
	public String getUsername() {
		return username;
	}

	public List<String> getTimesPerLevel() {
		return timesPerLevel;
	}
	
	public void setBestTimeForLevel(String bestTimeForLevel) {
		this.bestTimeForLevel = bestTimeForLevel;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void addTimeForLevel(String timeForLevel) {
		this.timesPerLevel.add(timeForLevel);
	}
}
