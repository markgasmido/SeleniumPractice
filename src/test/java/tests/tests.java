package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Home;
import pages.Landing;

public class tests {
	
	
	private WebDriver driver;
	
	private static final String URL = "http://automationpractice.com/index.php";
	
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1360, 789));
	}

//	@After
//	public void tearDown() {
//		driver.close();
//	}
	
	@Test // misread the scenario and the test was just if anything was found rather than any particular dress was found
	public void scenarioTest() {
		driver.get(URL);
		Home homePage = PageFactory.initElements(driver, Home.class);
		Landing landingPage = PageFactory.initElements(driver,Landing.class);
		
		String search = "dress";
		
		homePage.search(search);
		landingPage.getItemsFound();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.textToBePresentInElement(landingPage.getItemsFound(), "Showing 1 - 7 of 7 items"));
		assertTrue(driver.getPageSource().contains("Showing 1 - 7 of 7 items"));
	}
}
