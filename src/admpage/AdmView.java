package admpage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class AdmView extends JFrame {
	
	private AdmController ControllerInternalRef;

	private JPanel contentPane;


	public AdmView(AdmController controller) {
		setTitle("Adiministrator Menu");
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel AdmpagePanel = new JPanel();
		AdmpagePanel.setBackground(Color.PINK);
		contentPane.add(AdmpagePanel, BorderLayout.CENTER);
		AdmpagePanel.setLayout(null);
		
		JButton CreateProfileButton = new JButton("CREATE PROFILE");
		CreateProfileButton.setFont(new Font("Arial", Font.PLAIN, 16));
		CreateProfileButton.setBounds(83, 73, 250, 50);
		AdmpagePanel.add(CreateProfileButton);
		CreateProfileButton.addActionListener((ActionListener) ControllerInternalRef);
		CreateProfileButton.setActionCommand("Create");
		
		JButton EditProfileButton = new JButton("EDIT PROFILE");
		EditProfileButton.setFont(new Font("Arial", Font.PLAIN, 16));
		EditProfileButton.setBounds(83, 136, 250, 50);
		AdmpagePanel.add(EditProfileButton);
		EditProfileButton.addActionListener((ActionListener) ControllerInternalRef);
		EditProfileButton.setActionCommand("Edit");
		
		JButton BackButton = new JButton("BACK");
		BackButton.setFont(new Font("Arial", Font.PLAIN, 16));
		BackButton.setBounds(83, 199, 250, 50);
		AdmpagePanel.add(BackButton);
		BackButton.addActionListener((ActionListener) ControllerInternalRef);
		BackButton.setActionCommand("Back");
		
		JButton AddNewTitleButton = new JButton("ADD NEW TITLE");
		AddNewTitleButton.setFont(new Font("Arial", Font.PLAIN, 16));
		AddNewTitleButton.setBounds(83, 10, 250, 50);
		AdmpagePanel.add(AddNewTitleButton);
		AddNewTitleButton.addActionListener((ActionListener) ControllerInternalRef);
		AddNewTitleButton.setActionCommand("AddNewTitle");
	}
}
