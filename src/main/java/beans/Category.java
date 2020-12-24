package beans;

import java.util.Date;

public class Category {
    private String id;
    private String name;
    private Date dateCreated;

    public Category(String id, String name, Date dateCreated) {
        setId(id);
        this.name = name;
        this.dateCreated = dateCreated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    public String toString(){
        return id +" "+name+" "+dateCreated;
    }
}
