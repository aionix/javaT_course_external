package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by Артем on 26.03.2017.
 */
public class GroupCreationTests extends TestBase {

  @Test
  void createGroup(){
    app.getNavigationHelper().goToGroupsPage();
    List<GroupData> before = app.getGroupHelper().getListOfGroups();
    app.getGroupHelper().initNewGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("group_name5", null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().goToGroupsPage();
    List<GroupData> after = app.getGroupHelper().getListOfGroups();
    Assert.assertEquals(after, before.size() +1);
    System.out.println(after.get(0));





  }

  @Test
  void getListOfGroups(){
    app.getNavigationHelper().goToGroupsPage();
    app.getGroupHelper().getListOfGroups();
  }
}
