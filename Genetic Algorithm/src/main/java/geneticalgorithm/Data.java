/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithm;

import geneticalgorithm.domain.Course;
import geneticalgorithm.domain.Department;
import geneticalgorithm.domain.MeetingTime;
import geneticalgorithm.domain.Professor;
import geneticalgorithm.domain.Room;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * <h1> To Implement a Data Class </h1>
 */


public class Data {

    private ArrayList<Room> rooms;
    private ArrayList<Professor> professors;
    private ArrayList<Course> courses;
    private ArrayList<Department> depts;
    private ArrayList<MeetingTime> meetingTimes;
    private int numberOfClasses = 0;

    public Data() {
        initialize();
    }
    /*
    This initialize the test data for all the objects
    */

    private Data initialize() {
        Room room1 = new Room("R1", 25);
        Room room2 = new Room("R2", 45);
        Room room3 = new Room("R3", 35);
        rooms = new ArrayList<Room>(Arrays.asList(room1, room2, room3));
        MeetingTime meetingTime1 = new MeetingTime("MT1", "MWF 09:00 - 10:00");
        MeetingTime meetingTime2 = new MeetingTime("MT2", "MWF 10:00 - 11:00");
        MeetingTime meetingTime3 = new MeetingTime("MT3", "TTH 09:00 - 10:30");
        MeetingTime meetingTime4 = new MeetingTime("MT4", "TTH 10:30 - 12:00");
        meetingTimes = new ArrayList<MeetingTime>(Arrays.asList(meetingTime1, meetingTime2, meetingTime3, meetingTime4));
        Professor instructor1 = new Professor("I1", "Dr James Web  ");
        Professor instructor2 = new Professor("I2", "Mr. Mike Brown");
        Professor instructor3 = new Professor("I3", "Dr Steve Day  ");
        Professor instructor4 = new Professor("I4", "Mrs Jane Doe  ");
        professors = new ArrayList<Professor>(Arrays.asList(instructor1, instructor2, instructor3, instructor4));
        Course course1 = new Course("C1", "325K", new ArrayList<Professor>(Arrays.asList(instructor1, instructor2)), 25);
        Course course2 = new Course("C2", "319K", new ArrayList<Professor>(Arrays.asList(instructor1, instructor2, instructor3)), 35);
        Course course3 = new Course("C3", "462k", new ArrayList<Professor>(Arrays.asList(instructor1, instructor2)), 25);
        Course course4 = new Course("C4", "464K", new ArrayList<Professor>(Arrays.asList(instructor3, instructor4)), 30);
        Course course5 = new Course("C5", "360C", new ArrayList<Professor>(Arrays.asList(instructor4)), 35);
        Course course6 = new Course("C6", "303K", new ArrayList<Professor>(Arrays.asList(instructor1, instructor3)), 45);
        Course course7 = new Course("C7", "303L", new ArrayList<Professor>(Arrays.asList(instructor2, instructor4)), 45);
        courses = new ArrayList<Course>(Arrays.asList(course1, course2, course3, course4, course5, course6, course7));
        Department dept1 = new Department("MATH", new ArrayList<Course>(Arrays.asList(course1, course3)));
        Department dept2 = new Department("EE", new ArrayList<Course>(Arrays.asList(course2, course4, course5)));
        Department dept3 = new Department("PHY", new ArrayList<Course>(Arrays.asList(course6, course7)));
        depts = new ArrayList<Department>(Arrays.asList(dept1, dept2, dept3));
        depts.forEach(x -> numberOfClasses += x.getCourses().size());
        return this;
    }

    /**
     * @return This is the getter for the list of Class rooms
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /**
     * @return This is the getter for the list of professors
     */
    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    /**
     * @return This is the getter for the list of Courses
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * @return This is the getter for the list of Class departments
     */
    public ArrayList<Department> getDepts() {
        return depts;
    }

    /**
     * @return This is the getter for the list of meetingTimes
     */
    public ArrayList<MeetingTime> getMeetingTimes() {
        return meetingTimes;
    }

    /**
     * @return This is the getter for the list of no of class rooms
     */
    public int getNumberOfClasses() {
        return this.numberOfClasses;
    }
}
