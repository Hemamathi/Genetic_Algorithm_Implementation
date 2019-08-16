/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithm;

import geneticalgorithm.domain.Department;

import java.util.ArrayList;

import geneticalgorithm.domain.Class;
/*
 * <h1> To Implement a Class Schedule Class </h1>
 */

public class ClassSchedule {

    private ArrayList<Class> classes;
    private boolean isFitnessChanged = true;
    private double fitness = -1;
    private int classNumb = 0;
    private int numbOfConflicts = 0;
    private Data data;

    /**
     * @param classes         List of classes in the schedule
     * @param fitness         Fitness level of the class schedule
     * @param numbOfConflicts no of conflicts in the class schedule
     */
    public Data getData() {
        return data;
    }

    public ClassSchedule(Data data) {
        this.data = data;
        classes = new ArrayList<Class>(data.getNumberOfClasses());
    }

    public ClassSchedule initialize() {
        new ArrayList<Department>(data.getDepts()).forEach(dept -> {
            dept.getCourses().forEach(course -> {
                Class newClass = new Class(classNumb++, dept, course);
                newClass.setMeetingTime(data.getMeetingTimes().get((int) (data.getMeetingTimes().size() * Math.random())));
                newClass.setRoom(data.getRooms().get((int) (data.getRooms().size() * Math.random())));
                newClass.setProfessor(course.getProfessors().get((int) (course.getProfessors().size() * Math.random())));
                classes.add(newClass);
            });
        });
        return this;
    }

    public int getNumbOfConflicts() {
        return numbOfConflicts;
    }

    public ArrayList<Class> getClasses() {
        isFitnessChanged = true;
        return classes;
    }

    public double getFitness() {
        if (isFitnessChanged == true) {
            fitness = calculateFitness();
            isFitnessChanged = false;
        }
        return fitness;
    }

    private double calculateFitness() {
        numbOfConflicts = 0;
        classes.forEach(x -> {
            if (x.getRoom().getSeatCapacity() < x.getCourse().getMaxNumberOfStudents()) {
                numbOfConflicts++;
            }
            classes.stream().filter(y -> classes.indexOf(y) >= classes.indexOf(x)).forEach(y -> {
                if (x.getMeetingTime() == y.getMeetingTime() && x.getId() != y.getId()) {
                    if (x.getRoom() == y.getRoom()) {
                        numbOfConflicts++;
                    }
                    if (x.getProfessor() == y.getProfessor()) {
                        numbOfConflicts++;
                    }
                }
            });
        });
        return 1 / (double) (numbOfConflicts + 1);
    }

    public String toString() {
        String returnValue = new String();
        for (int x = 0; x < classes.size() - 1; x++) {
            returnValue += classes.get(x) + ",";
        }
        returnValue += classes.get(classes.size() - 1);
        return returnValue;
    }

    @Override
    public boolean equals(Object obj) {
        return ((this.classes.equals(((ClassSchedule) obj).getClasses())));
    }
}
