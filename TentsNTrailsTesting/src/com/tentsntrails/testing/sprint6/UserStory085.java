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
 * User Story # 85: As a user, I want to see the thumbs up reviews as green and
 * the thumbs down reviews as red so I can quickly see the overall rating of the
 * reviews in the list.
 * <p>
 * This test case is dependent on running CreateLocations first (it creates and
 * deletes it's own Reviews).
 * 
 * @author Aaron Carson
 * @version Apr 15, 2015
 */
public class UserStory085
{
	private WebDriver		driver;
	private String			baseUrl;
	private boolean			acceptNextAlert		= true;
	private StringBuffer	verificationErrors	= new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(TentsNTrails.FULLSCREEN_DIMENSION);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		baseUrl = TentsNTrails.URL;
	}
	
	/**
	 * Add review data needed to test this user story.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test00() throws Exception {
		driver.get(baseUrl + "/");
		String location = "Multnomah Falls (Testing)";
		
		// ----------------------------------------------
		// asenner: review
		// ----------------------------------------------
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("asenner");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		
		// goto location
		driver.findElement(By.linkText("Locations")).click();
		driver.findElement(By.name("searchString")).clear();
		driver.findElement(By.name("searchString")).sendKeys(location);
		driver.findElement(By.id("btn")).click();
		
		// make review
		driver.findElement(By.linkText("first")).click();
		driver.findElement(By.id("Rating")).click(); // upvote
		driver.findElement(By.id("Comment")).clear();
		driver.findElement(By.id("Comment")).sendKeys("I love waterfalls.");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Log off")).click();
		
		// ----------------------------------------------
		// jgarcia: review
		// ----------------------------------------------
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("jgarcia2");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		
		// goto location
		driver.findElement(By.linkText("Locations")).click();
		driver.findElement(By.name("searchString")).clear();
		driver.findElement(By.name("searchString")).sendKeys(location);
		driver.findElement(By.id("btn")).click();
		
		// make review
		driver.findElement(By.linkText("Write New Review")).click();
		driver.findElement(By.xpath("(//input[@id='Rating'])[2]")).click(); // downvote
		driver.findElement(By.id("Comment")).clear();
		// no comment
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Log off")).click();
		
		// ----------------------------------------------
		// acarson: review
		// ----------------------------------------------
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("acarson");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		
		// goto location
		driver.findElement(By.linkText("Locations")).click();
		driver.findElement(By.name("searchString")).clear();
		driver.findElement(By.name("searchString")).sendKeys(location);
		driver.findElement(By.id("btn")).click();
		
		// write review
		driver.findElement(By.linkText("Write New Review")).click();
		driver.findElement(By.id("Rating")).click(); // upvote
		driver.findElement(By.id("Comment")).clear();
		// no comment
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Log off")).click();
		
		// ----------------------------------------------
		// jpetersen: review
		// ----------------------------------------------
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("jpetersen");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		
		// goto location
		driver.findElement(By.linkText("Locations")).click();
		driver.findElement(By.name("searchString")).clear();
		driver.findElement(By.name("searchString")).sendKeys(location);
		driver.findElement(By.id("btn")).click();
		
		// write review
		driver.findElement(By.linkText("Write New Review")).click();
		driver.findElement(By.xpath("(//input[@id='Rating'])[2]")).click(); // downvote
		driver.findElement(By.id("Comment")).clear();
		driver.findElement(By.id("Comment")).sendKeys(
				"Trees just are not my thing.");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Log off")).click();
		
	}
	
	/**
	 * 1. When viewing the Location Details view for “Multnomah Falls”, there
	 * exist three reviews, which are displayed in the Review section.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test01() throws Exception {
		
		// search for location via main page
		driver.get(baseUrl + "/");
		driver.findElement(By.name("searchString")).clear();
		driver.findElement(By.name("searchString")).sendKeys(
				"Multnomah Falls (Testing)");
		driver.findElement(By.id("btn")).click();
		
		// verify that two reviews exist
		try {
			assertTrue("Needs 1st review ", isElementPresent(By.id("review")));
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertTrue("Needs 2nd review",
					isElementPresent(By.xpath("(//div[@id='review'])[2]")));
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
		// verify 3rd element does not exist
		try {
			assertFalse("Should only show two reviews",
					isElementPresent(By.xpath("(//div[@id='review'])[3]")));
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
	}
	
	/**
	 * 2. When viewing the Location Details view for “Multnomah Falls”,
	 * asenner’s thumb icon (from the first review) is displayed in green.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test02() throws Exception {
		
		// search for location via main page
		driver.get(baseUrl + "/");
		driver.findElement(By.name("searchString")).clear();
		driver.findElement(By.name("searchString")).sendKeys(
				"Multnomah Falls (Testing)");
		driver.findElement(By.id("btn")).click();
		
		// assert thumbs colors.
		try {
			assertTrue("Thumbs up reviews should be green.  ",
					reviewDivContainsColoredSpanAtIndex(1, "green", "up"));
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
	}
	
	/**
	 * 3. When viewing the Location Details view for “Multnomah Falls”,
	 * acarson's thumb icon (from the second review) is displayed in red.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test03() throws Exception {
		
		// search for location via main page
		driver.get(baseUrl + "/");
		driver.findElement(By.name("searchString")).clear();
		driver.findElement(By.name("searchString")).sendKeys(
				"Multnomah Falls (Testing)");
		driver.findElement(By.id("btn")).click();
		
		// assert thumbs colors.
		try {
			assertTrue("Thumbs down reviews should be red.  ",
					reviewDivContainsColoredSpanAtIndex(2, "red", "down"));
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
	}
	
	public boolean reviewDivContainsColoredSpanAtIndex(int index, String color,
			String thumbs) {
		try {
			WebElement span = driver.findElement(By
					.xpath("(//div[@id='review']/span)[" + index + "]"));
			
			boolean spanColor = span.getAttribute("class").contains(color);
			boolean matchThumbs = span.getAttribute("class").contains(
					"glyphicon-thumbs-" + thumbs);
			return spanColor && matchThumbs;
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
			return false;
		}
	}
	
	private boolean reviewDivContainsColoredSpanAtIndex(int index, String color) {
		try {
			WebElement e1 = driver.findElement(By.id("review"));
			WebElement e2 = e1.findElement(By.tagName("span"));
			boolean itemColor = (e2.getAttribute("class").contains("green")) ? true
					: false;
			return itemColor;
		}
		catch (NoSuchElementException ex) {
			return false;
		}
	}
	
	/**
	 * Remove Review data needed to test this user story.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test99() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("asenner");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Hello asenner!")).click();
		driver.findElement(By.linkText("My Reviews")).click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Log off")).click();
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("jgarcia2");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Hello jgarcia2!")).click();
		driver.findElement(By.linkText("My Reviews")).click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Log off")).click();
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("acarson");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Hello acarson!")).click();
		driver.findElement(By.linkText("My Reviews")).click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Log off")).click();
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("jpetersen");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Hello jpetersen!")).click();
		driver.findElement(By.linkText("My Reviews")).click();
		driver.findElement(By.linkText("Delete")).click();
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
	
	private boolean isElementPresentContainingText(By by, String text) {
		try {
			String eText = driver.findElement(By.xpath("//dd[4]")).getText();
			return eText.contains("Hiking");
		}
		catch (NoSuchElementException ex) {
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
