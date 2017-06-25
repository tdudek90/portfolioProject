package pl.tomekdudek.portfolioProject.models.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Tomek on 2017-06-25.
 */
public class InformationForm {

    private int id;
    private String name;
    @NotEmpty
    private String description;

    public InformationForm() {
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
}
