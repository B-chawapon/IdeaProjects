<<<<<<< Updated upstream
<<<<<<< Updated upstream
package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Course c1 = new Course("OOP");
        c1.addStudent("A");
        c1.addStudent("B");
        c1.addStudent("C");
        c1.addStudent("D");
        c1.addStudent("E");
        c1.addStudent("F");
        c1.addStudent("G");
        c1.addStudent("H");
        c1.addStudent("I");
        c1.addStudent("K");

        c1.dropStudent("C");


        for (int i = 0; i < c1.getNumberOfStudents(); i++) {
            System.out.println(c1.getStudents()[i]);

        }

        c1.clear();
        for (int i = 0; i < c1.getNumberOfStudents(); i++) {
            System.out.println(c1.getStudents()[i]);

        }
        System.out.println(c1.getNumberOfStudents());

    }
=======
=======
>>>>>>> Stashed changes
package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Course c1 = new Course("OOP");
        c1.addStudent("A");
        c1.addStudent("B");
        c1.addStudent("C");
        c1.addStudent("D");
        c1.addStudent("E");
        c1.addStudent("A");
        c1.addStudent("B");
        c1.addStudent("C");
        c1.addStudent("D");
        c1.addStudent("E");

        for (int i = 0; i < c1.getIndex(); ++i) {
            System.out.println(c1.getStudnets()[i]);
        }


    }
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
}