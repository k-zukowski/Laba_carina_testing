package org.laba.testing.util;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Utils {

  public void scrollDown(WebDriver driver){
    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
  }

}
