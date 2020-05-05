package welcome;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JLabel;
import java.awt.Font;

public class WelcomeView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	private WelcomeController ControllerInternalRef;

	
	public WelcomeView(WelcomeController controller) {
		
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
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setBounds(20, 50, 251, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		Button SearchButton = new Button("Search");
		SearchButton.setFont(new Font("Arial", Font.PLAIN, 16));
		SearchButton.setBounds(110, 90, 69, 34);
		panel.add(SearchButton);
		SearchButton.addActionListener((ActionListener) ControllerInternalRef);
		SearchButton.setActionCommand("Search");
		
		JLabel LoyaltyCardNumber = new JLabel("Loyalty Card Number");
		LoyaltyCardNumber.setForeground(Color.DARK_GRAY);
		LoyaltyCardNumber.setFont(new Font("Arial", Font.BOLD, 18));
		LoyaltyCardNumber.setBounds(51, 18, 184, 22);
		panel.add(LoyaltyCardNumber);
	}

}
