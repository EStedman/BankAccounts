/**
 * @author Hamilton Graham
 * @author Evan Stedman
 */

package project3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BankGUI extends JPanel {
	
	/**  */
	BankModel bankModelClass = new BankModel();
	
	/**  */
	private Listener listener;
	
	/**  */
	private JMenuBar menuBar;
	
	/**  */
	private JMenu file;
	
	/**  */
	private JMenu sort;
	
	/**  */
	private DefaultTableModel model;
	
	/**  */
	private JTable table = new JTable();
	
	/**  */
	private JLabel[] labels = new JLabel[7];
	
	/**  */
	private static JTextField[] textFields = new JTextField[10];
	
	/**  */
	private JButton[] buttons = new JButton[4];
	
	/**  */
	private JRadioButton checking = new JRadioButton();
	
	/**  */
	private JRadioButton savings = new JRadioButton();
	
	/**  */
	private ButtonGroup JRBGroup = new ButtonGroup();
	
	/**  */
	private JMenuItem[] menus = new JMenuItem[12];
	
	/**  */
	private JList list = new JList();

	public static String getTextFields(int i) {
		String a = textFields[i].getText();
		return a;
	}

	public void setTextFields(JTextField textFields, int i) {
		this.textFields[i] = textFields;
	}
	
	/*******************************************************************
	 * main
	 ******************************************************************/
	public static void main(String[] args){
		
		BankGUI panel = new BankGUI();
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.setTitle("BankGUI");
		frame.setLocation(0,0);
		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	
	/*******************************************************************
	 * Menu items do not have listeners attached yet, menu item
	 * methods are not yet implemented
	 ******************************************************************/
	public BankGUI() {
		bankModelClass = new BankModel();
		listener = new Listener();
		checking.setSelected(true);
		JPanel labelTextPanel = new JPanel(new GridLayout(7,2));
		JPanel JRBPanel = new JPanel(new GridLayout(1,2));
		JPanel buttonPanel = new JPanel(new GridLayout(4,1));
		JPanel panel1 = new JPanel(new BorderLayout());
		JPanel panel2 = new JPanel(new BorderLayout());
		JPanel panel3 = new JPanel(new BorderLayout());
		JPanel datePanel = new JPanel(new GridLayout(1,3));
		//list = new JList(col);
		//JScrollPane scrollingList = new JScrollPane(list);
		//list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		//JPanel listPanel = new JPanel();
		//listPanel.add(list);

		
		//JTable initialization
		//model = new DefaultTableModel(col,40);
		//bankModelClass.setColumnIdentifiers(col);

		table = new JTable(bankModelClass) {
			@Override
			public boolean isCellEditable(int i, int j) { 
				return false;
			}
		};
		JScrollPane	pane = new JScrollPane(table);
		file = new JMenu("File");
		sort = new JMenu("Sort");
		menuBar = new JMenuBar();

		checking.addActionListener(listener);
		savings.addActionListener(listener);
		
		// initialization and adding listeners
		for (int i = 0; i < 10; ++i) {
			if (i < 4) {
				buttons[i] = new JButton();
				buttons[i].addActionListener(listener);
			}
			if (i < 7) 
				labels[i] = new JLabel();
			if (i < 10) 
				textFields[i] = new JTextField();
			if (i < 10)
				menus[i] = new JMenuItem();
				menus[i].addActionListener(listener);
		}

		for (int i = 0; i < 10; ++i) {
			if (i < 7)
				file.add(menus[i]);
			else
				sort.add(menus[i]);
		}
		

		textFields[5].setEditable(false);
		textFields[5].setText("N/A");
		
		textFields[4].setEditable(false);
		textFields[4].setText("N/A");

		JRBGroup.add(checking);
		JRBGroup.add(savings);

		menuBar.add(file);
		menuBar.add(sort);

		labels[0].setText("Account Number: ");
		labels[1].setText("Account Owner: ");
		labels[2].setText("Date Opened: ");
		labels[3].setText("Account Balance: ");
		labels[4].setText("Monthly Fee: ");
		labels[5].setText("Interest Rate: ");
		labels[6].setText("Minimum Balance: ");

		buttons[0].setText("Add");
		buttons[1].setText("Delete");
		buttons[2].setText("Update");
		buttons[3].setText("Clear");

		checking.setText("Checking");
		savings.setText("Savings");

		menus[0].setText("Load From Binary...");
		menus[1].setText("Save As Binary...");
		menus[2].setText("Load From Text...");
		menus[3].setText("Save As Text...");
		menus[4].setText("Load From XML...");
		menus[5].setText("Save As XML...");
		menus[6].setText("Quit");
		menus[7].setText("By Account Number");
		menus[8].setText("By Account Owner");
		menus[9].setText("By Date Opened");

		
		// panel/frame setup
		datePanel.add(textFields[6]);
		datePanel.add(textFields[7]);
		datePanel.add(textFields[8]);
		
		JRBPanel.add(checking);
		JRBPanel.add(savings);
		
		buttonPanel.add(buttons[0]);
		buttonPanel.add(buttons[1]);
		buttonPanel.add(buttons[2]);
		buttonPanel.add(buttons[3]);
		labelTextPanel.add(labels[0]);
		labelTextPanel.add(textFields[0]);
		labelTextPanel.add(labels[1]);
		labelTextPanel.add(textFields[1]);
		labelTextPanel.add(labels[2]);
		labelTextPanel.add(datePanel);
		labelTextPanel.add(labels[3]);
		labelTextPanel.add(textFields[2]);
		labelTextPanel.add(labels[4]);
		labelTextPanel.add(textFields[3]);
		labelTextPanel.add(labels[5]);
		labelTextPanel.add(textFields[4]);
		labelTextPanel.add(labels[6]);
		labelTextPanel.add(textFields[5]);

		panel2.add(JRBPanel, BorderLayout.NORTH);
		panel2.add(labelTextPanel, BorderLayout.WEST);
		panel2.add(buttonPanel, BorderLayout.EAST);
		panel3.add(pane, BorderLayout.NORTH);
		//panel3.add(scrollingList, BorderLayout.NORTH);
		panel3.add(panel2, BorderLayout.SOUTH);
		panel1.add(menuBar, BorderLayout.NORTH);
		panel1.add(panel3, BorderLayout.SOUTH);
		add(panel1);
	}


	/*******************************************************************
	 * instead of one method call to an add(), I have both addChecking
	 * and addSavings in BankModel, it seemed simpler to me than having
	 * one polymorphic method
	 ******************************************************************/
	private class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttons[0]) {
				//add
				if (savings.isSelected() == true){
					bankModelClass.addSavings();
					bankModelClass.getValueAt(
							bankModelClass.acts.size() - 1, 0);
					for (int i = 0; i < 4; ++i) {
						Account a;
						if (bankModelClass.acts.size() != 0) 
							a = bankModelClass.acts.get(
									bankModelClass.acts.size() - 1);
						else 
							a = null;
						bankModelClass.setValueAt(a.getAccountNum(),
								bankModelClass.acts.size() - 1, i);
						bankModelClass.fireTableCellUpdated(
								BankModel.acts.size(), i);
					}
				}
				if (checking.isSelected() == true) {
					bankModelClass.addChecking();
					for (int i = 0; i < 4; ++i) {
						bankModelClass.fireTableCellUpdated(
								BankModel.acts.size(), i);
					}
				}
			}
			else if (e.getSource() == buttons[1]) {
				//delete
				if (BankModel.acts.size() > 0)
					bankModelClass.delete(table.getSelectedRow());
			}
			else if (e.getSource() == buttons[2]) {
				//update
				if (BankModel.acts.size() > 0){
					if(savings.isSelected() == true)
						bankModelClass.update(1,table.getSelectedRow());
					else if(checking.isSelected()== true)
						bankModelClass.update(2,table.getSelectedRow());
				}
			}
			else if (e.getSource() == buttons[3]) {
				//clear
			}
			if (e.getSource() == checking) {
				if (checking.isSelected() == true) {
					// altering the editable state of specific textfields
					// relevant to account type
					textFields[5].setEditable(false);
					textFields[5].setText("N/A");
					textFields[4].setEditable(false);
					textFields[4].setText("N/A");
					textFields[3].setEditable(true);
					textFields[3].setText("");
				}
			}
			if (e.getSource() == savings) {
				if (savings.isSelected() == true){
					// altering the editable state of specific textfields
					// relevant to account type
					textFields[3].setEditable(false);
					textFields[3].setText("N/A");
					textFields[5].setEditable(true);
					textFields[5].setText("");
					textFields[4].setEditable(true);
					textFields[4].setText("");
				}
			}
			if(e.getSource() == menus[0]){
				bankModelClass.loadBinary();
				
			}
			if(e.getSource() == menus[1]){
				try {
					bankModelClass.saveBinary();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			if(e.getSource() == menus[2]){
				try {
					bankModelClass.loadText("/Users/xxevanxx007/"
					+ "git/BankAccounts/Project3/accountText.txt");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			if(e.getSource() == menus[3]){
				try {
					bankModelClass.saveText("accountText.txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			if(e.getSource() == menus[6]){
				System.exit(0);
			}
		}
	}
}