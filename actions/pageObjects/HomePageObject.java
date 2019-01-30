package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage{
	WebDriver driver;
	
	public HomePageObject (WebDriver driverMapping)
	{
		driver = driverMapping;
	}
	
	public boolean isHomePageDisplayed() {
		waitToElementVisible(driver, HomePageUI.HOME_PAGE_WELCOME_MESSAGE);
		return isControlDisplayed(driver, HomePageUI.HOME_PAGE_WELCOME_MESSAGE);
	}
		
}
