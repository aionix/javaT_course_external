package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;
import ru.stqa.pft.mantis.generators.BrowserType;


import java.io.IOException;

public class TestBase {
  public final static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
         // new ApplicationManager(BrowserType.INTERNET_EXPLORER);

  @BeforeSuite
  public void setUp() throws IOException { app.init();
  }

  @AfterSuite
  public void tearDown(){
    app.closeBrowser();
  }

}