package org.laba.testing;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.laba.testing.gui.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationValidationTest implements IAbstractTest {

  @Test()
  @MethodOwner(owner = "kzuko")
  @TestPriority(Priority.P4)
  public void navigationElementIsVisible() {
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    final List<ExtendedWebElement> contextMenu = homePage.getContextMenu();
    Assert.assertTrue(contextMenu.size() > 0);
    Assert.assertEquals(getDriver().findElement(
        By.cssSelector("nav[aria-label='Navigation'] label[for='__drawer']")).getText(), "Carina");
    System.out.println(contextMenu.get(0).getAttribute("class"));
    Assert.assertTrue(contextMenu.get(0).getAttribute("class").endsWith("--active"));
  }

  @Test()
  @MethodOwner(owner = "kzuko")
  @TestPriority(Priority.P4)
  public void navigationHiddenComponents() {
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    final List<ExtendedWebElement> contextMenu = homePage.getContextMenu();
    ExtendedWebElement hiddenContextMenuElement = contextMenu.get(5);
    Assert.assertFalse(hiddenContextMenuElement.isVisible());
    homePage.getAutomationSubMenu().click();
    Assert.assertTrue(hiddenContextMenuElement.isVisible());
  }

  @Test()
  @MethodOwner(owner = "kzuko")
  @TestPriority(Priority.P4)
  public void navigationWorksProperly() {
    final Map<Integer, String> map = new HashMap<>() {{
      put(0, "http://zebrunner.github.io/carina/");
      put(1, "http://zebrunner.github.io/carina/getting_started/");
      put(2, "http://zebrunner.github.io/carina/project_structure/");
      put(3, "http://zebrunner.github.io/carina/configuration/");
      put(4, "http://zebrunner.github.io/carina/execution/");
      put(5, "http://zebrunner.github.io/carina/automation/web/");
      put(6, "http://zebrunner.github.io/carina/automation/mobile/");
      put(7, "http://zebrunner.github.io/carina/automation/api/");
      put(8, "http://zebrunner.github.io/carina/automation/windows/");
      put(9, "http://zebrunner.github.io/carina/advanced/database/");
      put(10, "http://zebrunner.github.io/carina/advanced/dataprovider/");
      put(11, "http://zebrunner.github.io/carina/advanced/driver/");
      put(12, "http://zebrunner.github.io/carina/advanced/mobile/");
      put(13, "http://zebrunner.github.io/carina/advanced/localization/");
      put(14, "http://zebrunner.github.io/carina/advanced/program_flow/");
      put(15, "http://zebrunner.github.io/carina/advanced/proxy/");
      put(16, "http://zebrunner.github.io/carina/advanced/screenshot/");
      put(17, "http://zebrunner.github.io/carina/advanced/security/");
      put(18, "http://zebrunner.github.io/carina/integration/zebrunner/");
      put(19, "http://zebrunner.github.io/carina/cucumber/");
      put(20, "http://zebrunner.github.io/carina/contribution/");
    }};
    for (Entry<Integer, String> entry : map.entrySet()) {
      HomePage homePage = new HomePage(getDriver());
      homePage.open();
      if (entry.getKey() > 4 && entry.getKey() <= 8) {
        homePage.getAutomationSubMenu().click();
      } else if (entry.getKey() > 8 && entry.getKey() <= 17) {
        homePage.getAdvancedSubMenu().click();
      } else if (entry.getKey().equals(18)) {
        homePage.getIntegrationSubMenu().click();
      }
      Assert.assertTrue(homePage.isPageOpened(), "Page is not opened");
      List<ExtendedWebElement> contextMenu = homePage.getContextMenu();
      contextMenu.get(entry.getKey()).click();
      Assert.assertEquals(getDriver().getCurrentUrl(), entry.getValue());
      Assert.assertTrue(contextMenu.get(entry.getKey()).getAttribute("class").endsWith("--active"));
    }
  }
}
