package com.example.springboot3todoapplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.springboot3todoapplication.Services.ToDoService;

@Controller
public class HomeController {

    @Autowired
    private ToDoService todoitemservice;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItem", todoitemservice.getAll());
        return modelAndView;
    }

    
}
