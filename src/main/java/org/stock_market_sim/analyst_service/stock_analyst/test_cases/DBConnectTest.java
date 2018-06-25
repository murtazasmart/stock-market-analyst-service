package org.stock_market_sim.analyst_service.stock_analyst.test_cases;

import static org.junit.Assert.*;

import java.net.PasswordAuthentication;
import java.sql.ResultSet;

import org.junit.Test;
import org.stock_market_sim.analyst_service.stock_analyst.database.DBConnect;

public class DBConnectTest {

	@Test
	public void testConnect() {
		DBConnect db = new DBConnect();
		if (db.connect().equals(null)) {
			fail("not connected");
			System.out.println("not connected");
		}else {
			System.out.println("connected");
		}
		
	}

	@Test
	public void testGetResults() {
		DBConnect db = new DBConnect();
		ResultSet rs= db.getResults("select * from event_tab");
		if (rs.equals(null)) {
			fail("No result found");
		}
		
	}

	@Test
	public void testSetResult() {
		
		DBConnect db = new DBConnect();
		int res=db.setResult("INSERT INTO event_tab(event_name, type, round, entity) VALUES ('test','test', 99,'test')");
		if (res==1) {
			fail("Insert Error");
		}else {
			System.out.println("insert ok");
		}
	}

	@Test
	public void testResetDB() {
		DBConnect db = new DBConnect();
		int res=db.resetDB("", null, null);
		if (res==1) {
			fail("Insert Error");
		}else {
			System.out.println("insert ok");
		}
	}

}
