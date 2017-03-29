package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

  public void initNewGroup() { click(By.xpath("*//input[1][@value='New group']"));
  }
  public void submitGroupCreation() {click(By.cssSelector("input[name='submit']"));
  }
  public void initGroupModification() {click(By.cssSelector("#content>form>input:nth-of-type(3)"));
  }
  public void submitGroupModification() {click(By.name("update"));
  }
  public void initDeletion() {click(By.cssSelector("#content>form>input:nth-of-type(2)"));
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
      System.out.println(m.getText());//два раза первый елемент выберает
    }
  }

  public void selectAllGroups(){
    List<WebElement> groups;
    groups = wd.findElements(By.className("group"));
    for (int i = 0; i < groups.size(); i++) {
      System.out.println(groups.get(i).getText());
      groups.get(i).findElement(By.name("selected[]")).click();
    }
    }

  public void selectFirstGroup() {
   click(By.xpath("*//span[1]"));
   // click(By.name("selected[]"));
}

  public boolean isThereAGroup() {
      return isElementPresent(By.className("group"));
  }

  public void createGroup(GroupData groupData) {
    initNewGroup();
    fillGroupForm(groupData);
    submitGroupCreation();
  }

  public int getGroupCount() {
    return wd.findElements(By.className("group")).size();
  }
}

