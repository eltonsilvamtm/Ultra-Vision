package homepage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
	private Connect DBConnection = new Connect();
	

	private ArrayList<String> titles = new ArrayList<String>();
	private static ArrayList<Integer> rowselected = new ArrayList<Integer>();
	
	
	/**
	 * Homepage constructor (will call the GUI every time the user interaction leads to the main window)
	 */
	public HomepageController() {
		View = new HomepageView(this);
		View.setVisible(true);
	}
	
	

	/**
	 * here all the actions performed by the buttons on the HomepageView class will be treated
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//redirect to the user profile page
		if(e.getActionCommand().equals("Settings")) {
			ContrAdm = new AdmController();
			View.dispose();
		}
		
		//redirect to the checkout page
		if(e.getActionCommand().equals("Checkout")) {
			
			ControllerCheckout = new CheckoutController();
			View.dispose();
		}
		
	}
	
	
	public ArrayList<Integer> AddToCart(int selectedRow) {
		rowselected.add(selectedRow);
		System.out.println(rowselected);
		return rowselected;
	}
	
	public static ArrayList<Integer> GetArray() {
		//String values = rowselected.toString();
		return rowselected;
	}

	//in charge of validate the user input according to the necessity, 
	//in this case as the table refreshes constantly the only major validation is field emptiness
	private boolean ValidateInput() {
		boolean validation = false;
		
			//error message if one of the fields is empty
			if(View.GetSearchArgument().isEmpty()) {
				JOptionPane.showMessageDialog(View, "Please enter a term to be searched","Empty Fields",JOptionPane.ERROR_MESSAGE);
			}
			else {
				validation = true;
			}
		
		return validation;
	}
	
	
	

}
