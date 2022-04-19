package example.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * The Class represents ProductsPage.
 *
 * @author Anil
 */
public class ProductsPage extends BasePage {

	/** The Products feature */
	@FindBy(xpath = "//span[contains(text(),'Products')]")
	public WebElement productsMenu;

	@FindBy(xpath = "//a[@data-menu-xmlid=\"stock.menu_product_variant_config_stock\"]")
	public WebElement productsMenuItem;

	@FindBy(xpath = "//button[@title='Create record']")
	public WebElement createRecordElement;

	@FindBy(xpath = "//button[@title='Save record']")
	public WebElement saveRecordElement;

	@FindBy(xpath = "//input[@name='name']")
	public WebElement productNameElement;

	@FindBy(xpath = "//button[@title='Edit record']")
	public WebElement editRecordElement;

	@FindBy(xpath = "//a[@title='Home menu']")
	public WebElement applicationIcon;

	/**
	 * Instantiates a new aspire app login page.
	 *
	 * @param driver the driver
	 */
	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	public void setProductName(String productName){
		productNameElement.sendKeys(productName);
		saveRecordElement.click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Edit record']")));
		Assert.assertTrue(editRecordElement.isDisplayed());
	}

}
