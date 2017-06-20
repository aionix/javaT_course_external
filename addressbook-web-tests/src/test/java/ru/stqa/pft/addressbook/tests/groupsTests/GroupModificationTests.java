package ru.stqa.pft.addressbook.tests.groupsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Артем on 26.03.2017.
 */
public class GroupModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){

    app.goTo().GroupsPage();
    if(! app.group().isThereAGroup()){
      app.group().initNewGroup();
      app.group().createGroup(new GroupData("forMidif", "header", "footer"));
      app.goTo().GroupsPage();
  }}

  @Test
  void testFirstGroupMidification(){
    LocalTime time1 = LocalTime.now();
    String time = time1.getHour()+":"+time1.getMinute()+"."+time1.getSecond();
    app.goTo().GroupsPage();

    List<GroupData> before = app.group().getListOfGroups();
    int index = 0;
    GroupData group = new GroupData(before.get(index).getId(),"modified_ "+time, "header2", "footer2");
    app.group().modifyGroup(index, group);
    app.goTo().GroupsPage();
    List<GroupData> after = app.group().getListOfGroups();

    before.remove(before.get(index));
    before.add(group);                    //adding edited group to set list
    System.out.println("before "+before);
    System.out.println("after"+after);
    Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before) );
  }


}
