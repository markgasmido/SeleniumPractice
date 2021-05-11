package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {

	@FindBy(className =  "search_query")
	private WebElement searchBar;
	
	public void search(String search) {
		this.searchBar.click();
		this.searchBar.sendKeys(search);
		this.searchBar.submit();
	}

	public WebElement getSearchBar() {
		return searchBar;
	}
}
