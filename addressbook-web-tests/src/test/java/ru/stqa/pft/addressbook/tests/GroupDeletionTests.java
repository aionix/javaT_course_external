package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Артем on 26.03.2017.
 */
public class GroupDeletionTests extends TestBase {
  @Test
  public void deleteGroup(){
    app.getSessionHelper().Login();
    app.getNavigationHelper().goToGroupsPage();
    String before = app.getGroupHelper().getListOfGroups2();
    app.getGroupHelper().selectFirstGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getNavigationHelper().goToGroupsPage();
    System.out.println("Before: "+before );
    app.getGroupHelper().getListOfGroups();

  }

  @Test
  void deleteAllGroups(){
    app.getNavigationHelper().goToGroupsPage();
    app.getGroupHelper().deleteAllGroups();
  }
}
