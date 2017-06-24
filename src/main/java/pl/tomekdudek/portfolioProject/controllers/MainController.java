package pl.tomekdudek.portfolioProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import pl.tomekdudek.portfolioProject.InformationRepository;
import pl.tomekdudek.portfolioProject.MailService;
import pl.tomekdudek.portfolioProject.ProjectRepository;
import pl.tomekdudek.portfolioProject.models.Project;
import pl.tomekdudek.portfolioProject.models.form.ProjectForm;
import pl.tomekdudek.portfolioProject.models.form.EmailForm;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class MainController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    InformationRepository informationRepository;

    @Autowired
    MailService mailService;


    @RequestMapping("/index")
    public String index(Model model) {

        model.addAttribute("projects", projectRepository.findAll());
        model.addAttribute("header", informationRepository.findOne(1));
        model.addAttribute("about", informationRepository.findOne(2));

        model.addAttribute("navigation", informationRepository.findOne(3));
        model.addAttribute("myprojects", informationRepository.findOne(4));
        model.addAttribute("aboutinfo", informationRepository.findOne(5));
        model.addAttribute("contact", informationRepository.findOne(6));
        model.addAttribute("skills", informationRepository.findOne(7));
        model.addAttribute("location", informationRepository.findOne(8));
        model.addAttribute("web", informationRepository.findOne(9));

        model.addAttribute("emailObject", new EmailForm());

        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    @ResponseBody
    public String mail(EmailForm emailForm) {

        mailService.sendEmail("ttomekk0@gmail.com", emailForm);
        return "Wysłano maila";

    }

//    @RequestMapping(value = "/data", method = RequestMethod.GET)
//    public String project(){
//        return "project";
//    }
//
//    @RequestMapping(value = "/data", method = RequestMethod.POST)
//    @ResponseBody
//    public String data(@RequestParam(value = "name", required = false) String nameFromForm,
//                        @RequestParam(value = "lastname",required = false) String lastnameFromForm,
//                        @RequestParam(value = "age", required = false) int age) {
//        return "Twoje imię to: " + nameFromForm + "Twoje nazwisko to: " + lastnameFromForm + "Twój wiek to: " + age;
//    }

    @RequestMapping(value = "/projectform", method = RequestMethod.GET)
    public String projectForm(Model model){
        model.addAttribute("projectObject", new ProjectForm());
        return "project";

    }

    @RequestMapping(value = "/projectform", method = RequestMethod.POST)
    public String newProjectForm(@ModelAttribute ("projectObject") @Valid ProjectForm projectForm, BindingResult result){
        if (result.hasErrors()){
            return "project";
        }
        Project projectObject = new Project(projectForm);
        projectRepository.save(projectObject);
        return "test";

    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(       Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }



}
