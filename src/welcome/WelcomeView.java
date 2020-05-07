package welcome;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WelcomeView extends JFrame {

	private JPanel contentPane;
	private JTextField EnterCardField;
	protected JButton SearchButton;
	private JLabel LoyaltyCardNumber;

	private WelcomeController ControllerInternalRef;

	
	public WelcomeView(WelcomeController controller) {
		
		this.ControllerInternalRef = controller;
		setLocationRelativeTo(null);
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 308, 180);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 300, 150);
		contentPane.add(panel);
		panel.setLayout(null);
		
		EnterCardField = new JTextField();
		EnterCardField.addKeyListener((KeyListener) ControllerInternalRef);
		EnterCardField.setFont(new Font("Arial", Font.PLAIN, 18));
		EnterCardField.setForeground(Color.LIGHT_GRAY);
		EnterCardField.setBounds(20, 50, 251, 34);
		panel.add(EnterCardField);
		EnterCardField.setColumns(10);
		
		SearchButton = new JButton("Search");
		SearchButton.setFont(new Font("Arial", Font.PLAIN, 16));
		SearchButton.setBounds(94, 94, 100, 40);
		panel.add(SearchButton);
		SearchButton.addActionListener((ActionListener) ControllerInternalRef);
		SearchButton.setActionCommand("Search");
		
		LoyaltyCardNumber = new JLabel("Loyalty Card Number");
		LoyaltyCardNumber.setForeground(Color.DARK_GRAY);
		LoyaltyCardNumber.setFont(new Font("Arial", Font.BOLD, 18));
		LoyaltyCardNumber.setBounds(51, 18, 184, 22);
		panel.add(LoyaltyCardNumber);
	}
	
	public String GetLoyaltyCard() {
		return EnterCardField.getText().trim();
	}
	
	public void ClearField() {
		EnterCardField.setText(null);
	}

}
