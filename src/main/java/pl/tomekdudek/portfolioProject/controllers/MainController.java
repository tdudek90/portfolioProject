package pl.tomekdudek.portfolioProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import pl.tomekdudek.portfolioProject.InformationRepository;
import pl.tomekdudek.portfolioProject.MailService;
import pl.tomekdudek.portfolioProject.ProjectRepository;
import pl.tomekdudek.portfolioProject.models.form.EmailForm;


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

//
        mailService.sendEmail("ttomekk0@gmail.com", emailForm);
        return "Wysłano maila";

    }

//


}
