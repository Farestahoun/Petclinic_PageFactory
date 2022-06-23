package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OwnersPage extends PageBase {

	public OwnersPage(WebDriver driver) {
		super(driver);
	}

	// private By tableNam = By.tagName("h2");
	private By firstrowName = By.xpath("//*[@id=\"owners\"]/tbody/tr[1]/td[1]/a");
	private By secondRowName = By.xpath("//*[@id=\"owners\"]/tbody/tr[2]/td[1]/a");

	public void checkOfAddedOwners(String expectedName) {
		String firstRowText = driver.findElement(firstrowName).getText();
		Assert.assertTrue(firstRowText.equals(expectedName));

		String secondRowText = driver.findElement(secondRowName).getText();
		Assert.assertTrue(secondRowText.equals(expectedName));
	}

	public void clickFirstRow() {
		clickButton(firstrowName);
	}

}
