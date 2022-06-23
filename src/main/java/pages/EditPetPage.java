package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditPetPage extends PageBase {

	public EditPetPage(WebDriver driver) {
		super(driver);
	}

	private By nameTxtBox = By.id("name");
	private By birthDateTxtBox = By.id("birthDate");
	private By dropDownList = By.id("type");
	private By updatePetBtN = By.xpath("//button[@type='submit' and @class='btn btn-default' ]");

	public void EditPet(String name, String birthDate, String type) {
		clearText(nameTxtBox);
		setTextElementText(nameTxtBox, name);
		clearText(birthDateTxtBox);
		setTextElementText(birthDateTxtBox, birthDate);
		selectDropDownList(dropDownList, type);
		clickButton(updatePetBtN);
	}

}
