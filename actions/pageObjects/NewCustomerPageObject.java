package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;
import pageUIs.NewCustomerPageUI;

public class NewCustomerPageObject extends AbstractPage{
	WebDriver driver;
	
	public NewCustomerPageObject (WebDriver driverMapping)
	{
		driver = driverMapping;
	}
	
	public boolean isNewCustomerPageDisplayed() {
		waitToElementVisible(driver, NewCustomerPageUI.NEW_CUSTOMER_TEXT);
		return isControlDisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_TEXT);
	}
	
	/*public NewAccountPageObject openNewAccountPage() {
		waitToElementVisible(driver,NewCustomerPageUI.NEW_ACCOUNT_LINK);
		clickToElement(driver,NewCustomerPageUI.NEW_ACCOUNT_LINK);
		return PageFactoryManager.getNewAccountPage(driver);
	}*/
		
	public boolean isHomePageUnDisplayed() {
		waitToElementInVisible(driver, HomePageUI.HOME_PAGE_WELCOME_MESSAGE);
		return isControlUndisplayed(driver, HomePageUI.HOME_PAGE_WELCOME_MESSAGE);
	}
	
	public boolean isAddCustomerPageUnDisplayed() {
		waitToElementInVisible(driver, NewCustomerPageUI.CUSTOMER_FORM);
		return isControlUndisplayed(driver, NewCustomerPageUI.CUSTOMER_FORM);
	}
	
}
