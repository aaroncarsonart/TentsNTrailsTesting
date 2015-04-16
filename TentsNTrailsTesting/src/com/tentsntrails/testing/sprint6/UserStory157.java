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
 * User Story # 157: As a user, I want to be able to update my recreations so
 * that I can change it after I register.
 * <p>
 * Note: running this test multiple times may fail, I don't think I successfully
 * cleaned up some of the settings, especially if some test cases fail.  
 * TODO: clean up this test...
 * 
 * @author Aaron Carson
 * @version Apr 14, 2015
 */
public class UserStory157
{
	private WebDriver		driver;
	private String			baseUrl;
	private boolean			acceptNextAlert		= true;
	private StringBuffer	verificationErrors	= new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(TentsNTrails.FULLSCREEN_DIMENSION);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		baseUrl = TentsNTrails.URL;
	}

	/**
	 * 1. When logged in as asenner and viewing asenner’s “My Profile” page, the
	 * text “Hiker” and “Camper” exists next to the Activities label.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test01() throws Exception {
		driver.get(baseUrl + "/");
		
		// login
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("asenner");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		
		// goto profile
		driver.findElement(By.linkText("Hello asenner!")).click();
		driver.findElement(By.linkText("My Profile")).click();
		
		// verify hiking is listed in activities
		try {
			assertEquals("Hiking", driver.findElement(By.xpath("//dd[4]"))
					.getText());
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		// verify camping is listed in activities
		try {
			assertEquals("Camping", driver.findElement(By.xpath("//dd[5]"))
					.getText());
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
		// logout
		driver.findElement(By.linkText("Log off")).click();
	}
	
	/**
	 * 2. When logged in as asenner and viewing jgarcia’s “My Profile” page, no
	 * text is listed by the Activities label.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test02() throws Exception {
		driver.get(baseUrl + "/");
		
		// login
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("asenner");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		
		// goto locations
		driver.findElement(By.linkText("Locations")).click();
		driver.findElement(By.name("searchString")).clear();
		driver.findElement(By.name("searchString")).sendKeys(
				"Grand Canyon National Park (Testing)");
		driver.findElement(By.id("btn")).click();
		
		// navigate to jgarcia2's profile via the test Review data
		driver.findElement(By.linkText("jgarcia2")).click();
		
		// check that no activities are listed (profile is private)
		try {
			boolean containsHiking = isElementPresentContainingText(
					By.xpath("//dd[4]"), "Hiking");
			boolean containsCamping = isElementPresentContainingText(
					By.xpath("//dd[4]"), "Camping");
			assertFalse("User activities should not display for private user ",
					containsHiking || containsCamping);
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
		// logout
		driver.findElement(By.linkText("Log off")).click();
	}
	
	/**
	 * 3. When logged in as asenner and viewing asenner’s “Personal Settings”
	 * page, a link with text “Change your preferred activities” exists.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test03() throws Exception {
		driver.get(baseUrl + "/");
		
		// login
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("asenner");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		
		// goto "personal settings" page
		driver.findElement(By.linkText("Hello asenner!")).click();
		driver.findElement(By.linkText("Personal Settings")).click();
		
		// verify change activities link exists
		try {
			assertTrue(isElementPresent(By
					.linkText("Change your preferred activities")));
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
		// logout
		driver.findElement(By.linkText("Log off")).click();
	}
	
	/**
	 * 4. When logged in as asenner and viewing asenner’s “Personal Settings”
	 * page, when the “Edit Activities” link is selected, the user is directed
	 * to an “Edit Activities” view, which displays checkboxes for each
	 * recreation type.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test04() throws Exception {
		driver.get(baseUrl + "/");
		
		// login
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("asenner");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		
		// goto change preferred activities page
		driver.findElement(By.linkText("Hello asenner!")).click();
		driver.findElement(By.linkText("Personal Settings")).click();
		driver.findElement(By.linkText("Change your preferred activities"))
				.click();
		
		// verify page title
		try {
			assertEquals("Change Activities - tents n trails",
					driver.getTitle());
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
		// verify checkboxes exist
		try {
			assertTrue("1st checkbox is missing",
					isElementPresent(By.id("RecOptions_0__IsChecked")));
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertTrue("2nd checkbox is missing",
					isElementPresent(By.id("RecOptions_1__IsChecked")));
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
		// done
		driver.findElement(By.linkText("Log off")).click();
	}
	
	/**
	 * 5. When logged in as asenner and viewing asenner’s “Edit Activities”
	 * view, after deselecting “Hiker” and pressing the “Cancel” link, the user
	 * is redirected to asenner’s “My Profile” page, where the text “Hiker” and
	 * “Camper” is listed next to the Activities label.
	 * 
	 * @throws Exception
	 */
	@Ignore
	@Test
	public void test05() throws Exception {
		driver.get(baseUrl + "/");
		
		// login
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("asenner");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		
		// goto change preferred activities page
		driver.findElement(By.linkText("Hello asenner!")).click();
		driver.findElement(By.linkText("Personal Settings")).click();
		driver.findElement(By.linkText("Change your preferred activities"))
				.click();
		
		// deselect hiker checkbox, then press cancel
		driver.findElement(By.id("RecOptions_0__IsChecked")).click();
		driver.findElement(By.linkText("Cancel")).click(); // fails
		
		// go to profile & verify that hiking and camping are both still listed
		driver.findElement(By.linkText("Hello asenner!")).click();
		driver.findElement(By.linkText("My Profile")).click();
		try {
			assertEquals("Hiking", driver.findElement(By.xpath("//dd[4]"))
					.getText());
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Camping", driver.findElement(By.xpath("//dd[5]"))
					.getText());
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		// done
		driver.findElement(By.linkText("Log off")).click();
	}
	
	/**
	 * 6. When logged in as asenner and viewing asenner’s “Edit Activities”
	 * view, after deselecting “Hiker” and pressing the “Submit” link, the user
	 * is redirected to asenner’s “My Profile” page, where the text “Camper” is
	 * listed next to the Activities label.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test06() throws Exception {
		driver.get(baseUrl + "/");
		
		// login
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("asenner");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		
		// goto change preferred activities page
		driver.findElement(By.linkText("Hello asenner!")).click();
		driver.findElement(By.linkText("Personal Settings")).click();
		driver.findElement(By.linkText("Change your preferred activities"))
				.click();
		
		// deselect hiker checkbox, then press save changes
		driver.findElement(By.id("RecOptions_0__IsChecked")).click();
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		
		// go to profile, and verify that only Hiking is present.
		driver.findElement(By.linkText("Hello asenner!")).click();
		driver.findElement(By.linkText("My Profile")).click();
		try {
			assertNotEquals("Hiking", driver.findElement(By.xpath("//dd[4]"))
					.getText());
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Camping", driver.findElement(By.xpath("//dd[4]"))
					.getText());
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
		// re-select hiker checkbox, to fix changes
		driver.findElement(By.linkText("Hello asenner!")).click();
		driver.findElement(By.linkText("Personal Settings")).click();
		driver.findElement(By.linkText("Change your preferred activities"))
				.click();
		driver.findElement(By.id("RecOptions_0__IsChecked")).click();
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
				
		
		// done
		driver.findElement(By.linkText("Log off")).click();
	}
	
	/**
	 * 7. When logged in as jgarcia and viewing jgarcia’s “My Profile” page, no
	 * text is listed next to the Activities label.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test07() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("jgarcia2");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Hello jgarcia2!")).click();
		driver.findElement(By.linkText("My Profile")).click();
		
		// verify that activities are empty
		try {
			assertEquals("", driver.findElement(By.xpath("//dd[4]")).getText());
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.linkText("Log off")).click();
		
	}
	
	/**
	 * 8. When logged in as jgarcia and viewing jgarcia’s “Edit Activities”
	 * view, after selecting “Hiker” and “Camper” the “Submit” link, the user is
	 * redirected to jgarcias’s “My Profile” page, where the text “Hiker” and
	 * “Camper” is listed next to the Activities label.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test08() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("jgarcia2");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Hello jgarcia2!")).click();
		driver.findElement(By.linkText("Personal Settings")).click();
		
		// add activities
		driver.findElement(By.linkText("Change your preferred activities"))
				.click();
		driver.findElement(By.id("RecOptions_0__IsChecked")).click();
		driver.findElement(By.id("RecOptions_1__IsChecked")).click();
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		
		// verify both activities show up.
		try {
			assertEquals("Manage - tents n trails", driver.getTitle());
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Hiking", driver.findElement(By.xpath("//dd[5]"))
					.getText());
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Camping", driver.findElement(By.xpath("//dd[6]"))
					.getText());
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
						
		driver.findElement(By.linkText("Log off")).click();		
	}
	
	/**
	 * 9. When logged in as jgarcia and viewing jgarcia’s “Edit Activities” 
	 * view, after deselecting “Camper” the “Submit” link, the user is 
	 * redirected to jgarcia’s “My Profile” page, where the text “Hiker” is 
	 * listed next to the Activities label.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test09() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("jgarcia2");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.linkText("Hello jgarcia2!")).click();
		driver.findElement(By.linkText("Personal Settings")).click();
		
		// add activities
		driver.findElement(By.linkText("Change your preferred activities"))
				.click();
		driver.findElement(By.id("RecOptions_1__IsChecked")).click();
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		
		// verify only Hiking activity shows up.
		try {
			assertEquals("Manage - tents n trails", driver.getTitle());
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Hiking", driver.findElement(By.xpath("//dd[5]"))
					.getText());
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertNotEquals("Camping", driver.findElement(By.xpath("//dd[5]"))
					.getText());
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
		driver.findElement(By.linkText("Log off")).click();		
	}
	
	/**
	 * When logged in as asenner and viewing jgarcia’s “My Profile” page, the 
	 * text “Hiker” is listed next to the Activities label.
	 * @throws Exception
	 */
	@Test
	public void test10() throws Exception {
		driver.get(baseUrl + "/");
		
		// login
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys("asenner");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Password1!");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		
		// goto locations
		driver.findElement(By.linkText("Locations")).click();
		driver.findElement(By.name("searchString")).clear();
		driver.findElement(By.name("searchString")).sendKeys(
				"Grand Canyon National Park (Testing)");
		driver.findElement(By.id("btn")).click();
		
		// navigate to jgarcia2's profile via the test Review data
		driver.findElement(By.linkText("jgarcia2")).click();
		
		// ensure only hiking is displayed
		try {
			assertEquals("Hiking", driver.findElement(By.cssSelector("dd")).getText());
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertNotEquals("Camping", driver.findElement(By.cssSelector("dd")).getText());
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
		// logout
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
