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
    app.getNavigationHelper().goToGroupsPage();
    if(! app.goTo().isThereAGroup()){
      app.goTo().createGroup(new GroupData("forMidif", "header", "footer"));
      app.getNavigationHelper().goToGroupsPage();
    }}

  @Test
  public void deleteFirstGroup(){
    app.getNavigationHelper().goToGroupsPage();
    if(! app.goTo().isThereAGroup()){
      app.goTo().initNewGroup();
      app.goTo().createGroup(new GroupData("forDeletion", "header", "footer"));
      app.getNavigationHelper().goToGroupsPage();
    }
    List<GroupData> before = app.goTo().getListOfGroups();
    app.goTo().selectFirstGroup();
    app.goTo().initDeletion();
    app.getNavigationHelper().goToGroupsPage();
    List <GroupData> after = app.goTo().getListOfGroups();
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
    app.getNavigationHelper().goToGroupsPage();
    app.goTo().selectAllGroups();
    System.out.println("+++++++++++++++++");
    app.goTo().getListOfGroups();
  }
}
