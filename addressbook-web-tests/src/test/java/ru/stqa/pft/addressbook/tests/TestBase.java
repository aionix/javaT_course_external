package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.generators.BrowserType;

import java.io.IOException;

public class TestBase  {
  public final static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.INTERNET_EXPLORER));
         // new ApplicationManager(BrowserType.INTERNET_EXPLORER);

  @BeforeSuite
  public void setUp() throws IOException { app.init();
  }

  @AfterSuite
  public void tearDown(){
    app.closeBrowser();
  }

}
