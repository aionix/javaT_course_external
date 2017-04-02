package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Артем on 26.03.2017.
 */
public class GroupHelper extends HelperBase {
    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void initNewGroup() {
        click(By.cssSelector("input[name='new']:nth-of-type(1)"));
    }

    public void submitGroupCreation() {
        click(By.cssSelector("input[name='submit']"));
    }

    public void initGroupModification() {
        click(By.cssSelector("#content>form>input:nth-of-type(3)"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void initDeletion() {
        click(By.cssSelector("#content>form>input:nth-of-type(2)"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void printOutAllGroups() {
        List<WebElement> groups;
        groups = wd.findElements(By.className("group"));
        for (WebElement m : groups) {
            System.out.println(m.getText());//два раза первый елемент выберает
        }
    }

    public void selectAllGroups() {
        List<WebElement> groups;
        groups = wd.findElements(By.className("group"));
        for (int i = 0; i < groups.size(); i++) {
            System.out.println(groups.get(i).getText());
            groups.get(i).findElement(By.name("selected[]")).click();
        }
    }
    private Groups groupCache = null;

    public Set<GroupData> getSetOfGroups() {
       /* if (groupCache != null){
            return new Groups(groupCache);
        }
        groupCache  = new HashSet<>();*/
        Set<GroupData> groups = new HashSet<>();
        List<WebElement> elements = wd.findElements(By.className("group"));
        for (int i = 0; i < elements.size(); i++) {
            String name = elements.get(i).getText();
            int id = Integer.parseInt(elements.get(i).findElement(By.tagName("input")).getAttribute("value"));   //достаем value из списка груп
            GroupData group = new GroupData(id, name, null, null); //упаковываю список групп в сет
            groups.add(group);                                               //
        }
        return groups;
    }
    public List<GroupData> getListOfGroups() {
        List<GroupData> groups = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.className("group"));
        for (int i = 0; i < elements.size(); i++) {
            String name = elements.get(i).getText();
            int id = Integer.parseInt(elements.get(i).findElement(By.tagName("input")).getAttribute("value"));   //достаем value из списка груп
            GroupData group = new GroupData(id, name, null, null);
            groups.add(group);
        }
        return groups;
    }

    public void modifyGroup(int index, GroupData group) {
        selectGroup(index);
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
    }

    public void selectFirstGroup() {
        click(By.xpath("*//span[1]"));
    }

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.className("group"));
    }

    public void createGroup(GroupData groupData) {
        fillGroupForm(groupData);
        submitGroupCreation();
    }

    public int getGroupCount() {
        return wd.findElements(By.className("group")).size();
    }

    public int getMaxIdFromGroup(Set<GroupData> list){
        int max = 0;
        for(GroupData g : list){
            if (g.getId() > max){
                max = g.getId();
            }}
        return max;
    }

    public void deleteById(GroupData group) {
        selectGroupById(group.getId());
        initDeletion();
    }


}

