package ru.stqa.pft.addressbook.tests;

import org.testng.ITestContext;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.generators.BrowserType;

import java.io.IOException;

@Listeners(MyTestListener.class)
public class TestBase  {
  public final static ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite
  public void setUp(ITestContext context) throws Exception {
    app.init();
    context.setAttribute("app", app);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown(){
    app.closeBrowser();
  }

}
