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
    private JLabel confirmBalanceLabel;
	
	UserAccountFrame() {
        GridBagConstraints positionConst = null;
        	
        setTitle("User Account Information");
        
        NumberFormat format = NumberFormat.getNumberInstance();
        format.setGroupingUsed(false);
        	
        userBalanceLabel = new JLabel("Please Enter Your Balance.");
        balanceField = new JFormattedTextField(format);
        balanceField.setEditable(true);
        balanceField.setText("");
        balanceBtn = new JButton("Submit Balance");
        balanceBtn.addActionListener(this);
        	
        setLayout(new GridBagLayout());
        positionConst = new GridBagConstraints();
               	
        positionConst.gridx = 2;
        positionConst.gridy = 0;
        positionConst.fill = GridBagConstraints.NONE;
        positionConst.weightx = 0;
        positionConst.insets = new Insets (10, 10, 10, 10);
        add(userBalanceLabel, positionConst);
        
        positionConst.gridx = 2;
        positionConst.gridy = 1;
        positionConst.fill = GridBagConstraints.HORIZONTAL;
        positionConst.weightx = 1.0;
        add(balanceField, positionConst);
        
        positionConst.gridx = 2;
        positionConst.gridy = 2;
        positionConst.fill = GridBagConstraints.NONE;
        positionConst.weightx = 0;
        add(balanceBtn, positionConst);
        
        confirmBalanceLabel = new JLabel("");
        confirmBalanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        positionConst.gridx = 2;
        positionConst.gridy = 3;
        positionConst.fill = GridBagConstraints.HORIZONTAL;
        positionConst.weightx = 1.0;
        confirmBalanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(confirmBalanceLabel, positionConst);
        
        positionConst.gridwidth = 1;
        positionConst.fill = GridBagConstraints.NONE;
        positionConst.weightx = 0;
        
        userDepositLabel = new JLabel("Deposit Amount: ");
        depositField = new JFormattedTextField(format);
        depositField.setEditable(true);
        depositField.setText("");
        depositBtn = new JButton("Deposit");
        depositBtn.addActionListener(this);
        
        positionConst.gridx = 1;
        positionConst.gridy = 4;
        positionConst.fill = GridBagConstraints.HORIZONTAL;
        positionConst.weightx = 1.0;
        add(userDepositLabel, positionConst);
        
        positionConst.gridx = 2;
        positionConst.gridy = 4;
        positionConst.fill = GridBagConstraints.HORIZONTAL;
        positionConst.weightx = 1.0;
        add(depositField, positionConst);
        
        positionConst.gridx = 3;
        positionConst.gridy = 4;
        positionConst.fill = GridBagConstraints.NONE;
        positionConst.weightx = 0;
        add(depositBtn, positionConst);
        
        userWithdrawLabel = new JLabel("Withdraw Amount: ");
        withdrawField = new JFormattedTextField(format);
        withdrawField.setEditable(true);
        withdrawField.setText("");
        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.addActionListener(this);
        
        positionConst.gridx = 1;
        positionConst.gridy = 5;
        positionConst.fill = GridBagConstraints.HORIZONTAL;
        positionConst.weightx = 1.0;
        add(userWithdrawLabel, positionConst);
        
        positionConst.gridx = 2;
        positionConst.gridy = 5;
        positionConst.fill = GridBagConstraints.HORIZONTAL;
        positionConst.weightx = 1.0;
        add(withdrawField, positionConst);
        
        positionConst.gridx = 3;
        positionConst.gridy = 5;
        positionConst.fill = GridBagConstraints.NONE;
        positionConst.weightx = 0;
        add(withdrawBtn, positionConst);
        
        userDepositLabel.setVisible(false);
        depositField.setVisible(false);
        depositBtn.setVisible(false);
        userWithdrawLabel.setVisible(false);
        withdrawField.setVisible(false);
        withdrawBtn.setVisible(false);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setMinimumSize(new Dimension(600, 400));
        setPreferredSize(new Dimension(600, 400));
        
		pack();
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null,  String.format("Goodbye. Your balance is: $%.2f", userBalance));
			}
		});
        }        
        @Override
        public void actionPerformed(ActionEvent e) {
        	try {
        		if (e.getSource() == balanceBtn) {
        			userBalance = Double.parseDouble(balanceField.getText());
        			confirmBalanceLabel.setText(String.format("Welcome. Your balance is: $%.2f", userBalance));
        			balanceField.setText("");
        			
        			userDepositLabel.setVisible(true);
        	        depositField.setVisible(true);
        	        depositBtn.setVisible(true);
        	        userWithdrawLabel.setVisible(true);
        	        withdrawField.setVisible(true);
        	        withdrawBtn.setVisible(true);
        	        
        	        userBalanceLabel.setVisible(false);
        	        balanceField.setVisible(false);
        	        balanceBtn.setVisible(false);
        	        
        	        this.revalidate();
        	        this.repaint();
        	        pack();
        	        
        		} else if (e.getSource() == depositBtn) {
        			double amount = Double.parseDouble(depositField.getText());
        			userBalance += amount;
        			confirmBalanceLabel.setText(String.format("Deposit Successful. New Balance: $%.2f", userBalance));
        			depositField.setText("");
        		} else if (e.getSource() == withdrawBtn) {
        			double amount = Double.parseDouble(withdrawField.getText());
        			if (amount > userBalance) {
        				JOptionPane.showMessageDialog(this, "Insufficient funds.", "Error", JOptionPane.ERROR_MESSAGE);
        			} else {
        				userBalance -= amount;
        				confirmBalanceLabel.setText(String.format("Withdrawal Successful. New Balance: $%.2f", userBalance));
        				withdrawField.setText("");
        			}
        		} 
        	} catch (NumberFormatException ex) {
        		JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        		balanceField.setText("");
        		depositField.setText("");
        		withdrawField.setText("");
        	}     	
        }
	public static void main(String[] args) {
		new UserAccountFrame();
	}
}