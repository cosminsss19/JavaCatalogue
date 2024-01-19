package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student extends User implements Serializable {
    private List<Grade> grades = new ArrayList<>();

    public Student(String name) {
        super(name);
    }

    public List<Grade> getGrades() {
        return new ArrayList<>(grades);
    }

    public void viewGrades() {
        System.out.println("Grades for student " + getName() + ":");
        for (Grade grade : grades) {
            System.out.println(grade);
        }
    }
}
