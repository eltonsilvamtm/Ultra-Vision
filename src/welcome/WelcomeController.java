package welcome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import admpage.AdmController;
import database.Connect;
import homepage.HomepageController;
import homepage.HomepageView;


public class WelcomeController extends Connect implements ActionListener, KeyListener{
	
	//To execute MVC communication on the 3 elements 
	//there has to be an instantiation of the Model and the View here
	private WelcomeView View;
	private Connect DBConnection;
	private HomepageController ControllerHomep;
	private AdmController ContrAdm;
	
	
	private String query;
	
	
	public WelcomeController() {
		View = new WelcomeView(this);
		View.setVisible(true);
		
	}
	
	/**
	 * checks the database to match a user loyalty card
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//will redirect to the home page
		if(e.getActionCommand().equals("Search")) {
			
			//check whether the card number format is correct
			if(View.GetLoyaltyCard().isEmpty() || !View.GetLoyaltyCard().matches("^\\d{6}\\d{2}\\d{4}$")) {
				JOptionPane.showMessageDialog(View, "Please enter a valid card.","16 digit card required",JOptionPane.ERROR_MESSAGE);
			}else {
				
				SearchButtonPressed();
			}
		}
	}
	
	
	private void SearchButtonPressed() {
		
		boolean queryresult;
		query = "SELECT name, surname, email FROM users.ultravision WHERE loyalty_card = '" + View.GetLoyaltyCard() + "'";
		queryresult = DBConnection.ReadCustomerData(query).isEmpty();
		
		if(queryresult) {
			ControllerHomep = new HomepageController();
			View.dispose();
		}
		else {
			JOptionPane.showMessageDialog(View, "It was not possible to find your account","Search failure",JOptionPane.INFORMATION_MESSAGE);
			View.ClearField();
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub	
	}
	//add enter button to the system logics
	@Override
	public void keyPressed(KeyEvent e) {
		
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {

			}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
