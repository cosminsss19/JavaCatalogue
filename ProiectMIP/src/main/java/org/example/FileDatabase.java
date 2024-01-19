// FileDatabase.java
package org.example;

import java.io.*;
import java.util.List;

public class FileDatabase {
    private static final String STUDENT_FILE = "students.txt";
    private static final String PROFESSOR_FILE = "professors.txt";

    public static void saveStudents(List<Student> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(STUDENT_FILE))) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> loadStudents() {
        List<Student> students = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(STUDENT_FILE))) {
            students = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void saveProfessors(List<Professor> professors) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PROFESSOR_FILE))) {
            oos.writeObject(professors);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Professor> loadProfessors() {
        List<Professor> professors = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PROFESSOR_FILE))) {
            professors = (List<Professor>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return professors;
    }
}
