package com.tentsntrails.testing.sprint5;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * This Test was automatically generated using Selenium IDE on 4/6/2015 This
 * tests whether the "Join Locations" functionality is working. It opens a
 * Firefox browswer, navigates to the baseUrl, logs in as "Admin", creates two
 * locations that are identical in everything but name, then merges the two.
 * 
 * @author J.J. Garcia    
 *
 */
public class MergeLocations
{
	private WebDriver		driver;
	private String			baseUrl;
	private boolean			acceptNextAlert		= true;
	private StringBuffer	verificationErrors	= new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://tentsntrails-test.azurewebsites.net/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testMergeLocations() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("Admin");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Locations")).click();
		driver.findElement(By.linkText("Add New")).click();
		driver.findElement(By.id("Label")).clear();
		driver.findElement(By.id("Label")).sendKeys("TempLocation");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Add New")).click();
		driver.findElement(By.id("Label")).clear();
		driver.findElement(By.id("Label")).sendKeys("MergedLocation");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Hello Admin!")).click();
		driver.findElement(By.linkText("Join Locations")).click();
		driver.findElement(By.id("SearchStringA")).clear();
		driver.findElement(By.id("SearchStringA")).sendKeys("TempLocation");
		driver.findElement(By.cssSelector("div > p > input[type=\"submit\"]"))
				.click();
		driver.findElement(By.id("SearchStringB")).clear();
		driver.findElement(By.id("SearchStringB")).sendKeys("MergedLocation");
		driver.findElement(By.xpath("//input[@value='Search Location B']"))
				.click();
		assertEquals("TempLocation", driver.findElement(By.xpath("//td[2]"))
				.getText());
		assertEquals(
				"MergedLocation",
				driver.findElement(By.xpath("//div[2]/table/tbody/tr[2]/td[2]"))
						.getText());
		driver.findElement(By.name("LocationA")).click();
		driver.findElement(By.name("LocationB")).click();
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("MergedLocation - tents n trails", driver.getTitle());
		assertEquals("Location A has been merged into Location B.", driver
				.findElement(By.cssSelector("p")).getText());
		driver.findElement(By.linkText("Locations")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Delete')])[3]"))
				.click();
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
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
