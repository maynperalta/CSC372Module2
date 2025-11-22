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
	
	UserAccountFrame() {
        GridBagConstraints positionConst = null;
        	
        setTitle("User Account Information");
        	
        userBalanceLabel = new JLabel("Please Enter Your Balance.");
        balanceField = new JTextField(15);
        balanceField.setEditable(true);
        balanceField.setText("balance");
        
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
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setVisible(true);
        }
        
        @Override
        public void actionPerformed(ActionEvent event) {
        	String userInput;
        	int userBalance;
        	
        	userInput = balanceField.getText();
        	userBalance = Integer.parseInt(userInput);
        	
        	
        }
	public static void main(String[] args) {
		new UserAccountFrame();
		
	
	
	}
}