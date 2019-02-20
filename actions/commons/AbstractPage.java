
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
	
	// Dùng trong trường hợp Locator cố định
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
	
	
	// Dùng trong trường hợp locator cố định
	public boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}
	
	
	public String getText(WebDriver driver, String  locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}
	
	// Dùng trong trường hợp locator cố định
	public void waitToElementVisible(WebDriver driver, String locator) {
		By byLocator = By.xpath(locator);
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}
	
	
	// Liệt Kê Tất Cả Các Hàm Chuyển Trang 
	
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
	
	// Hàm Chuyển Trang Được Áp Dụng Phương Pháp Dynamic Locator
	// Đây là hàm chuyển trang nhưng chỉ được áp dụng cho Web có vài chục trang
	public AbstractPage openDynamicPage(WebDriver driver, String pageName) {
		waitToElementVisible(driver,AbstractPageUI.DYNAMIC_LINK, pageName);
		//Nên viết thêm Hàm Wait có 3 tham số để tương ứng
		clickToElement(driver,AbstractPageUI.DYNAMIC_LINK, pageName);
		//Nên viết thêm Hàm Click có 3 tham số để tương ứng
		
		switch(pageName) {
		case "Deposit":
			return PageFactoryManager.getDepositPage(driver);
		case "New Account":
			return PageFactoryManager.getNewAccountPage(driver);
		case "New Customer":
			return PageFactoryManager.getNewCustomerPage(driver);
		default:
			return PageFactoryManager.getHomePage(driver);
		}	
	}
	
	
	
	// Đây là hàm chuyển trang có thể được áp dụng cho Web có trăm ngàn trang
		public void openDynamicMorePage(WebDriver driver, String pageName) 
		{
			waitToElementVisible(driver,AbstractPageUI.DYNAMIC_LINK, pageName);
			clickToElement(driver,AbstractPageUI.DYNAMIC_LINK, pageName);
		}
		
		
	
	// Đây là hàm Wait có 3 tham số
	// Dùng trong trường hợp Locator động
	public void waitToElementVisible(WebDriver driver, String locator, String... dynamicValue) {
		locator = String.format(locator, (Object[]) dynamicValue);
		// Ví dụ ta truyền vào waitToElementVisible (driver, "//a[text()='%s']", "New Customer");
		// Phân bổ tương ứng sẽ là locator = String.format("//a[text()='%s']", "New Customer");
		// Suy ra locator mới sẽ là locator = "//a[text()='New Customer']"; 
		System.out.println("Wait For Dynamic Locator:" + locator);
		By byLocator = By.xpath(locator);
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}
	
	// Đây là hàm Click có 3 tham số
	// Dùng trong trường hợp Locator động
	public void clickToElement(WebDriver driver, String locator, String... dynamicValue)
	{
		locator = String.format(locator, (Object[]) dynamicValue);
		System.out.println("Click on Dynamic Locator:" + locator);
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}
	
	// Đây là hàm isDisplay có 3 tham số
	// Dùng trong trường hợp Locator động
	public boolean isControlDisplayed(WebDriver driver, String locator, String... dynamicValue) {
		locator = String.format(locator, (Object[]) dynamicValue);
		System.out.println("Check Dynamic Locator display:" + locator);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}
	
}
