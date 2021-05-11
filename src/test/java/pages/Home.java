package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
	
	
	@FindBy(linkText = "3. Add a User")
	private WebElement addUserButton;
	
	@FindBy(linkText = "4. Login")
	private WebElement loginButton;
	
	
	public WebElement getLoginButton() {
		return loginButton;
	}


	public WebElement getAddUserButton() {
		return addUserButton;
	}
	
	
	
	
	

	
}
