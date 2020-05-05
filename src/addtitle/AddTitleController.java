package addtitle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import admpage.AdmController;

public class AddTitleController implements ActionListener{
	
	private AddTitleModel Model;
	private AddTitleView View;
	
	private AdmController ContrAdm;
	
	public AddTitleController() {
		View = new AddTitleView(this);
		View.setVisible(true);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//redirect to the a pop up that will ask if you want to add another item
		if(e.getActionCommand().equals("Add")) {
			
			View.dispose();
		}
		
		//redirects to the main adm menu
		if(e.getActionCommand().equals("Back")) {
			ContrAdm = new AdmController();
			View.dispose();
		}
	}

}
