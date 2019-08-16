/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithm.domain;

/*
 * <h1> To Implement a Room Class </h1>
 */


public class Room {

    private String number;
    private int seatCapacity;

    /**
     * @param number       This is the first parameter to the constructor to set value
     *                     of room number
     * @param seatCapacity This is the second parameter to the constructor to
     *                     set classroom seatCapacity
     */
    public Room(String number, int seatCapacity) {
        this.number = number;
        this.seatCapacity = seatCapacity;
    }

    /**
     * @return This is the getter for the number variable
     */
    public String getNumber() {
        return number;
    }

    /**
     * @return This is the getter for the seatCapacity variable
     */
    public int getSeatCapacity() {
        return seatCapacity;
    }

}
