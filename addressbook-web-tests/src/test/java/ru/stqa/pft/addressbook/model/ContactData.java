package ru.stqa.pft.addressbook.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.File;


@javax.persistence.Entity
@javax.persistence.Table(name = "addressbook")
public class ContactData {
    @Id
    @Column(name = "id")
    private int id;

    @Transient
    private String group;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;
    @Type(type="text")
    private String photo;


    public File getPhoto() { return new File(photo);
    }
    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
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
    public ContactData(){}


    public String getFirstname() {
        return firstname;
    }
    public String getGroup() {return group;}
    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", group='" + group + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
