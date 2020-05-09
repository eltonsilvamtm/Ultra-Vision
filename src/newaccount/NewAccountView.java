package newaccount;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import enums.Plans;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class NewAccountView extends JFrame {
	
	private NewAccountController ControllerInternalRef;
	private Plans[] MembershipPlans = Plans.values();
	
	private JPanel contentPane;
	private JTextField SurnameTextField;
	private JTextField EmailTextField;
	private JTextField NameTextField;
	private JButton CreateButton;
	private JButton BackButton;
	private JLabel NewCustomerLabel;
	private JLabel NameLabel;
	private JLabel SurnameLabel;
	private JLabel EmailLabel;
	private JComboBox<Plans> MembershipTypeBox;
	private JLabel lblNewLabel;


	public NewAccountView(NewAccountController controller) {
		this.setLocationRelativeTo(null);
		this.ControllerInternalRef = controller;
		setResizable(false);
		setTitle("New Customer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		NewCustomerLabel = new JLabel("New Customer");
		NewCustomerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NewCustomerLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		NewCustomerLabel.setBounds(0, 0, 426, 53);
		panel.add(NewCustomerLabel);
		
		NameLabel = new JLabel("Name:");
		NameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		NameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		NameLabel.setBounds(10, 63, 52, 27);
		panel.add(NameLabel);
		
		SurnameLabel = new JLabel("Surname:");
		SurnameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		SurnameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		SurnameLabel.setBounds(10, 132, 77, 27);
		panel.add(SurnameLabel);
		
		EmailLabel = new JLabel("Email:");
		EmailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		EmailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		EmailLabel.setBounds(10, 202, 62, 27);
		panel.add(EmailLabel);
		
		CreateButton = new JButton("CREATE");
		CreateButton.setFont(new Font("Arial", Font.PLAIN, 16));
		CreateButton.setBounds(245, 376, 130, 50);
		panel.add(CreateButton);
		CreateButton.addActionListener((ActionListener) ControllerInternalRef);
		CreateButton.setActionCommand("Create");
		
		BackButton = new JButton("BACK");
		BackButton.setFont(new Font("Arial", Font.PLAIN, 16));
		BackButton.setBounds(64, 376, 130, 50);
		panel.add(BackButton);
		BackButton.addActionListener((ActionListener) ControllerInternalRef);
		BackButton.setActionCommand("Back");
		
		SurnameTextField = new JTextField();
		SurnameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		SurnameTextField.setBounds(10, 156, 310, 35);
		panel.add(SurnameTextField);
		SurnameTextField.setColumns(10);
		
		EmailTextField = new JTextField();
		EmailTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		EmailTextField.setColumns(10);
		EmailTextField.setBounds(10, 226, 310, 35);
		panel.add(EmailTextField);
		
		NameTextField = new JTextField();
		NameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		NameTextField.setColumns(10);
		NameTextField.setBounds(10, 86, 310, 35);
		panel.add(NameTextField);
		
		MembershipTypeBox = new JComboBox<Plans>();
		MembershipTypeBox.setFont(new Font("Arial", Font.PLAIN, 16));
		MembershipTypeBox.setMaximumRowCount(4);
		MembershipTypeBox.setBounds(10, 296, 310, 35);
		panel.add(MembershipTypeBox);
		MembershipTypeBox.setModel(new DefaultComboBoxModel<>(MembershipPlans));
		
		lblNewLabel = new JLabel("Membership Type:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 271, 299, 27);
		panel.add(lblNewLabel);

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
	public String GetMembershipType() {
		//get the info from the combo box
		String membershiptype =  MembershipTypeBox.getSelectedItem().toString();
		return membershiptype;
	}

	public void ClearFields() {
		String clear="";
		NameTextField.setText(clear);
		SurnameTextField.setText(clear);
		EmailTextField.setText(clear);
	}

}
