/**
 * 
 */
package project3;

import java.util.Date;
import java.util.GregorianCalendar;

/***********************************************************************
 * @author Evan Stedman
 * @author Hamilton Graham
 **********************************************************************/

public class CheckingAccount extends Account {
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
    private double monthlyFee;
	/**  */
    private static final long serialVersionUID = 1L;
   
	public CheckingAccount() {
		
	}
 
    /*******************************************************************
     * 
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
	 * 
	 ******************************************************************/
	public void equals(){
		
	}
	
	/*******************************************************************
	 * 
	 ******************************************************************/
	public String toString(){
		return accountNum + ": " + accountOwner + ": " + 
				toString(date) + ": " + type + ": " + balance;
	}
}