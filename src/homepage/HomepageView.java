package homepage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class HomepageView extends JFrame {
	
	private HomepageController ControllerInternalRef;

	private JPanel contentPane;
	
	private JTextField SearchBarTextField;
	
	private JTable table;
	
	private JTextField TotalTextField, InitialDateTextField, QuantityTextField, PriceTextField;
	
	private JLabel lblNewLabel, lblInitialDate, TotalLabel, QuantityLabel, PriceLabel;
	
	private JButton SearchButton, AddToCartButton, CheckoutButton, ProfileButton;
	
	
	public HomepageView(HomepageController controller) {
		this.setLocationRelativeTo(null);
		this.ControllerInternalRef = controller;
		setResizable(false);
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Ultra-Vision");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 28));
		lblNewLabel.setBounds(10, 10, 531, 50);
		panel.add(lblNewLabel);
		
		SearchBarTextField = new JTextField();
		SearchBarTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		SearchBarTextField.setBounds(10, 99, 690, 50);
		panel.add(SearchBarTextField);
		SearchBarTextField.setColumns(10);
		
		SearchButton = new JButton("SEARCH");
		SearchButton.setFont(new Font("Arial", Font.PLAIN, 22));
		SearchButton.setBounds(716, 97, 150, 50);
		panel.add(SearchButton);
		SearchButton.addActionListener((ActionListener) ControllerInternalRef);
		SearchButton.setActionCommand("Search");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 184, 579, 395);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		//DefaultTableModel model = (DefaultTableModel) table.getModel();
		//ResultSet rs = controller.PopulateTable();
		//table.setModel(DbUtils.resultSetToTableModel(rs));
		
		
		AddToCartButton = new JButton("ADD TO CART");
		AddToCartButton.setFont(new Font("Arial", Font.PLAIN, 22));
		AddToCartButton.setBounds(208, 593, 193, 50);
		panel.add(AddToCartButton);
		AddToCartButton.addActionListener((ActionListener) ControllerInternalRef);
		AddToCartButton.setActionCommand("AddToCart");
		
		CheckoutButton = new JButton("CHECKOUT");
		CheckoutButton.setFont(new Font("Arial", Font.PLAIN, 22));
		CheckoutButton.setBounds(647, 593, 180, 50);
		panel.add(CheckoutButton);
		CheckoutButton.addActionListener((ActionListener) ControllerInternalRef);
		CheckoutButton.setActionCommand("Checkout");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(606, 183, 260, 400);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		TotalTextField = new JTextField();
		TotalTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		TotalTextField.setEditable(false);
		TotalTextField.setBounds(10, 301, 240, 35);
		panel_1.add(TotalTextField);
		TotalTextField.setColumns(10);
		
		TotalLabel = new JLabel("Total:");
		TotalLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		TotalLabel.setBounds(10, 274, 240, 24);
		panel_1.add(TotalLabel);
		
		InitialDateTextField = new JTextField();
		InitialDateTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		InitialDateTextField.setEditable(false);
		InitialDateTextField.setColumns(10);
		InitialDateTextField.setBounds(10, 85, 240, 35);
		panel_1.add(InitialDateTextField);
		
		lblInitialDate = new JLabel("Initial date:");
		lblInitialDate.setFont(new Font("Arial", Font.PLAIN, 16));
		lblInitialDate.setBounds(10, 58, 240, 24);
		panel_1.add(lblInitialDate);
		
		QuantityTextField = new JTextField();
		QuantityTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		QuantityTextField.setEditable(false);
		QuantityTextField.setColumns(10);
		QuantityTextField.setBounds(10, 157, 240, 35);
		panel_1.add(QuantityTextField);
		
		QuantityLabel = new JLabel("Quantity:");
		QuantityLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		QuantityLabel.setBounds(10, 130, 240, 24);
		panel_1.add(QuantityLabel);
		
		PriceTextField = new JTextField();
		PriceTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		PriceTextField.setEditable(false);
		PriceTextField.setColumns(10);
		PriceTextField.setBounds(10, 229, 240, 35);
		panel_1.add(PriceTextField);
		
		PriceLabel = new JLabel("Price:");
		PriceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		PriceLabel.setBounds(10, 202, 240, 24);
		panel_1.add(PriceLabel);
		
		ProfileButton = new JButton("SETTINGS");
		ProfileButton.setFont(new Font("Arial", Font.PLAIN, 22));
		ProfileButton.setBounds(540, 13, 150, 50);
		panel.add(ProfileButton);
		ProfileButton.addActionListener((ActionListener) ControllerInternalRef);
		ProfileButton.setActionCommand("Settings");
		
		JButton LogoutButton = new JButton("LOGOUT");
		LogoutButton.setFont(new Font("Arial", Font.PLAIN, 22));
		LogoutButton.setBounds(716, 13, 150, 50);
		panel.add(LogoutButton);
		LogoutButton.addActionListener((ActionListener) ControllerInternalRef);
		LogoutButton.setActionCommand("Logout");
	}
	
	public String GetSearchArgument() {
		return SearchBarTextField.getText().trim();
	}
	
	
}
