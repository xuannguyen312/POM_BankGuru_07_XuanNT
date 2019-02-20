package com.bankguru.demo;

public class DynamicLocator {

	public static void main(String[] args) {
		String NEW_ACCOUNT_LINK = "//a[text()='New Account']";
		String DEPOSIT_LINK = "//a[text()='Deposit']";
		String NEW_CUSTOMER_LINK = "//a[text()='New Customer']";
		String HOMEPAGE_LINK = "//a[text()='Manager']";
		String DYNAMIC_LINK_1_PARAM = "//a[text()='%s']";
		String DYNAMIC_LINK_2_PARAM = "//a[text()='%s']//a[text()='%s']";
		String DYNAMIC_LINK_3_PARAM = "//a[text()='%s']//a[text()='%s']//a[text()='%s']";
		String DYNAMIC_EDIT_TABLE = "//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-edit-row-btn']";
		String DYNAMIC_DELETE_TABLE = "//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-remove-row-btn']";

		clickToElement(NEW_CUSTOMER_LINK);
		//clickToElement(NEW_ACCOUNT_LINK);
		//clickToElement(DEPOSIT_LINK);
		//clickToElement(HOMEPAGE_LINK);

		clickToElement(DYNAMIC_LINK_1_PARAM, "New Account");
		//clickToElement(DYNAMIC_LINK_1_PARAM, "New Customer");
		//clickToElement(DYNAMIC_LINK_1_PARAM, "Manager");
		//clickToElement(DYNAMIC_LINK_1_PARAM, "Deposit");
		
		clickToElement(DYNAMIC_LINK_2_PARAM, "Female", "Afghanistan");
		clickToElement(DYNAMIC_LINK_2_PARAM, "Male", "Albania");
		
		clickToElement(DYNAMIC_LINK_3_PARAM, "Female", "Afghanistan", "Male");
		clickToElement(DYNAMIC_LINK_3_PARAM, "Male", "Albania", "Female");
		
		clickToElement(DYNAMIC_DELETE_TABLE, "12253515", "AFRICA", "12599691");
		clickToElement(DYNAMIC_DELETE_TABLE, "384187", "Afghanistan", "407124");
		
		clickToElement(DYNAMIC_EDIT_TABLE, "12253515", "AFRICA", "12599691");
		clickToElement(DYNAMIC_EDIT_TABLE, "384187", "Afghanistan", "407124");
	}

	public static void clickToElement(String pageName) {
		System.out.println(pageName);
	}

	public static void clickToElement(String pageName, String dynamicValue) {
		System.out.println(String.format(pageName, dynamicValue));
	}
	
	public static void clickToElement(String pageName, String dynamicValue_01, String dynamicValue_02) {
		System.out.println(String.format(pageName, dynamicValue_01, dynamicValue_02));
	}
	
	public static void clickToElement(String pageName, String dynamicValue_01, String dynamicValue_02, String dynamicValue_03) {
		System.out.println(String.format(pageName, dynamicValue_01, dynamicValue_02, dynamicValue_03));
	}
	
	public static void clickToElement(String locator, String... dynamicValue) {
		System.out.println("Click to Element: " + String.format(locator, (Object[]) dynamicValue));
	}

}
