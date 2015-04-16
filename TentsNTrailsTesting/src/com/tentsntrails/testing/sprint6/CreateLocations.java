package com.tentsntrails.testing.sprint6;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.tentsntrails.testing.TentsNTrails;

/**
 * Creates some temporary testing data for Locations for Sprint 6 user stories.
 * @author Aaron Carson
 * @version Apr 13, 2015
 */

//@Category()
public class CreateLocations
{
	
	private WebDriver		driver;
	private String			baseUrl = TentsNTrails.URL; // ensure current URL is used
	private boolean			acceptNextAlert		= true;
	private StringBuffer	verificationErrors	= new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testCreateLocations() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("admin");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Locations")).click();
		driver.findElement(By.linkText("Add New")).click();
		driver.findElement(By.id("Label")).clear();
		driver.findElement(By.id("Label")).sendKeys(
				"Grand Canyon National Park (Testing)");
		driver.findElement(By.id("Latitude")).clear();
		driver.findElement(By.id("Latitude")).sendKeys("36.0553");
		driver.findElement(By.id("Longitude")).clear();
		driver.findElement(By.id("Longitude")).sendKeys("-112.1218");
		driver.findElement(By.id("Description")).clear();
		driver.findElement(By.id("Description"))
				.sendKeys(
						"The Grand Canyon is a steep-sided canyon carved by the Colorado River in the state of Arizona in the United States.");
		new Select(driver.findElement(By.id("Difficulty")))
				.selectByVisibleText("Easy");
		driver.findElement(By.id("RecOptions_0__IsChecked")).click();
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Add New")).click();
		driver.findElement(By.id("Label")).clear();
		driver.findElement(By.id("Label"))
				.sendKeys("Multnomah Falls (Testing)");
		driver.findElement(By.id("Latitude")).clear();
		driver.findElement(By.id("Latitude")).sendKeys("45.5760");
		driver.findElement(By.id("Longitude")).clear();
		driver.findElement(By.id("Longitude")).sendKeys("-122.1154");
		driver.findElement(By.id("Description")).clear();
		driver.findElement(By.id("Description"))
				.sendKeys(
						"Multnomah Falls is a waterfall on the Oregon side of the Columbia River Gorge, located east of Troutdale, between Corbett and Dodson, along the Historic Columbia River Highway.");
		driver.findElement(By.id("RecOptions_0__IsChecked")).click();
		new Select(driver.findElement(By.id("Difficulty")))
				.selectByVisibleText("Medium");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Add New")).click();
		driver.findElement(By.id("Label")).clear();
		driver.findElement(By.id("Label")).sendKeys(
				"Santiam State Forest (Testing)");
		driver.findElement(By.id("Latitude")).clear();
		driver.findElement(By.id("Latitude")).sendKeys("44.7165");
		driver.findElement(By.id("Description")).clear();
		driver.findElement(By.id("Description"))
				.sendKeys(
						"Santiam State Forest is one of six state forests managed by the Oregon Department of Forestry. The forest is located approximately 25 miles (40 km) southeast of Salem, Oregon, and includes 47,871 acres (193.73 km2).");
		new Select(driver.findElement(By.id("Difficulty")))
				.selectByVisibleText("Hard");
		driver.findElement(By.id("RecOptions_0__IsChecked")).click();
		driver.findElement(By.id("RecOptions_1__IsChecked")).click();
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Add New")).click();
		driver.findElement(By.id("Label")).clear();
		driver.findElement(By.id("Label")).sendKeys(
				"Silver Falls State Park (Testing)");
		driver.findElement(By.id("Latitude")).clear();
		driver.findElement(By.id("Latitude")).sendKeys("44.8512");
		driver.findElement(By.id("Longitude")).clear();
		driver.findElement(By.id("Longitude")).sendKeys("-122.6462");
		driver.findElement(By.id("Description")).clear();
		driver.findElement(By.id("Description"))
				.sendKeys(
						"Silver Falls State Park is a state park in the U.S. state of Oregon, located near Silverton, about 20 miles (32 km) east-southeast of Salem. It is the largest state park in Oregon with an area of more than 9,000 acres (36 km2).");
		new Select(driver.findElement(By.id("Difficulty")))
				.selectByVisibleText("Varies");
		driver.findElement(By.id("RecOptions_1__IsChecked")).click();
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Add New")).click();
		driver.findElement(By.id("Label")).clear();
		driver.findElement(By.id("Label")).sendKeys(
				"Zion National Park (Testing)");
		driver.findElement(By.id("Latitude")).clear();
		driver.findElement(By.id("Latitude")).sendKeys("37.2026");
		driver.findElement(By.id("Longitude")).clear();
		driver.findElement(By.id("Longitude")).sendKeys("-112.9878");
		driver.findElement(By.id("Description")).clear();
		driver.findElement(By.id("Description"))
				.sendKeys(
						"Zion National Park is located in the Southwestern United States, near Springdale, Utah. A prominent feature of the 229-square-mile (590 km2) park is Zion Canyon, which is 15 miles (24 km) long and up to half a mile (800 m) deep.");
		new Select(driver.findElement(By.id("Difficulty")))
				.selectByVisibleText("NA");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Log off")).click();
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
	
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}
		catch (NoSuchElementException e) {
			return false;
		}
	}
	
	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			}
			else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
