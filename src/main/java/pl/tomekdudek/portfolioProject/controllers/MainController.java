package pl.tomekdudek.portfolioProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tomekdudek.portfolioProject.InformationRepository;
import pl.tomekdudek.portfolioProject.ProjectRepository;
import pl.tomekdudek.portfolioProject.models.Information;

/**
 * Created by Tomek on 2017-06-07.
 */
@Controller
public class MainController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    InformationRepository informationRepository;


    @RequestMapping("/index")
    public String index(Model model){
//        model.addAttribute("informations", informationRepository);
        model.addAttribute("projects", projectRepository.findAll());

        return "index";
    }



}
