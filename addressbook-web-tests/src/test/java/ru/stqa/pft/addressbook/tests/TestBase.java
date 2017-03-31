package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import sun.plugin2.util.BrowserType;

/**
 * Created by Артем on 26.03.2017.
 */
public class TestBase {
  protected final static ApplicationManager app = new ApplicationManager(BrowserType.DEFAULT);

  @BeforeSuite
  public void setUp() { app.init();
  }

  @AfterSuite
  public void tearDown(){
    app.closeBrowser();
  }

}
