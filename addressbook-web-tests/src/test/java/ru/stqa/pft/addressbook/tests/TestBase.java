package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

/**
 * Created by Артем on 26.03.2017.
 */
public class TestBase {
  protected final ApplicationManager app = new ApplicationManager();

  @BeforeClass
  public void setUp() {
    app.init();
  }

  @AfterMethod
  public void tearDown(){
    app.closeBrowser();
  }

}
