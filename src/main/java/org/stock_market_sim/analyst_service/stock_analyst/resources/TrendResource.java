package org.stock_market_sim.analyst_service.stock_analyst.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.stock_market_sim.analyst_service.stock_analyst.model.MarketEvent;
import org.stock_market_sim.analyst_service.stock_analyst.model.Player;
import org.stock_market_sim.analyst_service.stock_analyst.model.Recommendation;
import org.stock_market_sim.analyst_service.stock_analyst.model.Trend;
import org.stock_market_sim.analyst_service.stock_analyst.services.TrendService;

import com.google.gson.Gson;


@Path("/trends")
public class TrendResource {
	
	TrendService trendService = new TrendService();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response reqHelp(Player player){
		System.out.println("Analyser Started");
		System.out.println("User: "+player.getUser()); 
		System.out.println("Game id: "+player.getGameId()); 
		trendService.resetDataBase("",player.getGameId(),player.getUser());  
		Boolean validity=addTrendstoDB(player.getGameId(),player.getUser());
		if (validity.equals(true)) {
			addEventstoDB(player.getGameId());
			Gson gson = new Gson();
			return Response
				      .status(200)
				      .header("Access-Control-Allow-Origin", "*")
				      .entity(gson.toJson(sendResult(player,player.getGameId(),player.getUser())))
				      .build();
//			return sendResult(player,player.getGameId(),player.getUser());
		}
		else {
			return Response
				      .status(200)
				      .header("Access-Control-Allow-Origin", "*")
				      .header("Access-Control-Allow-Credentials", "true")
				      .header("Access-Control-Allow-Headers",
				        "origin, content-type, accept, authorization")
				      .header("Access-Control-Allow-Methods", 
				        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				      .entity("[]")
				      .build();
			//return null;
		}
		
		
	}
	
	public boolean addTrendstoDB(String gameid ,String useId){
		Boolean chkGameId=true;
		String requrl="https://stock-market-simulator.herokuapp.com/api/v1/game/trends/"+gameid;
		
		Client client =ClientBuilder.newClient();
		
		WebTarget target =client.target(requrl);
		
		Builder builder= target.request(MediaType.APPLICATION_JSON);
		
		
		Response response = builder.get();
		List <Trend> trends=null;
		try{
		trends= response.readEntity(new GenericType<List<Trend>>(){});
//		for (Trend trend:trends){
//		}
		}catch(ClassCastException e){
			System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmffffffffff");
			chkGameId=false;
		}finally{
			if (chkGameId.equals(true)) {
				System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmffffffffff");
				trendService.addTrends(gameid,useId, trends);
			}
		return chkGameId;
		}
	}
	
	public void addEventstoDB(String gameid){
		
		String requrl="https://stock-market-simulator.herokuapp.com/api/v1/game/events/"+gameid;
		Client client =ClientBuilder.newClient();
		
		WebTarget target =client.target(requrl);
		Builder builder= target.request(MediaType.APPLICATION_JSON);
		Response response = builder.get();
		
		List <MarketEvent> marketEvents= response.readEntity(new GenericType<List<MarketEvent>>(){});
//		for (MarketEvent marketEvent:marketEvents){
			trendService.addMarketEvents(marketEvents);
//			
//		}
	}
	
	
//POST
	//Consumes(MediaType.APPLICATION_JSON)
	//Produces(MediaType.APPLICATION_JSON)
//	public Trend addTrend(Trend trend){
//		getHelp();
//		return trendService.addTrend(trend);
//		
//	}
	public List<Recommendation> sendResult(Player player, String gameid ,String useId){
		try {
			
			trendService.calculateRecommendations(Integer.parseInt(player.getTurn()),gameid,useId);
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return trendService.sendResult(player,gameid,useId);  
	}
	
	public void getHelp(){
		Client client =ClientBuilder.newClient();
		
		WebTarget target =client.target("http://localhost:8080/testmewanrest/webapi/messages");
		Builder builder= target.request(MediaType.APPLICATION_JSON);
		Response response = builder.get();
		
		List <Messagexx> messages= response.readEntity(new GenericType<List<Messagexx>>(){});
		for (Messagexx message:messages){
			
			System.out.println("mmmmmm"+message.getMessage()); 
		}
		
		
	}

}
