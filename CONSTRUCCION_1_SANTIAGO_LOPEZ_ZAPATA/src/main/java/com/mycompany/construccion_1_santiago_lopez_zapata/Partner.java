
package com.mycompany.construccion_1_santiago_lopez_zapata;

/**
 *
 * @author Santiago L
 */
public class Partner extends Person{
    private float Funds_available;
    private int Subscription_type;
    private int []Unpaid_invoices;
    private int Authorized_persons;

    public Partner(int Id, String Name,float Funds_available, int Subscription_type, int []Unpaid_invoices, int Authorized_persons) {
        super(Id, Name);
        this.Funds_available = Funds_available;
        this.Subscription_type = Subscription_type;
        this.Unpaid_invoices = Unpaid_invoices;
        this.Authorized_persons = Authorized_persons;
    }

    public float getFunds_available() {
        return Funds_available;
    }

    public void setFunds_available(float Funds_available) {
        this.Funds_available = Funds_available;
    }

    public int getSubscription_type() {
        return Subscription_type;
    }

    public void setSubscription_type(int Subscription_type) {
        this.Subscription_type = Subscription_type;
    }

    public int []getUnpaid_invoices() {
        return Unpaid_invoices;
    }

    public void setUnpaid_invoices(int []Unpaid_invoices) {
        this.Unpaid_invoices = Unpaid_invoices;
    }

    public int getAuthorized_persons() {
        return Authorized_persons;
    }

    public void setAuthorized_persons(int Authorized_persons) {
        this.Authorized_persons = Authorized_persons;
    }
    
}
