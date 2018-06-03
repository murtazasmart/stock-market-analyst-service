package org.stock_market_sim.analyst_service.stock_analyst.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	static final String url="jdbc:mysql://localhost:3306/analyst_db";
	Statement st;
	
	public Statement connect(){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection(url, "root","");
		st=conn.createStatement();
		}catch(SQLException e){
			System.out.println("ERROR: Database Error :"+e);
			
		}catch (ClassNotFoundException  ee) {
			System.out.println("ERROR: ClassNotFoundException :"+ee);
		}
		return st;
	}
	
	public ResultSet getResults(String query){
        ResultSet res = null;
        try{
        connect();
        res = st.executeQuery(query);
        }
        catch(SQLException| NullPointerException e){
            
        }
        return res;
    }
	
	public int setResult(String query){
        int res = 0;
        try{
        Statement st = connect();
        System.out.println("RES: "+query);
        res = st.executeUpdate(query);
        }
        catch(SQLException| NullPointerException e){
        }
        
        return res;
    }

}
