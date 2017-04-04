package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
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
    @Parameter(names = "-c", description = "Group count")
    public int count;
    @Parameter(names = "-f", description = "Target file")
    public String file;

    public static void main(String[] args) throws IOException {
        GroupDataGenerator generator = new GroupDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        }catch (ParameterException e){
            jCommander.usage();
            return;
        }
        generator.run();
//        int count = Integer.parseInt(args[0]);
//        File file = new File(args[1]);
    }

    private void run() throws IOException {
        List<GroupData> groups = generateGroups(count);
        save(groups, new File(file));
    }

    private void save(List<GroupData> groups, File file) throws IOException {
        System.out.println(new File(".").getAbsoluteFile());
        Writer writer = new FileWriter(file);
        for(GroupData group: groups){
            writer.write(String.format("%s;%s;%s\n", group.getName(),               //циклом записываем в файл используя типа шаблон Стрингформат
                    group.getHeader(), group.getFooter()));
        }writer.close();
    }

    private List<GroupData> generateGroups(int count) {
        List<GroupData> group = new ArrayList<GroupData>();
        for (int i = 0; i < count; i++)
            group.add(new GroupData((String.format("test %s", i)),
                    "asd "+i+"",
                    "fotter "));
        return group;
    }
}
