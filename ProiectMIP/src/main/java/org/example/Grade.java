package org.example;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Grade implements Serializable {
    private Double value;
    private Date insertionDate;

    public Grade(Double gradeValue) {
        value = gradeValue;
        insertionDate = new Date();
    }

    public Double getValue() {
        return value;
    }

    public Date getInsertionDate() {
        return insertionDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return "Grade: " + value + " | Date: " + dateFormat.format(insertionDate);
    }
}
