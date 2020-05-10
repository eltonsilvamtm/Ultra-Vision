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
	private Connect DBConnection = new Connect();
	private AdmController ContrAdm;

	
	private String query;
	private ArrayList<String> AccountInfo = new ArrayList<>();
	
	
	public EditAccountController() {
		View = new EditAccountView(this);
		View.setVisible(true);
	}

	
	/**
	 * perform the action according to what button is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getActionCommand().equals("Search")) {
			//validate
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
			boolean validate = false;
			validate = ValidateFields();
			if(validate) {
				UpdateButtonPressed();
			}
			
		}
		
	}

	/**
	 * this method takes care of what happens when the button search is pressed
	 * it performs whether it is empty validation
	 */
	private void SearchButtonPressed() {
		
		String argument = View.GetSearchArgument();
		//execute pop up if it is empty
		if(argument.isEmpty()) {
			JOptionPane.showMessageDialog(View, "Please enter a Name or a Loyalty Card.","Empty Fields",JOptionPane.ERROR_MESSAGE);
		}
		
		//search the database by name
		else{
			query = "SELECT * FROM ultravision.users WHERE username LIKE '%" 
					+ argument + "%' OR surname LIKE '%" + argument + "%' OR loyalty_card LIKE '%" + argument + "%';";
			AccountInfo = DBConnection.ReadCustomerData(query);
			
			
		}
	}
	
	
	/**
	 * this method will populate the text fields with the information available on the database
	 * it was not possible to get this feature to work so whenever the customer is called from the database the combo box is not updated
	 */
	private void PopulateFields() {
		//clear residual data before inserting new data	
		int index = 0;
		View.ClearFields();
		if(AccountInfo.get(1) == "MusicLover") {
			index = 0;
		}
		else if(AccountInfo.get(1) == "VideoLover") {
			index = 1;
		}
		else if(AccountInfo.get(1) == "TVLover") {
			index = 3;
		}
		else if(AccountInfo.get(1) == "Premium") {
			index = 4;
		}
		View.WriteLoyaltyCard(AccountInfo.get(0));
		View.WriteMembershipType(index);
		View.WriteName(AccountInfo.get(2));
		View.WriteSurname(AccountInfo.get(3));
		View.WriteEmail(AccountInfo.get(4));
		
		}

	/**
	 * implements all the major validations of this class
	 * @return true or false
	 */
	private boolean ValidateFields() {
		
		boolean validation = false;

		//error message if one of the fields is empty
		if(View.GetName().isEmpty() || View.GetSurname().isEmpty() || View.GetEmail().isEmpty()) {
			JOptionPane.showMessageDialog(View, "All fields are required.","Empty Fields",JOptionPane.ERROR_MESSAGE);
		}
		//error message if it does not match the correct email format
		else if(!View.GetEmail().matches("\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b")) {
			JOptionPane.showMessageDialog(View, "Please enter a valid email.","Email required",JOptionPane.ERROR_MESSAGE);
		}
		else {
			validation = true;
		}
		return validation;
	}


	/**
	 * update customer data on the database (the update has to be done searching through 
	 * the loyalty card as its the only way to guarantee safety of the data)
	 */
	private void UpdateButtonPressed() {
		
		boolean queryresult;
		query = "UPDATE users.ultravision SET username = '" + View.GetName() + 
				"', surname = '" + View.GetSurname() + "', email = '"
				+ View.GetEmail() + "WHERE loyalty_card = '" + View.GetLoyaltyCard();
		
		queryresult = DBConnection.ExecuteQuery(query);
		
		if(!queryresult) {
			int yesorno = JOptionPane.showConfirmDialog(View, "The account " + View.GetLoyaltyCard() + " was updated! \n "
					+ " Would you like to search another account?"," Account updated!",JOptionPane.YES_NO_OPTION);
			//0 means that the staff wants to update another account 
			if(yesorno == 0) {
				View.ClearFields();
			}
			//1 mean that he does not want to update another account
			else {
				ContrAdm = new AdmController();
				View.dispose();
			}
		}
		else {
			JOptionPane.showMessageDialog(View, "Update not completed!","Updated failure",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
}