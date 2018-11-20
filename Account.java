import java.util.Scanner;
import java.util.Random;
public class Account{
//Declaring the private field
	private  int ID;
	public    double balance;
	public  String holder;
	private long  phoneNum;
	private int bank_id;
	
	// class constructor
 public  Account(int bank_id,int ID, double balance,String holder,long  phoneNum)
	{
	   this.bank_id=bank_id;
		this.ID= ID;
		this.balance= balance;
		this.holder=holder;
		this.phoneNum=phoneNum;
	}
 public long  getPhoneNum(long  ph)
 {
 return ph;
 }
 
 public int getBankID()
 {
	 return bank_id;
 }
	//define getID method to get ID
	public  int getID(int i)
	{
		
		return ID;
		
	}
	//Define getBalance method to get balance and define condition
	public    double getBalance(double b)
	{ 
			
		if (b<0)
		{
			System.out.println("Negative number not allowed! please re-enter.");
			//System.exit(0);
			//Banks.displayMenu();
			
		}
		else if(b>20000)
		{
		System.out.println("Your starting balance must be less than 10000.00 please try again" );
		//Banks.displayMenu();
		}
		
		
		return b;
           
		}
	
      
	//Define deposit method 
	public   void deposit(double dep)
	{
		Scanner sc= new Scanner(System.in);
		if(dep>0&&dep<10000)
		{
           balance=balance+dep;
			
			System.out.println("Updated account information: ");
			
			System.out.println("ID \t\t Holder\t\tBalance");
			System.out.println("+-------------+-------------------+------------+");
		    displayInfo();
		    System.out.println("+-------------+-------------------+------------+");
			
				}
		else if(dep>10000)
		{
			System.out.println("Please enter your phone number");
			long  phonnum=sc.nextLong();
			if(phonnum==phoneNum)
			{
				Random rand= new Random();

		          int pick = rand.nextInt(900) + 100;
		          System.out.println("Your code :"+pick);
		          System.out.println("Enter the code you reseved by text message");
		          int code= sc.nextInt();
		          if(pick==code)
		          {
		        	  balance=balance+dep;
		  			
		  			System.out.println("Updated account information: ");
		  			
		  			System.out.println("ID \t\t Holder\t\tBalance");
		  			System.out.println("+-------------+-------------------+------------+");
		  		    displayInfo();
		  		    System.out.println("+-------------+-------------------+------------+");
		          }else{System.out.println("The code you entered is not correct");}
  
		          System.out.println("Your phone number is not match");
		
		}
			
		else 
		{
			System.out.println("Negative number not allowed!");
		}
		
			
	}}
	//define withdraw method and set some condition for withdraw
	public   void withdraw(double withd)
	{
		
		if(balance>0 && withd<=balance)
		{
			balance= balance-withd;
		}
		System.out.println("Withdrawing amount $"+withd+"\n");
		System.out.println("Updated account information: ");
		System.out.println("ID \t\t Holder\t\tBalance");
		System.out.println("+--------------+--------------+------------+");
	    displayInfo();
	    System.out.println("+--------------+---------------+-----------+");
	}
	//Define getHolder method
	public  String getHolder(String holder)
		{
		
		String j= new String(holder);
		if(j.length()< 5)
		{
		System.out.println("Your name must be more than 5 character");
		//System.exit(0);
		//Banks.displayMenu();
		}
		
		return holder;
		
		}
	//define displayInfo method
	public  void displayInfo()
	
	{
				
		System.out.println(ID+"\t\t"+holder+"\t\t"+"$"+balance+"      "+bank_id);
		
			
		}}
	
	
