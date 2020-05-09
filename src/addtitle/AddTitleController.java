package addtitle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import admpage.AdmController;
import database.Connect;

public class AddTitleController implements ActionListener{
	
	protected AddTitleView View;
	private AdmController ContrAdm;
	private Connect DBConnection = new Connect();
	
	private String NewTitle[] = new String[6];
	private String query;
	
	public AddTitleController() {
		View = new AddTitleView(this);
		View.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//check whether there is any empty field as well as if the number fields match
		if(e.getActionCommand().equals("Add")) {
			//redirect to a validation section
			boolean validate;
			validate = ValidateFields();
			if(validate) {
				AddButtonPressed();
				AddAnotherTitle();
			}
			
		}
		
		//redirects to the main adm menu
		if(e.getActionCommand().equals("Back")) {
			ContrAdm = new AdmController();
			View.dispose();
		}
	}
	
	
	
	private boolean ValidateFields() {
		boolean validation = false;
		//display pop up error message if there are any empty fields
		
		if(View.GetTitle().isEmpty() || View.GetDirectorOrBand().isEmpty() || View.GetGenre().isEmpty() 
			|| View.GetQuantity().isEmpty() || View.GetYearOfRelease().isEmpty() || View.GetMembershipType().isEmpty()) {
			JOptionPane.showMessageDialog(View, "All fields are required.","Empty Fields",JOptionPane.ERROR_MESSAGE);
		}
		
		//display an error message if the quantity is not a number between 1 and 100
		else if(!View.GetQuantity().matches("\\b(\\d){1,100}\\b")) {
			JOptionPane.showMessageDialog(View, "Please enter a number between 1 and 100.","Quantity required",JOptionPane.ERROR_MESSAGE);
		}
		
		//display an error message if the number entered is not a 4 digit format
		else if(!View.GetYearOfRelease().matches("^(19[0-9]{2}|2[0-9]{3})$")) {
			JOptionPane.showMessageDialog(View, "Please enter a year between 1900 and 2020.","Year required",JOptionPane.ERROR_MESSAGE);
		}else {
			validation = true;
		}
		
		return validation;
	}


	private void AddButtonPressed() {
		
		boolean queryresult;
		query = "INSERT INTO ultravision.titles (title, genre, director_band, yearofrelease, membership_type, quantity) VALUES ('"
				+ View.GetTitle() + "', '" + View.GetGenre() + "', '" + View.GetDirectorOrBand() + "', '" 
				+ View.GetYearOfRelease() + "', '" + View.GetMembershipType() + "', '" + View.GetQuantity() +"');";
		System.out.println(query);
		//System.exit(0);
		queryresult = DBConnection.ExecuteQuery(query);
		
		if(!queryresult) {
			JOptionPane.showMessageDialog(View, "Title successfuly added!","Account updated", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(View, "There was an error trying to add a new title!","Insert Into failure",JOptionPane.ERROR_MESSAGE);
		}
	}


	private void AddAnotherTitle() {
		
		int decision = JOptionPane.showConfirmDialog(View, "Would you like to add another title?","Add another title",JOptionPane.YES_NO_OPTION );
		
		//zero means that the user pressed yes
		//it is necessary to clear the fields before closing the pop up
		if(decision == 0) {
			View.ClearFields();
		}
		//one means that the user pressed no
		//redirect user to the adm menu page
		else if(decision == 1) {
			ContrAdm = new AdmController();
			View.dispose();
		}
		
	}


}