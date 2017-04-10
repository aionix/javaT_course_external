package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;

import java.sql.*;


/**
 * Created by Sergey on 10.04.2017.
 */
public class DbConnectionTest {


    @Test
    public void testDbConnect(){
    Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");
            Statement st = conn.createStatement();
            String group_name = null;
            ResultSet result = st.executeQuery("SELECT group_id, group_name FROM  group_list");
            while ((result.next())){
                group_name = result.getString("group_name");
                System.out.println(group_name);
            }
            result.close();
            st.close();
            conn.close();

        } catch (SQLException e1) {
            System.out.println("SQLException " + e1.getMessage());
        }

    }}


