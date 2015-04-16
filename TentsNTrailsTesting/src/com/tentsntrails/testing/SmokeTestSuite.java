package com.tentsntrails.testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This is an idea I had to simply run the site and see if it is running. It
 * as a series of assert statements based on the website's title.
 * 
 * @author Aaron Carson
 * @version Apr 13, 2015
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
	SmokeTestSuite.CheckByWebsiteTitle.class
})


/**
 * Small test classes can be placed in the TestSuite class if you want, to make 
 * things encapsulated and possibly easier to read or manage.  Not sure if 
 * this is a good idea or not, just trying out different methodologies.
 * @author Aaron Carson
 * @version Apr 15, 2015
 */
public class SmokeTestSuite
{
	
	/**
	 * Check if the Site runs with a series of three assertions.
	 * @author Aaron Carson
	 * @version Apr 15, 2015
	 */
	public static class CheckByWebsiteTitle{		
		
		WebDriver driver;
		
		@Before
		public void setup(){
			driver = new FirefoxDriver(); 
		}
		
		@Test
		public void run() throws Exception {
			driver.get(TentsNTrails.URL);
			assertFalse("Page not loaded correctly.", driver.getTitle().contains("Problem loading page"));
			assertFalse("Server Error in Application", driver.findElement(By.cssSelector("h1")).getText().contains("Server Error in '/' Application."));
			assertTrue("Unexpected title: does not contain \"tents n trails\".", driver.getTitle().contains("tents n trails"));
		}
		
		@After
		public void tearDown(){
			driver.quit();
		}
	}
}
