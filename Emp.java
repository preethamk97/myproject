/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.*;  
import java.util.Scanner;
import static javax.script.ScriptEngine.NAME;
class MysqlCon
{  
 
}  
public class Emp 
{

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException 
    {
          
Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//here sonoo is database name, root is username and password
   
  Connection  conn=DriverManager.getConnection( "jdbc:derby://localhost:1527/R","ROOT","ROOT"); {
        //here sonoo is database name, root is username and password
    
        Statement stmt=conn.createStatement();
        System.out.println("enter the customer details");
        System.out.println("1 to enter \n2 to display information\n3 to search for a record\n4 for transaction");
        int ch;
        Scanner scan=new Scanner(System.in);
        
         ch=scan.nextInt();
         switch(ch)
         {
                case 1:System.out.println("Enter account number");
                int acc=scan.nextInt();   
                System.out.println("name\n");
                String name=scan.next();
                System.out.println("dob\n");
                String dob=scan.next();
                System.out.println("address");
                String addr=scan.next();
                System.out.println("date of creation");
                String create_date=scan.next();

                System.out.println("account type");
                String acc_type=scan.next();
                System.out.println("mobile no");
                int mob_no=scan.nextInt();
                System.out.println("enter email");
                String cus_email=scan.next();
                System.out.println("enter balance");
                int acc_balance=scan.nextInt();
                
                
                 PreparedStatement ps;
        ps = conn.prepareStatement("INSERT INTO ROOT.BANK(ACC_NO,NAME,CUSTOMER_DOB,DATE_ACC_CREATE,ACCOUNT_TYPE,MOBILE_NUMBER,CUSTOMER_EMAIL,ACC_BALANCE,CUSTOMER_ADDRESS) VALUES(?,?,?,?,?,?,?,?,?)");
          ps.setInt(1, acc);
                ps.setString(2, name);             
                ps.setString(3,dob);
                ps.setString(4,create_date);
                   ps.setString(5,acc_type);
                    ps.setInt(6,mob_no);
                     ps.setString(7,cus_email);
                     ps.setDouble(8,acc_balance);                   
                      ps.setString(9,addr);
                        ps.executeUpdate();
           case 2:

           

           

        

     ResultSet rs=stmt.executeQuery("select * from ROOT.BANK");

    

       while (rs.next()) 
       {

    for(int i = 1; i < 10; i++)

        System.out.print(rs.getString(i)+"\t");

               

    System.out.println();
       }

       break;

       case 3:System.out.println("enter customer id");
              String cus_id=scan.next();

              PreparedStatement pst;

              pst = conn.prepareStatement("SELECT* FROM ROOT.BANK WHERE ACC_NO=?");

              pst.setString(1, cus_id);

 

             ResultSet rst;

             rst = pst.executeQuery();

      while(rst.next())

      {

          for (int i=1;i<10;i++)

          {

                 System.out.print(rst.getString(i)+"\t");

          }

      }
                case 4:transaction();

          

            }              
            }
           
        
    //    ResultSet rs=stmt.executeQuery("select * from ROOT.DETAILS");
       // while(rs.next())
         //   System.out.println(rs.getString(1));
         
    }
    public static void transaction()throws SQLException, ClassNotFoundException 
    {
          
Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
Connection  conn=DriverManager.getConnection( "jdbc:derby://localhost:1527/R","ROOT","ROOT"); 
            
        Statement stmt=conn.createStatement();
    
        int fina=0;
        System.out.println("Enter 1 to verify the account details\n2 to check balance\n3 for withdrawal\n4 for deposit");
        Scanner sc=new Scanner(System.in);
        int ch=sc.nextInt();
        switch(ch)
        {
            case 1:System.out.println("Enter the account number");
                   String acc=sc.next();
                    PreparedStatement pst;

              pst = conn.prepareStatement("SELECT* FROM ROOT.BANK WHERE ACC_NO=?");

              pst.setString(1,acc);

 

             ResultSet rst;

             rst = pst.executeQuery();

           while(rst.next())

           {

             for (int i=1;i<10;i++)

              {

                 System.out.print(rst.getString(i)+"\t");

              }
            }
           return;
           
            case 2:System.out.println("Enter the account number");
                    acc=sc.next();
                   

                    pst = conn.prepareStatement("SELECT ACC_BALANCE FROM ROOT.BANK WHERE ACC_NO=?");

                    pst.setString(1,acc);

                    rst = pst.executeQuery();

                    while(rst.next())

                    {

                     for (int i=1;i<10;i++)

                       {

                         System.out.print(rst.getString(i)+"\t");

                        }
                     }
                    System.exit(0);
                    break;
            case 3:System.out.println("Enter the account number");
                    acc=sc.next();
                   String var=null;

                    pst = conn.prepareStatement("SELECT ACC_BALANCE FROM ROOT.BANK WHERE ACC_NO=?");

                    pst.setString(1,acc);

                    rst = pst.executeQuery();
                     while(rst.next())

                    {

                     
                      for (int i=1;i<10;i++)

                       {

                         System.out.print(rst.getString(i)+"\t");

                        }


                        }
                     System.out.println("Enter the amount to deposit");
                     String amt=sc.next();
                     
                     
                     var=var+amt;
                     pst = conn.prepareStatement("UPDATE ROOT.BANK SET ACC_BALANCE="+var+"WHERE ACC_NO=?");

                    pst.setString(1,acc);
                    System.exit(0);
                    break;
            case 4:
                   System.out.println("Enter the account number");
                    acc=sc.next();
                   var=null;

                    pst = conn.prepareStatement("SELECT ACC_BALANCE FROM ROOT.BANK WHERE ACC_NO=?");

                    pst.setString(1,acc);

                    rst = pst.executeQuery();
                     while(rst.next())

                    {

                     
                      for (int i=1;i<10;i++)

                       {

                         System.out.print(rst.getString(i)+"\t");

                        }


                        }
                     System.out.println("Enter the amount to withdraw");
                     amt=sc.next();
                     
                     while(amt!=null&&var!=null&&(var.compareTo(amt)>0))
                     {
                         int  fina_ = Integer.parseInt(var) - Integer.parseInt(amt);
                     }
                     System.out.println("The modified balance is"+fina);
                     
                     String f=Integer.toString(fina);
                     pst = conn.prepareStatement("UPDATE ROOT.BANK SET ACC_BALANCE="+f+"WHERE ACC_NO=?");

                    pst.setString(1,acc);
                    return;
                    
                    
            default:System.out.println("Invalid option");   
                    System.exit(0);
    }
}
class account_type extends Emp
{   
    public  void account()  throws SQLException, ClassNotFoundException 
    {
          
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      
        Connection  conn=DriverManager.getConnection( "jdbc:derby://localhost:1527/R","ROOT","ROOT");
      for(;;)
      {
        System.out.println("Enter the type of account");
        System.out.println("Enter 1 for current deposits\n2 for savings bank\n3 for recurring deposit\n4 for fixed deposit");
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        switch(choice)
        {
            case 1:   System.out.println("enter account number");
                      String accno=sc.next();

                      PreparedStatement pst;

                      pst = conn.prepareStatement("SELECT* FROM ROOT.BANK WHERE ACC_NO=?");

                      pst.setString(1,accno);

 

                      ResultSet rst;

                      rst = pst.executeQuery();
                       long start=System.currentTimeMillis();
                       System.out.println("Enter the initial amount of deposit:");  
                       float initial=sc.nextFloat();  
                       if(initial<100)  
                       {  
                            System.out.println("Invalid Amount\nTry again:\n");  
                            System.out.println("Enter the initial amount of deposit:");  
                            initial=sc.nextFloat();  
                       }
                       System.out.println("Enter the period of account (in days)");
                       float period=sc.nextFloat();
                       double f=initial+(initial*period*5.5);
                       
            case 2:    System.out.println("enter account number");
                      accno=sc.next();

              
                      pst = conn.prepareStatement("SELECT* FROM ROOT.BANK WHERE ACC_NO=?");

                      pst.setString(1,accno);

 

                       

                      rst = pst.executeQuery();
                       start=System.currentTimeMillis();
                       System.out.println("Enter the initial amount of deposit:");  
                        initial=sc.nextFloat();  
                       if(initial<100)  
                       {  
                            System.out.println("Invalid Amount\nTry again:\n");  
                            System.out.println("Enter the initial amount of deposit:");  
                            initial=sc.nextFloat();  
                       }        
                       System.out.println("Enter the period of account (in days)");
                       period=sc.nextFloat();
                       f=initial+(period*6.5);
                       
                       
                       
        }            
      }
    }
}
}