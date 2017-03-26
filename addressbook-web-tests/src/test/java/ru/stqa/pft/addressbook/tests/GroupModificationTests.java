package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Артем on 26.03.2017.
 */
public class GroupModificationTests extends TestBase {

  @Test
  void testGroupMidification(){
    app.getNavigationHelper().goToGroupsPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("update_name", "header2", "footer2"));
    app.getGroupHelper().submitGroupModification();
  }
}
