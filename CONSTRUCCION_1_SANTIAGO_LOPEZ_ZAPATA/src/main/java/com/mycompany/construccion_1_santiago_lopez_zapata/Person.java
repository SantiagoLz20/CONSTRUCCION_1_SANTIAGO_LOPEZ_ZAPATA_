
package com.mycompany.construccion_1_santiago_lopez_zapata;
/**
 *
 * @author Santiago L
 */
public class Person {
    private int Id;
    private String Name;

    public Person(int Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
}
