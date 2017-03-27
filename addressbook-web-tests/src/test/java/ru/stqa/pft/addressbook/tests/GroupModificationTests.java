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
    app.getGroupHelper().selectFirstGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("group_name1", "header1", "footer1"));
    app.getGroupHelper().submitGroupModification();
  }
}
