package editaccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import admpage.AdmController;
import database.Connect;
import homepage.HomepageController;
import welcome.WelcomeController;

public class EditAccountController extends Connect implements ActionListener {
	
	protected EditAccountView View;
	private Connect DBConnection;
	private AdmController ContrAdm;

	
	private String query;
	private ArrayList<String> AccountInfo = new ArrayList<>();
	
	
	public EditAccountController() {
		View = new EditAccountView(this);
		View.setVisible(true);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getActionCommand().equals("Search")) {
			
			SearchButtonPressed();
			PopulateFields();
		}
		
		
		//redirect to the welcome page
		if(e.getActionCommand().equals("Back")) {
			ContrAdm = new AdmController();
			View.dispose();
		}
		
		
		//updates the record and asks whether you want to update another customer
		if(e.getActionCommand().equals("Update")) {
			
			ValidateFields();
			UpdateButtonPressed();
			UpdateAnotherCustomer();
		}
		
	}


	private void SearchButtonPressed() {
		
		String argument = View.GetSearchArgument();
		//execute pop up if it is empty
		if(argument.isEmpty()) {
			JOptionPane.showMessageDialog(View, "Please enter a Name or a Loyalty Card.","Empty Fields",JOptionPane.ERROR_MESSAGE);
		}
		
		//search the database by name
		else if(argument.matches("([A-Z]|[a-z])")) {
			
			query = "SELECT name, surname, email, loyalty_card FROM users.ultravision WHERE name = '" + argument + "'";
			AccountInfo = DBConnection.ReadCustomerData(query);
						
		}
		
		//search the database by loyalty card
		else if(argument.matches("(\\d{4}[-. ]?){4}|\\d{4}[-. ]?\\d{6}[-. ]?\\d{5}")) {
			
			query = "SELECT name, surname, email, loyalty_card FROM users.ultravision WHERE loyalty_card = " + argument + "";
			AccountInfo = DBConnection.ReadCustomerData(query);
			
		}
	}
	
	
	//this method will populate the text fields with the information available on the database
	private void PopulateFields() {
		//clear residual data before inputing new data	
		View.ClearFields();
		View.WriteName(AccountInfo.get(0));
		View.WriteSurname(AccountInfo.get(1));
		View.WriteEmail(AccountInfo.get(2));
		View.WriteLoyaltyCard(AccountInfo.get(3));
		}


	private void ValidateFields() {

		//error message if one of the fields is empty
		if(View.GetName().isEmpty() || View.GetSurname().isEmpty() || View.GetEmail().isEmpty()) {
			JOptionPane.showMessageDialog(View, "All fields are required.","Empty Fields",JOptionPane.ERROR_MESSAGE);
		}
		//error message if it does not match the correct email format
		if(!View.GetEmail().matches("\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b")) {
			JOptionPane.showMessageDialog(View, "Please enter a valid email.","Email required",JOptionPane.ERROR_MESSAGE);
		}
		
	}


	//update customer data on the database (the update has to be done searching through 
	//the loyalty card as its the only way to guarantee safety of the data)
	private void UpdateButtonPressed() {
		
		boolean queryresult;
		query = "UPDATE users.ultravision SET name = '" + View.GetName() + 
				"', surname = '" + View.GetSurname() + "', email = '"
				+ View.GetEmail() + "WHERE loyalty_card = '" + View.GetLoyaltyCard();
		
		queryresult = DBConnection.ExecuteQuery(query);
		
		if(queryresult) {
			JOptionPane.showMessageDialog(View, "Account successfuly updated!","Account updated",JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(View, "Update not completed!","Updated failure",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	private void UpdateAnotherCustomer() {
		
		int yesorno = JOptionPane.showConfirmDialog(View, "Would you like to update another customer?","Updated customer",JOptionPane.YES_NO_OPTION);
		//0 means yes
		if(yesorno == 0) {
			View.ClearFields();
		}
		else {
			ContrAdm = new AdmController();
			View.dispose();
		}
	}

	
}