package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Артем on 26.03.2017.
 */
public class GroupDeletionTests extends TestBase {
  @Test
  public void deleteFirstGroup(){
    app.getNavigationHelper().goToGroupsPage();
    int before = app.getGroupHelper().getGroupCount();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("forDeletion", "header", "footer"));
      app.getNavigationHelper().goToGroupsPage();
    }
    app.getGroupHelper().selectFirstGroup();
    app.getGroupHelper().initDeletion();
    app.getNavigationHelper().goToGroupsPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before -1);
  }

  @Test
  void deleteAllGroups(){
    app.getNavigationHelper().goToGroupsPage();
    app.getGroupHelper().selectAllGroups();
    System.out.println("+++++++++++++++++");
    app.getGroupHelper().getListOfGroups();
  }
}
