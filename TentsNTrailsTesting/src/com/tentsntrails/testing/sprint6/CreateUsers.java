package com.tentsntrails.testing.sprint6;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.tentsntrails.testing.TentsNTrails;

/**
 * This test case creates a new set of users.  It can only be run once per
 * database, as there is currently no way to delete users.
 * @author Aaron Carson
 * @version Apr 14, 2015
 */
public class CreateUsers
{
	private WebDriver		driver;
	private String			baseUrl;
	private boolean			acceptNextAlert		= true;
	private StringBuffer	verificationErrors	= new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = TentsNTrails.URL;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	/**
	 * Create some users.
	 * @throws Exception
	 */
	@Test
	public void testCreateUsers() throws Exception {
		driver.get(baseUrl + "/");
		
		// create: asenner
		driver.findElement(By.id("registerLink")).click();
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("asenner");
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("asenner@fake.com");
		driver.findElement(By.id("FirstName")).clear();
		driver.findElement(By.id("FirstName")).sendKeys("April");
		driver.findElement(By.id("LastName")).clear();
		driver.findElement(By.id("LastName")).sendKeys("Senner");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.id("ConfirmPassword")).clear();
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Password1!");
		driver.findElement(By.id("Private")).click();
		driver.findElement(By.id("RecOptions_0__IsChecked")).click();
		driver.findElement(By.id("RecOptions_1__IsChecked")).click();
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Log off")).click();

		// create: acarson
		driver.findElement(By.id("registerLink")).click();
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("acarson");
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("acarson@fake.com");
		driver.findElement(By.id("FirstName")).clear();
		driver.findElement(By.id("FirstName")).sendKeys("Aaron");
		driver.findElement(By.id("LastName")).clear();
		driver.findElement(By.id("LastName")).sendKeys("Carson");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.id("ConfirmPassword")).clear();
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Password1!");
		driver.findElement(By.id("RecOptions_0__IsChecked")).click();
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Log off")).click();
		
		// create: jpetersen
		driver.findElement(By.id("registerLink")).click();
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("jpetersen");
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("jpetersen@fake.com");
		driver.findElement(By.id("FirstName")).clear();
		driver.findElement(By.id("FirstName")).sendKeys("Jared");
		driver.findElement(By.id("LastName")).clear();
		driver.findElement(By.id("LastName")).sendKeys("Petersen");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.id("ConfirmPassword")).clear();
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Password1!");
		driver.findElement(By.id("RecOptions_1__IsChecked")).click();
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Log off")).click();
		
		// create: jgarcia
		driver.findElement(By.id("registerLink")).click();
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("jgarcia");
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("jgarcia@fake.com");
		driver.findElement(By.id("FirstName")).clear();
		driver.findElement(By.id("FirstName")).sendKeys("J.J.");
		driver.findElement(By.id("LastName")).clear();
		driver.findElement(By.id("LastName")).sendKeys("Garcia");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.id("ConfirmPassword")).clear();
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Password1!");
		driver.findElement(By.id("Private")).click();
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("jgarcia2");
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("jgarcia2@fake.com");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.id("ConfirmPassword")).clear();
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Password1!");
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
