package editaccount;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enums.Plans;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.Writer;
import javax.swing.JComboBox;

public class EditAccountView extends JFrame {
	
	private EditAccountController ControllerInternalRef;
	private Plans[] MembershipPlans = Plans.values(); 

	private JPanel contentPane;
	
	private JTextField SearchCustomerTextField, SurnameTextField, EmailTextField, NameTextField, LoyaltyCardTextField;
	
	private JLabel SearchCustomerLabel, NameLabel, SurnameLabel, EmailLabel, LoyaltyCardLabel;
	
	private JButton SearchButton, UpdateButton, BackButton;
	
	private JComboBox<Plans> comboBox;

	
	public EditAccountView(EditAccountController controller) {
		this.setLocationRelativeTo(null);
		setResizable(false);
		this.ControllerInternalRef = controller;
		setTitle("Search Customer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		SearchCustomerLabel = new JLabel("Search Customer");
		SearchCustomerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SearchCustomerLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		SearchCustomerLabel.setBounds(0, 0, 426, 53);
		panel.add(SearchCustomerLabel);
		
		SearchCustomerTextField = new JTextField("Name or Loyalty Card");
		SearchCustomerTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				SearchCustomerTextField.setText("");
			}
			
			public void focusLost(FocusEvent e) {
				//keep the text which the user has typed in
			}
		});
		SearchCustomerTextField.setText("Name or Loyalty Card");
		SearchCustomerTextField.setToolTipText("");
		SearchCustomerTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		SearchCustomerTextField.setBounds(10, 63, 310, 35);
		panel.add(SearchCustomerTextField);
		SearchCustomerTextField.setColumns(10);
		
		SearchButton = new JButton("Search");
		SearchButton.setFont(new Font("Arial", Font.PLAIN, 16));
		SearchButton.setBounds(331, 63, 85, 36);
		panel.add(SearchButton);
		SearchButton.addActionListener((ActionListener) ControllerInternalRef);
		SearchButton.setActionCommand("Search");
		
		NameLabel = new JLabel("Name:");
		NameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		NameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		NameLabel.setBounds(10, 108, 52, 27);
		panel.add(NameLabel);
		
		SurnameLabel = new JLabel("Surname:");
		SurnameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		SurnameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		SurnameLabel.setBounds(10, 177, 77, 27);
		panel.add(SurnameLabel);
		
		EmailLabel = new JLabel("Email:");
		EmailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		EmailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		EmailLabel.setBounds(10, 247, 62, 27);
		panel.add(EmailLabel);
		
		LoyaltyCardLabel = new JLabel("Loyalty Card:");
		LoyaltyCardLabel.setHorizontalAlignment(SwingConstants.LEFT);
		LoyaltyCardLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		LoyaltyCardLabel.setBounds(10, 384, 102, 36);
		panel.add(LoyaltyCardLabel);
		
		UpdateButton = new JButton("UPDATE");
		UpdateButton.setFont(new Font("Arial", Font.PLAIN, 16));
		UpdateButton.setBounds(249, 483, 130, 50);
		panel.add(UpdateButton);
		UpdateButton.addActionListener((ActionListener) ControllerInternalRef);
		UpdateButton.setActionCommand("Update");
		
		BackButton = new JButton("BACK");
		BackButton.setFont(new Font("Arial", Font.PLAIN, 16));
		BackButton.setBounds(54, 483, 130, 50);
		panel.add(BackButton);
		BackButton.addActionListener((ActionListener) ControllerInternalRef);
		BackButton.setActionCommand("Back");
		
		SurnameTextField = new JTextField();
		SurnameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		SurnameTextField.setBounds(10, 201, 310, 35);
		panel.add(SurnameTextField);
		SurnameTextField.setColumns(10);
		
		EmailTextField = new JTextField();
		EmailTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		EmailTextField.setColumns(10);
		EmailTextField.setBounds(10, 271, 310, 35);
		panel.add(EmailTextField);
		
		NameTextField = new JTextField();
		NameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		NameTextField.setColumns(10);
		NameTextField.setBounds(10, 131, 310, 35);
		panel.add(NameTextField);
		
		LoyaltyCardTextField = new JTextField();
		LoyaltyCardTextField.setEditable(false);
		LoyaltyCardTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		LoyaltyCardTextField.setColumns(10);
		LoyaltyCardTextField.setBounds(10, 412, 310, 35);
		panel.add(LoyaltyCardTextField);
		
		JLabel lblMembershipType = new JLabel("Membership Type:");
		lblMembershipType.setHorizontalAlignment(SwingConstants.LEFT);
		lblMembershipType.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMembershipType.setBounds(10, 316, 256, 27);
		panel.add(lblMembershipType);
		
		comboBox = new JComboBox<Plans>();
		comboBox.setMaximumRowCount(4);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setBounds(10, 339, 310, 35);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel<>(MembershipPlans));
	}
	
	public String GetSearchArgument() {
		return SearchCustomerTextField.getText().trim();
	}
	public String GetName() {
		return NameTextField.getText().trim();
	}
	public String GetSurname() {
		return SurnameTextField.getText().trim();
	}
	public String GetEmail() {
		return EmailTextField.getText().trim();
	}
	public String GetLoyaltyCard() {
		return LoyaltyCardTextField.getText().trim();
	}
	
	//writing into text fields methods (setters)
	
	public void WriteName(String data) {
		NameTextField.setText(data);
	}
	public void WriteSurname(String data) {
		SurnameTextField.setText(data);
	}
	public void WriteEmail(String data) {
		EmailTextField.setText(data);
	}
	public void WriteLoyaltyCard(String data) {
		LoyaltyCardTextField.setText(data);
	}
	public void WriteMembershipType(int index) {
		comboBox.setSelectedIndex(index);
	}
	
	
	/**
	 * clear all fields
	 */
	public void ClearFields() {
		String empty="";
		SearchCustomerTextField.setText(empty);
		NameTextField.setText(empty);
		SurnameTextField.setText(empty);
		EmailTextField.setText(empty);
		LoyaltyCardTextField.setText(empty);
	}
}
