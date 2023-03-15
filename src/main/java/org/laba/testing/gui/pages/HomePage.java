package org.laba.testing.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.laba.testing.gui.components.Header;
import org.laba.testing.gui.components.Navbar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class HomePage extends AbstractPage {

  @FindBy(xpath = "//header[@class='md-header']")
  private Header header;

  @FindBy(xpath = "//div[@class='md-sidebar md-sidebar--primary']")
  private Navbar navbar;

  @FindBy(xpath = "//label[contains(text(),'%s')]")
  private ExtendedWebElement subMenu;


  public HomePage(WebDriver driver) {
    super(driver);
    setUiLoadedMarker(subMenu);
    setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
  }

  public Header getHeader() {
    return header;
  }

  public Navbar getNavbar() {
    return navbar;
  }

  public ExtendedWebElement getSubMenu() {
    return subMenu;
  }


}
