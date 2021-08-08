/**
 * 
 */
package com.aditya.jdbc;

import java.sql.CallableStatement;
/**
 * @author aditya
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class JDBCTest {
    
	//private final static String HOST = "jdbc:mysql://mysql-rfam-public.ebi.ac.uk:4497/Rfam";
	//private final static String USER = "rfamro";
	
	private final static String HOST = "jdbc:mysql://localhost:3306/employees";
	private final static String USER = "root";
	private final static String PASSWORD = "root";
	private final static String STATEMENT_QUERY = "SELECT * FROM EMPLOYEES";
	private final static String PREPARED_STATEMENT_QUERY = "UPDATE EMPLOYEES SET FIRST_NAME=? where EMP_NO=?";
	private final static String CALLABLE_STATEMENT_QUERY = "{? = call sayHello(?)}";
    public static void main(String[] args) {

       
       /* try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
      */
    	Statement stmt = null; //PreparedStatement-arguments //CallableStatement - Functions/procedures
    	ResultSet rs = null;
    	PreparedStatement pStmt = null;
		CallableStatement cStmt = null;
     
        try (Connection conn = DriverManager.getConnection(
                HOST,USER , PASSWORD)) {

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
          
		    //Statement
            stmt = conn.createStatement();
            
            rs= stmt.executeQuery(STATEMENT_QUERY);
            //Using If to fetch only one record
            if(rs.next()) {
            	System.out.println(rs.getString("FIRST_NAME")+" "+rs.getString("LAST_NAME"));
            }
			
			
			//PreparedStatement
			 pStmt = conn.prepareStatement(PREPARED_STATEMENT_QUERY);
			 pStmt.setString(1,"Aditya");
			 pStmt.setInt(2,10001);
			 
			 int records = pStmt.executeUpdate();
			 System.out.println(records +" got updated");
			 
			//CallableStatement
			cStmt = conn.prepareCall(CALLABLE_STATEMENT_QUERY);
			cStmt.registerOutParameter(1, Types.VARCHAR);
            cStmt.setString(2, "Aditya");
            cStmt.execute();

            System.out.print("String Returned: "+cStmt.getString(1));
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}