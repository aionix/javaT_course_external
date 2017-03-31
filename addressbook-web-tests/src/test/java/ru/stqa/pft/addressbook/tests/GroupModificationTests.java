package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Артем on 26.03.2017.
 */
public class GroupModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.getNavigationHelper().goToGroupsPage();
    if(! app.goTo().isThereAGroup()){
      app.goTo().createGroup(new GroupData("forMidif", "header", "footer"));
      app.getNavigationHelper().goToGroupsPage();
  }}

  @Test
  void testFirstGroupMidification(){
    List<GroupData> before = app.goTo().getListOfGroups();
    int index = 0;
    GroupData group = new GroupData(before.get(index).getId(),"group_name14", "header2", "footer1");
    app.goTo().modifyGroup(index, group);
    app.getNavigationHelper().goToGroupsPage();
    List<GroupData> after = app.goTo().getListOfGroups();

    before.remove(before.get(index));
    before.add(group);
    System.out.println("bef "+before);
    System.out.println("aft"+after);
    Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before) );

  }




}
