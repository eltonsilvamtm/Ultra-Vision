package editaccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import admpage.AdmController;
import welcome.WelcomeController;

public class EditAccountController implements ActionListener{
	
	private EditAccountModel Model;
	private EditAccountView View;
	
	private AdmController ContrAdm;
	private WelcomeController ContrWelc;
	
	
	public EditAccountController() {
		View = new EditAccountView(this);
		View.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//redirect to the welcome page
		if(e.getActionCommand().equals("Back")) {
			ContrWelc = new WelcomeController();
			View.dispose();
		}
		
		//updates the record and redirect to the Adm page
		if(e.getActionCommand().equals("Update")) {
			ContrAdm = new AdmController();
			View.dispose();
		}
	}

}
