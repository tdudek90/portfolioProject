package pl.tomekdudek.portfolioProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import pl.tomekdudek.portfolioProject.InformationRepository;
import pl.tomekdudek.portfolioProject.MailService;
import pl.tomekdudek.portfolioProject.ProjectRepository;
import pl.tomekdudek.portfolioProject.models.Information;
import pl.tomekdudek.portfolioProject.models.Project;
import pl.tomekdudek.portfolioProject.models.form.EmailForm;

import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.util.Date;


@Controller
public class MainController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    InformationRepository informationRepository;

    @Autowired
    MailService mailService;

    @Autowired
    TemplateEngine templateEngine;


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
        model.addAttribute("projectObject", new Project());
        return "project";

    }

    @RequestMapping(value = "/projectform", method = RequestMethod.POST)
    @ResponseBody
    public String newProjectForm(@Valid Project projecta, BindingResult result){
        if (result.hasErrors()){

            return "error" + result.getAllErrors().toString();
        }
        return "Przyszła klasa" + projecta.getName();

    }



}
