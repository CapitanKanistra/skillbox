package main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
import response.Course;

import java.util.List;
import java.util.Optional;


@RestController

public class CourseController {
    @RequestMapping(value = "/courses/", method = RequestMethod.GET)
    public List<Course> list() {
        return Storage.getAllCourses();
    }

    @RequestMapping(value = "/courses/", method = RequestMethod.POST)
    public int add(Course course) {
        return Storage.addCourse(course);

    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable int id) {
        Course course = Storage.getCourse(id);
        if (course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(course, HttpStatus.OK);
    }


    @RequestMapping(value = "/courses/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable int id) {
        Course course = Storage.deleteCourse(id);
        if (course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(course, HttpStatus.OK);
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity put(@PathVariable int id, Course courseNew) {
        Course course = Storage.putCourse(id);
        if (course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(courseNew, HttpStatus.OK);
    }
}




