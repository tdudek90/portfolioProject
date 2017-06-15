package pl.tomekdudek.portfolioProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tomekdudek.portfolioProject.ProjectRepository;

/**
 * Created by Tomek on 2017-06-07.
 */
@Controller
public class MainController {

    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("projects", projectRepository.findAll());
        return "index";
    }



}
