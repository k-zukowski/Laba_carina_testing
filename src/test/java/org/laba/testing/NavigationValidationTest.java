package org.laba.testing;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.laba.testing.gui.components.Navbar;
import org.laba.testing.gui.enums.NavElement;
import org.laba.testing.gui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationValidationTest implements IAbstractTest {

  @Test()
  @MethodOwner(owner = "kzukowski")
  @TestPriority(Priority.P4)
  public void navigationElementIsVisibleTest() {
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Navbar navbar = homePage.getNavbar();
    Assert.assertTrue(navbar.getNavigationElementsCount() > 0);
    Assert.assertEquals(navbar.getFirstElementText(), "Carina");
    Assert.assertTrue(navbar.getAttributeById(0,"class").endsWith("--active"));
    navbar.isNavElementActive(NavElement.OVERVIEW);
  }

  @Test()
  @MethodOwner(owner = "kzukowski")
  @TestPriority(Priority.P4)
  public void navigationHiddenComponentsTest() {
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Navbar navbar = homePage.getNavbar();
    Assert.assertFalse(navbar.isNavbarElementVisibleById(5));
    homePage.getSubMenu().format("Automation").click();
    Assert.assertTrue(navbar.isNavbarElementVisibleById(5));
  }

  @Test()
  @MethodOwner(owner = "kzukowski")
  @TestPriority(Priority.P4)
  public void navigationWorksProperlyTest() {
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
      if (entry.getValue().contains("carina/automation/")) {
        homePage.getSubMenu().format("Automation").click();
      } else if (entry.getValue().contains("carina/advanced/")) {
        homePage.getSubMenu().format("Advanced").click();
      } else if (entry.getValue().contains("carina/integration/")) {
        homePage.getSubMenu().format("Integration").click();
      }
      Navbar navbar = homePage.getNavbar();
      navbar.clickNavbarElementById(entry.getKey());
      Assert.assertEquals(getDriver().getCurrentUrl(), entry.getValue());
      Assert.assertTrue(navbar.getAttributeById(entry.getKey(),"class").endsWith("--active"));
    }
  }
}
