package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserAccountFrame extends JFrame implements ActionListener {
    
	private JLabel userBalanceLabel;
    private JTextField balanceField;
    private JLabel userDepositLabel;
    private JTextField depositField;
    private JLabel userWithdrawLabel;
    private JTextField withdrawField;
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
        balanceField = new JTextField(15);
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
        depositField = new JTextField(10);
        depositBtn = new JButton("Deposit");
        depositBtn.addActionListener(this);
        
        positionConst.gridx = 1;
        positionConst.gridy = 4;
        add(userDepositLabel, positionConst);
        
        positionConst.gridx = 2;
        positionConst.gridy = 4;
        add(depositField, positionConst);
        
        positionConst.gridx = 3;
        positionConst.gridy = 4;
        add(depositBtn, positionConst);
        
        userWithdrawLabel = new JLabel("Withdraw Amount: ");
        withdrawField = new JTextField(10);
        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.addActionListener(this);
        
        positionConst.gridx = 1;
        positionConst.gridy = 5;
        add(userWithdrawLabel, positionConst);
        
        positionConst.gridx = 2;
        positionConst.gridy = 5;
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
        	String userInput = balanceField.getText();
        	
        	userBalance = Double.parseDouble(userInput);
        	
        	confirmBalanceLabel.setText("Welcome. Your balance is: $" + userBalance);
        	
        }
	public static void main(String[] args) {
		new UserAccountFrame();
		
	
	
	}
}