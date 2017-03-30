package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Артем on 26.03.2017.
 */
public class GroupModificationTests extends TestBase {

  @Test
  void testFirstGroupMidification(){
    app.getNavigationHelper().goToGroupsPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("forMidification", "header", "footer"));
      app.getNavigationHelper().goToGroupsPage();
    }
    List<GroupData> before = app.getGroupHelper().getListOfGroups();
    app.getGroupHelper().selectFirstGroup();
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData(before.get(0).getId(),"group_name54", "header2", "footer1");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().goToGroupsPage();
    List<GroupData> after = app.getGroupHelper().getListOfGroups();

    before.remove(before.get(0));
    before.add(group);
    System.out.println("bef "+before);
    System.out.println("aft"+after);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after) );

  }


}
