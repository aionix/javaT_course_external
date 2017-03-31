package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Артем on 26.03.2017.
 */
public class GroupCreationTests extends TestBase {

  @Test
  void createGroup() throws InterruptedException {
    app.getNavigationHelper().goToGroupsPage();
    List<GroupData> before = app.goTo().getListOfGroups();
    app.goTo().initNewGroup();
    GroupData group = new GroupData("aa1", "grHeader123456", "footer");
    app.goTo().createGroup(group);
    app.getNavigationHelper().goToGroupsPage();

    List<GroupData> after = app.goTo().getListOfGroups();
    Assert.assertEquals(after.size(),before.size() +1);
    int max = 0;
    for(GroupData g : after){
      if (g.getId() > max){
        max = g.getId();
      }}
    group.setId(max);
    before.add(group);

    Assert.assertEquals(new HashSet<GroupData>(after), new HashSet<GroupData>(before));
  }

  @Test(enabled = false)
  void getListOfGroups(){
    app.getNavigationHelper().goToGroupsPage();
    app.goTo().getListOfGroups();
    app.goTo().initNewGroup();
  }
}
