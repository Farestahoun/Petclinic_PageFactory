package tests;

import org.testng.annotations.Test;

import pages.AddNewPetPage;
import pages.AddOwnersPage;
import pages.EditPetPage;
import pages.FindOwnersPage;
import pages.HomePage;
import pages.OwnerInformationPage;

public class EditPetTest extends TestBase {

	@Test
	public void userCanEditPet() {
		long executionTime = System.currentTimeMillis();
		HomePage homeObject = new HomePage(driver);
		homeObject.openFindOwnersPage();
		FindOwnersPage findOwnerObject = new FindOwnersPage(driver);
		findOwnerObject.openAddOwnerPage();
		AddOwnersPage addOwnerObject = new AddOwnersPage(driver);
		addOwnerObject.setOwnerData("Khaled", "Saiad" + executionTime, "darmStr", "Darmstadt", "25343543");
		// check adding owner in OnwerInformation
		OwnerInformationPage ownerInformationObject = new OwnerInformationPage(driver);
		ownerInformationObject.checkOwnerInformation("Khaled", "Saiad" + executionTime, "darmStr", "Darmstadt",
				"25343543");
		// Serach for omwer and check results
		homeObject.openFindOwnersPage();
		findOwnerObject.searchForOwner("Saiad" + executionTime);
		findOwnerObject.clickFindOwnerButton();
		ownerInformationObject.checkOwnerInformation("Khaled", "Saiad" + executionTime, "darmStr", "Darmstadt",
				"25343543");
		// Click new Pet button
		ownerInformationObject.clickaddNewPetBtN();
		// Filling Data of adding
		AddNewPetPage newPetObject = new AddNewPetPage(driver);
		newPetObject.addPet("cristina", "1970-12-11", "cat");
		// Check Added Pet
		ownerInformationObject.checkPetInfos("cristina", "1970-12-11", "cat");
		// click edit pet button
		ownerInformationObject.clickEditPetBtN();
		// edit pet
		EditPetPage editPetObject = new EditPetPage(driver);
		editPetObject.EditPet("Mahitar", "1960-10-10", "cat");
		// check edited infos
		ownerInformationObject.checkPetInfos("Mahitar", "1960-10-10", "cat");
	}
}
