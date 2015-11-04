
package project3;

import java.util.Date;
import java.util.GregorianCalendar;

/***********************************************************************
 * This is where the account is created if it's savings
 * @author Evan Stedman
 * @author Hamilton Graham
 **********************************************************************/
public class SavingsAccount extends Account {
	
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
	
	/** retains the monthly interest rate for an account */
	private double interest;
	
	/** Used for serialization */
    private static final long serialVersionUID = 1L;
   
    /** the minimun balance an account must have */
    private double minBalance;
    
    /** the interest rate an account pays */
    private double interestRate;
 
    /*******************************************************************
     * creates an arbitrary savings account 
     ******************************************************************/
    public SavingsAccount() {
    	accountNum = "000";
		accountOwner = "N/A";
		date = new GregorianCalendar(01,01,1990);
		balance = 0;
		interest = 0;
		minBalance = 0;
    }
    
    /*******************************************************************
     * Constructor allows for the creation of purposed savings account
     * @param accountNum a given string for the account title
     * @param accountOwner string to represent the account holder
     * @param balance a double to hold the initialized value
     * @param interest sets the interest rate to have a savings account
     * @param min sets the minimum balance to keep a saving account open
     * @param date an acceptable date on the calendar
     ******************************************************************/
	public SavingsAccount(String accountNum,
			String accountOwner,
			double balance,
			double interest,
			double min,
			GregorianCalendar date) {
		super();
		this.minBalance = min;
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.balance = balance;
		this.interest = interest;
		this.date = date;
		this.type = "Savings";
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
	 * @return the minBalance
	 ******************************************************************/
	public double getMinBalance() {
		return minBalance;
	}
	
	/*******************************************************************
	 * @param minBalance the minBalance to set
	 ******************************************************************/
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	
	/*******************************************************************
	 * @return the interestRate
	 ******************************************************************/
	public double getInterestRate() {
		return interestRate;
	}

	/*******************************************************************
	 * @param interestRate the interestRate to set
	 ******************************************************************/
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	/*******************************************************************
	 *@returns true if two checking accounts are equivalent and 
	 *returns false if the accounts are not equal
	 ******************************************************************/
	public boolean equals(Account b){
		if (this.getAccountNum() == b.getAccountNum() &&
				this.getAccountOwner() == b.getAccountOwner() &&
				this.getBalance() == b.getBalance() &&
				this.getDate() == b.getDate() &&
				this.getClass() == b.getClass())
			return true;
		else
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
