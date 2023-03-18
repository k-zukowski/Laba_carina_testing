package org.laba.testing;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.laba.testing.gui.components.Header;
import org.laba.testing.gui.pages.HomePage;
import org.laba.testing.util.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderValidationTest implements IAbstractTest {

  @Test()
  @MethodOwner(owner = "kzukowski")
  @TestPriority(Priority.P4)
  public void zebrunnerLogoTest() {
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Header header = homePage.getHeader();
    Assert.assertTrue(header.getLogoLocationX() < header.getHeaderLocationX());
    header.logoClick();
    Assert.assertEquals(getDriver().getCurrentUrl(), "http://zebrunner.github.io/carina/");
  }

  @Test()
  @MethodOwner(owner = "kzukowski")
  @TestPriority(Priority.P4)
  public void carinaBrandTest() {
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Header header = homePage.getHeader();
    Assert.assertTrue(header.getHeaderText().contains("Carina"));
  }

  @Test()
  @MethodOwner(owner = "kzukowski")
  @TestPriority(Priority.P4)
  public void searchComponentTest() {
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Header header = homePage.getHeader();
    Assert.assertTrue(header.isSearchBarPresent());
    Assert.assertEquals(header.getSearchBarLabel(), "Search");
  }

  @Test()
  @MethodOwner(owner = "kzukowski")
  @TestPriority(Priority.P4)
  public void githubLinkTest() {
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Header header = homePage.getHeader();
    Assert.assertTrue(header.isGithubLinkPresent());
    header.githubClick();
    Assert.assertEquals(getDriver().getCurrentUrl(), "https://github.com/zebrunner/carina/");
  }

  @Test()
  @MethodOwner(owner = "kzukowski")
  @TestPriority(Priority.P4)
  public void headerIsStickyTest() {
    HomePage homePage = new HomePage(getDriver());
    Utils utils = new Utils();
    homePage.open();
    utils.scrollDown(getDriver());
    Header header = homePage.getHeader();
    Assert.assertTrue(header.isHeaderVisible());
  }
}
