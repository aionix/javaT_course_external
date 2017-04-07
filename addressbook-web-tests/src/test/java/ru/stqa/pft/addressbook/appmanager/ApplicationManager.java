package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.plugin2.util.BrowserType;


/**
 * Created by Артем on 26.03.2017.
 */
public class ApplicationManager {
  public ApplicationManager(int browser) {
    this.browser = browser;
  }

  public WebDriver wd;
  public WebDriverWait wait;
  private int browser;
  private GroupHelper groupHelper;
  private NavigationHelper navigationHelper;
  private SessionHelper sessionHelper;
  private ContactHelper contactHelper;

  public void init() {
    if (browser == BrowserType.MOZILLA){
        //System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
      wd = new FirefoxDriver();
    }else  if (browser == BrowserType.DEFAULT){
      wd = new ChromeDriver();
    }else if (browser == BrowserType.INTERNET_EXPLORER){
      //System.setProperty("webdriver.ie.driver", "C:\\drivers\\IEDriverServer.exe");
      wd = new InternetExplorerDriver();
    }
    wait =              new WebDriverWait(wd, 10);
    groupHelper =       new GroupHelper(wd);
    navigationHelper =  new NavigationHelper(wd);
    sessionHelper =     new SessionHelper(wd);
    contactHelper =     new ContactHelper(wd);
//default page
    wd.get("http://localhost/addressbook/");
    sessionHelper.Login();
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
