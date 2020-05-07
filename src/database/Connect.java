package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Connect extends JFrame{
	
	private String dbServer = "jdbc:mysql://localhost:3306/ultravision";
    private String user = "root";
    private String password = "beatles.506070";
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs;
    private ArrayList<String> data = new ArrayList<String>();
    
    
    //Constructor that will create a connection
    public Connect(){
        
        try{
            // Get a connection to the database
            conn = DriverManager.getConnection(dbServer, user, password) ;

            // Get a statement from the connection
            stmt = conn.createStatement() ;

        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
                System.out.println( e ) ;
        }
        
    }
    
    
    /**
     * 
     * @param data which will be added to the database
     * @param query to run the program
     * @return whether it was successful or not
     */
    public boolean ExecuteQuery(String query) {
    	
    	boolean result = false;
    	try{
            // Execute the query
            rs = stmt.executeQuery(query);
            //requesting whether the query was successful or not
            result = rs.next();

            // Calling the method in charge of closing the connections
            CloseConnection();
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
                System.out.println( e ) ;
        }
    	
    	return result;
    }
    
    
    
    /**
     * 
     * @param query used to read the data from the database
     * @return whether the data was found or not
     */
    public ArrayList<String> ReadCustomerData(String query) {
    	
    	try{
            // Execute the query
            rs = stmt.executeQuery(query);
            
            //requesting whether the query was successful or not
            if(rs.next()) {
            	//fetching the data
            	while(rs.next()){	
              		data.add( rs.getString("name"));
              		data.add( rs.getString("surname"));
              		data.add( rs.getString("email"));
              		data.add( rs.getString("loyalty_card"));
            	}
            }
            //account not found
            else {
            	JOptionPane.showMessageDialog(this, "Account could not be found!","Account not found",JOptionPane.ERROR_MESSAGE);
            }

            // Calling the method in charge of closing the connections
            CloseConnection();
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
                System.out.println( e ) ;
        }
    	
    	return data;
    }
    
    
    /**
     * 
     * @param query used to read the data from the database
     * @return whether the data was found or not
     */
    public ArrayList<String> ReadTitleData(String query) {
    	
    	try{
            // Execute the query
            rs = stmt.executeQuery(query);
            
            //requesting whether the query was successful or not
            if(rs.next()) {
            	//fetching the data
            	while(rs.next()){
            		data.add( rs.getString("title"));
            		data.add( rs.getString("genre"));
            		data.add( rs.getString("director_band"));
            		data.add( rs.getString("year"));
            		data.add( rs.getString("quantity"));
            		data.add( rs.getString("membership_type"));
            	}
            }
            //account not found
            else {
            	JOptionPane.showMessageDialog(this, "Title could not be found!","Title not found",JOptionPane.ERROR_MESSAGE);
            }

            // Calling the method in charge of closing the connections
            CloseConnection();
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
                System.out.println( e ) ;
        }
    	
    	return data;
    }

    
    /**
     * delete the data from the database
     */
    public void DeleteData(String query) {
    	try{
            // Execute the query
            rs = stmt.executeQuery(query);

            // Calling the method in charge of closing the connections
            CloseConnection();
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
                System.out.println( e ) ;
        }
    }
    
    
    
    private void CloseConnection() {
    	  try {
              rs.close();
              stmt.close();
              conn.close();
          }
          catch (SQLException ex) {
              Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

}
