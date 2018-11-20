import java.util.Scanner;
import java.util.ArrayList;

public class Banks{
	//private field for bank class
	private   String name;
	private   String owners;
	private  int ID;
	private  int bank_id;
	private   String division;
	private  int numAccounts=0;
	private  double totalBalance=0;
	private static int nextID=1000;
	private   ArrayList<Account> accounts = new ArrayList<Account>();
	private   ArrayList<Banks> banks = new ArrayList<Banks>();
	
	public Banks(String name, String owners, int ID,String division)
	{
	this.name=name;
	this.owners=owners;
	this.ID=ID;
	this.division=division;
	}
	//Define displayMenu method
	public   void  displayMenu()
	{System.out.println("**********************************************************");
		System.out.println("Welcome to Our Banks.\n");
	    System.out.println("B - Bank Information \n");
	    System.out.println("Nb - New Bank \n");
	    System.out.println("La - List of account in Bank \n");
	    System.out.println("Bs - all banks summary \n");
	    System.out.println("N - New Account \n");
	    System.out.println("L - List all accounts \n");
	    System.out.println("T - Trnsfer Money\n");
	    System.out.println("Bo- Give Bonus\n");
	    System.out.println("S - search accounts by ID \n");
	    System.out.println("A - Display AccountMenu \n");
	    System.out.println("Q - Quit program \n");
	    System.out.println("? - Help menu \n");
	    System.out.println("**********************************************************");
	    System.out.println("\n");
	    System.out.println("Please enter the command at the prompt\n");
	    System.out.println("==> ?");
	
	    Scanner sc = new Scanner(System.in);
	    String choise= sc.nextLine();{
	    if(choise.equals("B"))
	    {
	    	displayBankInfo();
	    }
	    else if(choise.equals("N"))
	    {
	    	
	    	newAccount(accounts);
	    	displayMenu();
	    }
	    else if(choise.equals("Bs"))
	    {
	    	summary_Of_Bank_info();
	    	displayMenu();
	    }
	    else if(choise.equals("L"))
	    {
	    	listAccounts(accounts);
	    	displayMenu();
	    }
	    else if(choise.equals("T"))
	    {
	    	TransferMoney(accounts);
	    	displayMenu();
	    }
	    else if(choise.equals("Bo"))
	    {
	    	Bonus(accounts);
	    	displayMenu();
	    }
	    else if(choise.equals("S"))
	    {
	    	searchID(accounts);
	    	displayMenu();
	    	}
	    else if(choise.equals("Nb"))
	    {
	    	create_new_bank();
	    	
	    	displayMenu();
	    	}
	    else if(choise.equals("La"))
	    {
	    	list_account_in_bank();
	    	
	    	displayMenu();
	    	}
	    else if(choise.equals("Q"))
	    {
	    	System.out.println("Exiting program.  Sayonara!!");
	    	System.exit(0);
	    	}
	    else if(choise.equals("?"))
	    {
	    	System.out.println("Do you need help?");
	    	}
	    else
	    {
	    	System.out.println(choise+" is not valid menu item");
	    	displayMenu();
	    	}
	    }}
		
	//Define displayAccountMenu method
	public   void displayAccountMenu(int SearchedID)
	{
	System.out.println("M - Main Menu \n");
	System.out.println("D - Deposit to account \n");
	System.out.println("W - Withdraw from account \n");
	System.out.println("B - Balance Information \n");
	System.out.println("X - Delete account \n");
	System.out.println("? - Help menu \n");
	System.out.println("Account "+SearchedID+"==>");
	Scanner sc = new Scanner(System.in);
    String choise= sc.nextLine();{
    if(choise.equals("M"))
    {
    	displayMenu();
    }
    else if(choise.equals("D"))
    {
       	
    	deposit(accounts,SearchedID);	
    	displayAccountMenu(SearchedID);
    }
    else if(choise.equals("W"))
    {
    	withdraw(accounts,SearchedID);
    	displayAccountMenu(SearchedID);
    }
    else if(choise.equals("B"))
    {
    	balance(accounts,SearchedID);
    displayAccountMenu(SearchedID);
    }
    else if(choise.equals("X"))
    {
    	delete(accounts,SearchedID);
    displayAccountMenu(SearchedID);
        }
    else if(choise.equals("?"))
    {
    	//help
    }
    else
    {System.out.println(choise+" is not valid menu item");}
    }
	}
	
	public  void create_new_bank()
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter bank's name :");
		name = sc.nextLine();
		System.out.println("Enter bank's owner :");
		owners=sc.nextLine();
		System.out.println("Enter bank's ID :");
		ID= sc.nextInt();
		System.out.println("Enter bank's division :");
		 division=sc.nextLine();
		 division=sc.nextLine();
		
		Banks b= new Banks(name,owners,ID,division);
		//Banks j=new Banks(b.getBankName(name),b.getBankOwners(owners),b.getBankID(ID),b.getBankDivision(division));
		banks.add(b);
		
	}
	
	//define displayBankInfo method
	public void  displayBankInfo()
	{
		name= "Dean Bank";
		owners="Dean Zeller, Stephen Lowery";
		ID=31415;
		division= "Colorado";
		System.out.println("Bank Information");
		System.out.println("Bank Name :"+name);
		System.out.println("Owners: "+owners);
		System.out.println("ID: "+ID);
		System.out.println("Division: "+division);
		System.out.println("# Account: "+numAccounts);
		System.out.println("Total Balance: "+getTotalBalance(accounts));
		displayMenu();
		
	}
			
	//Define listAccounts method
	public   void listAccounts(ArrayList<Account> accounts)
	{
		System.out.println("List Accounts");
		if(!(accounts.isEmpty()))
		{
		System.out.println("ID\t\tHolder\t\tBalance\t\tBank ID");
		System.out.println("+---------+-------------+----------------------");
		for(int i=0; i<accounts.size();i++)
		{
				
		accounts.get(i).displayInfo();
		   
		    
		}
		System.out.println("+---------+------------------------+-------------");
		System.out.println("# Account :"+numAccounts);
		System.out.println("Total Balance :"+getTotalBalance(accounts));
		
		}
		else
		{System.out.println("<There are no accounts>");
		System.out.println("# Account :"+numAccounts);
		System.out.println("Total Balance :"+getTotalBalance(accounts));
		}
	}
	public  void creatA()
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter bank id account create for");
		int bank_id=sc.nextInt();
		for(int i=0;i<banks.size();i++)
		{
			
			 if(bank_id==banks.get(i).getBankID())
			 {
				 
			 }
			 }
		
	}
	//define newAccount method
	public   void newAccount(ArrayList<Account> accounts)
	{
		
		Scanner sc= new Scanner(System.in);
			
				
		System.out.println("Please enter account holder name ");
		 String holder= sc.nextLine();
		System.out.println("Please enter Starting balance");
		  double balance= sc.nextDouble();
		  System.out.println("Please enter phone number"); 
		  long  phonnum= sc.nextLong();
		  System.out.println("Enter bank id account create for");
			 bank_id=sc.nextInt();
			for(int i=0;i<banks.size();i++)
			{
				
				 if(bank_id==banks.get(i).getBankID()){
		  
		Account a= new Account(bank_id,nextID,balance,holder,phonnum);
		Account k = new Account(a.getBankID(),a.getID(nextID),a.getBalance(balance),a.getHolder(holder),a.getPhoneNum(phonnum));
		
		accounts.add(k);
		numAccounts++;
		System.out.println("Account "+nextID+" created for "+holder+" with a starting balance of $"+balance+"under bank id"+bank_id+"\n");
				
	     nextID++;
		
		displayMenu();
		
			 }
			 else{System.out.println("Bank id you enterd invalid");}
			 }
	}
	//Define deposit method
	public  void deposit(ArrayList<Account> accounts,int SearchedID)
	{     
	
		Scanner sc= new Scanner(System.in);
		
		for(int i=0; i<accounts.size();i++){
			Account a= accounts.get(i);
	    	int k= a.getID(i);
	    	if(k==SearchedID)
	    	{
	    			    	        		
	    		System.out.println("Enter the amount to deposit");
	    		double dip= sc.nextDouble();
	    		accounts.get(i).deposit(dip);
	    			    		
	    	}
			
		}
					
	}
	//define withdraw method
	public   void withdraw(ArrayList<Account> accounts,int SearchedID)
	{
       Scanner sc= new Scanner(System.in);
		
		for(int i=0; i<accounts.size();i++){
			Account a= accounts.get(i);
	    	int k= a.getID(i);
	    	if(k==SearchedID)
	    	{
	    		System.out.println("Withdrawing funds.\n");	    	        		
	    		System.out.println("Enter the amount to withdraw");
	    		double with= sc.nextDouble();
	    		accounts.get(i).withdraw(with);
	    			    		
	    	}
			
		}
		
		
	}
	
	//define balance method
	public  void balance(ArrayList<Account> accounts,int SearchedID)
	{
		
		int bal= SearchedID;
		
		for(int i=0; i<accounts.size();i++){
	    	Account a= accounts.get(i);
	    	int k= a.getID(nextID);
	    	if(k==SearchedID){
	    		System.out.println("ID\t\tHolder\t\tBalnce");
	    		System.out.println("-------------------------------------------");
	    	accounts.get(i).displayInfo();}}
		System.out.println("-------------------------------------------");
	}
	//define delete method
	public  void delete(ArrayList<Account> accounts,int SearchedID )
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Are you sure to delete the account?(Y/N)");
		String t= sc.nextLine();
		int IDtoDelete= SearchedID;
		if(t.equalsIgnoreCase("y"))
		{
		  for(int i=0; i<accounts.size();i++){
			Account del=accounts.get(i);
			int d=del.getID(i);
			 if(d==IDtoDelete){
			accounts.remove(i);
			 System.out.println("Account "+IDtoDelete+" seccessfully deleted\n");
			  numAccounts--;
			
			 displayMenu();}
			 
		} {System.out.println("try again");}
	
	}}
	//define getTotalBalance method
	public  double getTotalBalance(ArrayList<Account> accounts)
	{
		totalBalance=0;
	for(int i =0; i<accounts.size();i++)
		
	{ 
		Account bal= accounts.get(i);
		double b= bal.balance;
		 totalBalance= totalBalance+b;
		 
	}
	return  totalBalance;
	}
	//define search method
	public  void searchID(ArrayList<Account> accounts)
	{
	System.out.println("Search Accounts :");
	if(!(accounts.isEmpty()))
	{
	Scanner search = new Scanner(System.in);
	System.out.println("Enter account ID: ");
	int SearchedID= search.nextInt();
	
   for(int i=0; i<accounts.size();i++)	
	
   {
	    	Account a= accounts.get(i);
	    	int k= a.getID(i);
	    	
	   if(k==SearchedID){
	    	
	    	System.out.println("Account(s):");
	    	System.out.println("ID\t\tHolder\t\tBalance");
	    	System.out.println("----------+----------------+----------------");
	    	 accounts.get(i).displayInfo();
	    	System.out.println("------------+---------------+---------------");
	   
	    	Scanner x= new Scanner(System.in);
	    	 System.out.println("IS this account correct?(Y/N)");
	    	 String t= x.nextLine();
	    	   while(t.equalsIgnoreCase("Y"))
	    	    {
	    	 	    	 
	    	   displayAccountMenu(SearchedID);
	            }}}
	    	
           {System.out.println("Account"+SearchedID+"not exist");}
	   }
	
   else
   {System.out.println("<There are no account>");
   }
	
}
//Transfer method that transfer money from one account to another	
public  void TransferMoney(ArrayList<Account> accounts)
{
	Scanner ba = new Scanner(System.in);
	System.out.println("Enter bank id money transfer from");
	int bank_T_ID= ba.nextInt();
	for(int t=0; t<banks.size();t++)
	{
		Banks bk= banks.get(t);
		int sid=bk.getBankID();
		if(bank_T_ID==sid)
		{
	System.out.println("Enter account Id transfer from");
Scanner sc= new Scanner(System.in);	
int TraID= sc.nextInt();
for(int i=0; i<accounts.size();i++)
{
	Account a= accounts.get(i);
	int j= a.getID(i);
	if(j==TraID)
	{
		System.out.println("Enter the amount of money to trnsfer");
		double tmoney= sc.nextDouble();
		accounts.get(i).withdraw(tmoney);
		System.out.println("Enter bank ID money transfer to");
		int bank_ID_2T = sc.nextInt();
		for(int t2=0;t2<banks.size();t2++)
		{
			Banks bk2= banks.get(t2);
			int sid2=bk2.getBankID();
			if(bank_ID_2T==sid2)
			{
		System.out.println("Enter account ID transfer in to");
		int TranInTo= sc.nextInt();
		for(int q=0; q<accounts.size();q++)
		{
			Account b= accounts.get(q);
			int w=b.getID(q);
			if(w==TranInTo)
			{
				accounts.get(q).deposit(tmoney);
			}
		}
	}
}
}}}
		//else {System.out.println("Invalid bank Id number");}
	}
	
}
//Bonus method that is automated and if the condition is fulfill it give the bonus to every account that fulfill the condition  
public  void Bonus(ArrayList<Account> accounts)
{
	
	double bounce=50.0;
	for(int i=0; i<accounts.size();i++)
	{
		Account a=accounts.get(i);
		
		
		if(a.balance>10000)
		{
			accounts.get(i).deposit(bounce);
			
		}
	}
	
	}
public  void list_account_in_bank()
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter bank id");
	int ba_id=sc.nextInt();
	for(int v=0;v<banks.size();v++)
	{
		if(ba_id==banks.get(v).getBankID())
		{
	
	for(int i=0;i<accounts.size();i++)
	{
		if(ba_id==accounts.get(i).getBankID());
		{
			accounts.get(i).displayInfo();
		}
	}
	//System.out.println("Invalid bank id");
		}}
}
public  void summary_Of_Bank_info()
{ int count=0;
  double t_balance=0;
  System.out.println("Name\t\tOwners\t\tID\t\tDivision ");
  System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*-*-*-*-*-*-");
	for(int i=0;i<banks.size();i++)
	{
		for(int j=0;j<accounts.size();j++)
		{
			if(banks.get(i).getBankID()==accounts.get(j).getBankID())
			{
				count++;
				t_balance=t_balance+accounts.get(j).balance;
			}
					
		}
		banks.get(i).print_bank_info();
		System.out.println("\n");
		System.out.println("Number of Accounts \t  "+count);
		System.out.println("Total balance of Banks \t  "+t_balance);
		System.out.println("\n");
		count = 0;
		t_balance=0;
	}
	System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*-*-*-*-*-*-");
}
public String getBankName()
{
	return name;
}
public String getBankOwners()
{
	return owners;
}
public int getBankID()
{
	return ID;
}
public String getBankDivision()
{
	return division;
}
public  void  print_bank_info()
{
//System.out.println("Name     "+  "Owners     "+     "ID       "      +"Division ");
//System.out.println("----------------------------------------------------");
System.out.println(name+"\t\t"+owners+"\t\t"+ID+"\t\t"+division);	
}
}

