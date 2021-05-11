package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Landing {
	
	@FindBy(className = "product-count")
	private WebElement itemsFound;

	public WebElement getItemsFound() {
		return itemsFound;
	}
	
	
}
