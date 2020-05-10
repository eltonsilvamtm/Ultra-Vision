package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Connect extends JFrame{
	
	//this huge string named as dbServer name was the only option i found to fix the different time zone server 
	//here is the link with the source
	//https://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue
	private String dbServer = "jdbc:mysql://127.0.0.1:3306/ultravision?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow";
    private String user = "root";
    private String password = "root081190";
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs;
    
    private ArrayList<String> data = new ArrayList<String>();
    
    
    /**
     * Constructor that will create a connection
     */
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
     * this method is used as a is a general type of query usage.
     * it can perform inserts, updates and delete queries
     * @param data which will be added to the database
     * @param query to run the program
     * @return true or false
     */
    public boolean ExecuteQuery(String query) {
    	
    	boolean result = false;
    	
    	try{
            // Execute the query
    		result = stmt.execute(query);
    		
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
     * method to read the customer data from the database and 
     * return it to the controller which will then add it to the view
     * @param query used to read the data from the database
     * @return whether the data was found or not
     */
    public ArrayList<String> ReadCustomerData(String query) {
    	
    	try{
            // Execute the query
            rs = stmt.executeQuery(query);
            
            	while(rs.next()){
            		data.add( rs.getString("loyalty_card"));
            		data.add( rs.getString("membership_type"));
              		data.add( rs.getString("username"));
              		data.add( rs.getString("surname"));
              		data.add( rs.getString("email"));
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
     * @return an arraylist that contains the table info
     */
    public ArrayList<String> ReadTitleData(String query) {
    	
    	try{
    		//conn = DriverManager.getConnection(dbServer, user, password) ;
    		PreparedStatement pst = conn.prepareStatement(query);
    		rs = pst.executeQuery(query);
            // Execute the query
            
              	//fetching the data
            	while(rs.next()){
            		data.add( rs.getString("title"));
            		data.add( rs.getString("genre"));
            		data.add( rs.getString("director_band"));
            		data.add( rs.getString("yearofrelease"));
            		data.add( rs.getString("quantity"));
            		data.add( rs.getString("membership_type"));
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
     * @param query selects all the titles from the database
     * @return a table model which will be inserted into a table at the home page view
     */
    public DefaultTableModel GetTableData(String query) {
			
    	DefaultTableModel model = new DefaultTableModel();
    	model.addColumn("Title");
		model.addColumn("Genre");
		model.addColumn("Director/Band");
		model.addColumn("Category");
		model.addColumn("Year");
		model.addColumn("In Stock");
    	
    	
		try {
			//get prepared statement
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery(query);
			
			//loop through all the database data
			while(rs.next()) {
				
				//get all elements off of one row
				String title = rs.getString("title");
				String genre = rs.getString("genre");
				String director_band = rs.getString("director_band");
				String yearofrelease = rs.getString("yearofrelease");
				String category = rs.getString("membership_type");
				String in_stock = rs.getString("quantity");
				
				//add the row to the default table model
				Object[] rowdata = {title, genre, director_band, yearofrelease, category, in_stock};
				model.addRow(rowdata);
			}
			
			return model;
		}catch( SQLException se ){
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
		
		
    	return null;
    }
    
    /**
     * close the connection at the end of every query
     */
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
