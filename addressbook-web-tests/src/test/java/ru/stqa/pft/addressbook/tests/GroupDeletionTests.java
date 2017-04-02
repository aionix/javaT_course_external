package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

/**
 * Created by Артем on 26.03.2017.
 */
public class GroupDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().GroupsPage();
    if(! app.group().isThereAGroup()){
      app.group().createGroup(new GroupData("forMidif", "header", "footer"));
      app.goTo().GroupsPage();
    }}

  @Test
  public void deleteFirstGroup(){
    Set<GroupData> before = app.group().getSetOfGroups();
    GroupData deletedGroup = before.iterator().next();    //получил ИД группы на удаление рандомно
    app.goTo().GroupsPage();
    app.group().deleteById(deletedGroup);                     //удаляю группу полученную выше
    app.goTo().GroupsPage();
    Set <GroupData> after = app.group().getSetOfGroups();
    Assert.assertEquals(after.size(), before.size() -1);

    System.out.println(deletedGroup);
    before.remove(deletedGroup);
    Assert.assertEquals(after, before);                             //сравниваем объекты групдата по 2м полям
    }

  @Test
  void deleteAllGroups(){
    app.goTo().GroupsPage();
    app.group().selectAllGroups();
    System.out.println("+++++++++++++++++");
    app.group().getListOfGroups();
  }
}
