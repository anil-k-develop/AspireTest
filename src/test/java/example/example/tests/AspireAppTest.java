package example.example.tests;

import example.example.factory.PageinstancesFactory;
import example.example.pages.*;
import example.example.util.TestProperties;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * The Class AspireAppTest.
 *
 * @author Anil
 */
@Test(testName = "Aspire App test", description = "Login to aspire app and validate Manufacturing order")
public class AspireAppTest extends BaseTest {

	/**
	 * Aspire App Test.
	 */

	@Test
	public void aspireAppLoginTest() throws InterruptedException {
		AspireAppLoginPage aspireLoginPage = PageinstancesFactory.getInstance(AspireAppLoginPage.class);
		aspireLoginPage.enterEmail(TestProperties.getProperty("email"));
		aspireLoginPage.enterPassword(TestProperties.getProperty("password"));
		aspireLoginPage.clickSignIn();
		ActionManagerPage actionManagerPage = PageinstancesFactory.getInstance(ActionManagerPage.class);
		Assert.assertTrue(isElementPresent(actionManagerPage.inventoryFeature));
		clickElement(actionManagerPage.inventoryFeature);
		ProductsPage productsPage = PageinstancesFactory.getInstance(ProductsPage.class);
		Assert.assertTrue(isElementPresent(productsPage.productsMenu));
		clickElement(productsPage.productsMenu);
		Assert.assertTrue(isElementPresent(productsPage.productsMenuItem));
		clickElement(productsPage.productsMenuItem);
		clickElement(productsPage.createRecordElement);
		Assert.assertTrue(isElementPresent(productsPage.saveRecordElement));
		String productName = RandomStringUtils.randomAlphanumeric(5).toUpperCase();
		productsPage.setProductName(productName);
		clickElement(productsPage.applicationIcon);
		Assert.assertTrue(isElementPresent(actionManagerPage.manufacturingFeature));
		clickElement(actionManagerPage.manufacturingFeature);
		ManufacturingOrdersPage manufacturingOrdersPage = PageinstancesFactory.getInstance(ManufacturingOrdersPage.class);
		Assert.assertTrue(isElementPresent(manufacturingOrdersPage.manufacturingOrdersText));
		clickElement(manufacturingOrdersPage.manufacturingOrdersCreateButton);
		Thread.sleep(2000);
		Assert.assertTrue(isElementPresent(manufacturingOrdersPage.manufacturingOrdersSaveRecordButton));
		manufacturingOrdersPage.setProductName(productName);
		Thread.sleep(2000);
		clickElement(manufacturingOrdersPage.confirmOrder);
		Thread.sleep(3000);
		Assert.assertTrue(isElementPresent(manufacturingOrdersPage.markAsDone));
		clickElement(manufacturingOrdersPage.markAsDone);
		Assert.assertTrue(isElementPresent(manufacturingOrdersPage.confirmationOk));
		clickElement(manufacturingOrdersPage.confirmationOk);
		Assert.assertTrue(isElementPresent(manufacturingOrdersPage.confirmationApply));
		clickElement(manufacturingOrdersPage.confirmationApply);
		Assert.assertTrue(isElementPresent(manufacturingOrdersPage.currentStatusDone));
		String actualProductName = manufacturingOrdersPage.createdProductName.getText();
		Assert.assertEquals(productName, actualProductName);

	}
}
