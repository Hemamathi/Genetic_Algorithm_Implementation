/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithm.domain;

/*
 * <h1> To Implement a MeetingTime Class </h1>
 */


public class MeetingTime {
    private String id;
    private String time;

    /**
     * @param id   This is the first parameter to the constructor to set value
     *             of Meeting id
     * @param time This is the second parameter to the constructor to set
     *             meeting time
     */
    public MeetingTime(String id, String time) {
        this.id = id;
        this.time = time;
    }

    /**
     * @return This is the getter for the id variable
     */
    public String getId() {
        return id;
    }

    /**
     * @return This is the getter for the time variable
     */
    public String getTime() {
        return time;
    }


}
