package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Артем on 26.03.2017.
 */
public class NavigationHelper extends HelperBase {
  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void GroupsPage() {
    if(isElementPresent(By.cssSelector("h1"))
            && wd.findElement(By.cssSelector("h1")).getText().equals("Groups")
            && isElementPresent(By.xpath("*//input[1][@value='New group']"))){
      return;
    }
    click(By.linkText("groups"));
  }
  public void goToHomePage(){
    if(isElementPresent(By.id("maintable"))){
      return;
    }click(By.id("logo"));
  }
}
