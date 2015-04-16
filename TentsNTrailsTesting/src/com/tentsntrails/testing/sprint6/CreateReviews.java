package com.tentsntrails.testing.sprint6;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Adds Reviews for testing User Story 157.
 * 
 * @author Aaron Carson
 * @version Apr 14, 2015
 */
public class CreateReviews
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
	public void testAddReviews() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("loginLink")).click();
	    driver.findElement(By.id("UserName")).clear();
	    driver.findElement(By.id("UserName")).sendKeys("asenner");
	    driver.findElement(By.id("Password")).clear();
	    driver.findElement(By.id("Password")).sendKeys("Password1!");
	    driver.findElement(By.cssSelector("input.btn.btn-default")).click();
	    driver.findElement(By.linkText("Locations")).click();
	    driver.findElement(By.linkText("Grand Canyon National Park (Testing)")).click();
	    driver.findElement(By.linkText("first")).click();
	    driver.findElement(By.id("Rating")).click();
	    driver.findElement(By.id("Comment")).clear();
	    driver.findElement(By.id("Comment")).sendKeys("This is a nice canyon.");
	    driver.findElement(By.cssSelector("input.btn.btn-default")).click();
	    driver.findElement(By.linkText("Log off")).click();
	    driver.findElement(By.id("loginLink")).click();
	    driver.findElement(By.id("UserName")).clear();
	    driver.findElement(By.id("UserName")).sendKeys("jgarcia2");
	    driver.findElement(By.id("Password")).clear();
	    driver.findElement(By.id("Password")).sendKeys("Password1!");
	    driver.findElement(By.cssSelector("input.btn.btn-default")).click();
	    driver.findElement(By.linkText("Locations")).click();
	    driver.findElement(By.linkText("Grand Canyon National Park (Testing)")).click();
	    driver.findElement(By.linkText("Write New Review")).click();
	    driver.findElement(By.xpath("(//input[@id='Rating'])[2]")).click();
	    driver.findElement(By.id("Comment")).clear();
	    driver.findElement(By.id("Comment")).sendKeys("I don't like canyons.");
	    driver.findElement(By.cssSelector("input.btn.btn-default")).click();
	    driver.findElement(By.linkText("Log off")).click();
	    driver.findElement(By.id("loginLink")).click();
	    driver.findElement(By.id("UserName")).clear();
	    driver.findElement(By.id("UserName")).sendKeys("acarson");
	    driver.findElement(By.id("Password")).clear();
	    driver.findElement(By.id("Password")).sendKeys("Password1!");
	    driver.findElement(By.cssSelector("input.btn.btn-default")).click();
	    driver.findElement(By.linkText("Locations")).click();
	    driver.findElement(By.linkText("Grand Canyon National Park (Testing)")).click();
	    driver.findElement(By.linkText("Write New Review")).click();
	    driver.findElement(By.id("Rating")).click();
	    driver.findElement(By.id("Comment")).clear();
	    driver.findElement(By.id("Comment")).sendKeys("I go here every year with my parents.");
	    driver.findElement(By.cssSelector("input.btn.btn-default")).click();
	    driver.findElement(By.linkText("Log off")).click();
	    driver.findElement(By.id("loginLink")).click();
	    driver.findElement(By.id("UserName")).clear();
	    driver.findElement(By.id("UserName")).sendKeys("jpetersen");
	    driver.findElement(By.id("Password")).clear();
	    driver.findElement(By.id("Password")).sendKeys("Password1!");
	    driver.findElement(By.cssSelector("input.btn.btn-default")).click();
	    driver.findElement(By.linkText("Locations")).click();
	    driver.findElement(By.linkText("Grand Canyon National Park (Testing)")).click();
	    driver.findElement(By.linkText("Write New Review")).click();
	    driver.findElement(By.id("Rating")).click();
	    driver.findElement(By.id("Comment")).clear();
	    driver.findElement(By.id("Comment")).sendKeys("Sometimes I wish we'd all just get along.");
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
