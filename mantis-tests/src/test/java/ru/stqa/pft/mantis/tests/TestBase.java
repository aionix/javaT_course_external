package ru.stqa.pft.mantis.tests;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;
import ru.stqa.pft.mantis.generators.BrowserType;

import java.io.File;
import java.io.IOException;

public class TestBase {
  public final static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.INTERNET_EXPLORER));
         // new ApplicationManager(BrowserType.INTERNET_EXPLORER);

  @BeforeSuite
  public void setUp() throws IOException {
    app.init();
    app.ftp().upload(new File("scr/test/resources/config_inc.php"),
            "config_inc.php", "config_inc.php.back");
  }

  @AfterSuite
  public void tearDown() throws IOException {
    app.ftp().restore("config_inc.php.back", "config_inc.php");
    app.closeBrowser();
  }

}
