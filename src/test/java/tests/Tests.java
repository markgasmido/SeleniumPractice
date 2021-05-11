package tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AddAUser;
import pages.Home;
import pages.Login;

public class Tests {

	private WebDriver driver;
	
	private static final String URL = "http://thedemosite.co.uk/";
	
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1360, 789));
	}

	@After
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void scenarioTest() {
		driver.get(URL + "index.php");
		Home homePage = PageFactory.initElements(driver, Home.class);
		AddAUser userPage = PageFactory.initElements(driver, AddAUser.class);
		Login loginPage = PageFactory.initElements(driver, Login.class);
		
		String username = "test";
		String password = "test";
		
		homePage.getAddUserButton().click();
		userPage.createUser(username, password);
		homePage.getLoginButton().click();
		
		loginPage.loginInfo(username, password);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.textToBePresentInElement(loginPage.getMessage(), "Success"));
		
		assertTrue(driver.getPageSource().contains("**Successful Login**"));
	}
	
	
	

}
