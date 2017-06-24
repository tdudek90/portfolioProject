package pl.tomekdudek.portfolioProject.models.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


public class ProjectForm {


    private int id;
    @NotEmpty(message = "{NotEmpty.project.name}")
    private String name;
    @NotEmpty(message = "{NotEmpty.project.description}")
    private String description;
    @NotEmpty(message = "{NotEmpty.project.client}")
    private String client;
    private Date date;
    @NotEmpty
    private String img;

    public ProjectForm(){

    }


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
