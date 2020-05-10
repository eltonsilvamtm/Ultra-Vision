package homepage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import database.Connect;
import net.proteanit.sql.DbUtils;
import welcome.WelcomeController;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.ModuleLayer.Controller;
import java.awt.event.ActionEvent;

public class HomepageView extends JFrame{
	
	private HomepageController ControllerInternalRef;
	private static Connect DBConnection = new Connect();

	private static JPanel contentPane;
	private JTextField SearchBarTextField;
	private JTable TitlesTable;
	private JTextField TotalTextField, InitialDateTextField, QuantityTextField, PriceTextField;
	private JLabel lblNewLabel, lblInitialDate, TotalLabel, QuantityLabel, PriceLabel;
	private JButton AddToCartButton, ProfileButton;
	
	public DefaultTableModel TitlesModel = new DefaultTableModel();
	public DefaultTableModel CheckoutModel = new DefaultTableModel();
	private String query = "SELECT * FROM ultravision.titles;";
	private JTable CheckoutTable;
	private int quantity;
	private int price = 3;
	private static int total = 0;
	private static String card;
	
	
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
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 34));
		lblNewLabel.setBounds(10, 10, 866, 50);
		panel.add(lblNewLabel);
		
		//inner class here in charge of treating the search terms
		// it is called at any time that a key on the keyboard is called
		SearchBarTextField = new JTextField();
		SearchBarTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String argument = SearchBarTextField.getText().trim();
				FilterTitles(argument);
			}
		});
		SearchBarTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		SearchBarTextField.setBounds(139, 124, 450, 40);
		panel.add(SearchBarTextField);
		SearchBarTextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 184, 579, 167);
		panel.add(scrollPane);

		//inner class here again with the purpose of disable the table editing
		TitlesTable = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		TitlesTable.setRowSelectionAllowed(true);
		TitlesTable.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(TitlesTable);
		TitlesModel = DBConnection.GetTableData(query);
		TitlesTable.setModel(TitlesModel);
		
		//this anonymous inner class is in charge of enabling the user to select only one row of the table
		//but unfortunately I could not get it to work
		 TitlesTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()) {
					return ;
				}
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				if(lsm.isSelectionEmpty()) {
					
				}else {
					int selectedRow=lsm.getMinSelectionIndex();
				}
			}
			
		});
		
		//anonymous inner class in charge of adding 
		//selected items into the checkout table 
		AddToCartButton = new JButton("ADD TO CART");
		AddToCartButton.setActionCommand("AddToCart");
		AddToCartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//this method is getting the selected rows by the user
				//then copying its data and transferring to the checkout table
				if(e.getActionCommand().equals("AddToCart")) {
					TitlesModel = (DefaultTableModel) TitlesTable.getModel();
					int[] index = TitlesTable.getSelectedRows();
					Object[] row = new Object[6];
					CheckoutModel = (DefaultTableModel) CheckoutTable.getModel();

					for(int i = 0; i < index.length; i++) {
						
						row[0] = TitlesModel.getValueAt(index[i], 0);
						row[1] = TitlesModel.getValueAt(index[i], 1);
						row[2] = TitlesModel.getValueAt(index[i], 2);
						row[3] = TitlesModel.getValueAt(index[i], 3);
						row[4] = TitlesModel.getValueAt(index[i], 4);
						row[5] = TitlesModel.getValueAt(index[i], 5);
						
						CheckoutModel.addRow(row);
						quantity++;
						total += price;
						System.out.println(quantity);
						QuantityTextField.setText(Integer.toString(quantity));
						TotalTextField.setText(Integer.toString(total));
						if(quantity >= 4) {
							
						}
					}
				}
		}});
		
		AddToCartButton.setFont(new Font("Arial", Font.PLAIN, 22));
		AddToCartButton.setBounds(10, 582, 193, 50);
		panel.add(AddToCartButton);
		
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
		
		TotalLabel = new JLabel("Total(\u20AC):");
		TotalLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		TotalLabel.setBounds(10, 274, 240, 24);
		panel_1.add(TotalLabel);
		
		InitialDateTextField = new JTextField();
		InitialDateTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		InitialDateTextField.setEditable(false);
		InitialDateTextField.setColumns(10);
		InitialDateTextField.setBounds(10, 85, 240, 35);
		panel_1.add(InitialDateTextField);
		//displaying the current date
		ShowDate();
		
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
		PriceTextField.setText(Integer.toString(price));
		
		PriceLabel = new JLabel("Price per title(\u20AC):");
		PriceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		PriceLabel.setBounds(10, 202, 240, 24);
		panel_1.add(PriceLabel);
		
		ProfileButton = new JButton("SETTINGS");
		ProfileButton.setFont(new Font("Arial", Font.PLAIN, 22));
		ProfileButton.setBounds(669, 93, 150, 50);
		panel.add(ProfileButton);
		ProfileButton.addActionListener((ActionListener) ControllerInternalRef);
		ProfileButton.setActionCommand("Settings");
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSearch.setFont(new Font("Arial", Font.PLAIN, 34));
		lblSearch.setBounds(10, 124, 119, 40);
		panel.add(lblSearch);
		
		JScrollPane CheckoutScrollPane = new JScrollPane();
		CheckoutScrollPane.setBounds(10, 433, 579, 109);
		panel.add(CheckoutScrollPane);
		
		//disabling editing table option
		CheckoutTable = new JTable(){
			public boolean isCellEditable(int row, int column) {
				return false;
			}};
		CheckoutScrollPane.setViewportView(CheckoutTable);
		CheckoutTable.setRowSelectionAllowed(true);
		CheckoutTable.setModel(CheckoutModel);
		CheckoutModel.addColumn("Title");
		CheckoutModel.addColumn("Genre");
		CheckoutModel.addColumn("Director/Band");
		CheckoutModel.addColumn("Category");
		CheckoutModel.addColumn("Year");
		CheckoutModel.addColumn("In Stock");
		
		//the button remove work to remove an item from the checkout table
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.setFont(new Font("Arial", Font.PLAIN, 22));
		btnRemove.setActionCommand("AddToCart");
		btnRemove.setBounds(216, 582, 193, 50);
		panel.add(btnRemove);
		btnRemove.setActionCommand("Remove");
		btnRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//it will receive the action command and perform deductions on the final price and quantity
				//there are still a couple of bugs like what if the user chooses more than one row at the same time?
				if(e.getActionCommand().equals("Remove")) {
					
					CheckoutModel.removeRow(CheckoutTable.getSelectedRow());
					
						quantity--;
						total -= price;
					
						QuantityTextField.setText(Integer.toString(quantity));
						TotalTextField.setText(Integer.toString(total));
						
				}
			}
		});
		
		//redirect the user to a opo up which will display its total purchase price and maybe a return date for the next software update
		JButton PayNow = new JButton("PAY NOW");
		PayNow.setFont(new Font("Arial", Font.PLAIN, 22));
		PayNow.setActionCommand("AddToCart");
		PayNow.setBounds(423, 582, 193, 50);
		panel.add(PayNow);
		PayNow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomepageView.ThankYou();
			}

			
		});
		
		JLabel lblCheckout = new JLabel("Checkout");
		lblCheckout.setHorizontalAlignment(SwingConstants.LEFT);
		lblCheckout.setFont(new Font("Arial", Font.PLAIN, 34));
		lblCheckout.setBounds(10, 377, 231, 40);
		panel.add(lblCheckout);
	}
	
	/**
	 * display customer's order details
	 */
	protected static void ThankYou() {
		String finalmessage = "Your order total is: €" + total + " \n Please enter your card number:";
		card = JOptionPane.showInputDialog(contentPane, finalmessage, "Thank you", JOptionPane.INFORMATION_MESSAGE);
		ValidateField();
	}

	private static void ValidateField() {
		//check whether the card number format is correct
		if(card.isEmpty() || !card.matches("^\\d{6}\\d{2}\\d{4}$")) {
			JOptionPane.showMessageDialog(contentPane, "Please enter a valid card.","12 digit card required",JOptionPane.ERROR_MESSAGE);
		}else {
			boolean isordercompleted;
			String query = "SELECT loyalty_card FROM ultravision.users WHERE loyalty_card = '" + card + "';";
			isordercompleted = DBConnection.ReadCustomerData(query).isEmpty();
			if(isordercompleted) {
				JOptionPane.showMessageDialog(contentPane, "Thank you for your order","Thank you!",JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		}
		
	}

	/**
	 * 
	 * @return the argument that will be used to search the database
	 */
	public String GetSearchArgument() {
		return SearchBarTextField.getText().trim();
	}
	
	/**
	 * this method sorts the table according to what the user inserts
	 * @param argument receives the argument to search through the database
	 */
	private void FilterTitles(String argument) {
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(TitlesModel);
		TitlesTable.setRowSorter(sorter);
		sorter.setRowFilter(RowFilter.regexFilter(argument));
	}
	
	/**
	 * inputs the date on the data field
	 */
	public void ShowDate() {
		Date today = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		InitialDateTextField.setText(sf.format(today));
	}
	
	
}
