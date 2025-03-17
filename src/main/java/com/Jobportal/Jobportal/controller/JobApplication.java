package com.Jobportal.Jobportal.controller;


import com.Jobportal.Jobportal.Configure.EmailService;
import com.Jobportal.Jobportal.Reppo.InfoRepo;
import com.Jobportal.Jobportal.entities.Info;
import jakarta.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class JobApplication {

    @Autowired
    public InfoRepo infoRepo;

    @Autowired
    public EmailService emailService;
    @GetMapping("/")
    public String jobDesc(){
        return "jobdesc.html";
    }
    @GetMapping("/apply")
    public String getApply() {

        return "form.html";
    }
    @PostMapping("/apply")
    public String apply(@RequestParam("name") String name,
                        @RequestParam("email") String email,
                        @RequestParam("mobile") String mobile,
                        @RequestParam("resume") MultipartFile resumeFile) throws ServletException, IOException {
        System.out.println("Here");
        byte[] resume = resumeFile.getBytes();
        Info info=new Info(name,mobile,email,resume) ;
        infoRepo.save(info);
        emailService.sendEmail("rushikeshkotkar73@gmail.com",name+" New Application",name+"Got new Application");
        return "redirect:/";
    }

}
