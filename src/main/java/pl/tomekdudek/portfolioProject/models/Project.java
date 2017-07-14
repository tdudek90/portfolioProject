package pl.tomekdudek.portfolioProject.models;

import org.springframework.format.annotation.DateTimeFormat;
import pl.tomekdudek.portfolioProject.models.form.ProjectForm;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Tomek on 2017-06-24.
 */

@Entity
public class Project {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private String client;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date date;
    private String img;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;

    public Project() {
    }

    public Project(ProjectForm projectForm){
        name = projectForm.getName();
        description = projectForm.getDescription();
        client = projectForm.getClient();
        date = projectForm.getDate();
        img = projectForm.getImg();
        url = projectForm.getUrl();
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
