package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.pft.mantis.generators.BrowserType;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


/**
 * Created by Артем on 26.03.2017.
 */
public class ApplicationManager {
    private MailHelper          mailHelper;
    private RegistrationHelper  registrationHelper;
    private FtpHelper           ftp;
    private SoapHelper          soapHelper;

    public ApplicationManager(String browser)  {
      this.browser = browser;
      properties = new Properties();
  }


  public final Properties properties;
  private WebDriver wd;
  public WebDriverWait wait;
  private String browser;

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
   // sessionHelper.Login();
  }

  public void closeBrowser() {
      if(wd != null){
          wd.quit();
      }}

  public HttpSession newSession(){
      return new HttpSession(this);
  }
    public String getProperty(String key) {
      return properties.getProperty(key);
    }

    public RegistrationHelper registration() {
      if (registrationHelper == null){
          registrationHelper = new RegistrationHelper(this);
      }return registrationHelper;
    }
  /*  public  FtpHelper ftp(){
        if( wd == null) {
            ftp = new FtpHelper(this);
        }return ftp;
    }*/
    public  MailHelper mailHelper(){
        if( mailHelper == null) {
            mailHelper = new MailHelper(this);
        }return mailHelper;
    }
    public SoapHelper soapHelper(){
        if(soapHelper == null){
            soapHelper =  new SoapHelper(this);
        }return soapHelper;
    }


    public WebDriver getDriver() {
      if( wd == null){
          if (browser.equals(BrowserType.MOZILLA)) {
              wd = new FirefoxDriver();
          } else if (browser.equals(BrowserType.CHROME)) {
              System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
              wd = new ChromeDriver();
          } else if (browser.equals(BrowserType.INTERNET_EXPLORER)) {
              System.setProperty("webdriver.ie.driver", "C:\\drivers\\IEDriverServer.exe");
              wd = new InternetExplorerDriver();
          }
          wait = new WebDriverWait(wd, 10);
            //default page
            // wd.get(properties.getProperty("web.baseURL"));
      }return wd;
    }

}
