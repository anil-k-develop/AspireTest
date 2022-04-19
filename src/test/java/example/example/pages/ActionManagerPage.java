package example.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The Class represents ActionManagerPage.
 *
 * @author Anil
 */
public class ActionManagerPage extends BasePage {

	@FindBy(xpath = "//a[@data-menu-xmlid='stock.menu_stock_root']")
	public WebElement inventoryFeature;

	@FindBy(xpath = "//a[@data-menu-xmlid='mrp.menu_mrp_root']")
	public WebElement manufacturingFeature;

	public ActionManagerPage(WebDriver driver) {
		super(driver);
	}

}
