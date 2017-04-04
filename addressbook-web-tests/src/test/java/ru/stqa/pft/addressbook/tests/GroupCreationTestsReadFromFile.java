package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Артем on 26.03.2017.
 */
public class GroupCreationTestsReadFromFile extends TestBase {

@DataProvider
public Iterator<Object[]> validGroups() throws IOException {
    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
    String line = reader.readLine();
    while(line != null){
        String[] split = line.split(";");
        list.add(new Object[] {new GroupData(split[0], split[1], split[2])});
        line = reader.readLine();
    }

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
          int max = app.group().getMaxIdFromGroup(after);       //беру макс число, тк как новая группа получает новый ИД

          before.add(group.setId(max));                         //присваиваю макс ИД последей созданной группе
          assertThat(after, equalTo(before));
  }

  @Test(enabled = false)
  void getListOfGroups(){
    app.goTo().GroupsPage();
    app.group().getListOfGroups();
    app.group().initNewGroup();
  }


}
