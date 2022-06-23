package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	private By findOwners = By.xpath("//span[contains(text(),'Find owners')]");

	public FindOwnersPage openFindOwnersPage() {
		clickButton(findOwners);
		return new FindOwnersPage(driver);
	}

}
