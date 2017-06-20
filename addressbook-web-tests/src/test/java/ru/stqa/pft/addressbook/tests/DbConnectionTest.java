package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.sql.*;


/**
 * Created by Sergey on 10.04.2017.
 */
public class DbConnectionTest {

    @Test
    public void testDbConnect(){
    Connection conn = null;
    Groups groups = new Groups();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery("SELECT group_id, group_name FROM  group_list");
            while ((result.next())){
                groups.add(new GroupData().setId(result.getInt("group_id")).setName(result.getString("group_name")));
            }
            result.close();
            st.close();
            conn.close();
        } catch (SQLException e1) {
            System.out.println("SQLException " + e1.getMessage());
        }
        System.out.println(groups);
    }
}


