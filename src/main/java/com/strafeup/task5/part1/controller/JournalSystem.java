package com.strafeup.task5.part1.controller;

import com.strafeup.task5.part1.model.Journal;
import com.strafeup.task5.part1.model.Student;
import com.strafeup.task5.part1.view.ConsolePrinter;
import com.strafeup.task5.part1.view.UserInput;

public class JournalSystem {
    private Journal journal;

    public JournalSystem() {
        journal = new Journal();
    }

    public void start() {
        menu();
    }

    public void printAllStudents() {
        for (Student student : journal.getStudentList()) {
            ConsolePrinter.print(student.toString());
        }
    }

    private void menu() {
        int menuInput;
        while (true) {
            ConsolePrinter.print("Welcome to journal system\n 1. Create student record\n 2. View the journal\n 5. Exit");
            menuInput = UserInput.getNumber();
            switch (menuInput) {
                case 1:
                    journal.createStudent();
                    break;
                case 2:
                    printAllStudents();
                    break;
                case 5:
                    return;
            }
        }
    }


}
