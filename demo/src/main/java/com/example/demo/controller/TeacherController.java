package com.example.demo.controller;

import com.example.demo.items.Teacher;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/teachers")
public class TeacherController {

    List<Teacher> list = new ArrayList<>();

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return list;
    }

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        list.add(teacher);
        return teacher;
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable int id, @RequestBody Teacher updatedTeacher) {
        for (Teacher teacher : list) {
            if (teacher.getId() == id) {
                teacher.setName(updatedTeacher.getName());
                teacher.setSubject(updatedTeacher.getSubject());
                return teacher;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable int id) {
        list.removeIf(teacher -> teacher.getId() == id);
        return "Teacher deleted successfully";
    }
}

// @RequestMapping("/students")
// Change according to project:

// Project	URL
// Student	/students
// Employee	/employees
// Book	/books
// Product	/products
// Course	/courses

// B. Update variable names inside methods
// Student Example
// item.setName(updatedItem.getName());
// item.setCourse(updatedItem.getCourse());

// Employee Example
// item.setName(updatedItem.getName());
// item.setDepartment(updatedItem.getDepartment());

/*
@RestController
@RequestMapping("/teachers")
public class TeacherController {

    List<Teacher> list = new ArrayList<>();

    // GET all teachers
    @GetMapping
    public List<Teacher> getAllTeachers() {
        return list;
    }

    // POST - add new teacher
    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        list.add(teacher);
        return teacher;
    }

    // PUT - update teacher
    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable int id, @RequestBody Teacher updatedTeacher) {
        for (Teacher teacher : list) {
            if (teacher.getId() == id) {
                teacher.setName(updatedTeacher.getName());
                teacher.setSubject(updatedTeacher.getSubject());
                return teacher;
            }
        }
        return null;
    }

    // DELETE - remove teacher
    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable int id) {
        list.removeIf(teacher -> teacher.getId() == id);
        return "Teacher deleted successfully";
    }
}
*/