package org.example;

import java.util.Date;

public class Grade {
    private Double value;
    private Date insertionDate;
    public void GradeAssignation(Double gradeValue)
    {
        value=gradeValue;
        insertionDate=new Date();
    }

    public Double getValue() {
        return value;
    }
    public Date getInsertionDate() {
        return insertionDate;
    }
}
