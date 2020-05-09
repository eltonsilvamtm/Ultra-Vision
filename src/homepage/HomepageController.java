package homepage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import admpage.AdmController;
import checkout.CheckoutController;
import database.Connect;
import editaccount.EditAccountController;
import welcome.WelcomeController;
import welcome.WelcomeView;

public class HomepageController extends Connect implements ActionListener{
	
	//To execute MVC communication on the 3 elements 
	//there has to be an instantiation of the Model and the View here
	private HomepageView View;
	private CheckoutController ControllerCheckout;
	private AdmController ContrAdm;
	private WelcomeController ContrWelcome;
	private Connect DBConnection;
	
	private String query;
	private ArrayList<String> titles = new ArrayList<String>();
	
	
	public HomepageController() {
		View = new HomepageView(this);
		View.setVisible(true);
	}
	
	

	//here all the actions performed by the buttons on the HomepageView class will be treated
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//redirect to the user profile page
		if(e.getActionCommand().equals("Settings")) {
			ContrAdm = new AdmController();
			View.dispose();
		}
		
		//will perform the search on the database
		if(e.getActionCommand().equals("Search")) {
			ValidateInput();
			PerformSearch(View.GetSearchArgument());
		}
		
		//this will add the chosen product to the cart
		if(e.getActionCommand().equals("AddToCart")) {
			
		}
		
		//redirect to the checkout page
		if(e.getActionCommand().equals("Checkout")) {
			ControllerCheckout = new CheckoutController();
			View.dispose();
		}
		
		if(e.getActionCommand().equals("Logout")) {
			ContrWelcome = new WelcomeController();
			View.dispose();
		}
		
	}
	
	
	//populate the table with all the items available on the database
	protected ResultSet PopulateTable() {
		ResultSet rs = null;
		query = "SELECT * FROM ultravision.titles;";
		//rs = DBConnection.ReadTitleData(query);
		return rs;
	}

	//search for one item on the database
	protected ArrayList<String> PerformSearch(String argument) {
		
		query = "SELECT * FROM titles.ultravision WHERE CONCAT(title, genre, director_band) LIKE '%" + argument + "%'";
        
		return DBConnection.ReadTitleData(query);
	}

	private void ValidateInput() {
		//error message if one of the fields is empty
		if(View.GetSearchArgument().isEmpty()) {
			JOptionPane.showMessageDialog(View, "Please enter a term to be searched","Empty Fields",JOptionPane.ERROR_MESSAGE);
		}
	}
	

}
