package org.laba.testing.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

  @FindBy(xpath = "//div[@class='md-header-nav__ellipsis']")
  private ExtendedWebElement header;

  @FindBy(xpath = "//a[@class='md-header-nav__button md-logo']//img[@alt='logo']")
  private ExtendedWebElement logo;

  @FindBy(xpath = "//input[@placeholder='Search']")
  private ExtendedWebElement searchBar;

  @FindBy(xpath = "//div[@class='md-header-nav__source']//div[@class='md-source__repository']")
  private ExtendedWebElement githubLink;

  public Header(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);
    setUiLoadedMarker(logo);
  }

  public int getLogoLocationX () {
    return this.logo.getLocation().x;
  }

  public int getHeaderLocationX() {
    return this.header.getLocation().x;
  }

  public void logoClick() {
    this.logo.click();
  }

  public String getHeaderText() {
    return this.header.getText();
  }

  public boolean isSearchBarPresent() {
    return this.searchBar.isElementPresent();
  }

  public String getSearchBarAttribute(String attribute) {
    return this.searchBar.getAttribute(attribute);
  }

  public boolean isGithubLinkPresent() {
    return this.githubLink.isElementPresent();
  }

  public void githubClick() {
    this.githubLink.click();
  }

  public boolean isHeaderVisible() {
    return this.header.isVisible();
  }
}
