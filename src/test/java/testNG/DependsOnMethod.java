package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;


public class DependsOnMethod {
	
	@Test
	public void addToCart() {
		Reporter.log("Add to cart", true);
	}
	
	@Test(dependsOnMethods = "addToCart")
	public void deleteProductFromCart() {
		Reporter.log("Delete from cart", true);
	}
	

}
