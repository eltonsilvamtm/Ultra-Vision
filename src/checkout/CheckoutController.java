package checkout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import homepage.HomepageController;

public class CheckoutController implements ActionListener{
	
	private CheckoutModel Model;
	private CheckoutView View;
	private HomepageController ContrHomepage;
	
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
			new ThankYou();
			View.dispose();
		}
		
	}

}

	class ThankYou extends CheckoutController{
	
		public ThankYou() {
			
		}
	}
