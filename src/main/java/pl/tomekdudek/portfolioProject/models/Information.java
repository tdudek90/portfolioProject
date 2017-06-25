package pl.tomekdudek.portfolioProject.models;


import pl.tomekdudek.portfolioProject.models.form.InformationForm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Tomek on 2017-06-15.
 */
@Entity
public class Information {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;

    public Information(InformationForm informationForm){
        name = informationForm.getName();
        description = informationForm.getDescription();
    }

    public Information() {
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

    @Override
    public String toString() {
        return description;
    }
}
