package ru.stqa.pft.addressbook.model;

import java.io.File;

/**
 * Created by Sergey on 28.03.2017.
 */
public class ContactData {
    private String group;
    private final String firstname;
    private final String lastname;
    private File photo;


    public File getPhoto() { return photo;
    }
    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }
    public ContactData(String firstname, String lasttname, String group){
        this.firstname = firstname;
        this.lastname = lasttname;
        this.group = group;
    }
    public ContactData(String firstname, String lasttname){
        this.firstname = firstname;
        this.lastname = lasttname;
    }

    public String getFirstname() {
        return firstname;
    }
    public String getGroup() {return group;}
    public String getLastname() {
        return lastname;
    }
}
