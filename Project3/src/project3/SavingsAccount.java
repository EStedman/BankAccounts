
package project3;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Evan Stedman
 * @author Hamilton Graham
 */
public class SavingsAccount extends Account {
	/**  */
	private String accountNum;
	/**  */
	private String accountOwner;
	/**  */
	private GregorianCalendar date;
	/**  */
	private String type;
	/**  */
	private double balance;
	/**  */
	private double interest;
	
	/**  */
    private static final long serialVersionUID = 1L;
   
    /**  */
    private double minBalance;
    
    /**  */
    private double interestRate;
 
    public SavingsAccount() {
    	
    }
    
    /*******************************************************************
     * 
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
	
	@Override
	public double getBalance() {
		return balance;
	}
	
	@Override
	public String getAccountNum() {
		return accountNum;
	}
	
	@Override
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
	 * wasn't really sure if this is how we were meant to implement 
	 * equals(), checks values of account a against account b
	 ******************************************************************/
	public boolean equals(Account a, Account b){
		if (a.getAccountNum() == b.getAccountNum() &&
				a.getAccountOwner() == b.getAccountOwner() &&
				a.getBalance() == b.getBalance() &&
				a.getDate() == b.getDate() &&
				a.getClass() == b.getClass())
			return true;
		else
			return false;
		
	}
	
	/*******************************************************************
	 * 
	 ******************************************************************/
	public String toString(){
		return accountNum + ": " + accountOwner + ": " +
				toString(date) + ": " + type + ": " + balance;
	}
}
