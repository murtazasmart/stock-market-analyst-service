package org.stock_market_sim.analyst_service.stock_analyst.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.stock_market_sim.analyst_service.stock_analyst.database.DBConnect;
import org.stock_market_sim.analyst_service.stock_analyst.model.MarketEvent;
import org.stock_market_sim.analyst_service.stock_analyst.model.Player;
import org.stock_market_sim.analyst_service.stock_analyst.model.Trend;
import org.stock_market_sim.analyst_service.stock_analyst.model.Recommendation;

public class TrendService {
	private DBConnect dbconnect= new DBConnect();
	private String query="";
	
	public MarketEvent addMarketEvents(MarketEvent marketEvent){
		//String sector="xx";
		query="Insert into event_tab ( round, event_name, type, entity) values ("+marketEvent.getRound()+",'"+marketEvent.getName()+"','"+marketEvent.getType()+"','"+marketEvent.getEntity()+"');";
		int x= dbconnect.setResult(query);
		x=x+1; 
		//trend.setSector(trend.getSector()+"xxxx");
		return marketEvent;
	}
	
	public void resetDataBase(String resttype,String gameid ,String useId){
		int x=dbconnect.resetDB(resttype, gameid , useId);
	}
	int x=2;
	public Trend addTrends(String gameid ,String useId, List<Trend> trends){
		
		for (Trend trend:trends){		
			String squery="Insert into trend_tab (turn, sector, stock, price, game_id, user_id) values ("+trend.getRound()+",'"+trend.getSector()+"','"+trend.getEntity()+"','"+trend.getValue()+"','"+gameid+"','"+useId+"');";
			query=query+squery;
		}
		
//		if ( trend.getType().equals("sector")) {
//			
//			trend.setSector(trend.getEntity()); 
//		}
		
		//String sector="xx";
//		String squery=" Insert into trend_tab (turn, sector, stock, price, game_id, user_id) values ("+trend.getRound()+",'"+trend.getSector()+"','"+trend.getEntity()+"','"+trend.getValue()+"','"+gameid+"','"+useId+"');";
//		query=query+squery;
		System.out.println(query);
//		if (x==10) {
			int xxxx= dbconnect.setResult(query);
//		}
		
		x=x+1;
		//trend.setSector(trend.getSector()+"xxxx");
		return trends.get(0);
	}
	public int addRecommendation(Recommendation recommendation,String gameId ,String useId){
		//String sector="xx";
		query="Insert into recommendation_tab (rec_time, type, name, action, duration, game_id, user_id) values ('"+recommendation.getRectime()+"','"+recommendation.getType()+"','"+recommendation.getName()+"','"+recommendation.getAction()+"',"+recommendation.getDuration()+",'"+gameId+"','"+useId+"');";
		int x= dbconnect.setResult(query);
		//x=x+1;
		//trend.setSector(trend.getSector()+"xxxx");
		return x;
	}
	
	public void calculateRecommendations(int inturn,String gameId ,String useId) throws SQLException{
		int Cturn = 0;
		String Csector = "";
		String Cstock = "";
		Double Cprice = 0.0;
		
		
		query="select distinct sector, stock from trend_tab where game_id='"+gameId+"' and user_id ='"+useId+"';";
		ResultSet res1= dbconnect.getResults(query);
		
		if (res1!=null) {
			while (res1.next()) {
				String sector=res1.getString("sector");
				String stock=res1.getString("stock");
				
				query="select * from trend_tab where stock='"+stock+"' and sector='"+sector+"' and turn ="+inturn+" and game_id='"+gameId+"' and user_id ='"+useId+"';";
				ResultSet res11= dbconnect.getResults(query);
				if (res11!=null) {
					while (res11.next()) {
						
						Cturn = res11.getInt("turn");
						Csector = res11.getString("sector");
						Cstock = res11.getString("stock");
						Cprice = Double.parseDouble(res11.getString("price"));
						
					}
					
				}
				
				
				query="select * from trend_tab where stock='"+stock+"' and sector='"+sector+"' and turn >"+inturn+" and game_id='"+gameId+"' and user_id ='"+useId+"';";
				ResultSet res2= dbconnect.getResults(query);
				int probebility= 333;//(int)(Math.random()*10);
				if (res2!=null) {
					while (res2.next()) {
						int Turn = res2.getInt("turn");
						String Sector = res2.getString("sector");
						String Stock = res2.getString("stock");
						Double Price = Double.parseDouble(res2.getString("price")) ;
						
						
						Recommendation r= new Recommendation();
						r.setRectime(""+inturn);
						if (Cprice < Price) {
							if (probebility==2) {
								r.setAction("SELL");
							}else {
							r.setAction("BUY");
							}
							//r.setDuration(Cturn-inturn);
//							if (sector == null || sector==stock) {
//								r.setType("sector");
//							}else{
//								r.setType("stock");
//							}
//							r.setName(Stock);
//							int resp=addRecommendation(r);
						}
						
						if (Cprice > Price) {
							//r.setRectime(""+inturn);
							if (probebility==4) {
								r.setAction("BUY");
							}
							r.setAction("SELL");
						}
						r.setDuration(Turn-inturn);
						//r.setDuration(Cturn-inturn);
						if (sector.equals(stock)) {
							r.setType("sector");
						}else{
							r.setType("stock");
						}
						r.setName(Stock);
						
						 probebility= 1;//(int)(Math.random()*10);
						if ((probebility==1 ||probebility==3 ||probebility==5 ||probebility==7 ||probebility==9) && r.getAction()!=null ) {
							int resp=addRecommendation(r, gameId , useId);
						}
						
						
						
					}
					
				}
				
			}
		}
		
	}
	
	public List<Recommendation> sendResult(Player player,String gameId ,String useId){
		ArrayList<Recommendation> recommendationAL = new ArrayList<Recommendation>();
		
		query="select * from recommendation_tab where game_id='"+gameId+"' and user_id ='"+useId+"';";
		ResultSet res= dbconnect.getResults(query);
		
		if (res!=null) {
			try {
				while (res.next()) {
					String rectime = res.getString("rec_time");
					String type = res.getString("type");
					String name = res.getString("name");
					String action = res.getString("action");
					int duration = res.getInt("duration");
					
					Recommendation recommendation= new Recommendation();
					recommendation.setRectime(rectime);
					recommendation.setType(type);
					recommendation.setName(name);
					recommendation.setAction(action);
					recommendation.setDuration(duration);
					
					
					recommendationAL.add(recommendation);
					//kk++;
				}
			} catch (SQLException e) {
				
				System.out.println("eee"+e);
				e.printStackTrace();
			}
		}
		

		dbconnect.disconnect();
		return recommendationAL;
		
	}
	
}
