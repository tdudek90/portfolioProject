package pl.tomekdudek.portfolioProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.tomekdudek.portfolioProject.models.form.ProjectForm;

/**
 * Created by Tomek on 2017-06-25.
 */
@Controller
public class SecureController {


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping ("/afterlogout")
    public String afterLogout(){
        return "afterlogout";
    }



//    @GetMapping("/admin")
//    public String adminPage(Model model){
//        model.addAttribute("projectObject", new ProjectForm());
//        return "project";
//    }
}
