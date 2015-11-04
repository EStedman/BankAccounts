
/**
 * @author Evan Stedman
 * @author Hamilton Graham
 * @param <Accounts>
 */

/*
 * I haven't been able to properly implement fireXupdate methods 
 */
package project3;
import java.security.acl.LastOwnerException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class BankModel extends DefaultTableModel{

	/**  */
	static ArrayList<Account> acts = new ArrayList<Account>();
	private String col[] = {"Account Number","Account Owner","Balance",
			"Information"};


	/*******************************************************************
	 * 
	 ******************************************************************/
	public BankModel() {
//		getColumnName(0);
//		getColumnName(1);
//		getColumnName(2);
//		getColumnName(3);
		acts = new ArrayList<Account>();
	}
	
	/*******************************************************************
	 * 
	 ******************************************************************/
	public BankModel(ArrayList<Account> acts) {
		this.acts = acts;
	}

	/*******************************************************************
	 * apllies the appropriate column headers
	 * @ Override
	 ******************************************************************/
	public String getColumnName(int column) {
		return col[column];
	}
		// removed when I began converting to JTable
	// override these two methods from AbstractListModel class
	//	/*******************************************************************
	//	 * 
	//	 ******************************************************************/
	//		public Object getElementAt(int row) {
	//			return acts.get(row);
	//				
	//		}
	//			
	//	/*******************************************************************
	//	 * 
	//	 ******************************************************************/
	//		public int getSize() {
	//			return acts.size() - 1;
	//				
	//		}

	/*******************************************************************
	 * 
	 ******************************************************************/
	public void sortDateCreated(){

	}

	/*******************************************************************
	 * 
	 ******************************************************************/
	public void sortAccountNum(){

	}

	/*******************************************************************
	 * 
	 ******************************************************************/
	public void sortAccountOwner(){

	}

	/*******************************************************************
	 * 
	 ******************************************************************/
	public void sortAccountType(){

	}

	/*******************************************************************
	 * 
	 ******************************************************************/
	public void saveText(){

	}

	/*******************************************************************
	 * 
	 ******************************************************************/
	public void saveBinary(){

	}

	/*******************************************************************
	 * 
	 ******************************************************************/
	public void saveXML(){

	}

	/*******************************************************************
	 * 
	 ******************************************************************/
	public void loadText(){

	}

	/*******************************************************************
	 * 
	 ******************************************************************/
	public void loadBinary(){

	}

	/*******************************************************************
	 * 
	 ******************************************************************/
	public void loadXML(){

	}

	/*******************************************************************
	 * 	@Override
	 ******************************************************************/
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	/*******************************************************************
	 * 	May actually be useless, haven't removed yet
	 * @Override
	 ******************************************************************/
	public void setValueAt(Object value, int row, int col) {
		//data[row][col] = (String) value;
		fireTableCellUpdated(row, col);
	}

	
	/*******************************************************************
	 * 
	 ******************************************************************/
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if (acts.size() == 0)
			return 40;
		else
			return acts.size();
	}

	/*******************************************************************
	 * sends the approprate objects to the JTable cells
	 ******************************************************************/
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Account a;
		if (acts.size() != 0) 
			a = acts.get(rowIndex);
		else {
			a = null;
			return null;
		}
		switch (columnIndex) {
		case 0:
			setValueAt(a.getAccountNum(), rowIndex, columnIndex);
			return a.getAccountNum();
		case 1:
			return a.getAccountOwner();
		case 2:
			return a.getBalance();
		case 3:
			if (a instanceof CheckingAccount)
				return "Monthly Fee: $" + a.getMonthlyFee();
			else if (a instanceof SavingsAccount)
				return "Min. Balance: $" + ((SavingsAccount)
								a).getMinBalance();
			
		}
		return columnIndex;
	}

	/*******************************************************************
	 * constructed a CheckingAccount and added it to an arraylist of 
	 * accounts
	 ******************************************************************/
	public void addChecking() {
		GregorianCalendar date = new GregorianCalendar(
				Integer.parseInt(BankGUI.getTextFields(8)),
				Integer.parseInt(BankGUI.getTextFields(7)) - 1,
				Integer.parseInt(BankGUI.getTextFields(6)));
		Account a = new CheckingAccount(BankGUI.getTextFields(0),
				BankGUI.getTextFields(1),
				Double.parseDouble(BankGUI.getTextFields(2)),
				Double.parseDouble(BankGUI.getTextFields(3)),
				date);
		acts.add(a);
		fireTableDataChanged();
	}

	/*******************************************************************
	 * constructed a SavingsAccount and added it to an arraylist of accounts
	 ******************************************************************/
	public void addSavings() {
		GregorianCalendar date = new GregorianCalendar(
				Integer.parseInt(BankGUI.getTextFields(8)),
				Integer.parseInt(BankGUI.getTextFields(7)) - 1,
				Integer.parseInt(BankGUI.getTextFields(6)));
		Account a = new SavingsAccount(BankGUI.getTextFields(0),
				BankGUI.getTextFields(1),
				Double.parseDouble(BankGUI.getTextFields(2)),
				Double.parseDouble(BankGUI.getTextFields(4)),
				Double.parseDouble(BankGUI.getTextFields(5)),
				date);
		acts.add(a);
		System.out.println(acts.get(acts.size()-1) + ": " + acts.size());
		System.out.println(a.getAccountOwner());
		fireTableDataChanged();
	}


	/*******************************************************************
	 * Simple enough, made the call to getRowCount to try to get around
	 * a bug where the pretty empty cells are removed when deleting an
	 * account, not properly implemented yet
	 ******************************************************************/
	public void delete(int row) {
	    acts.remove(row);
	    fireTableRowsDeleted(row, row);
	    getRowCount();
	    fireTableDataChanged();
	}

	/*******************************************************************
	 * 
	 ******************************************************************/
	public void update(int type, int row) {
		if(type == 1){
			GregorianCalendar date = new GregorianCalendar(
					Integer.parseInt(BankGUI.getTextFields(8)),
					Integer.parseInt(BankGUI.getTextFields(7)) - 1,
					Integer.parseInt(BankGUI.getTextFields(6)));
			Account b = new SavingsAccount(BankGUI.getTextFields(0),
					BankGUI.getTextFields(1),
					Double.parseDouble(BankGUI.getTextFields(2)),
					Double.parseDouble(BankGUI.getTextFields(4)),
					Double.parseDouble(BankGUI.getTextFields(5)),
					date);
			acts.set(row, b);
			fireTableDataChanged();
		}
		else if(type == 2){
			GregorianCalendar date = new GregorianCalendar(
					Integer.parseInt(BankGUI.getTextFields(8)),
					Integer.parseInt(BankGUI.getTextFields(7)) - 1,
					Integer.parseInt(BankGUI.getTextFields(6)));
			Account b = new CheckingAccount(BankGUI.getTextFields(0),
					BankGUI.getTextFields(1),
					Double.parseDouble(BankGUI.getTextFields(2)),
					Double.parseDouble(BankGUI.getTextFields(3)),
					date);
			acts.set(row, b);
			fireTableDataChanged();
		}
	}


	// add other methods as needed
}