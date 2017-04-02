package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Артем on 26.03.2017.
 */
public class GroupCreationTests extends TestBase {

  @Test
  void createGroup() {
    for(int i = 20; i < 30; i++) {
      app.goTo().GroupsPage();
      Set<GroupData> before = app.group().getSetOfGroups();
      app.group().initNewGroup();
      GroupData group = new GroupData("ZooLand2_"+ i +"", "zoooo", "footer");
      app.group().createGroup(group);
      app.goTo().GroupsPage();
      Set<GroupData> after = app.group().getSetOfGroups();
      assertThat(after.size(), equalTo(before.size() + 1));
      int max = app.group().getMaxIdFromGroup(after);       //беру макс число, тк как новая группа получает новый ИД

      before.add(group.setId(max));                         //присваиваю макс ИД последей созданной группе
      assertThat(after, equalTo(before));
    }

  }

  @Test(enabled = false)
  void getListOfGroups(){
    app.goTo().GroupsPage();
    app.group().getListOfGroups();
    app.group().initNewGroup();
  }


}
