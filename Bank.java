import java.util.*;

import java.io.*;
 abstract class Customer{
	protected String name,acc_type;
	protected long acc_no;
	protected double balance;
	//protected int date;
	abstract  void get_details() throws IOException;
}
class Defaults{
	
	private double sav,cur,fix,rec;
	private double sr,cr,fr,rr;
	public void read_def() throws IOException{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the minimum balance for savings account");
		sav=sc.nextDouble();
		System.out.println("Enter the rate of interest for savings account");
		sr=sc.nextDouble();
		System.out.println("Enter the minimum balance for current account");
		cur=sc.nextDouble();
		/*System.out.println("Enter the rate of interest for current account");
		cr=sc.nextDouble();*/
		System.out.println("Enter the minimum balance for fixed deposit account");
		fix=sc.nextDouble();
		System.out.println("Enter the rate of interest for fixed deposit account");
		fr=sc.nextDouble();
		System.out.println("Enter the minimum balance for Recurring deposit account");
		rec=sc.nextDouble();
		System.out.println("Enter the rate of interest for Recurring deposit  account");
		rr=sc.nextDouble();
		FileWriter fw=new FileWriter("Defaults.txt");
		fw.write(System.lineSeparator());
		fw.write("Savings_account "+Double.toString(sav)+" "+Double.toString(sr));
		fw.write(System.lineSeparator());
		fw.write("Current_account "+Double.toString(cur));
		fw.write(System.lineSeparator());
		fw.write("Fixed_account "+Double.toString(fix)+" "+Double.toString(fr));
		fw.write(System.lineSeparator());
		fw.write("Recurring_account "+Double.toString(rec)+"  "+Double.toString(rr));
		fw.write(System.lineSeparator());
		fw.close();
	}
}
class Create_Account extends Customer{
	Scanner sc=new Scanner(System.in);
	public void get_details() throws IOException{
		System.out.println("Enter the Name of the customer");
		name=sc.next();
		System.out.println("Enter the Account number");
		acc_no=sc.nextLong();
		//check if acc number already exists
		System.out.print("Enter the type of account\nsaving->savings account\ncurrent->current account\nfixed->fixed deposit\nrecurring->recurring deposit");
		acc_type=sc.next();
		acc_type.toLowerCase();
		//check if acc_type is proper
		char ch=acc_type.charAt(0);
		FileReader fr=new FileReader("Defaults.txt");
		BufferedReader br=new BufferedReader(fr);
		String temp[],temp2[];
		String s;
		int i=0,j=0;
		double bal=0;
		switch(ch){
		case 's':
			System.out.println("Enter the minimum balance");
			balance=sc.nextDouble();
			s=br.readLine();
			temp=s.split(" ");
			
			bal=Double.parseDouble(temp[1]);
			if(balance<bal){
				System.out.println("Minimun balance should be :"+bal);
				return;
			}
				break;	
		case 'c':
			System.out.println("Enter the minimum balance");
			balance=sc.nextDouble();
			s=br.readLine();
			s=br.readLine();
			temp=s.split(" ");
			
			bal=Double.parseDouble(temp[1]);
			if(balance<bal){
				System.out.println("Minimun balance should be :"+bal);
				return;
			}
			
		break;
	}
}
}
public class Bank {
	public static void main(String args[]) throws IOException{
		//Defaults def=new Defaults();
		Create_Account ca=new Create_Account();
		//def.read_def();
		ca.get_details();
	}
}

