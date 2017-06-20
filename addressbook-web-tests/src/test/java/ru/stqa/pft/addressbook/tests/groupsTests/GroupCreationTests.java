package ru.stqa.pft.addressbook.tests.groupsTests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Артем on 26.03.2017.
 */
public class GroupCreationTests extends TestBase {
@DataProvider
public Iterator<Object[]> validGroups(){
    List<Object[]> list = new ArrayList<>();
    list.add(new Object[] {new GroupData("test_gr_1","header1","footer1")});
    list.add(new Object[] {new GroupData("test_gr_2","header2","footer2")});
    return list.iterator();
}
  @Test(dataProvider = "validGroups")
  void createGroup(GroupData group) {
          app.goTo().GroupsPage();
          Set<GroupData> before = app.group().getSetOfGroups();
          app.group().initNewGroup();
          app.group().createGroup(group);
          app.goTo().GroupsPage();
          Set<GroupData> after = app.group().getSetOfGroups();
          assertThat(after.size(), equalTo(before.size() + 1));
          int max = app.group().maxidFromGroup(after);          //take max number - new group gets new number
          before.add(group.setId(max));                         //set max value to newly created group
          assertThat(after, equalTo(before));
  }

  @Test(enabled = false)
  void getListOfGroups(){
    app.goTo().GroupsPage();
    app.group().getListOfGroups();
    app.group().initNewGroup();
  }


}
