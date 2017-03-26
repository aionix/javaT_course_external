package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Артем on 26.03.2017.
 */
public class ApplicationManager {
  public WebDriver wd;
  public WebDriverWait wait;
  //int Browser = BrowserType.INTERNET_EXPLORER;
  private GroupHelper groupHelper;
  private NavigationHelper navigationHelper;
  private SessionHelper sessionHelper;

  public void init() {
    System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
    wd = new ChromeDriver();
    wait = new WebDriverWait(wd, 10);
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
//default page
    wd.get("http://localhost/addressbook/");
    sessionHelper.Login();
  }

  public void closeBrowser() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }
  public NavigationHelper getNavigationHelper() {return  navigationHelper;}
  public SessionHelper getSessionHelper(){return  sessionHelper;}


}
