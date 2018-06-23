package org.stock_market_sim.analyst_service.stock_analyst.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	//static final String url="jdbc:mysql://localhost:3306/analyst_db";
	
	//static final String url="jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2243277";
	static final String url="jdbc:mysql://mysql7001.site4now.net:3306/db_a3d821_analyst";
	Connection conn;
	Statement st;
	
	public Statement connect(){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		//Connection conn= DriverManager.getConnection(url, "root","");
		//Connection conn= DriverManager.getConnection(url, "sql2243277","cG3%aK9%");
		conn= DriverManager.getConnection(url, "a3d821_analyst","mekala1234");
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
			System.out.println("ERROR: Database Error :");  
			conn.close();
			//st.close();
		} catch (SQLException e) {
			
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
		query=query+"commit;";
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
	public int resetDB(String resetType,String gameId ,String useId){
		int ret;
		ret=setResult("delete from recommendation_tab where game_id='"+gameId+"' and user_id ='"+useId+"';");
		ret=setResult("delete from event_tab;");
		ret=setResult("delete from trend_tab where game_id='"+gameId+"' and user_id ='"+useId+"';");
		return ret; 
	}

}
