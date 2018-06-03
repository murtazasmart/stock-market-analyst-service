package org.stock_market_sim.analyst_service.stock_analyst.resources;

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
		return sendResult(player);
		//getHelp();
		//return trendService.addTrend(trend);
		
	}
	
	
	
//POST
	//Consumes(MediaType.APPLICATION_JSON)
	//Produces(MediaType.APPLICATION_JSON)
//	public Trend addTrend(Trend trend){
//		getHelp();
//		return trendService.addTrend(trend);
//		
//	}
	public List<Recommendation> sendResult(Player player){
		return trendService.sendResult(player);  
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