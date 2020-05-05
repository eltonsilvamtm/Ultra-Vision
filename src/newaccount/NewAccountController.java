package newaccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import admpage.AdmController;


public class NewAccountController implements ActionListener{
	
	private NewAccountModel Model;
	private NewAccountView View;
	private AdmController ContrAdm;
	
	public NewAccountController() {
		View = new NewAccountView(this);
		View.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//redirect to the Adm page
		if(e.getActionCommand().equals("Back")) {
			ContrAdm = new AdmController();
			View.dispose();
		}
		
		//create a new account and redirect to as pop up asking if you want to create anothe account
		if(e.getActionCommand().equals("Create")) {
			
		}
	}

}
