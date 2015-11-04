	
	/******************************************************************
	 * This part of the program runs the arraylist of accounts and reads
	 * in files when necessary.
	 * @author Evan Stedman
	 * @author Hamilton Graham
	 * @param <Accounts>
	 ******************************************************************/
	
	package project3;
	import java.security.acl.LastOwnerException;
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.ObjectOutputStream;
	import java.io.PrintWriter;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.GregorianCalendar;
	import java.util.Scanner;
	import javax.swing.*;
	import javax.swing.table.AbstractTableModel;
	import javax.swing.table.DefaultTableModel;
	
	public class BankModel extends DefaultTableModel{
	
		/** a list of accouns */
		static ArrayList<Account> acts = new ArrayList<Account>();
		
		/** used to parse info into the account */
		private String col[] = {"Account Number","Account Owner","Balance",
				"Information"};
	
		/*******************************************************************
		 * Cunstructor that sets up a Generic arraylist called acts
		 ******************************************************************/
		public BankModel() {
	//		getColumnName(0);
	//		getColumnName(1);
	//		getColumnName(2);
	//		getColumnName(3);
			acts = new ArrayList<Account>();
		}
		
		/*******************************************************************
		 * Allows for a copy of the arraylist for MVC
		 * @param acts the current list of accounts
		 ******************************************************************/
		public BankModel(ArrayList<Account> acts) {
			this.acts = acts;
		}
	
		/*******************************************************************
		 * apllies the appropriate column headers
		 * @param column is the number of pieces of info we need for account
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
		 * sorts the data by date created, earlier dates first
		 ******************************************************************/
		public void sortDateCreated(){
	
		}
	
		/*******************************************************************
		 * sorts the data by accountnum, smaller accounts first
		 ******************************************************************/
		public void sortAccountNum(){
	
		}
	
		/*******************************************************************
		 * sorts accounts by owner first by lower number then alphabetically
		 ******************************************************************/
		public void sortAccountOwner(){
	
		}
	
		/*******************************************************************
		 * sorts accounts between checking and savings type
		 ******************************************************************/
		public void sortAccountType(){
	
		}
	
		/*******************************************************************
		 * This method saves the current arraylist of accounts as a text 
		 * file to be read in
		 * @param file is the local directory to store the accounts
		 * @throws IOException 
		 ******************************************************************/
		public void saveText(String file) throws FileNotFoundException {
		    PrintWriter pw = new PrintWriter(new FileOutputStream(file));
		    pw.println(acts.size());
		    for (int i = 0; i < acts.size(); i++){
		        pw.println(acts.get(i).toString());
		    }
		    pw.println("\n");
		    pw.close();
		}
	
		/*******************************************************************
		 * This method saves the current arraylist of accounts as a binary 
		 * file to be read in
		 * @throws IOException
		 ******************************************************************/
		public static void saveBinary() throws IOException{
			Account[] a = new Account[500];
			try
			{
				FileOutputStream fileOut = new FileOutputStream("/Users/"
						+ "xxevanxx007/git/BankAccounts/Project3/"
						+ "accountText.src");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeInt(acts.size());
				for (int i = 0; i < acts.size(); ++i) {
					if (acts.get(0) instanceof SavingsAccount)
						a[i] = (SavingsAccount) acts.get(0);
					else if (acts.get(0) instanceof CheckingAccount)
						a[i] = (CheckingAccount) acts.get(0);
					out.writeObject(a[i]);
				}
				out.close();
				fileOut.close();
			}catch(IOException i)
			{
				i.printStackTrace();
			}
		}
	
		/*******************************************************************
		 * This method saves the current arraylist of accounts as an xml 
		 * file to be read in
		 ******************************************************************/
		public void saveXML(){
	
		}
	
		/*******************************************************************
		 * reads the saved list of accounts from a text file
		 * @param file is the local address
		 * @throws FileNotFoundException 
		 ******************************************************************/
		public void loadText(String file) throws FileNotFoundException{
			Scanner s = new Scanner(new File(file));
			int size = s.nextInt();
			System.out.println(size);
			int i = 0;
			String[] data = new String[size+1];
			while(s.hasNextLine()){
				System.out.println(s.nextLine().toString());
				
				//data[i] = (""+s.nextLine().toString());
				//i++;
				//System.out.println(data);
			}
			s.close();
			fireTableDataChanged();
		}
	
		/*******************************************************************
		 * reads the saved list of accounts from a binary file
		 ******************************************************************/
		public void loadBinary(){
	
		}
	
		/*******************************************************************
		 * reads the saved list of accounts from a XML file
		 ******************************************************************/
		public void loadXML(){
	
		}
	
		/*******************************************************************
		 * @returns 4 because thats the number of collumns used
		 * @Override
		 ******************************************************************/
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 4;
		}
	
		/*******************************************************************
		 * allows for the setting of values for the table
		 * @param the value to be added to the table
		 * @param the row of the table to be added to
		 * @param the column of the table for the element to be added to
		 * @Override
		 ******************************************************************/
		public void setValueAt(Object value, int row, int col) {
			//data[row][col] = (String) value;
			fireTableCellUpdated(row, col);
		}
	
		
		/*******************************************************************
		 * simply gets row count
		 * @returns 40 as a standard
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
		 * @param rowIndex the row that is selected
		 * @param columnIndex the column that is selected
		 * @return null if accountsize is 0 then returns the information in
		 * the form as account values
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
			if(Double.parseDouble(BankGUI.getTextFields(2)) < 0)
				throw new IllegalArgumentException();
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
			if(Double.parseDouble(BankGUI.getTextFields(5)) >=    
					Double.parseDouble(BankGUI.getTextFields(2)) ||
					Double.parseDouble(BankGUI.getTextFields(2)) < 0)
				throw new IllegalArgumentException();
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
		 * When a certain 
		 * @param type used to determine what kind of update to do
		 * @param row used to know what info to update
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