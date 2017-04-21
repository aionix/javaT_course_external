package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.pft.addressbook.generators.BrowserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;


/**
 * Created by Артем on 26.03.2017.
 */
public class ApplicationManager {
  public ApplicationManager(String browser)  {
      this.browser = browser;
      properties = new Properties();
  }
  private final Properties properties;
  public WebDriver wd;
  public WebDriverWait wait;
  private String browser;
  private GroupHelper groupHelper;
  private NavigationHelper navigationHelper;
  private SessionHelper sessionHelper;
  private ContactHelper contactHelper;

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
      //System.out.println("Absolute is --- " + new File(".").getAbsolutePath());
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

    if("".equals(properties.getProperty("selenium.server"))) {
        if (browser.equals(BrowserType.MOZILLA)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.INTERNET_EXPLORER)) {
            System.setProperty("webdriver.ie.driver", "C:\\drivers\\IEDriverServer.exe");
            wd = new InternetExplorerDriver();
        }
    }else {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        wd = new RemoteWebDriver(new URL(properties.getProperty("selenium.server")), capabilities);
     //   capabilities.setPlatform(Platform.fromString(System.getProperty("platfrom", "win7")));
    }
    wait =              new WebDriverWait(wd, 10);
    groupHelper =       new GroupHelper(wd);
    navigationHelper =  new NavigationHelper(wd);
    sessionHelper =     new SessionHelper(wd);
    contactHelper =     new ContactHelper(wd);
//default page
    wd.get(properties.getProperty("web.baseURL"));
    sessionHelper.Login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
   // sessionHelper.Login();
  }

  public void closeBrowser() {
    wd.quit();
  }

  public GroupHelper group() {
    return groupHelper;
  }
  public NavigationHelper goTo() {return  navigationHelper;}
  public SessionHelper getSessionHelper(){return  sessionHelper;}
  public ContactHelper getContactHelper() {return contactHelper;}
}
