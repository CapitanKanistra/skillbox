package main;

import response.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {
    private static int currentId = 1;


    private static HashMap<Integer, Course> courses = new HashMap<Integer, Course>();

    public static List<Course> getAllCourses() {
        ArrayList<Course> courseList = new ArrayList<Course>();
        courseList.addAll(courses.values());
        return courseList;
    }

    public static int addCourse(Course course) {
        int id = currentId++;
        course.setId(id);
        courses.put(id, course);
        return id;
    }

    public static Course deleteCourse(int courseId) {
        if (courses.containsKey(courseId)) {
            courses.remove(courseId);
        }
        return null;
    }


    public static Course getCourse(int courseId) {
        if (courses.containsKey(courseId)) {
            return courses.get(courseId);
        }
        return null;
    }

    public static Course putCourse(int courseId, Course courseNew) {
        if (courses.containsKey(courseId)) {

            courses.put(courseId, courseNew);

        }
        return null;
    }

}







