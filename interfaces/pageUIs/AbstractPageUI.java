package pageUIs;

public class AbstractPageUI {
	//Tập hợp tất cả các locator của tất cả element trong Menu để dùng cho việc chuyển 
	//trang
	public static final String NEW_CUSTOMER_LINK = "//a[text()='New Customer']";
	public static final String DEPOSIT_LINK="//a[text()='Deposit']";
	public static final String NEW_ACCOUNT_LINK = "//a[text()='New Account']";
	
	// Áp Dụng Dynamic Locator 
	public static final String DYNAMIC_LINK = "//a[text()='%s']";
}
