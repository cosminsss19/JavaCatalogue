package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Subject implements Serializable {
    private String name;
    private List<Grade> gradeList = new ArrayList<>();
    private Double finalAverage;

    public Subject(String disciplineName) {
        this.name = disciplineName;
    }

    public String getName() {
        return name;
    }

    public List<Grade> getGradeList() {
        return new ArrayList<>(gradeList);
    }

    public void addGrade(Double gradeValue) {
        gradeList.add(new Grade(gradeValue));
        calculateFinalAverage();
    }

    public void deleteGrade(Grade grade) {
        gradeList.remove(grade);
        calculateFinalAverage();
    }

    private void calculateFinalAverage() {
        if (gradeList != null && !gradeList.isEmpty()) {
            double totalValueOfGrades = gradeList.stream().mapToDouble(Grade::getValue).sum();
            finalAverage = totalValueOfGrades / gradeList.size();
        } else {
            finalAverage = 0.0;
        }
    }

    public Double getFinalAverage() {
        return finalAverage;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", finalAverage=" + finalAverage +
                '}';
    }
}
