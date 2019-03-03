package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;
import pageUIs.NewCustomerPageUI;

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
	
	/*public NewCustomerPageObject openNewCustomerPage() {
		waitToElementVisible(driver,HomePageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver,HomePageUI.NEW_CUSTOMER_LINK);
		return PageFactoryManager.getNewCustomerPage(driver);
	}*/
	
	public boolean isNewCustomerPageUnDisplayed() {
		waitToElementInVisible(driver, NewCustomerPageUI.NEW_CUSTOMER_TEXT);
		return isControlUndisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_TEXT);
	}
	
	
	
		
}
