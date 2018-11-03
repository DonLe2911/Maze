package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import variables.*;

class Level2Test {

	private WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/Maze/level2.html");
	}

	@Test
	void isHeaderVisible() {
		WebElement header = driver.findElement(By.className(Selectors.header));
		assertTrue(header.isDisplayed());
	}

	@Test
	void areControlsVisible() {
		WebElement button_container = driver.findElement(By.className(Selectors.button_container));
		// id
		WebElement execute_button = driver.findElement(By.id(Selectors.execute_button));
		WebElement new_game_button = driver.findElement(By.id(Selectors.new_game_button));
		// id
		WebElement timer = driver.findElement(By.id(Selectors.timer_display));
		ArrayList<WebElement> webelements = new ArrayList<WebElement>();
		webelements.addAll(Arrays.asList(button_container, execute_button, new_game_button, timer));

		for (WebElement w : webelements) {
			assertTrue(w.isDisplayed());
		}
	}

	@Test
	void isInfoPanelVisible() {
		WebElement info_panel = driver.findElement(By.className(Selectors.info_panel_display));
		WebElement instructions = driver.findElement(By.className(Selectors.instructions_display));
		WebElement example = driver.findElement(By.className(Selectors.example_instructions));

		WebElement instructionsInputBox = driver.findElement(By.id(Selectors.instructions_input));

		ArrayList<WebElement> webelements = new ArrayList<WebElement>();
		webelements.addAll(Arrays.asList(info_panel, instructions, example, instructionsInputBox));

		for (WebElement w : webelements) {
			assertTrue(w.isDisplayed());
		}
	}

	@Test
	void isTimerRunning() {
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String timer = driver.findElement(By.id(Selectors.timer_display)).getText();
		String[] split = timer.split(":");
		assertEquals(true, Integer.parseInt(split[0]) > 0 || Integer.parseInt(split[1]) > 0);
	}

	void correctInstructionsLeadToNextPage() {
		String userInput = Tag.move_fw + "\n" + Tag.move_right + "\n" + Tag.move_left + "\n" + Tag.repeat + "\n"
				+ Tag.jump_right + "\n" + Tag.jump_fw;

		StringBuffer correctInput = new StringBuffer(userInput);

		WebElement instructionsInputBox = driver.findElement(By.id(Selectors.instructions_input));
		WebElement execute_button = driver.findElement(By.id(Selectors.execute_button));

		instructionsInputBox.sendKeys(correctInput);
		execute_button.click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
//		WebElement success_popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notification_modal")));
		WebElement success_button = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-success")));
		success_button.click();

//		WebElement success_button = driver.findElement(By.className("btn-success"));
//		success_button.click();
		assertEquals(true, driver.getCurrentUrl().contains(Tag.page_level3));

	}

	@AfterEach
	void close() {
		driver.close();
	}

}
