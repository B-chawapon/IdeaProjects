package com.company;

public class Course {
    private String courseName;
    private String[] students = new String[8];
    private String[] newStudents;
    private int index=0;

    public Course(String courseName) {
        this.courseName = courseName;
    }
    public void addStudent(String student) {
        if (index >= students.length) {
            newStudents = new String[students.length];
            for(int i = 0; i < students.length; ++i) {
                newStudents[i] = students[i];
            }

            students = new String[index + 1];
            for(int i = 0; i < newStudents.length; ++i) {
                students[i] = newStudents[i];
            }
            students[index] = student;
            index++;
        }
        else {
            students[index] = student;
            index++;
        }

    }

    public void dropStudent(String student) {
        int temp = 0;
        for(int i = 0; i < students.length; i++) {
            if (students[i] == student) {
                students[i] = "";
                temp = i;
                break;
            }
        }

        for(temp=temp; temp < students.length - 1; temp++) {
            students[temp] = students[temp + 1];
        }
        index--;
    }
    public String getCourseName() {
        return this.courseName;
    }

    public String[] getStudents() {
        return this.students;
    }

    public int getNumberOfStudents() {
        return this.index;
    }

    public void clear() {
        students = new String[8];
        index = 0;
    }
}
