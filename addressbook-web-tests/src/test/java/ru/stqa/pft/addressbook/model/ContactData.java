package ru.stqa.pft.addressbook.model;

/**
 * Created by Sergey on 28.03.2017.
 */
public class ContactData {
    private final String group;
    private final String firstname;
    private final String lastname;

    public ContactData(String firstname, String lasttname, String group){
        this.firstname = firstname;
        this.lastname = lasttname;
        this.group = group;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getGroup() {return group;}
    public String getLastname() {
        return lastname;
    }
}
