package pl.tomekdudek.portfolioProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Tomek on 2017-06-10.
 */

@Component
public class CronSimpleTask {

    @Autowired
    ProjectRepository projectRepository;

    // s m g d m
    //* co kazda
    // / - co iles
//    @Scheduled(cron = "0 0 * * *")
//    public void printSomething(){
//        System.out.println("Hello");
//    }

}
