package org.stock_market_sim.analyst_service.stock_analyst.services;

import org.stock_market_sim.analyst_service.stock_analyst.database.DBConnect;
import org.stock_market_sim.analyst_service.stock_analyst.model.Trend;

public class TrendService {
	private DBConnect dbconnect= new DBConnect();
	private String query;

	public Trend addTrend(Trend trend){
		query="Insert into trend_tab (turn, sector, stock, price_def) values (2,'testSEMEra','testST','5');";
		int x= dbconnect.setResult(query);
		x=x+1;
		trend.setSector(trend.getSector()+"xxxx");
		return trend;
	}
	
}
