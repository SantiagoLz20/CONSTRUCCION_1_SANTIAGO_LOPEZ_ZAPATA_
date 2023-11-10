package com.mycompany.construccion_1_santiago_lopez_zapata;
/**
 *
 * @author Santiago L
 */
public class Bills {
    private String Invoice_concept;
    private float Invoice_value;
    private String Partner_name;
    private int Invoice_code;
    public Bills(String Invoice_concept, float Invoice_value, String Partner_name, int Invoice_code) {
        this.Invoice_concept = Invoice_concept;
        this.Invoice_value = Invoice_value;
        this.Partner_name = Partner_name;
        this.Invoice_code=Invoice_code;
    }

    public String getInvoice_concept() {
        return Invoice_concept;
    }

    public void setInvoice_concept(String Invoice_concept) {
        this.Invoice_concept = Invoice_concept;
    }

    public float getInvoice_value() {
        return Invoice_value;
    }

    public void setInvoice_value(float Invoice_value) {
        this.Invoice_value = Invoice_value;
    }

    public String getPartner_name() {
        return Partner_name;
    }

    public void setPartner_name(String Partner_name) {
        this.Partner_name = Partner_name;
    }

    public int getInvoice_code() {
        return Invoice_code;
    }

    public void setInvoice_code(int Invoice_code) {
        this.Invoice_code = Invoice_code;
    }
}
