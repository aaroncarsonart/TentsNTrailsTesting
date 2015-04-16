package com.tentsntrails.testing.sprint6;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.tentsntrails.testing.TentsNTrails;

/**
 * User Story # 130: As a user, I want to jump directly to the Location Details 
 * page when a search has only one result so that I can access the content I 
 * care about more quickly.
 * 
 * @author Aaron Carson
 * @version Apr 14, 2015
 */
public class UserStory130
{

	private static int		TIMEOUT				= 10;
	
	private WebDriver		driver;
	private String			baseUrl;
	private boolean			acceptNextAlert		= true;
	private StringBuffer	verificationErrors	= new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		baseUrl = TentsNTrails.URL;
		driver = new FirefoxDriver();
		driver.manage().window().setSize(TentsNTrails.FULLSCREEN_DIMENSION);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		// driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
	
	/**
	 * 1. On the Location index view, after selecting “All” from the the “View
	 * by” drop down menu, when “” is searched, the Location index view loads,
	 * displaying all five locations.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.linkText("Locations")).click();
		driver.findElement(By.id("dropdownMenu1")).click();
		driver.findElement(By.linkText("All")).click();
		driver.findElement(By.id("btn")).click();
		int searchResultsCount = driver.findElements(
				By.xpath("//a[contains(text(),'View Media')]")).size();
		assertTrue("Search results must contain at least 5 elements",
				searchResultsCount >= 5);
	}
	
	/**
	 * 2. On the Location index view, after selecting “All” from the the “View
	 * by” drop down menu, when “Park” is searched, the Location index view
	 * loads, displaying three locations: “Grand Canyon National Park”, “ Silver
	 * Falls State Park”, and “Zion National Park.”
	 * 
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		driver.get(baseUrl + "/Location");
		driver.findElement(By.linkText("Locations")).click();
		driver.findElement(By.id("dropdownMenu1")).click();
		driver.findElement(By.linkText("All")).click();
		driver.findElement(By.name("searchString")).clear();
		driver.findElement(By.name("searchString")).sendKeys("Park");
		driver.findElement(By.id("btn")).click();
		assertLinkTextPresent("Grand Canyon National Park (Testing)");
		assertLinkTextPresent("Silver Falls State Park (Testing)");
		assertLinkTextPresent("Zion National Park (Testing)");
	}
	
	/**
	 * 3. On the Location index view, after selecting “All” from the the “View
	 * by” drop down menu, when “Silver Falls” is searched, the Location Details
	 * view for “Silver Falls State Park” loads.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		assertPageTitleContainsSearchQuery("Silver Falls State Park (Testing)");
	}
	
	/**
	 * 4. On the Location index view, after selecting “All” from the the “View
	 * by” drop down menu, when “Santiam State Forest” is searched, the Location
	 * Details view for “Santiam State Forest” loads.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		assertPageTitleContainsSearchQuery("Santiam State Forest (Testing)");
	}
	
	public void assertPageTitleContainsSearchQuery(String title) {
		driver.get(baseUrl + "/Location");
		driver.findElement(By.linkText("Locations")).click();
		driver.findElement(By.id("dropdownMenu1")).click();
		driver.findElement(By.linkText("All")).click();
		driver.findElement(By.name("searchString")).clear();
		driver.findElement(By.name("searchString")).sendKeys(title);
		driver.findElement(By.id("btn")).click();
		if (!driver.getTitle().contains(title)) {
			fail("title of page must contain " + title);
		}
	}
	
	/**
	 * 5. On the Location index view, after selecting “All” from the the “View
	 * by” drop down menu, when “Niagara Falls” is searched, the Location Index
	 * view is displayed, showing zero results.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception {
		driver.get(baseUrl + "/Location");
		driver.findElement(By.linkText("Locations")).click();
		driver.findElement(By.id("dropdownMenu1")).click();
		driver.findElement(By.linkText("All")).click();
		driver.findElement(By.name("searchString")).clear();
		driver.findElement(By.name("searchString")).sendKeys("Niagara Falls");
		driver.findElement(By.id("btn")).click();
		assertLinkTextNotPresent("Grand Canyon National Park (Testing)");
		assertLinkTextNotPresent("Silver Falls State Park (Testing)");
		assertLinkTextNotPresent("Zion National Park (Testing)");
		assertLinkTextNotPresent("Multnomah Falls (Testing)");
		assertLinkTextNotPresent("Santiam State Forest (Testing)");
	}
	
	/**
	 * 6. On the Location index view, after selecting “Hiking” from the the
	 * “View by” drop down menu, when “Park” is searched, the Location Details
	 * view for “Grand Canyon National Park” loads.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test6() throws Exception {
		String viewBy = "Hiking"; // View By button
		String query = "Park"; // Search query
		
		driver.get(baseUrl + "/Location");
		driver.findElement(By.linkText("Locations")).click();
		driver.findElement(By.id("dropdownMenu1")).click();
		driver.findElement(By.linkText(viewBy)).click();
		driver.findElement(By.name("searchString")).clear();
		driver.findElement(By.name("searchString")).sendKeys(query);
		driver.findElement(By.id("btn")).click();
		assertLinkTextPresent("Grand Canyon National Park (Testing)");
		assertLinkTextNotPresent("Silver Falls State Park (Testing)");
		assertLinkTextNotPresent("Zion National Park (Testing)");
		assertLinkTextNotPresent("Multnomah Falls (Testing)");
	}
	
	/**
	 * 7. On the Location index view, after selecting “Hiking” from the the
	 * “View by” drop down menu, when “Silver Falls” is searched, the location
	 * Index view is displayed, showing zero results.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test7() throws Exception {
		String viewBy = "Hiking"; // View By button
		String query = "Silver Falls State Park (Testing)"; // Search query
		
		driver.get(baseUrl + "/Location");
		driver.findElement(By.linkText("Locations")).click();
		driver.findElement(By.id("dropdownMenu1")).click();
		driver.findElement(By.linkText(viewBy)).click();
		driver.findElement(By.name("searchString")).clear();
		driver.findElement(By.name("searchString")).sendKeys(query);
		driver.findElement(By.id("btn")).click();
		assertLinkTextNotPresent("Grand Canyon National Park (Testing)");
		assertLinkTextNotPresent("Silver Falls State Park (Testing)");
		assertLinkTextNotPresent("Zion National Park (Testing)");
		assertLinkTextNotPresent("Multnomah Falls (Testing)");
		assertLinkTextNotPresent("Santiam State Forest (Testing)");
	}
	
	/**
	 * Positive test for link text.
	 * 
	 * @param s
	 */
	public void assertLinkTextPresent(String s) {
		assertTrue(s, isElementPresent(By.linkText(s)));
	}
	
	/**
	 * Negative test for link text.
	 * 
	 * @param s
	 */
	public void assertLinkTextNotPresent(String s) {
		assertFalse(s, isElementPresent(By.linkText(s)));
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
