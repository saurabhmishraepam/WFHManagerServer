package com.epam.wfhmanager.wfhmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class WorkingHoursUpdateController {

    @PostMapping("/workinghour")
    public void updateWorkingHours(@RequestBody String body){

        System.out.println(body);

    }
    @RequestMapping("/index")
    public ModelAndView thymeleafView(Map<String, Object> model) {
        model.put("number", 1234);
        model.put("message", "Hello from Spring MVC");
        return new ModelAndView("thymeleaf/index");
    }
}
