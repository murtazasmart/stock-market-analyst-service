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


@Path("/trends")
public class TrendResource {
	
	TrendService trendService = new TrendService();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Recommendation> reqHelp(Player player){
		System.out.println("mmmmmm"+player.getUser()); 
		System.out.println("mmmmmm"+player.getGameId()); 
		trendService.resetDataBase("",player.getGameId(),player.getUser());  
		addTrendstoDB(player.getGameId(),player.getUser());
		addEventstoDB(player.getGameId());
		
		return sendResult(player,player.getGameId(),player.getUser());
		//getHelp();
		//return trendService.addTrend(trend);
		
	}
	
	public void addTrendstoDB(String gameid ,String useId){
		//gameid="5b2007adaad91b0030c23d8e";
		String requrl="https://stock-market-simulator.herokuapp.com/api/v1/game/trends/"+gameid;
		Client client =ClientBuilder.newClient();
		
		WebTarget target =client.target(requrl);
		Builder builder= target.request(MediaType.APPLICATION_JSON);
		Response response = builder.get();
		System.out.println("to hear done MERALK");
		List <Trend> trends= response.readEntity(new GenericType<List<Trend>>(){});
		for (Trend trend:trends){
			trendService.addTrend(trend,gameid,useId);
			System.out.println("mmmmmmxx"+trend.getEntity()+" AND "+trend.getRound()+" AND "+trend.getValue()); 
		}
	}
	
	public void addEventstoDB(String gameid){
		//gameid="5b2007adaad91b0030c23d8e";
		String requrl="https://stock-market-simulator.herokuapp.com/api/v1/game/events/"+gameid;
		Client client =ClientBuilder.newClient();
		
		WebTarget target =client.target(requrl);
		Builder builder= target.request(MediaType.APPLICATION_JSON);
		Response response = builder.get();
		System.out.println("to hear done MERALK");
		List <MarketEvent> marketEvents= response.readEntity(new GenericType<List<MarketEvent>>(){});
		for (MarketEvent marketEvent:marketEvents){
			trendService.addMarketEvents(marketEvent);
			//System.out.println("mmmmmmxx"+trend.getEntity()+" AND "+trend.getRound()+" AND "+trend.getValue()); 
		}
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
			System.out.println("mxxxxxxxxxxxxxx");
			trendService.calculateRecommendations(Integer.parseInt(player.getTurn()),gameid,useId);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trendService.sendResult(player,gameid,useId);  
	}
	public void getHelp(){
		Client client =ClientBuilder.newClient();
		
		WebTarget target =client.target("http://localhost:8080/testmewanrest/webapi/messages");
		Builder builder= target.request(MediaType.APPLICATION_JSON);
		Response response = builder.get();
		System.out.println("to hear done MERALK");
		List <Messagexx> messages= response.readEntity(new GenericType<List<Messagexx>>(){});
		for (Messagexx message:messages){
			
			System.out.println("mmmmmm"+message.getMessage()); 
		}
		
		
		
		
		//message.
//		Response response =client.target("http://localhost:8080/testmewanrest/webapi/messages").request(MediaType.APPLICATION_JSON).get();
//		Messagexx message= response.readEntity(Messagexx.class);
//		String message=response.readEntity(String.class);
//		
//		String arrayFromString=message;
//		Gson googleJson = new Gson();
//		List<Messagexx>  javaArrayListFromGSON = googleJson.fromJson(arrayFromString, Messagexx.class);
//		 
//		System.out.println(javaArrayListFromGSON);
		
		//System.out.println("mmmmmm"+message.getMessage());
	}

}
