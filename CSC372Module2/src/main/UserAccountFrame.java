package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

public class UserAccountFrame extends JFrame implements ActionListener {
    
	private JLabel userBalanceLabel;
    private JFormattedTextField balanceField;
    private JLabel userDepositLabel;
    private JFormattedTextField depositField;
    private JLabel userWithdrawLabel;
    private JFormattedTextField withdrawField;
    private JButton balanceBtn;
    private JButton depositBtn;
    private JButton withdrawBtn;
    private double userBalance = 0;
    private JPanel confirmBalancePanel;
    private JLabel confirmBalanceLabel;
	
	UserAccountFrame() {
        GridBagConstraints positionConst = null;
        	
        setTitle("User Account Information");
        	
        userBalanceLabel = new JLabel("Please Enter Your Balance.");
        balanceField = new JFormattedTextField(NumberFormat.getNumberInstance());
        balanceField.setEditable(true);
        balanceField.setText("");
        
        balanceBtn = new JButton("Submit Balance");
        balanceBtn.addActionListener(this);
        	
        setLayout(new GridBagLayout());
        positionConst = new GridBagConstraints();
        	
        positionConst.gridx = 2;
        positionConst.gridy = 0;
        positionConst.insets = new Insets (10, 10, 10, 10);
        add(userBalanceLabel, positionConst);
        
        positionConst.gridx = 2;
        positionConst.gridy = 1;
        positionConst.fill = GridBagConstraints.HORIZONTAL;
        positionConst.weightx = 1.0;
        add(balanceField, positionConst);
        
        positionConst.gridx = 2;
        positionConst.gridy = 2;
        add(balanceBtn, positionConst);
        
        confirmBalancePanel = new JPanel();
        confirmBalanceLabel = new JLabel("");
        confirmBalancePanel.add(confirmBalanceLabel);
        
        positionConst.gridx = 2;
        positionConst.gridy = 3;
        add(confirmBalancePanel, positionConst);
        
        userDepositLabel = new JLabel("Deposit Amount: ");
        depositField = new JFormattedTextField(NumberFormat.getNumberInstance());
        depositField.setEditable(true);
        depositField.setText("");
        depositBtn = new JButton("Deposit");
        depositBtn.addActionListener(this);
        
        positionConst.gridx = 1;
        positionConst.gridy = 4;
        add(userDepositLabel, positionConst);
        
        positionConst.gridx = 2;
        positionConst.gridy = 4;
        positionConst.fill = GridBagConstraints.HORIZONTAL;
        positionConst.weightx = 1.0;
        add(depositField, positionConst);
        
        positionConst.gridx = 3;
        positionConst.gridy = 4;
        add(depositBtn, positionConst);
        
        userWithdrawLabel = new JLabel("Withdraw Amount: ");
        withdrawField = new JFormattedTextField(NumberFormat.getNumberInstance());
        withdrawField.setEditable(true);
        withdrawField.setText("");
        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.addActionListener(this);
        
        positionConst.gridx = 1;
        positionConst.gridy = 5;
        add(userWithdrawLabel, positionConst);
        
        positionConst.gridx = 2;
        positionConst.gridy = 5;
        positionConst.fill = GridBagConstraints.HORIZONTAL;
        positionConst.weightx = 1.0;
        add(withdrawField, positionConst);
        
        positionConst.gridx = 3;
        positionConst.gridy = 5;
        add(withdrawBtn, positionConst);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setVisible(true);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        	try {
        		if (e.getSource() == balanceBtn) {
        			userBalance = Double.parseDouble(balanceField.getText());
        			confirmBalanceLabel.setText("Welcome. Your balance is: $" + userBalance);
        		} else if (e.getSource() == depositBtn) {
        			double amount = Double.parseDouble(depositField.getText());
        			userBalance += amount;
        			confirmBalanceLabel.setText("Deposit Successful. New Balance: $" + userBalance);
        			depositField.setText("");
        		} else if (e.getSource() == withdrawBtn) {
        			double amount = Double.parseDouble(withdrawField.getText());
        			userBalance -= amount;
        			confirmBalanceLabel.setText("Withdrawal Successful. New Balance: $" + userBalance);
        			withdrawField.setText("");
        		} 
        	} catch (NumberFormatException ex) {
        		JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        	}
        		
        	
        }
	public static void main(String[] args) {
		new UserAccountFrame();
		
	
	
	}
}