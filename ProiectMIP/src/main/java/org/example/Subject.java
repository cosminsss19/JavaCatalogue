package org.example;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String name;
    private List<Grade> gradeList=new ArrayList<>();
    private Double finalAverage;
    public Subject(String disciplineName)
    {
        this.name=disciplineName;
    }

    public String getName() {
        return name;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }
    public void calculateFinalAverage()
    {
        if (this.gradeList.isEmpty()) {
            this.finalAverage = 0.0;
        } else {
            Double totalValueOfGrades=0.0;
            for (Grade grade:gradeList)
            {
                totalValueOfGrades+=grade.getValue();
            }
            this.finalAverage=totalValueOfGrades/this.gradeList.size();
        }
    }
    public Double getFinalAverage()
    {
        return this.finalAverage;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "name='" + name + '\'' +
                ", finalAverage=" + finalAverage +
                '}';
    }
}
