package com.mycompany.construccion_1_santiago_lopez_zapata;

import javax.swing.JOptionPane;

/**
 *
 * @author Santiago L
 */
public class Controller {
    Partner list[]= new Partner[0];
    public void size()
    {
        if (list.length<=35)
        {
            Partner increase[] = new Partner[list.length];
            for(int i=0;i<list.length;i++)
            {
                increase[i]=list[i];
            }
            list=new Partner[list.length+1];
            for(int i=0;i<list.length;i++)
            {
                list[i]=increase[i];
            }
            insert();
        }else
        {
            message("The maximum number of partners has been reached");
        }
    }
    public void insert()
    {
        Partner person;
        int id,Subscription_type,Unpaid_invoices[]=new int[0],Authorized_persons=0,count=0;
        String name;
        float Funds_available;
        do
        {
            id=Integer.parseInt(text("Enter the ID: "));
            for(int i=0;i<list.length;i++)
            {
                if(list[i].getId()==id)
                {
                    count++;
                    message("ID is already registered, try again.");
                    break;
                }
            }
        }while(count!=0);
        name= text("Enter the name: ");
        Subscription_type=Subscription();
        if(Subscription_type==1)
        {
            Funds_available=100000;
        }else{Funds_available=50000;}
        person = new Partner(id,name,Funds_available,Subscription_type,Unpaid_invoices,Authorized_persons);
        list[list.length]=person;
    }
    public int Subscription()
    {
        int Option=0;
        do
        {
            Option=Integer.parseInt(text( "CHOOSE THE TYPE OF SUBSCRIPTION\n" +"\n" +
                                            "1.VIP (Initial fee: 100,000).\n" +
                                            "2.Regular (Initial fee: 50,000)"));
            if(Option==1)
            {
                int count=0;
                for(int i=0;i<list.length;i++)
                {
                    if(list[i].getSubscription_type()==1)
                    {
                        count++;
                    }
                }
                if(count==3)
                {
                    message("It is not possible to be VIP, there are no spots available.");
                    Option=0;
                }
            }
        }while(Option!=1 || Option!=2);
        
        return Option;
    }
    public String text(String message)
    {
        return JOptionPane.showInputDialog(message);
    }
    public void message(String message)
    {
        JOptionPane.showMessageDialog(null,message);
    }
    public boolean search(int id)
    {
        boolean found=false;
        for(int i=0;i<list.length;i++)
        {
            if(id==list[i].getId())
            {
                found=true;
                break;
            }
        }
        return found;
    }   
    public int found(int id)
    {
        int found=0;
        for(int i=0;i<list.length;i++)
            {
                if(id==list[i].getId())
                {
                    found=i;
                    break;
                }
            }
        return found;
    }
    public boolean Increase_funds(int id)
    {
        boolean increase=false;
        
        if(search(id)==true)
        {
            increase=how_much(Float.parseFloat(text("Enter the amount of money: ")),found(id));
        }else{message("ID not found.");}
        return increase;
    }
    public boolean how_much(float money,int found)
    {
        boolean ammount=false;
        float total;
        if(list[found].getSubscription_type()==1)
        {
            if(money+list[found].getFunds_available()>=5000000)
            {
                total=money+list[found].getFunds_available();
                list[found].setFunds_available(total);
                ammount=true;
            }else{message("you reached the funds limit");}
        }
        else if(list[found].getSubscription_type()==2)
        {
            if(money+list[found].getFunds_available()>=1000000)
            {
                total=money+list[found].getFunds_available();
                list[found].setFunds_available(total);
                ammount=true;
            }else{message("you reached the funds limit");}
        }
        return ammount;
    }
    public void New_Authorized_persons(int id)
    {
        int count=0,position=found(id);
        Controller_Authorized_Persons New = new Controller_Authorized_Persons();
        for(int i=0;i<list.length;i++)
        {
            if(list[i].getAuthorized_persons()==1)
            {
                count++;
            }
        }
        if(count<10)
        {
            if(search(id)==true && list[position].getFunds_available()>0)
            {
                if(list[position].getAuthorized_persons()==0)
                {
                    New.size(id);
                }
                else{message("The maximum number of Authorized Persons has been reached");}
            }else{message("The ID does not exist");}
        }else{message("The maximum number of Authorized Persons has been reached");}
    }
    
    Bills bills[] = new Bills[0];
    public void size_bill(int id)
    {
        Bills increase[]=new Bills[bills.length];
        for(int i=0;i<bills.length;i++)
        {
            increase[i]=bills[i];
        }
        bills=new Bills[bills.length+1];
        for(int i=0;i<bills.length-1;i++)
        {
            bills[i]=increase[i];
        }
    }
    
    public boolean insert_Bills(int Id_Partner)
    {
        boolean insert=false;
        int code=0; 
        Bills person;
        int position;
        String concept, name;
        float cost;
        position=found(Id_Partner);
        if(list[position].getUnpaid_invoices().length<20)
        {
            concept= text("Enter the concept: ");
            cost=Float.parseFloat(text("Enter the cost: "));
            if(list[position].getFunds_available()>cost)
            {
                do
                {
                    code=(int)(Math.random() *9999-1000)+ 1000;
                    insert=true;
                    for(int i=0;i<bills.length;i++)
                    {
                        if(code==bills[i].getInvoice_code())
                        {
                            insert=false;
                            break;
                        }
                    }
                }while(insert==false);
                size_bill(Id_Partner);
                name=list[position].getName();
                person = new Bills(concept, cost,name,code);
                bills[bills.length]=person;
                int size[]=new int[list[position].getUnpaid_invoices().length+1];
                for(int i=0;i<list[position].getUnpaid_invoices().length;i++)
                {
                    size[i]=list[position].getUnpaid_invoices()[i];
                }
                list[position].setUnpaid_invoices(size);
            }else{message("Insufficient funds.");}
        }else{message("Invoice limit reached.");}
        return insert;
    }
    public int total_invoices(int position)
    {
        int total=list[position].getUnpaid_invoices().length;
        return total;
    }
    public boolean Delete_Partner(int id)
    {
        int position;
        boolean result=false;
        if(search(id)==true)
        {
            position=found(id);
            if(list[position].getUnpaid_invoices().length==0)
            {
                if(list[position].getAuthorized_persons()==0)
                {
                    if(list[position].getSubscription_type()==2)
                    {
                        Partner suppress[] = new Partner[list.length-1];
                        for(int i=0;i<list.length;i++)
                        {
                            if(list[i].getId()==id){}
                            else{suppress[i]=list[i];}
                        }
                        list=new Partner[suppress.length];
                        for(int i=0;i<list.length;i++)
                        {
                            list[i]=suppress[i];
                        }
                        result=true;
                        
                    }else{message("It cannot be deleted, it is VIP.");}
                }else{message("It cannot be deleted, it has an authorized person.");}
            }else{message("Cannot be deleted, has outstanding invoices.");}
        }else{message("Partner not found.");}
        return result;
    }
    public boolean pay_bill(int id)
    {
        boolean result=false;
        int code, position;
        float value;
        if(search(id)==true)
        {
            position=found(id);
            code=Integer.parseInt(text("Enter the code of the invoice to pay: "));
            int []list_unpaid=list[position].getUnpaid_invoices();
            for(int i=0;i<list[position].getUnpaid_invoices().length;i++)
            {
                if(list_unpaid[i]==code)
                {
                    if(list[position].getFunds_available()>bills[position].getInvoice_value())
                    {
                        value=list[position].getFunds_available()-bills[position].getInvoice_value();
                        list[position].setFunds_available(value);
                        Bills suppress[] = new Bills[list.length-1];
                        for(int j=0;i<bills.length;j++)
                        {
                            if(bills[i].getInvoice_code()==code){}
                            else{suppress[i]=bills[i];}
                        }
                        bills=new Bills[suppress.length];
                        for(int j=0;j<bills.length;j++)
                        {
                            bills[i]=suppress[i];
                        }
                        result=true;
                        break;
                    }else{message("Insufficient funds.");}
                }else{message("Code not found.");}
            }
        }else{message("ID not found.");}
        return result;
    }
}

