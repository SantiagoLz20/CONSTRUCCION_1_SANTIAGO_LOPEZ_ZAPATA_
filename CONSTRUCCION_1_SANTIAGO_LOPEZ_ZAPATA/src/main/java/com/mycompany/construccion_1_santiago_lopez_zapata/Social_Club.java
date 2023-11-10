package com.mycompany.construccion_1_santiago_lopez_zapata;

import javax.swing.JOptionPane;

/**
 *
 * @author Santiago L
 */
public class Social_Club {
    public static void main(String[] args) {
        Controller manage = new Controller();
        int option=7,id;
        do
        {
            option=Integer.parseInt(JOptionPane.showInputDialog("MENU\n" +
            "1. Affiliate Partner.\n" +
            "2. Register authorized person.\n" +
            "3. Pay a bill.\n" +
            "4. Record consumption.\n" +
            "5. Increase funds.\n" +
            "6. Delete partner."));
            switch(option)
            {
                case 1:
                    manage.size();
                    break;
                case 2:
                    id=Integer.parseInt(JOptionPane.showInputDialog("Enter the member's ID: "));
                    manage.New_Authorized_persons(id);
                    break;
                case 3:
                    id=Integer.parseInt(JOptionPane.showInputDialog("Enter the member's ID: "));
                    manage.pay_bill(id);
                    break;
                case 4:
                    id=Integer.parseInt(JOptionPane.showInputDialog("Enter the member's ID: "));
                    manage.insert_Bills(id);
                    break;
                case 5:
                    id=Integer.parseInt(JOptionPane.showInputDialog("Enter the member's ID: "));
                    if(manage.Increase_funds(id)==true)
                    {
                        JOptionPane.showMessageDialog(null, "Increased funds.");
                    }
                    break;
                case 6:
                    id=Integer.parseInt(JOptionPane.showInputDialog("Enter the member's ID: "));
                    if(manage.Delete_Partner(id)==true)
                    {
                        JOptionPane.showMessageDialog(null, "removed partner.");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Option does not exist try again:");
            }
                
        }while(option!=0);
        
    }
    
}
