package com.mycompany.construccion_1_santiago_lopez_zapata;

import javax.swing.JOptionPane;

/**
 *
 * @author Santiago L
 */
public class Controller_Authorized_Persons {
    Authorized_persons list[]= new Authorized_persons[0];
    public void size(int id)
    {
        Authorized_persons increase[] = new Authorized_persons[list.length];
        for(int i=0;i<list.length;i++)
        {
            increase[i]=list[i];
        }
        list=new Authorized_persons[list.length+1];
        for(int i=0;i<list.length-1;i++)
        {
            list[i]=increase[i];
        }
        insert(id);
    }
    public void insert(int Id_Partner)
    {
        Authorized_persons person;
        int id,count=0;
        String name;
        do
        {
            id=Integer.parseInt(text("Enter the ID: "));
            for(int i=0;i<list.length;i++)
            {
                if(list[i].getId()==id)
                {
                    count++;
                    text("ID is already registered, try again.");
                    break;
                }
            }
        }while(count!=0);
        name= text("Enter the name: ");
        person = new Authorized_persons(id,name,Id_Partner);
        list[list.length]=person;
        message("Authorized person successfully entered.");
    }
    public String text(String message)
    {
        return JOptionPane.showInputDialog(message);
    } 
    public void message(String message)
    {
        JOptionPane.showMessageDialog(null,message);
    }
    public boolean Delete_authorized(int id)
    {
        Controller New = new Controller();
        boolean found= false;
        for(int i=0;i<list.length;i++)
        {
            if(id==list[i].getId())
                {
                    if(New.total_invoices(i)==0)
                    {
                        Authorized_persons decrease[] = new Authorized_persons[list.length-1];
                        for(int k=0;k<list.length;k++)
                        {
                            if(id==list[i].getId()){}
                            else{decrease[k]=list[k];}
                            
                        }
                        list=decrease;
                        for(int h=0;h<list.length;h++)
                        {
                            list[h]=decrease[h];
                        }
                        found=true;
                        break;
                        // Reducir la persona autorizada si es true
                    }
                }
        }
        return found;
    }
}
