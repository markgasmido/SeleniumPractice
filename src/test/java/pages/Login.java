package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	
	@FindBy(name = "username")
	private WebElement userLogin;
	
	@FindBy(name = "password")
	private WebElement userPassword;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement message;
	
	
	public void loginInfo(String username, String password) {
		userLogin.sendKeys(username);
		userPassword.sendKeys(password);
		userPassword.submit();
	}


	public WebElement getUserLogin() {
		return userLogin;
	}


	public WebElement getUserPassword() {
		return userPassword;
	}


	public WebElement getMessage() {
		return message;
	}
	
	
	
}
