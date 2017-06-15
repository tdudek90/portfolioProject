package pl.tomekdudek.portfolioProject.models.form;

import com.sun.scenario.effect.impl.prism.PrImage;

/**
 * Created by Tomek on 2017-06-15.
 */
public class EmailForm {

    private String name;
    private String email;
    private String phoneNumber;
    private String message;

    public EmailForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
