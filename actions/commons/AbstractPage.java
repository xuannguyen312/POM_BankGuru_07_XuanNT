
package commons;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.DepositPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageUIs.AbstractPageUI;
import pageUIs.HomePageUI;
import pageUIs.NewAccountPageUI;
import pageUIs.NewCustomerPageUI;

public class AbstractPage {
	
	/*WEB BROWSER*/
	
	public void openUrl(WebDriver driver, String ulr) {
		//Tham số WebDriver trong hàm là bắt buộc
		// Hàm này có cần thêm tham số gì không?
		// Hàm này có trả về gì không/trả về kiểu dl gì?
		// Nếu hàm không có kiểu dl trả về thì viết là "public void"
		// Nếu hàm có kiểu dk trả về thì hàm đó phải viết là "public" + "kiểu dl trả về"
		driver.get(ulr);
	}
	
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();	
	}
	
	
	// Cách dùng hàm getCurrentUlr
	// loginPageUrl = getCurrentUrl(driver);

	public int countElement(WebDriver driver, String locator) {
		List <WebElement> elements = driver.findElements(By.xpath(locator));
	    return elements.size();
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void back(WebDriver driver)
	{
		driver.navigate().back();
	}
	
	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void senkeyAlert(WebDriver driver, String keys) {
		driver.switchTo().alert().sendKeys(keys);
	}
	
	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	/*WEB ELEMENT*/
	
	public void clickToElement(WebDriver driver, String locator)
	{
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}
	
	//Cách dùng hàm click
	// clickToElement(driver, "//button[@id='login']");
	
	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);	
	}
	
	public boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}
	
	public String getText(WebDriver driver, String  locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}
	
	public void waitToElementVisible(WebDriver driver, String locator) {
		By byLocator = By.xpath(locator);
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}
	
	public NewAccountPageObject openNewAccountPage(WebDriver driver) {
		waitToElementVisible(driver,AbstractPageUI.NEW_ACCOUNT_LINK);
		clickToElement(driver,AbstractPageUI.NEW_ACCOUNT_LINK);
		return PageFactoryManager.getNewAccountPage(driver);
	}
	
	public NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
		waitToElementVisible(driver,AbstractPageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver,AbstractPageUI.NEW_CUSTOMER_LINK);
		return PageFactoryManager.getNewCustomerPage(driver);
	}
	
	public DepositPageObject openDepositPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.DEPOSIT_LINK);
		clickToElement(driver,AbstractPageUI.DEPOSIT_LINK);
		return PageFactoryManager.getDepositPage(driver);
	}
}
