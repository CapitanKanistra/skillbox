package main;

import main.model.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController

public class CourseController {
    @Autowired
    private TodolistRepository todolistRepository;
    @RequestMapping(value = "/courses/", method = RequestMethod.GET)//getall
    public List<Course> list() {
        Iterable<Course> courseIterable = todolistRepository.findAll();
        ArrayList<Course> courses = new ArrayList<>();
        for (Course course:courseIterable) {
            courses.add(course);

        }
        return courses;
    }

    @RequestMapping(value = "/courses/", method = RequestMethod.POST)//addone
    public int add(Course course) {
        Course newCourse = todolistRepository.save(course);
        return newCourse.getId();

    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)//getOneID
    public ResponseEntity get(@PathVariable int id) {
        Optional<Course> optionalCourse = todolistRepository.findById(id);
        if (!optionalCourse.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalCourse.get(), HttpStatus.OK);
    }


    @RequestMapping(value = "/courses/{id}", method = RequestMethod.DELETE)//deleteOneID
    public ResponseEntity delete(@PathVariable int id) {
        Optional<Course> optionalCourse = todolistRepository.findById(id);
        if (!optionalCourse.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        todolistRepository.deleteById(id);
        return new ResponseEntity(optionalCourse.get(), HttpStatus.OK);
    }


    @RequestMapping(value = "/courses/{id}", method = RequestMethod.PUT)//PUT
    public ResponseEntity put(@PathVariable int id, Course courseNew) {
        Optional<Course> optionalCourse = todolistRepository.findById(id);
        if (!optionalCourse.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        todolistRepository.save(courseNew);

        return new ResponseEntity(courseNew, HttpStatus.OK);
    }
}




