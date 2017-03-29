package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by Артем on 26.03.2017.
 */
public class GroupDeletionTests extends TestBase {
  @Test
  public void deleteFirstGroup(){
    app.getNavigationHelper().goToGroupsPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("forDeletion", "header", "footer"));
      app.getNavigationHelper().goToGroupsPage();
    }
    List<GroupData> before = app.getGroupHelper().getListOfGroups();
    app.getGroupHelper().selectFirstGroup();
    app.getGroupHelper().initDeletion();
    app.getNavigationHelper().goToGroupsPage();
    List <GroupData> after = app.getGroupHelper().getListOfGroups();
    Assert.assertEquals(after.size(), before.size() -1);
    before.remove(before.get(0));
    Assert.assertEquals(after, before);
//    for (int i = 0; i < after.size(); i++ ){
//      System.out.println("after: " + after);
//      System.out.println("before: " + before);
//      Assert.assertEquals(after.get(i), before.get(i));

    }
  }


  @Test
  void deleteAllGroups(){
    app.getNavigationHelper().goToGroupsPage();
    app.getGroupHelper().selectAllGroups();
    System.out.println("+++++++++++++++++");
    app.getGroupHelper().getListOfGroups();
  }
}
