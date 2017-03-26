package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Артем on 26.03.2017.
 */
public class GroupCreationTests extends TestBase {

  @Test
  void createGroup(){
    app.getSessionHelper().Login("admin", "secret");
    app.getNavigationHelper().goToGroupsPage();
    app.getGroupHelper().initNewGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("group_name1", "header1", "footer1"));
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().goToGroupsPage();
    app.getGroupHelper().getListOfGroups();

  }

  @Test
  void getListOfGroups(){
    app.getSessionHelper().Login();
    app.getNavigationHelper().goToGroupsPage();
    app.getGroupHelper().getListOfGroups();
  }
}
