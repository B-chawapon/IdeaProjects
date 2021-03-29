<<<<<<< Updated upstream
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
=======
package com.company;

public class Course {
    String courseName;
    String[] students = new String[2];
    int numberOfStudents;
    private int index;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public int getIndex() {
        return this.index;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public String[] getStudnets() {
        return this.students;
    }

    public int getNumberOfStudebts() {
        return this.numberOfStudents;
    }

    public void addStudent(String student) {
        if ( index >= students.length) {
            String[] newStudents = new String[students.length];


            for(int i = 0; i < students.length; ++i) {
                newStudents[i] = students[i];
            }

            students = new String[index + 1];

            for(int i = 0; i < newStudents.length; ++i) {
                students[i] = newStudents[i];
            }

            students[this.index] = student;
            index++;
        } else  {
            students[index] = student;
            index++;
        }

    }

    public void dropStudent(String student) {
        int temp = 0;

        for(int i = 0; i < students.length; ++i) {
            if (students[i]==student ) {
                students[i] = "";
                temp = i;
                break;
            }
        }

        for(int i = temp; i < this.students.length - 1; ++i) {
            students[i] = students[i + 1];
        }

        String[] newStudents = new String[this.students.length];

        for(int i = 0; i < this.students.length; ++i) {
            newStudents[i] = this.students[i];
        }

        this.students = new String[this.index - 1];

        for(int i = 0; i < newStudents.length - 1; ++i) {
            this.students[i] = newStudents[i];
        }

        --this.index;
    }

    public void clear() {
        this.students = new String[2];
        this.index = 0;
    }
}
>>>>>>> Stashed changes
