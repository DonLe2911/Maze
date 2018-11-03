package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import variables.Selectors;
import variables.Tag;

class WelcomePage {
	
	private WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/Maze");
	}

	// header is displayed
	@Test
	void isHeaderDisplayed() {
		WebElement title = driver.findElement(By.className(Selectors.header));
		assertEquals(true, title.isDisplayed());
	}
	
	// logo lead to welcome page
	@Test
	void isLogoRedirecting() {
		WebElement logo = driver.findElement(By.id(Selectors.logo));
		logo.click();
		WebElement welcome_container = driver.findElement(By.id(Selectors.welcome));
		assertEquals(true, welcome_container.isDisplayed());
	}
	
	// play button leads to level 1
	@Test
	void isPlayWorking() {
		WebElement play_btn = driver.findElement(By.id(Selectors.play));
		play_btn.click();
		assertEquals(true, driver.getCurrentUrl().contains(Tag.page_level1));
	}
	
	// check video is showing
	@Test
	void test() {
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String video_time = driver.findElement(By.className(Selectors.video)).getAttribute("currentTime");
		assertEquals(true, Float.parseFloat(video_time) > 0);
	}
	
	@AfterEach
	void close() {
		driver.close();
	}

}
