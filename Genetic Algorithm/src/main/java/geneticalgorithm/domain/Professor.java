/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithm.domain;

/*
 * <h1> To Implement a Professor Class </h1>
 */


public class Professor {

    private String id;
    private String name;

    /**
     * @param id   This is the first parameter to the constructor to set value of
     *             professor id
     * @param time This is the second parameter to the constructor to set
     *             professor name
     */
    public Professor(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return This is the getter for the id variable
     */

    public String getId() {
        return id;
    }

    /**
     * @return This is the getter for the name variable
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return ((this.id.equalsIgnoreCase(((Professor) obj).id)) && (this.name.equalsIgnoreCase(((Professor) obj).name)));
    }

}
