package newaccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import addtitle.AddTitleController;
import admpage.AdmController;
import database.Connect;


public class NewAccountController extends Connect implements ActionListener{
	
	protected NewAccountView View;
	private AdmController ContrAdm;
	private Connect DBConnection = new Connect();
	
	private String[] NewAccount = new String[4];
	private String query;
	private String loyalty_card;
	
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
		
		//create a new account and redirect to as pop up asking if you want to create another account
		if(e.getActionCommand().equals("Create")) {
			boolean validate = false;
			validate = ValidateFields();
			if(validate) {
				CreateButtonPressed();
			}
			
		}
	}

	
	/**
	 * treats user inputs checking whether they are empty or does not contain email pattern 
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
				} else {
					validation = true;
				}
		return validation;
	}
	
	/**
	 * this method inserts a new user into the database system
	 * it also checks whether the query was successful or not 
	 */
	private void CreateButtonPressed() {
		
		boolean queryresult;
		loyalty_card = GetLoyaltyCard();
		
		query = "INSERT INTO ultravision.users (loyalty_card, membership_type, username, surname, email) VALUES ('"
		+ loyalty_card + "', '" + View.GetMembershipType() + "', '" + View.GetName() + "', '" + View.GetSurname() + "', '" + View.GetEmail() +"');";
		
		queryresult = DBConnection.ExecuteQuery(query);
		
		//if query result is true it means that the account was updated
		if(!queryresult) {
			int yesorno = JOptionPane.showConfirmDialog(View, "Account succesfully created! Your Loyalty card number is: \n" + loyalty_card +
							"\n Would you like to create another account?","Welcome!",JOptionPane.YES_NO_OPTION);
			//0 means create another account and 1 means that he is done creating accounts
			if(yesorno == 0) {
				View.ClearFields();
			}
			else {
				ContrAdm = new AdmController();
				View.dispose();
			}
		}
		//if the account cannot be created for an external reason
		else {
			JOptionPane.showMessageDialog(View, "There was an error trying to create the account!","Insert Into failure",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	

	/**
	 * this method will create a simple new membership card
	 * @return the loyalty card number
	 */
	private String GetLoyaltyCard() {
		String MyCard;
		int max = 9;
		int min = 1;
		double cardnumber =  ((Math.random()*((max-min)+1))+min);
		//casting the card number into a string and setting to be a maximum of 12 numbers
		MyCard = Double.toString(cardnumber).replace(".", "").substring(0, 12);
		//removing the dot of the double number
		MyCard.trim().replaceFirst(".", "");
		return MyCard;
		
	}




}
