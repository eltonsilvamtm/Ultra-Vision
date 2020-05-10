package admpage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import addtitle.AddTitleController;
import editaccount.EditAccountController;
import homepage.HomepageController;
import newaccount.NewAccountController;
import welcome.WelcomeController;

public class AdmController implements ActionListener{
	
	private AdmView View;
	
	private WelcomeController ContrWelcome;
	private NewAccountController ContrNewAcc;
	private EditAccountController ContrEditAcc;
	private AddTitleController ContrAddTitle;
	private HomepageController ContrHomepage;
	
	public AdmController() {
		View = new AdmView(this);
		View.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//redirect to the create account page
		if(e.getActionCommand().equals("Create")) {
			ContrNewAcc = new NewAccountController();
			View.dispose();
		}
		
		//redirect to the edit account page
		if(e.getActionCommand().equals("Edit")) {
			ContrEditAcc = new EditAccountController();
			View.dispose();
		}
		
		//redirect to the welcome page
		if(e.getActionCommand().equals("Back")) {
			ContrHomepage = new HomepageController();
			View.dispose();
		}
		
		//redirect to the add new title page
		if(e.getActionCommand().equals("AddNewTitle")) {
			ContrAddTitle = new AddTitleController();
			View.dispose();
		}
	}

}
