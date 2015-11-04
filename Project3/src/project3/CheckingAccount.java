package project3;

import java.util.Date;
import java.util.GregorianCalendar;

/***********************************************************************
 * This is where the account is created if it's checking
 * @author Evan Stedman
 * @author Hamilton Graham
 **********************************************************************/

public class CheckingAccount extends Account {
	
	/** represents the account for the bank */
	private String accountNum;
	
	/** represents the account holder */
	private String accountOwner;
	
	/** holds the type checking */
	private String type;
	
	/** holds the date of the transaction */
	private GregorianCalendar date;
	
	/** the current dollar value of the account */
	private double balance;
    
	/** the value of the fee for a certain checking account */
    private double monthlyFee;
	
    /** used to enforce serializable */
    private static final long serialVersionUID = 1L;
   
    /**
     * Constructor that Initializes an account with arbitrary values
     */
	public CheckingAccount() {
		accountNum = "000";
		accountOwner = "N/A";
		date = new GregorianCalendar(01,01,1990);
		balance = 0;
		monthlyFee = 0;
		
	}
 
    /*******************************************************************
     * Constructor allows for the creation of purposed checking account
     * @param accountNum a given string for the account title
     * @param accountOwner string to represent the account holder
     * @param balance a double to hold the initialized value'
     * @param fee the monthly fee an account has to pay
     * @param date an acceptable date on the calendar
     ******************************************************************/
	public CheckingAccount(String accountNum,
			String accountOwner,
			double balance,
			double fee,
			GregorianCalendar date){
		super();
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.balance = balance;
		this.monthlyFee = fee;
		this.date = date;
		this.type = "Checking";
		
	}
	
	/*******************************************************************
	 * @param balance the current/initial balance of the account
	 ******************************************************************/
	public void setbalance(double balance) {
		this.balance = balance;
	}
	
	/*******************************************************************
	 * @return the current balance
	 ******************************************************************/
	public double getBalance() {
		return balance;
	}
	
	/*******************************************************************
	 * @param accountNum is the current accounts I.D.
	 ******************************************************************/
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	/*******************************************************************
	 * @return accountNum is the current accounts number for the bank to
	 * know
	 ******************************************************************/
	public String getAccountNum() {
		return accountNum;
	}
	
	/*******************************************************************
	 * @param accountOwner is the person who owns the current account
	 ******************************************************************/
	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}
	
	/*******************************************************************
	 * @return the holder of the account
	 ******************************************************************/
	public String getAccountOwner() {
		return accountOwner;
	}
	
	/*******************************************************************
	 * @return the monthlyFee
	 ******************************************************************/
	public double getMonthlyFee() {
		return monthlyFee;
	}
	
	/*******************************************************************
	 * @param monthlyFee the monthlyFee to set
	 ******************************************************************/
	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}
	
	/*******************************************************************
	 * @returns true if two checking accounts are equivalent and 
	 * returns false if the accounts are not equal
	 ******************************************************************/
	public boolean equals(Account compAccount){
		if(this.accountNum == compAccount.getAccountNum() && 
				this.accountOwner == compAccount.getAccountOwner() &&
				this.balance == compAccount.getBalance() &&
				this.date == compAccount.getDate() &&
				this.monthlyFee == compAccount.getMonthlyFee())
			return true;

		return false;
	}
	
	/*******************************************************************
	 * @return all of the account info as a single string
	 ******************************************************************/
	public String toString(){
		return accountNum + ":" + accountOwner + ":" + 
				toString(date) + ":" + type + ":" + balance;
	}
}