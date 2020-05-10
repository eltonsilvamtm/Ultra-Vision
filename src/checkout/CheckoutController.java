package checkout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import database.Connect;
import homepage.HomepageController;
import welcome.WelcomeController;

public class CheckoutController extends Connect implements ActionListener{
	
	private CheckoutView View;
	private Connect DBConnection = new Connect();
	private HomepageController ContrHomepage;
	private WelcomeController ContrWelcome;
	
	
	public CheckoutController() {
		
		View = new CheckoutView(this);
		View.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		//redirects the user to the main page
		if(e.getActionCommand().equals("GoBack")) {
			ContrHomepage = new HomepageController();
			View.dispose();
		}
		
		//redirects the user to a thank you pop up box
		if(e.getActionCommand().equals("PayNow")) {
			ContrWelcome = new WelcomeController();
			View.dispose();
		}
		
	}

}
