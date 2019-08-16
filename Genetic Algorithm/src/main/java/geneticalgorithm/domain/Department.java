/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithm.domain;

import java.util.ArrayList;

/*
 * <h1> To Implement a Department Class </h1>
 */


public class Department {

    private String name;
    private ArrayList<Course> courses;

    /**
     * @param name    This is the first parameter to the constructor to set value
     *                of department name
     * @param courses This is the third parameter to the constructor to set
     *                value of list of professors taking the course
     */
    public Department(String name, ArrayList<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    /**
     * @return This is the getter for the name variable
     */
    public String getName() {
        return name;
    }

    /**
     * @return This is the getter for the courses variable
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    @Override
    public boolean equals(Object obj) {
        return ((this.name == null ? ((Department) obj).name == null : this.name.equals(((Department) obj).name)) && (this.courses.equals(((Department) obj).getCourses())));
    }
}
