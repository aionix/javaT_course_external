package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

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
    app.goTo().GroupsPage();
    if(! app.group().isThereAGroup()){
      app.group().initNewGroup();
      app.group().createGroup(new GroupData("forDeletion", "header", "footer"));
      app.goTo().GroupsPage();
    }
    List<GroupData> before = app.group().getListOfGroups();
    app.group().selectFirstGroup();
    app.group().initDeletion();
    app.goTo().GroupsPage();
    List <GroupData> after = app.group().getListOfGroups();
    Assert.assertEquals(after.size(), before.size() -1);
    before.remove(before.get(0));

    Assert.assertEquals(after, before);                             //сравниваем объекты групдата по 2м полям
//    for (int i = 0; i < after.size(); i++ ){
//      System.out.println("after: " + after);
//      System.out.println("before: " + before);
//      Assert.assertEquals(after.get(i), before.get(i));
    }



  @Test
  void deleteAllGroups(){
    app.goTo().GroupsPage();
    app.group().selectAllGroups();
    System.out.println("+++++++++++++++++");
    app.group().getListOfGroups();
  }
}
