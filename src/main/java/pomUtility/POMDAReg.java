package pomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMDAReg {
	
	@FindBy(xpath="//h1[text()='Register']")
	private WebElement header; 
	
	@FindBy(name="name")
	private WebElement nameTF;
	
	@FindBy(name="email")
	private WebElement emailTF;
	
	@FindBy(name="password")
	private WebElement passwordTF;
	
	@FindBy(xpath="//button[text()='Register']")
	private WebElement registerbtn;
	
	public POMDAReg(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
	
	public String getHeader() {
		return header.getText();
	}
	
	public void getNameTF(String name){
		nameTF.sendKeys(name);
	}
	
	public void getEmailTF(String email) {
		emailTF.sendKeys(email);
	}
	
	public void getPasswordTF(String password) {
		passwordTF.sendKeys(password);
	}
	
	public void getRegisterBtn(){
		registerbtn.click();
	}
	
	public void Register(String name, String email, String password) {
		nameTF.sendKeys(name);
		emailTF.sendKeys(email);
		passwordTF.sendKeys(password);
		registerbtn.click();
	}
}
