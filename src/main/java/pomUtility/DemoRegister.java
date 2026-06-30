package pomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoRegister {
	
	//Page Object Model (POM) it is a design pattern used in automation
	
	//Declare
	@FindBy(id="name")
	private WebElement name;
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath = "//button[contains(text(), 'Register')]")
	private WebElement button;
	
	//Initialize
	
	public DemoRegister(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//Utilize
	
	/*
	public WebElement getName() {
		return name;
	}
	
	public WebElement getEmail() {
		return email;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getButton() {
		return button;
	}
	*/
	
	//optimizing the getter methods
	
	public void getName(String nameInput) {
		 name.sendKeys(nameInput);
	}
	
	public void getEmail(String emailInput) {
		email.sendKeys(emailInput);
	}
	
	public void getPassword(String passwordInput) {
		password.sendKeys(passwordInput);
	}
	
	public void getButton() {
		button.click();
	}
	
	//Business logic
	public void registerTest(String nameInput, String emailInput, String passwordInput) {
		name.sendKeys(nameInput);
		email.sendKeys(emailInput);
		password.sendKeys(passwordInput);
		button.click();
	}
	
	
	
	
	
	
	

}
