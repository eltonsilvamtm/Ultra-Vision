package addtitle;

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
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AddTitleView extends JFrame {
	
	private AddTitleController ControllerInternalRef;

	private JPanel contentPane;
	private JTextField TitleTextField;
	private JTextField GenreTextField;
	private JTextField DirectorOrBandTextField;
	private JTextField YearOfReleaseTextField;
	private JTextField QuantityTextField;

	
	public AddTitleView(AddTitleController controller) {
		setResizable(false);
		setTitle("Add new Title");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel AddNewTitleLabel = new JLabel("Add a new Title");
		AddNewTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AddNewTitleLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		AddNewTitleLabel.setBounds(10, 10, 456, 48);
		panel.add(AddNewTitleLabel);
		
		JLabel GenreLabel = new JLabel("Genre:");
		GenreLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GenreLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		GenreLabel.setBounds(10, 140, 456, 28);
		panel.add(GenreLabel);
		
		JLabel TitleLabel = new JLabel("Title:");
		TitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		TitleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		TitleLabel.setBounds(10, 68, 456, 28);
		panel.add(TitleLabel);
		
		JLabel DirectorOrBandLabel = new JLabel("Director/Band:");
		DirectorOrBandLabel.setHorizontalAlignment(SwingConstants.LEFT);
		DirectorOrBandLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		DirectorOrBandLabel.setBounds(10, 209, 456, 28);
		panel.add(DirectorOrBandLabel);
		
		JLabel YearOfReleaseLabel = new JLabel("Year of release:");
		YearOfReleaseLabel.setHorizontalAlignment(SwingConstants.LEFT);
		YearOfReleaseLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		YearOfReleaseLabel.setBounds(10, 278, 456, 28);
		panel.add(YearOfReleaseLabel);
		
		TitleTextField = new JTextField();
		TitleTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		TitleTextField.setBounds(10, 95, 456, 35);
		panel.add(TitleTextField);
		TitleTextField.setColumns(10);
		
		JLabel MembershipTypeLabel = new JLabel("Membership type:");
		MembershipTypeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		MembershipTypeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		MembershipTypeLabel.setBounds(10, 422, 456, 28);
		panel.add(MembershipTypeLabel);
		
		GenreTextField = new JTextField();
		GenreTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		GenreTextField.setColumns(10);
		GenreTextField.setBounds(10, 164, 456, 35);
		panel.add(GenreTextField);
		
		DirectorOrBandTextField = new JTextField();
		DirectorOrBandTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		DirectorOrBandTextField.setColumns(10);
		DirectorOrBandTextField.setBounds(10, 233, 456, 35);
		panel.add(DirectorOrBandTextField);
		
		YearOfReleaseTextField = new JTextField();
		YearOfReleaseTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		YearOfReleaseTextField.setColumns(10);
		YearOfReleaseTextField.setBounds(10, 304, 456, 35);
		panel.add(YearOfReleaseTextField);
		
		JLabel QuantityLabel = new JLabel("Quantity:");
		QuantityLabel.setHorizontalAlignment(SwingConstants.LEFT);
		QuantityLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		QuantityLabel.setBounds(10, 349, 456, 28);
		panel.add(QuantityLabel);
		
		QuantityTextField = new JTextField();
		QuantityTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		QuantityTextField.setColumns(10);
		QuantityTextField.setBounds(10, 374, 456, 35);
		panel.add(QuantityTextField);
		
		JComboBox MembershipTypeBox = new JComboBox();
		MembershipTypeBox.setMaximumRowCount(5);
		MembershipTypeBox.setFont(new Font("Arial", Font.PLAIN, 16));
		MembershipTypeBox.setBounds(10, 448, 456, 35);
		panel.add(MembershipTypeBox);
		
		JButton AddButton = new JButton("ADD");
		AddButton.setFont(new Font("Arial", Font.PLAIN, 16));
		AddButton.setBounds(290, 600, 120, 50);
		panel.add(AddButton);
		AddButton.addActionListener((ActionListener) ControllerInternalRef);
		AddButton.setActionCommand("Add");
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Arial", Font.PLAIN, 16));
		btnBack.setBounds(60, 600, 120, 50);
		panel.add(btnBack);
		btnBack.addActionListener((ActionListener) ControllerInternalRef);
		btnBack.setActionCommand("Back");
	}
}
