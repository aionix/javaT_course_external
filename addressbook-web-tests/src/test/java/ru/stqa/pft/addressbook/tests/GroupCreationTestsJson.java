package ru.stqa.pft.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Артем on 26.03.2017.
 */
public class GroupCreationTestsJson extends TestBase {

@DataProvider
public Iterator<Object[]> validGroupsFromJson() throws IOException {
    System.out.println(new File(".").getAbsoluteFile());
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")));
    String json = "";
    String line = reader.readLine();
    while(line != null){
        json += line;
        line = reader.readLine();
    }
    Gson gson = new Gson();
    List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>(){}.getType());
    return groups.stream().map(groupData -> new Object[]{groupData}).collect(Collectors.toList()).iterator();
}
  @Test(dataProvider = "validGroupsFromJson")
  void createGroup(GroupData group) {
          app.goTo().GroupsPage();
          Set<GroupData> before = app.group().getSetOfGroups();
          app.group().initNewGroup();
          app.group().createGroup(group);
          app.goTo().GroupsPage();
          Set<GroupData> after = app.group().getSetOfGroups();
          assertThat(after.size(), equalTo(before.size() + 1));
          int max = app.group().maxidFromGroup(after);       //беру макс число, тк как новая группа получает новый ИД

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
