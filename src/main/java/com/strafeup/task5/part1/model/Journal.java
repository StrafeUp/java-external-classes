package com.strafeup.task5.part1.model;

import com.strafeup.task5.part1.view.UserInput;

import java.util.ArrayList;
import java.util.List;

public class Journal {

    List<Student> studentList = new ArrayList<>();

    private void addStudent(Student student) {
        studentList.add(student);
    }

    public void createStudent() {
        addStudent(new Student(UserInput.getWordStartsWithUppercase("surname"), UserInput.getWordStartsWithUppercase("name"),
                UserInput.getDateOfBirth(), UserInput.getPhoneNumber(), UserInput.getAddress()));
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
