package pl.tomekdudek.portfolioProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.tomekdudek.portfolioProject.InformationRepository;
import pl.tomekdudek.portfolioProject.MailService;
import pl.tomekdudek.portfolioProject.ProjectRepository;
import pl.tomekdudek.portfolioProject.UserRepository;
import pl.tomekdudek.portfolioProject.models.Information;
import pl.tomekdudek.portfolioProject.models.Project;
import pl.tomekdudek.portfolioProject.models.User;
import pl.tomekdudek.portfolioProject.models.form.ProjectForm;
import pl.tomekdudek.portfolioProject.models.form.EmailForm;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class MainController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    InformationRepository informationRepository;

    @Autowired
    MailService mailService;

    @Autowired
    UserRepository userRepository;




    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("projects", projectRepository.findAll());
        model.addAttribute("header", informationRepository.findOne(1));
        model.addAttribute("about", informationRepository.findOne(2));
        model.addAttribute("about2", informationRepository.findOne(12));

        model.addAttribute("navigation", informationRepository.findOne(3));
        model.addAttribute("myprojects", informationRepository.findOne(4));
        model.addAttribute("aboutinfo", informationRepository.findOne(5));
        model.addAttribute("contact", informationRepository.findOne(6));
        model.addAttribute("skills", informationRepository.findOne(7));
        model.addAttribute("location", informationRepository.findOne(8));
        model.addAttribute("web", informationRepository.findOne(9));
        model.addAttribute("admin", informationRepository.findOne(10));

        model.addAttribute("emailObject", new EmailForm());

        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    @ResponseBody
    public String mail(EmailForm emailForm) {

        mailService.sendEmail("ttomekk0@gmail.com", emailForm);
        return "Wysłano maila";

    }

    @RequestMapping(value = "/adminview", method = RequestMethod.GET)
    public String adminview(Model model) {
        model.addAttribute("projectObject", new ProjectForm());
        model.addAttribute("informationObject", new Information());
        return "adminview";

    }

    @RequestMapping(value = "/newproject", method = RequestMethod.GET)
    public String projectForm(Model model) {
        model.addAttribute("projectObject", new ProjectForm());
        model.addAttribute("informationObject", new Information());
        return "project";

    }

    @RequestMapping(value = "/newproject", method = RequestMethod.POST)
    @ResponseBody
    public String newProjectForm(@ModelAttribute("projectObject") @Valid ProjectForm projectForm, BindingResult result) {
        if (result.hasErrors()) {
            return "project";
        }

        Project projectObject = new Project(projectForm);
        projectRepository.save(projectObject);
        return "Dodano nowy projekt";

    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public String user() {
        List<User> userList = userRepository.findByRole("ADMIN");
        return userList.stream().map(s -> s.getName()).collect(Collectors.joining("", "", ""));
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editInfo(Model model) {
        model.addAttribute("informationObject",new Information());
        return "editinfo";

    }



    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public String editAbout(@ModelAttribute("informationObject") @Valid Information informationForm, BindingResult result) {

        if (result.hasErrors()){
            return "editinfo";
        }
        Information existing = informationRepository.findOne(2);
        existing.setDescription(informationForm.getDescription());
        informationRepository.save(existing);
        return "Dokonano zmiany tekstu sekcji about";

    }


}
