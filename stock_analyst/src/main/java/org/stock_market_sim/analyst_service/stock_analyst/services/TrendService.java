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
	private String query;
	
	public MarketEvent addMarketEvents(MarketEvent marketEvent){
		//String sector="xx";
		query="Insert into event_tab ( round, event_name, type, entity) values ("+marketEvent.getRound()+",'"+marketEvent.getName()+"','"+marketEvent.getType()+"','"+marketEvent.getEntity()+"');";
		int x= dbconnect.setResult(query);
		x=x+1; 
		//trend.setSector(trend.getSector()+"xxxx");
		return marketEvent;
	}
	
	public Trend addTrend(Trend trend){
		String sector="xx";
		query="Insert into trend_tab (turn, sector, stock, price_def) values ("+trend.getRound()+",'"+sector+"','"+trend.getEntity()+"','"+trend.getValue()+"');";
		int x= dbconnect.setResult(query);
		x=x+1;
		//trend.setSector(trend.getSector()+"xxxx");
		return trend;
	}
	
	public List<Recommendation> sendResult(Player player){
		ArrayList<Recommendation> recommendationAL = new ArrayList<Recommendation>();
		
		query="select * from recommendation_tab;";
		ResultSet res= dbconnect.getResults(query);
		
		if (res!=null) {
			try {
				while (res.next()) {
					String rectime = res.getString("rec_time");
					String type = res.getString("type");
					String name = res.getString("name");
					String action = res.getString("action");
					int duration = res.getInt("duration");
					System.out.println("xx"+name);
					Recommendation recommendation= new Recommendation();
					recommendation.setRectime(rectime);
					recommendation.setType(type);
					recommendation.setName(name);
					recommendation.setAction(action);
					recommendation.setDuration(duration);
					System.out.println("xy"+recommendation.getDuration());
					
					recommendationAL.add(recommendation);
					//kk++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("eee"+e);
				e.printStackTrace();
			}
		}
		System.out.println("dd");
		System.out.println("element : " + recommendationAL);
//		for ( int j=0; j<recommendationAL.size(); j++ )
//		      System.out.println("element " + j + ": " + recommendationAL.get(j) );
		
		//new ArrayList<Message>(messages.values());
		return recommendationAL;
		//return ArrayList<Recommendation>(recommendationAL.getClass());
	}
	
}
