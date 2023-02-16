package main;

import main.model.Course;
import main.model.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@Controller

public class DefaultController {
    @Autowired
    TodolistRepository todolistRepository;
    @RequestMapping("/")
    public String index(Model model)
    {
        Iterable<Course> courseIterable = todolistRepository.findAll();
        ArrayList<Course> courses = new ArrayList<>();
        for (Course course:courseIterable){
            courses.add(course);
        }
        model.addAttribute("courses",courses);
        model.addAttribute("CoursesCount",courses.size());

        return "index";
    }
}
