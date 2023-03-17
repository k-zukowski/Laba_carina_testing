package org.laba.testing.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import java.util.List;
import org.laba.testing.gui.enums.NavElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Navbar extends AbstractUIObject {

  @FindBy(xpath = "//li[contains(@class,'md-nav__item') and not(contains(@class,'--nested'))]")
  private List<ExtendedWebElement> navbarElements;

  @FindBy(css = "nav[aria-label='Navigation'] label[for='__drawer']")
  private ExtendedWebElement firstElement;

  public Navbar(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);
    setUiLoadedMarker(navbarElements.get(0));
  }

  public String getFirstElementText() {
    return firstElement.getText();
  }

  public String getAttributeById(int id, String attribute) {
    return this.navbarElements.get(id).getAttribute(attribute);
  }

  public int getNavigationElementsCount() {
    return this.navbarElements.size();
  }

  public boolean isNavbarElementVisibleById(int id) {
    return this.navbarElements.get(id).isVisible();
  }

  public void clickNavbarElementById(int id) {
    this.navbarElements.get(id).click();
  }

  public boolean isNavElementActive(NavElement navElement) {
    return  isNavElementActiveById(navElement.ordinal());
  }

  private boolean isNavElementActiveById (int id) {
    return this.navbarElements.get(id).getAttribute("class").endsWith("--active");
  }

}
