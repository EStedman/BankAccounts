/***********************************************************************
 * @author Evan Stedman
 * @author Hamilton Graham
 **********************************************************************/

package project3;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;



public abstract class Account implements Serializable {
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
    private static final long serialVersionUID = 1L;
   
    /**  */
    private double monthlyFee;
 
	public Account (){
		
	}
	
	public String getAccountNum() {
		return accountNum;
	}


	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}


	public String getAccountOwner() {
		return accountOwner;
	}


	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}


	public GregorianCalendar getDate() {
		return date;
	}

	public String toString(GregorianCalendar date) {
		 SimpleDateFormat formatter=new SimpleDateFormat("yyyy MM dd"); 
		 return formatter.format(date.getTimeInMillis());
    }

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
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