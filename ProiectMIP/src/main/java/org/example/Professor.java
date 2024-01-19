package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Professor extends User implements Serializable {
    private List<Subject> subjects = new ArrayList<>();

    public Professor(String name) {
        super(name);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public void deleteSubject(Subject subject) {
        this.subjects.remove(subject);
    }

    public void alphabeticalSort() {
        subjects.sort(Comparator.comparing(Subject::getName));
    }

    public void sortByDate() {
        subjects.sort(Comparator.comparing(Subject::getFinalAverage));
    }

    public void showFinalAverage(Subject subject) {
        System.out.println("Final average for discipline " + subject.getName() + ": " + subject.getFinalAverage());
    }
}
