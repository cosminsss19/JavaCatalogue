// App.java
package org.example;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = FileDatabase.loadStudents();
        List<Professor> professors = FileDatabase.loadProfessors();

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Professors");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageStudents(students, scanner);
                    break;
                case 2:
                    manageProfessors(professors, scanner);
                    break;
                case 3:
                    FileDatabase.saveStudents(students);
                    FileDatabase.saveProfessors(professors);
                    System.out.println("Exiting. Data saved.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void manageStudents(List<Student> students, Scanner scanner) {
        while (true) {
            System.out.println("\n=== Student Management ===");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade to Student");
            System.out.println("3. Remove Grade from Student");
            System.out.println("4. View Student Grades");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent(students, scanner);
                    break;
                case 2:
                    addGradeToStudent(students, scanner);
                    break;
                case 3:
                    removeGradeFromStudent(students, scanner);
                    break;
                case 4:
                    viewStudentGrades(students, scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addStudent(List<Student> students, Scanner scanner) {
        System.out.println("\n=== Add Student ===");
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        students.add(new Student(studentName));
        System.out.println("Student added successfully.");
    }

    private static void addGradeToStudent(List<Student> students, Scanner scanner) {
        System.out.println("\n=== Add Grade to Student ===");
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        for (Student student : students) {
            if (student.getName().equals(studentName)) {
                System.out.print("Enter grade value: ");
                double gradeValue = scanner.nextDouble();
                student.getGrades().add(new Grade(gradeValue));
                System.out.println("Grade added to student successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static void removeGradeFromStudent(List<Student> students, Scanner scanner) {
        System.out.println("\n=== Remove Grade from Student ===");
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        for (Student student : students) {
            if (student.getName().equals(studentName)) {
                if (!student.getGrades().isEmpty()) {
                    System.out.print("Enter index of grade to remove (starting from 1): ");
                    int gradeIndex = scanner.nextInt();
                    if (gradeIndex > 0 && gradeIndex <= student.getGrades().size()) {
                        student.getGrades().remove(gradeIndex - 1);
                        System.out.println("Grade removed from student successfully.");
                        return;
                    } else {
                        System.out.println("Invalid grade index.");
                    }
                } else {
                    System.out.println("No grades to remove.");
                }
            }
        }

        System.out.println("Student not found.");
    }

    private static void viewStudentGrades(List<Student> students, Scanner scanner) {
        System.out.println("\n=== View Student Grades ===");
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        for (Student student : students) {
            if (student.getName().equals(studentName)) {
                student.viewGrades();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static void manageProfessors(List<Professor> professors, Scanner scanner) {
        while (true) {
            System.out.println("\n=== Professor Management ===");
            System.out.println("1. Add Professor");
            System.out.println("2. Add Subject to Professor");
            System.out.println("3. Remove Subject from Professor");
            System.out.println("4. View Professor Subjects");
            System.out.println("5. Calculate Final Average for a Subject");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProfessor(professors, scanner);
                    break;
                case 2:
                    addSubjectToProfessor(professors, scanner);
                    break;
                case 3:
                    removeSubjectFromProfessor(professors, scanner);
                    break;
                case 4:
                    viewProfessorSubjects(professors, scanner);
                    break;
                case 5:
                    calculateFinalAverage(professors, scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addProfessor(List<Professor> professors, Scanner scanner) {
        System.out.println("\n=== Add Professor ===");
        System.out.print("Enter professor name: ");
        String professorName = scanner.nextLine();
        professors.add(new Professor(professorName));
        System.out.println("Professor added successfully.");
    }

    private static void addSubjectToProfessor(List<Professor> professors, Scanner scanner) {
        System.out.println("\n=== Add Subject to Professor ===");
        System.out.print("Enter professor name: ");
        String professorName = scanner.nextLine();

        for (Professor professor : professors) {
            if (professor.getName().equals(professorName)) {
                System.out.print("Enter subject name: ");
                String subjectName = scanner.nextLine();
                professor.addSubject(new Subject(subjectName));
                System.out.println("Subject added to professor successfully.");
                return;
            }
        }

        System.out.println("Professor not found.");
    }

    private static void removeSubjectFromProfessor(List<Professor> professors, Scanner scanner) {
        System.out.println("\n=== Remove Subject from Professor ===");
        System.out.print("Enter professor name: ");
        String professorName = scanner.nextLine();

        for (Professor professor : professors) {
            if (professor.getName().equals(professorName)) {
                System.out.print("Enter subject name: ");
                String subjectName = scanner.nextLine();
                professor.getSubjects().removeIf(subject -> subject.getName().equals(subjectName));
                System.out.println("Subject removed from professor successfully.");
                return;
            }
        }

        System.out.println("Professor not found.");
    }

    private static void viewProfessorSubjects(List<Professor> professors, Scanner scanner) {
        System.out.println("\n=== View Professor Subjects ===");
        System.out.print("Enter professor name: ");
        String professorName = scanner.nextLine();

        for (Professor professor : professors) {
            if (professor.getName().equals(professorName)) {
                System.out.println("Subjects for professor " + professor.getName() + ":");
                for (Subject subject : professor.getSubjects()) {
                    System.out.println(subject.getName());
                }
                return;
            }
        }

        System.out.println("Professor not found.");
    }

    private static void calculateFinalAverage(List<Professor> professors, Scanner scanner) {
        System.out.println("\n=== Calculate Final Average for a Subject ===");
        System.out.print("Enter professor name: ");
        String professorName = scanner.nextLine();

        for (Professor professor : professors) {
            if (professor.getName().equals(professorName)) {
                System.out.print("Enter subject name: ");
                String subjectName = scanner.nextLine();

                for (Subject subject : professor.getSubjects()) {
                    if (subject.getName().equals(subjectName)) {
                        professor.showFinalAverage(subject);
                        return;
                    }
                }

                System.out.println("Subject not found.");
                return;
            }
        }

        System.out.println("Professor not found.");
    }
}
