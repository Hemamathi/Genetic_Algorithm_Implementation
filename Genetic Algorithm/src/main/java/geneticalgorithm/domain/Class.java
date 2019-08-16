/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithm.domain;

/*
 * <h1> To Implement a Classroom Class </h1>
 */

public class Class {

    private int id;
    private Department dept;
    private Course course;
    private Professor professor;
    private MeetingTime meetingTime;
    private Room room;

    /**
     * @param id          This is the first parameter to the constructor to set value of
     *                    id which is class id
     * @param dept        This is the second parameter to the constructor to set value
     *                    of department class is being held at that time
     * @param course      This is the third parameter to the constructor to set value
     *                    of course the class is being held at that time
     * @param professor   Tells which professor is taking the class at the time
     * @param room        Tells which room the class is being held
     * @param meetingTime Tells on what time the class is being held
     */
    public Class(int id, Department dept, Course course) {
        this.id = id;
        this.dept = dept;
        this.course = course;

    }

    /**
     * @param id This is the setter for the id variable
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param dept This is the setter for the dept variable
     */
    public void setDept(Department dept) {
        this.dept = dept;
    }

    /**
     * @param course This is the setter for the course variable
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * @param professor This is the setter for the professor variable
     */

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    /**
     * @param meetingTime This is the setter for the meetingTime variable
     */
    public void setMeetingTime(MeetingTime meetingTime) {
        this.meetingTime = meetingTime;
    }

    /**
     * @param room This is the setter for the room variable
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * @return This is the getter for the id variable
     */
    public int getId() {
        return id;
    }

    /**
     * @return This is the getter for the dept variable
     */
    public Department getDept() {
        return dept;
    }

    /**
     * @return This is the getter for the course variable
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @return This is the getter for the professor variable
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * @return This is the getter for the meetingTime variable
     */
    public MeetingTime getMeetingTime() {
        return meetingTime;
    }

    /**
     * @return This is the getter for the room variable
     */
    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "[" + dept.getName() + "," + course.getNumber() + "," + professor.getId() + "," + meetingTime.getId() + "," + room.getNumber() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        return ((this.id == ((Class) obj).id) && (this.dept.equals(((Class) obj).getDept())) && (this.course.equals(((Class) obj).getCourse())));
    }
}
