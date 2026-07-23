package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUse {
	
	@DataProvider
	public Object[][] data(){
		Object[][] obj = new Object[3][2];
		
		obj[0][0] = "user1";
		obj[0][1] = "pass1";
		obj[1][0] = "user2";
		obj[1][1] = "pass2";
		obj[2][0] = "user3";
		obj[2][1] = "pass3";
	
		return obj;
	}
	
	
	@Test(dataProvider = "data")
	public void login(String name, String password) {
		System.out.println(name + " " + password);
	}
	

}
