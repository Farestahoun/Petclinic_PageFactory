package pages;

import org.openqa.selenium.By;

//import java.security.PublicKey;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class OwnerInformationPage extends PageBase {

	public OwnerInformationPage(WebDriver driver) {
		super(driver);
	}

	public By ownerNameThatIsSerachFor = By.xpath("//table/tbody/tr/td/b");

	// Elements of Owner Information Table
	private By nameRow = By.xpath("//table[1]/tbody/tr[1]/td[1]");
	private By adressRoW = By.xpath("//table/tbody/tr[2]/td[1]");
	private By cityRow = By.xpath("//table/tbody/tr[3]/td[1]");
	private By telephoneRow = By.xpath("//table/tbody/tr[4]/td[1]");

	// Elements of Edit Owner and Add new Pet BtN
	private By editOwnerButton = By.xpath("//a[@class='btn btn-default'][1]");
	private By addNewPetBtN = By.xpath("//a[@class='btn btn-default'][2]");
	private By editPetBtN = By.xpath("//table[2][@class='table table-striped']/tbody/tr/td[2]/table/tbody/tr/td[1]/a");
	private By addVisitBtN = By.xpath("//table[2][@class='table table-striped']/tbody/tr/td[2]/table/tbody/tr/td[2]/a");

	// Elemnts of Pets Table
	private By AddedPetName = By.xpath("//table[2][@class='table table-striped']/tbody/tr/td[1]/dl/dd[1]");
	private By addedBirthDate = By.xpath("//table[2][@class='table table-striped']/tbody/tr/td[1]/dl/dd[2]");
	private By addedType = By.xpath("//table[2][@class='table table-striped']/tbody/tr/td[1]/dl/dd[3]");

	// Elements of Visit Table
	private By addedVisitDate = By.xpath("//table[@class='table-condensed']/tbody/tr[1]/td[1]");
	private By addedDesciption = By.xpath("//table[@class='table-condensed']/tbody/tr[1]/td[2]");

	// Method to assert thta details of the added owner added correctly and in
	// right position
	public void checkOwnerInformation(String firstName, String lastName, String addedAdress, String addedCity,
			String addedTelephone) {
		SoftAssert soft = new SoftAssert();
		String nameText = driver.findElement(nameRow).getText();
		soft.assertEquals(nameText, firstName + " " + lastName);
		String adressText = driver.findElement(adressRoW).getText();
		soft.assertEquals(adressText, addedAdress);
		String cityText = driver.findElement(cityRow).getText();
		soft.assertEquals(cityText, addedCity);
		String telephoneText = driver.findElement(telephoneRow).getText();
		Assert.assertEquals(telephoneText, addedTelephone);
	}

	public void hardAssertForSearchingForAlreadyAddedOwner(String addedOwnerSearchFor)

	{
		String searchedOwnerText = driver.findElement(ownerNameThatIsSerachFor).getText();
		Assert.assertTrue(searchedOwnerText.contains(addedOwnerSearchFor));
	}

	public void clickEditOwnerButton() {
		clickButton(editOwnerButton);
	}

	public void clickaddNewPetBtN() {
		clickButton(addNewPetBtN);
	}

	// Methods for checking adding Pet infos
	public void checkPetInfos(String expectedName, String expectedBirthDate, String expectedType) {
		String atcualName = driver.findElement(AddedPetName).getText();
		Assert.assertEquals(atcualName, expectedName);
		String actualBirthDate = driver.findElement(addedBirthDate).getText();
		Assert.assertEquals(actualBirthDate, expectedBirthDate);
		String actualType = driver.findElement(addedType).getText();
		Assert.assertEquals(actualType, expectedType);
	}

	// click on Editpet BtN
	public void clickEditPetBtN() {
		clickButton(editPetBtN);
	}

	// Click on Addvisit BtN
	public void clickAddVisitBtN() {
		clickButton(addVisitBtN);
	}

	//
	public void checkVisitInfo(String expectedDate, String expectedDescription) {
		String atcualName = driver.findElement(addedVisitDate).getText();
		Assert.assertEquals(atcualName, expectedDate);
		String actualDescription = driver.findElement(addedDesciption).getText();
		Assert.assertEquals(actualDescription, expectedDescription);
	}
}
