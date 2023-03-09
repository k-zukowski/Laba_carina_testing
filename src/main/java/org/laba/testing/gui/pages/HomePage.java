package org.laba.testing.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class HomePage extends AbstractPage {

  @FindBy(xpath = "//div[@class='md-header-nav__ellipsis']")
  private ExtendedWebElement header;

  @FindBy(xpath = "//a[@class='md-header-nav__button md-logo']//img[@alt='logo']")
  private ExtendedWebElement logo;

  @FindBy(xpath = "//input[@placeholder='Search']")
  private ExtendedWebElement searchBar;

  @FindBy(xpath = "//div[@class='md-header-nav__source']//div[@class='md-source__repository']")
  private ExtendedWebElement githubLink;

  @FindBy(xpath = ".//li[contains(@class,'md-nav__item') and not(contains(@class,'--nested'))]")
  private List<ExtendedWebElement> contextMenu;

  @FindBy(xpath = "//label[contains(text(),'Automation')]")
  private ExtendedWebElement automationSubMenu;

  @FindBy(xpath = "//label[contains(text(),'Advanced')]")
  private ExtendedWebElement advancedSubMenu;

  @FindBy(xpath = "//label[contains(text(),'Integration')]")
  private ExtendedWebElement integrationSubMenu;

  public HomePage(WebDriver driver) {
    super(driver);
    setUiLoadedMarker(header);
    setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
  }

  public ExtendedWebElement getAutomationSubMenu() {
    return automationSubMenu;
  }

  public ExtendedWebElement getAdvancedSubMenu() {
    return advancedSubMenu;
  }

  public ExtendedWebElement getIntegrationSubMenu() {
    return integrationSubMenu;
  }

  public ExtendedWebElement getGithubLink() {
    return githubLink;
  }

  public List<ExtendedWebElement> getContextMenu() {
    return contextMenu;
  }

  public ExtendedWebElement getSearchBar() {
    return searchBar;
  }

  public ExtendedWebElement getHeader() {
    return header;
  }

  public ExtendedWebElement getLogo() {
    return logo;
  }

}
