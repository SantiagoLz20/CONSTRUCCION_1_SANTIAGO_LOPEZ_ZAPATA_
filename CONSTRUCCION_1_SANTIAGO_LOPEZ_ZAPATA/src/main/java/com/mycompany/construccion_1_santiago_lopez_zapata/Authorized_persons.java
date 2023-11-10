package com.mycompany.construccion_1_santiago_lopez_zapata;

/**
 *
 * @author Santiago L
 */
public class Authorized_persons extends Person{
    private int Id_Partner;

    public Authorized_persons(int Id, String Name, int Id_Partner) {
        super(Id, Name);
        this.Id_Partner = Id_Partner;
    }

    public int getId_Partner() {
        return Id_Partner;
    }

    public void setId_Partner(int Id_Partner) {
        this.Id_Partner = Id_Partner;
    }
    
}
