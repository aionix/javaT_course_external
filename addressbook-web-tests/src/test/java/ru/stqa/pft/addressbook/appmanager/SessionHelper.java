package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Артем on 26.03.2017.
 */
public class SessionHelper extends HelperBase {
  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void Login(String username, String password) {
    type(By.name("user"), username);
    type(By.name("pass"), password);
    click(By.xpath("//*[@value='Login']"));
  }

  public void Login() {
    type(By.name("user"), "admin");
    type(By.name("pass"), "secret");
    click(By.xpath("//*[@value='Login']"));
  }
}
