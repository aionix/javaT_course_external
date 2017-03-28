package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Артем on 26.03.2017.
 */
public class GroupDeletionTests extends TestBase {
  @Test
  public void deleteGroup(){
    app.getNavigationHelper().goToGroupsPage();
    app.getGroupHelper().selectAllGroups();
    app.getGroupHelper().initDeletion();
    app.getNavigationHelper().goToGroupsPage();
   // System.out.println("Before: "+before );
   // app.getGroupHelper().getListOfGroups();

  }

  @Test
  void deleteAllGroups(){
    app.getNavigationHelper().goToGroupsPage();
    app.getGroupHelper().selectAllGroups();
  }
}
