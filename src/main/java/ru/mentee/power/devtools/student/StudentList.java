package ru.mentee.power.devtools.student;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    // TODO
    private List<Student> studentList;

    public StudentList() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (student != null) {
            studentList.add(student);
        }
    }

    public List<Student> getStudentsByCity(String city) {
        System.out.println("Debug: filtering students by city = " + city);
        return studentList.stream().filter(s -> s.city().equals(city)).toList();
    }
}