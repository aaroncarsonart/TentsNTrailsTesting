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
 * Deletes previously created locations by logging in as admin, searching
 * for the test locations by name (unique so should return one result exactly),
 * then deleting them from the details page.
 * @author Aaron Carson
 * @version Apr 14, 2015
 */
public class DeleteLocations {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = TentsNTrails.URL;
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDeleteLocations() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("loginLink")).click();
    driver.findElement(By.id("UserName")).clear();
    driver.findElement(By.id("UserName")).sendKeys("admin");
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys("Password1!");
    driver.findElement(By.cssSelector("input.btn.btn-default")).click();
    driver.findElement(By.linkText("Locations")).click();
    driver.findElement(By.name("searchString")).clear();
    driver.findElement(By.name("searchString")).sendKeys("Grand Canyon National Park (Testing)");
    driver.findElement(By.id("btn")).click();
    driver.findElement(By.linkText("Delete")).click();
    driver.findElement(By.cssSelector("input.btn.btn-default")).click();
    driver.findElement(By.name("searchString")).clear();
    driver.findElement(By.name("searchString")).sendKeys("Multnomah Falls (Testing)");
    driver.findElement(By.id("btn")).click();
    driver.findElement(By.linkText("Delete")).click();
    driver.findElement(By.cssSelector("input.btn.btn-default")).click();
    driver.findElement(By.name("searchString")).clear();
    driver.findElement(By.name("searchString")).sendKeys("Santiam State Forest (Testing)");
    driver.findElement(By.id("btn")).click();
    driver.findElement(By.linkText("Delete")).click();
    driver.findElement(By.cssSelector("input.btn.btn-default")).click();
    driver.findElement(By.name("searchString")).clear();
    driver.findElement(By.name("searchString")).sendKeys("Silver Falls State Park (Testing)");
    driver.findElement(By.id("btn")).click();
    driver.findElement(By.linkText("Delete")).click();
    driver.findElement(By.cssSelector("input.btn.btn-default")).click();
    driver.findElement(By.name("searchString")).clear();
    driver.findElement(By.name("searchString")).sendKeys("Zion National Park (Testing)");
    driver.findElement(By.id("btn")).click();
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
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
