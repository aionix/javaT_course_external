package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Артем on 26.03.2017.
 */
public class GroupCreationTests extends TestBase {

  @Test
  void createGroup(){
    app.getNavigationHelper().goToGroupsPage();
    app.getGroupHelper().initNewGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("group_name5", null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().goToGroupsPage();
    app.getGroupHelper().getListOfGroups();

  }

  @Test
  void getListOfGroups(){
    app.getNavigationHelper().goToGroupsPage();
    app.getGroupHelper().getListOfGroups();
  }
}
