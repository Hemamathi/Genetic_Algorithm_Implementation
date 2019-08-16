/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithm.domain;

import java.util.ArrayList;

/*
 * <h1> To Implement a Course Class </h1>
 */


public class Course {

    private String number = null;
    private String name = null;
    private int maxNumberOfStudents;
    private ArrayList<Professor> professors;

    /**
     * @param number              This is the first parameter to the constructor to set value
     *                            of course number
     * @param name                This is the second parameter to the constructor to set value
     *                            of Course name
     * @param professors          This is the third parameter to the constructor to set
     *                            value of list of professors taking the course
     * @param maxNumberOfStudents Tells which maximum number of students that
     *                            can be registered for the class
     */
    public Course(String number, String name, ArrayList<Professor> professors, int maxNumberOfStudents) {
        this.number = number;
        this.name = name;
        this.professors = professors;
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    /**
     * @return This is the getter for the number variable
     */
    public String getNumber() {
        return number;
    }

    /**
     * @return This is the getter for the name variable
     */
    public String getName() {
        return name;
    }

    /**
     * @return This is the getter for the maxNumberOfStudents variable
     */
    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    /**
     * @return This is the getter for the professors variable
     */
    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return ((this.name.equalsIgnoreCase(((Course) obj).name)) && (this.number == ((Course) obj).number) && (this.professors.equals(((Course) obj).getProfessors())));
    }

}
