/***********************************************************************
 * This is the part that allows for multiple types of account
 * and sets the layout for them
 * @author Evan Stedman
 * @author Hamilton Graham
 **********************************************************************/

package project3;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;



public abstract class Account implements Serializable {
	
	/** this is thw account number for the bank */
	private String accountNum;
	
	/** this is the holder of the account */
	private String accountOwner;
	
	/** this is the calender layout */
	private GregorianCalendar date;
	
	/** this holds the type of account either checking or savings */
	private String type;
	
	/** how much the account has */
	private double balance;

	/** allows for serialization */
    private static final long serialVersionUID = 1L;
    
    /** adds amonthly fee to an account if checking */
    private double monthlyFee;
 
    /*******************************************************************
	 * This is just a basic constructor
	 ******************************************************************/
	public Account (){
		accountNum = "000";
		accountOwner = "N/A";
		date = new GregorianCalendar(01,01,1990);
		balance = 0;
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
	 * @returns the date in calender format
	 ******************************************************************/
	public GregorianCalendar getDate() {
		return date;
	}

	/*******************************************************************
	 * @return allows for creating string value for date
	 ******************************************************************/
	public String toString(GregorianCalendar date) {
		 SimpleDateFormat formatter=new SimpleDateFormat("yyyy MM dd"); 
		 return formatter.format(date.getTimeInMillis());
    }
	
	/*******************************************************************
	 * @returns true of an account is equal to this account else 
	 * returns false
	 ******************************************************************/
	public boolean equals(Account compAccount){
		if(this.accountNum == compAccount.getAccountNum() && 
				this.accountOwner == compAccount.getAccountOwner() &&
				this.balance == compAccount.getBalance() &&
				this.date == compAccount.getDate())
			return true;

		return false;
	}
	
	/*******************************************************************
	 * @returns entire account info as string
	 ******************************************************************/
	public String toString(){
		return accountNum + ": " + accountOwner + ": " +
				toString(date) + ": " + type + ": " + balance;
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
}