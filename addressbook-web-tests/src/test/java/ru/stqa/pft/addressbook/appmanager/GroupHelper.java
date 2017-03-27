package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by Артем on 26.03.2017.
 */
public class GroupHelper extends HelperBase {
  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void initNewGroup() {
    click(By.xpath("*//input[1][@value='New group']"));
  }

  public void submitGroupCreation() {
    click(By.cssSelector("input[name='submit']"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void getListOfGroups() {
    List<WebElement> groups;
    groups = wd.findElements(By.className("group"));
    for (WebElement m : groups) {
      System.out.println(m.getText());
    }
    System.out.println(groups.get(0).getText());   //почему-то возвращает null а get text  все ок
  }
  public String getListOfGroups2() {
    List<WebElement> groups;
    String list = null;
    groups = wd.findElements(By.className("group"));
    for (WebElement m : groups) {
      list =  m.getText();
    }
    return list;

  }

  public void deleteSelectedGroup() {
    click(By.cssSelector("#content>form>input:nth-of-type(2)"));
  }
  public void deleteAllGroups(){
    List<WebElement> groups;
    groups = wd.findElements(By.className("group"));
    for (WebElement el : groups){
      el.findElement(By.name("selected[]")).click();
      System.out.println(el.getText());
    }
  }

  public void selectFirstGroup() {
   click(By.xpath("*//span[1]"));
   // click(By.name("selected[]"));
}

  public void initGroupModification() {
    click(By.cssSelector("#content>form>input:nth-of-type(3)"));
  }
  public void submitGroupModification() {
    click(By.name("update"));
  }
}
