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
	
	public void resetDataBase(String resttype){
		int x=dbconnect.resetDB(resttype);
	}
	public Trend addTrend(Trend trend){
		if (trend.getSector()==null || trend.getSector()=="") {
			trend.setSector(trend.getEntity());
		}
		//String sector="xx";
		query="Insert into trend_tab (turn, sector, stock, price) values ("+trend.getRound()+",'"+trend.getSector()+"','"+trend.getEntity()+"','"+trend.getValue()+"');";
		int x= dbconnect.setResult(query);
		x=x+1;
		//trend.setSector(trend.getSector()+"xxxx");
		return trend;
	}
	public int addRecommendation(Recommendation recommendation){
		//String sector="xx";
		query="Insert into recommendation_tab (rec_time, type, name, action, duration) values ('"+recommendation.getRectime()+"','"+recommendation.getType()+"','"+recommendation.getName()+"','"+recommendation.getAction()+"',"+recommendation.getDuration()+");";
		int x= dbconnect.setResult(query);
		//x=x+1;
		//trend.setSector(trend.getSector()+"xxxx");
		return x;
	}
	
	public void calculateRecommendations(int inturn) throws SQLException{
		int Cturn = 0;
		String Csector = "";
		String Cstock = "";
		Double Cprice = 0.0;
		
		
		query="select distinct sector, stock from trend_tab;";
		ResultSet res1= dbconnect.getResults(query);
		System.out.println("myyyyyyyyyy1");
		if (res1!=null) {
			while (res1.next()) {
				String sector=res1.getString("sector");
				String stock=res1.getString("stock");
				System.out.println("myyyyyyyyyy11");
				query="select * from trend_tab where stock='"+stock+"' and sector='"+sector+"' where turn ="+inturn+";";
				ResultSet res11= dbconnect.getResults(query);
				if (res11!=null) {
					while (res11.next()) {
						System.out.println("xx");
						Cturn = res11.getInt("turn");
						Csector = res11.getString("sector");
						Cstock = res11.getString("stock");
						Cprice = Double.parseDouble(res11.getString("price"));
						System.out.println("myyyyyyyyyy111");
					}
					
				}
				
				
				query="select * from trend_tab where stock='"+stock+"' and sector='"+sector+"' and turn >"+inturn+";";
				ResultSet res2= dbconnect.getResults(query);
				int probebility= 333;//(int)(Math.random()*10);
				if (res2!=null) {
					while (res2.next()) {
						int Turn = res2.getInt("turn");
						String Sector = res2.getString("sector");
						String Stock = res2.getString("stock");
						Double Price = Double.parseDouble(res2.getString("price")) ;
						System.out.println("myyyyyyyyyy2");
						
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
						if (sector == null || sector==stock) {
							r.setType("sector");
						}else{
							r.setType("stock");
						}
						r.setName(Stock);
						
						 probebility= 1;//(int)(Math.random()*10);
						if ((probebility==1 ||probebility==3 ||probebility==5 ||probebility==7 ||probebility==9) && r.getAction()!=null ) {
							int resp=addRecommendation(r);
						}
						
						
						
					}
					
				}
				
			}
		}
		
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
		dbconnect.disconnect();
		return recommendationAL;
		//return ArrayList<Recommendation>(recommendationAL.getClass());
	}
	
}
