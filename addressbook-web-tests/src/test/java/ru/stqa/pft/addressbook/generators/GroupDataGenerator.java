package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey on 03.04.2017.
 */
public class GroupDataGenerator {
    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<GroupData> groups = generateGroups(count);
        save(groups, file);
    }

    private static void save(List<GroupData> groups, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for(GroupData group: groups){
            writer.write(String.format("%s;%s;%s", group.getName(),
                    group.getHeader(), group.getFooter()));
        }writer.close();
    }

    private static List<GroupData> generateGroups(int count) {
        List<GroupData> group = new ArrayList<GroupData>();
        for (int i = 0; i < count; i++)
            group.add(new GroupData((String.format("test %s", i)),
                    "asd"+i+"",
                    "fotter"));
        return null;
    }
}
