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
	private Connect DBConnection;
	
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
			
			ValidateFields();
			CreateButtonPressed();
			CreateAnotherAccount();
		}
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
	

	private void CreateButtonPressed() {
		
		boolean queryresult;
		loyalty_card = GetLoyaltyCard();
		query = "INSERT INTO users.ultravision (name, surname, email, loyalty_card) VALUES ('"
		+ View.GetName() + "', '" + View.GetSurname() + "', '" + View.GetEmail() + "', '" + loyalty_card +")";
		
		queryresult = DBConnection.ExecuteQuery(query);
		
		if(queryresult) {
			JOptionPane.showMessageDialog(View, "Account successfuly created!","Account updated",JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(View, "There was an error trying to create a new account!","Insert Into failure",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	private void CreateAnotherAccount() {
		
		int yesorno = JOptionPane.showConfirmDialog(View, "Would you like to create another account?","Updated customer",JOptionPane.YES_NO_OPTION);
		//0 means yes
		if(yesorno == 0) {
			JOptionPane.showMessageDialog(View, loyalty_card ,"Loyalty card number:",JOptionPane.INFORMATION_MESSAGE);
			View.ClearFields();
		}
		else {
			JOptionPane.showMessageDialog(View, loyalty_card ,"Loyalty card number:",JOptionPane.INFORMATION_MESSAGE);
			ContrAdm = new AdmController();
			View.dispose();
		}
		
	}
	

	//this method will create a simple new membership card
	private String GetLoyaltyCard() {
		String MyCard;
		double max = 999999999999999.9;
		double min = 100000000000000.0;
		double cardnumber = (Math.random()*((max-min)+1))+min;
		//casting the card number into a string
		MyCard = Double.toString(cardnumber);
		//removing the dot of the double number
		MyCard.trim().replaceAll(".", "");
		return MyCard;
	}




}
