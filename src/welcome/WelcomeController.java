package welcome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import homepage.HomepageController;


public class WelcomeController implements ActionListener{
	
	//To execute MVC communication on the 3 elements 
	//there has to be an instantiation of the Model and the View here
	private WelcomeModel Model;
	private WelcomeView View;
	private HomepageController ControllerHomep;
	
	
	public WelcomeController() {
		View = new WelcomeView(this);
		View.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//will redirect to the homepage
		if(e.getActionCommand().equals("Search")) {
			ControllerHomep = new HomepageController();
			View.dispose();
		}
	}

}
