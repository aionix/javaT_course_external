package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Артем on 26.03.2017.
 */
public class GroupCreationTests extends TestBase {

  @Test
  void createGroup() throws InterruptedException {
    app.goTo().GroupsPage();
    Set<GroupData> before = app.group().getSetOfGroups();
    app.group().initNewGroup();
    GroupData group = new GroupData("aa1", "grHeader123456", "footer");
    app.group().createGroup(group);
    app.goTo().GroupsPage();

    Set<GroupData> after = app.group().getSetOfGroups();
    Assert.assertEquals(after.size(),before.size() +1);
    before.add(group);

    Assert.assertEquals(new HashSet<GroupData>(after), new HashSet<GroupData>(before));
  }

  @Test(enabled = false)
  void getListOfGroups(){
    app.goTo().GroupsPage();
    app.group().getListOfGroups();
    app.group().initNewGroup();
  }

  public int getMaxIdFromGroup(List<GroupData> list){
    int max = 0;
    for(GroupData g : list){
      if (g.getId() > max){
        max = g.getId();
      }}
    return max;
  }
}
