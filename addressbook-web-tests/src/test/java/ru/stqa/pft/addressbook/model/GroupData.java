package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by Артем on 26.03.2017.
 */

@javax.persistence.Entity
@javax.persistence.Table(name = "group_list")

public class GroupData {
    @Id
    @Column(name = "group_id")
    private int id;

    @Expose
    @Column(name = "group_name")
    private  String name;

    @Expose
    @Column(name = "group_header")
    @Type(type = "text")
    private  String header;

    @Expose
    @Column(name = "group_footer")
    @Type(type = "text")
    private  String footer;

    public GroupData(int id, String name, String header, String footer) {
        this.id = id;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }
    public GroupData(String name, String header, String footer) {
        this.id = 0;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }
    public GroupData(){}

    public int          getId()               { return id;
    }
    public GroupData    setId(int id)         { this.id = id; return this;
    }
    public String       getName()             { return name;
    }
    public GroupData    setName(String name)  { this.name = name; return this;
    }

    public String getHeader()                 { return header;
    }
    public GroupData    setHeader(String header) { this.header = header; return this;
    }
    public String       getFooter()            { return footer;
    }
    public GroupData    setFooter(String footer)   {this.footer = footer; return  this;
    }

    @Override
    public String toString() {
        return "GroupData{" + "id='" + id +
                '\'' + ", name='" + name + '\'' + '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (id != groupData.id) return false;
        return name != null ? name.equals(groupData.name) : groupData.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
