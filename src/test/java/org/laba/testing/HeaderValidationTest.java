package org.laba.testing;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.laba.testing.gui.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderValidationTest implements IAbstractTest {

  @Test()
  @MethodOwner(owner = "kzuko")
  @TestPriority(Priority.P4)
  public void zebrunnerLogo() {
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    Assert.assertTrue(homePage.getLogo().getLocation().x < homePage.getHeader().getLocation().x);
    homePage.getLogo().click();
    Assert.assertEquals(getDriver().getCurrentUrl(), "http://zebrunner.github.io/carina/");
  }

  @Test()
  @MethodOwner(owner = "kzuko")
  @TestPriority(Priority.P4)
  public void carinaBrand() {
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    Assert.assertTrue(homePage.getHeader().getText().contains("Carina"));
  }

  @Test()
  @MethodOwner(owner = "kzuko")
  @TestPriority(Priority.P4)
  public void searchComponent() {
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    Assert.assertTrue(homePage.getSearchBar().isElementPresent());
    Assert.assertEquals(homePage.getSearchBar().getAttribute("aria-label"), "Search");
  }

  @Test()
  @MethodOwner(owner = "kzuko")
  @TestPriority(Priority.P4)
  public void githubLink() {
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    Assert.assertTrue(homePage.getGithubLink().isElementPresent());
    homePage.getGithubLink().click();
    Assert.assertEquals(getDriver().getCurrentUrl(), "https://github.com/zebrunner/carina/");
  }

  @Test()
  @MethodOwner(owner = "kzuko")
  @TestPriority(Priority.P4)
  public void headerIsSticky() {
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    Assert.assertTrue(homePage.getHeader().isVisible());
  }
}
