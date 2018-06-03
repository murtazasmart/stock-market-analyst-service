package org.stock_market_sim.analyst_service.stock_analyst.model;

public class Trend {

	private int turn;
	private String sector;
	private String stock;
	double priceDef;
	
	public Trend(){
		
	}
	
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public double getPriceDef() {
		return priceDef;
	}
	public void setPriceDef(double priceDef) {
		this.priceDef = priceDef;
	}
	
	
	
}
