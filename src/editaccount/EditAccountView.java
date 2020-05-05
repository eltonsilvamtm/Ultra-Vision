package editaccount;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class EditAccountView extends JFrame {
	
	private EditAccountController ControllerInternalRef;

	private JPanel contentPane;
	private JTextField SearchCustomerTextField;
	private JTextField SurnameTextField;
	private JTextField EmailTextField;
	private JTextField NameTextField;
	private JTextField LoyaltyCardTextField;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditAccountView frame = new EditAccountView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public EditAccountView(EditAccountController controller) {
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
		
		JLabel SearchCustomerLabel = new JLabel("Search Customer");
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
		
		JButton SearchButton = new JButton("Search");
		SearchButton.setFont(new Font("Arial", Font.PLAIN, 16));
		SearchButton.setBounds(331, 63, 85, 36);
		panel.add(SearchButton);
		
		JLabel NameLabel = new JLabel("Name:");
		NameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		NameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		NameLabel.setBounds(10, 148, 52, 27);
		panel.add(NameLabel);
		
		JLabel SurnameLabel = new JLabel("Surname:");
		SurnameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		SurnameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		SurnameLabel.setBounds(10, 217, 77, 27);
		panel.add(SurnameLabel);
		
		JLabel EmailLabel = new JLabel("Email:");
		EmailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		EmailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		EmailLabel.setBounds(10, 287, 62, 27);
		panel.add(EmailLabel);
		
		JLabel LoyaltyCardLabel = new JLabel("Loyalty Card:");
		LoyaltyCardLabel.setHorizontalAlignment(SwingConstants.LEFT);
		LoyaltyCardLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		LoyaltyCardLabel.setBounds(10, 351, 102, 36);
		panel.add(LoyaltyCardLabel);
		
		JButton UpdateButton = new JButton("UPDATE");
		UpdateButton.setFont(new Font("Arial", Font.PLAIN, 16));
		UpdateButton.setBounds(256, 462, 95, 36);
		panel.add(UpdateButton);
		UpdateButton.addActionListener((ActionListener) ControllerInternalRef);
		UpdateButton.setActionCommand("Update");
		
		JButton BackButton = new JButton("BACK");
		BackButton.setFont(new Font("Arial", Font.PLAIN, 16));
		BackButton.setBounds(75, 462, 95, 36);
		panel.add(BackButton);
		BackButton.addActionListener((ActionListener) ControllerInternalRef);
		BackButton.setActionCommand("Back");
		
		SurnameTextField = new JTextField();
		SurnameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		SurnameTextField.setBounds(10, 241, 310, 35);
		panel.add(SurnameTextField);
		SurnameTextField.setColumns(10);
		
		EmailTextField = new JTextField();
		EmailTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		EmailTextField.setColumns(10);
		EmailTextField.setBounds(10, 311, 310, 35);
		panel.add(EmailTextField);
		
		NameTextField = new JTextField();
		NameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		NameTextField.setColumns(10);
		NameTextField.setBounds(10, 171, 310, 35);
		panel.add(NameTextField);
		
		LoyaltyCardTextField = new JTextField();
		LoyaltyCardTextField.setEditable(false);
		LoyaltyCardTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		LoyaltyCardTextField.setColumns(10);
		LoyaltyCardTextField.setBounds(10, 379, 310, 35);
		panel.add(LoyaltyCardTextField);
	}
}
