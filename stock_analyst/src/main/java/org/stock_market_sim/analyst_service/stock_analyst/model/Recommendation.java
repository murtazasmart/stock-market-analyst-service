package org.stock_market_sim.analyst_service.stock_analyst.model;

public class Recommendation {

	private String rectime;
	private String type;
	private String name;
	private String action;
	private int duration;
	public String getRectime() {
		return rectime;
	}
	public void setRectime(String rectime) {
		this.rectime = rectime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
