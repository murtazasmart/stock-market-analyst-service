package org.stock_market_sim.analyst_service.stock_analyst.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	//static final String url="jdbc:mysql://localhost:3306/analyst_db";
	//static final String url="jdbc:mysql://www.databases-auth.000webhost.com:3306/id6218335_analyst_db";
	static final String url="jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2243277";
	Statement st;
	
	public Statement connect(){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		//Connection conn= DriverManager.getConnection(url, "id6218335_mekala","mekala");
		Connection conn= DriverManager.getConnection(url, "sql2243277","cG3%aK9%");
		st=conn.createStatement();
		}catch(SQLException e){
			System.out.println("ERROR: Database Error :"+e);
			
		}catch (ClassNotFoundException  ee) {
			System.out.println("ERROR: ClassNotFoundException :"+ee);
		}
		return st;
	}
	public Statement disconnect(){
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
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
	public int resetDB(String resetType){
		int ret;
		ret=setResult("delete from recommendation_tab;");
		ret=setResult("delete from event_tab;");
		ret=setResult("delete from trend_tab;");
		return ret; 
	}

}
