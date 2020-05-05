package checkout;

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
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class CheckoutView extends JFrame {
	
	private CheckoutController ControllerInternalRef;

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckoutView frame = new CheckoutView();
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
	public CheckoutView(CheckoutController controller) {
		setTitle("Checkout");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblCheckout = new JLabel("Checkout");
		lblCheckout.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckout.setFont(new Font("Arial", Font.PLAIN, 22));
		lblCheckout.setBounds(10, 10, 466, 45);
		panel.add(lblCheckout);
		
		JLabel lblCartContains = new JLabel("Cart:");
		lblCartContains.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCartContains.setBounds(10, 65, 466, 35);
		panel.add(lblCartContains);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 466, 216);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton PayNowButton = new JButton("PAY NOW");
		PayNowButton.setFont(new Font("Arial", Font.PLAIN, 16));
		PayNowButton.setBounds(60, 428, 120, 50);
		panel.add(PayNowButton);
		PayNowButton.setActionCommand("PayNow");
		PayNowButton.addActionListener((ActionListener) ControllerInternalRef);
		
		JButton GoBackButton = new JButton("GO BACK");
		GoBackButton.setFont(new Font("Arial", Font.PLAIN, 16));
		GoBackButton.setBounds(290, 428, 120, 50);
		panel.add(GoBackButton);
		GoBackButton.setActionCommand("GoBack");
		GoBackButton.addActionListener((ActionListener) ControllerInternalRef);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTotal.setBounds(10, 321, 466, 35);
		panel.add(lblTotal);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Arial", Font.PLAIN, 16));
		textField.setBounds(10, 350, 466, 50);
		panel.add(textField);
		textField.setColumns(10);
	}

}
