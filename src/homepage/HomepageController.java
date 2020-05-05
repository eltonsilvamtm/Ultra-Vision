package homepage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import checkout.CheckoutController;

public class HomepageController implements ActionListener{
	
	//To execute MVC communication on the 3 elements 
	//there has to be an instantiation of the Model and the View here
	private HomepageModel Model;
	private HomepageView View;
	private CheckoutController ControllerCheckout;
	
	public HomepageController() {
		View = new HomepageView(this);
		View.setVisible(true);
	}
	
	//here all the actions performed by the buttons on the HomepageView class will be treated
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//redirect to the user profile page
		if(e.getActionCommand().equals("Profile")) {
			
			View.dispose();
		}
		
		//will perform the search on the database
		if(e.getActionCommand().equals("Search")) {
			
		}
		
		//this will add the chosen product to the cart
		if(e.getActionCommand().equals("AddToCart")) {
			
		}
		
		//redirect to the checkout page
		if(e.getActionCommand().equals("Checkout")) {
			ControllerCheckout = new CheckoutController();
			View.dispose();
		}
		
	}
	
	

}
