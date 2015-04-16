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
 * Removes reviews that were previously added for User Story # 157.
 * @author Aaron Carson
 * @version Apr 14, 2015
 */
public class DeleteReviews {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://tentsntrails-test.azurewebsites.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRemoveReviews() throws Exception {
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
