package model;

import java.util.Date;


public class Project {
   private int id;
   private String name;
   private String description;
   private Date createdAt;
   private Date UpdatedAt;

    public Project(int id, String name, String description, Date createdAt, Date UpdatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.UpdatedAt = UpdatedAt;
    }

    public Project() {
        this.createdAt = new Date(); 
        this.UpdatedAt = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Date UpdatedAt) {
        this.UpdatedAt = UpdatedAt;
    }

    @Override
    public String toString() {
        return this.name;
    }
   
   
   
}

