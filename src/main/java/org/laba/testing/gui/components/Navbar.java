package org.laba.testing.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Navbar extends AbstractUIObject {

  @FindBy(xpath = "//li[contains(@class,'md-nav__item') and not(contains(@class,'--nested'))]")
  private List<ExtendedWebElement> elements;

  public Navbar(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);
    setUiLoadedMarker(elements.get(0));
  }

  public String getFirstElementText(WebDriver webDriver) {
    return webDriver.findElement(
        By.cssSelector("nav[aria-label='Navigation'] label[for='__drawer']")).getText();
  }

  public String getAttributeById(int id, String attribute) {
    return this.elements.get(id).getAttribute(attribute);
  }

  public int getSize() {
    return this.elements.size();
  }

  public boolean isVisibleById(int id) {
    return this.elements.get(id).isVisible();
  }

  public void clickById(int id) {
    this.elements.get(id).click();
  }

}
