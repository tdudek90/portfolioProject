package pl.tomekdudek.portfolioProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tomekdudek.portfolioProject.models.form.ProjectForm;

/**
 * Created by Tomek on 2017-06-25.
 */
@Controller
public class SecureController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String afterLogin(){
//        return "adminview";
//    }

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
