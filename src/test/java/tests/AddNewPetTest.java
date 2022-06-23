package tests;

import org.testng.annotations.Test;

import pages.AddNewPetPage;
import pages.AddOwnersPage;
import pages.FindOwnersPage;
import pages.HomePage;
import pages.OwnerInformationPage;

public class AddNewPetTest extends TestBase {

	// validate that user can add unique pet with valid Name and BirthDate
	@Test
	public void validAddUniquePetTest_ValidNameValidBirthD() {

		long executionTime = System.currentTimeMillis();
		HomePage homeObject = new HomePage(driver);
		homeObject.openFindOwnersPage();
		FindOwnersPage findOwnerObject = new FindOwnersPage(driver);
		findOwnerObject.openAddOwnerPage();
		AddOwnersPage addOwnerObject = new AddOwnersPage(driver);
		addOwnerObject.setOwnerData("Maher", "Mohamed" + executionTime, "Baustr", "dortmund", "65839396");
		// check date in OnwerInformation
		OwnerInformationPage ownerInformationObject = new OwnerInformationPage(driver);
		ownerInformationObject.checkOwnerInformation("Maher", "Mohamed" + executionTime, "Baustr", "dortmund",
				"65839396");
		// Search for it and check search result
		homeObject.openFindOwnersPage();
		findOwnerObject.searchForOwner("Mohamed" + executionTime);
		findOwnerObject.clickFindOwnerButton();
		ownerInformationObject.checkOwnerInformation("Maher", "Mohamed" + executionTime, "Baustr", "dortmund",
				"65839396");
		// Click new Pet
		ownerInformationObject.clickaddNewPetBtN();
		// Filling Data of adding
		AddNewPetPage newPetObject = new AddNewPetPage(driver);
		newPetObject.addPet("Marwan", "1980-11-10", "cat");
		// Check Added Pet
		ownerInformationObject.checkPetInfos("Marwan", "1980-11-10", "cat");
	}

	// Validate that user cannot add new Pet in case that all fields are blank
	@Test
	public void invalidAddUniquePetTest_NameBirthDateEmpty() {
		long executionTime = System.currentTimeMillis();
		HomePage homeObject = new HomePage(driver);
		homeObject.openFindOwnersPage();
		FindOwnersPage findOwnerObject = new FindOwnersPage(driver);
		findOwnerObject.openAddOwnerPage();
		AddOwnersPage addOwnerObject = new AddOwnersPage(driver);
		addOwnerObject.setOwnerData("Hamda", "Ibrahim" + executionTime, "Tahounstr", "omarnia", "5637347");
		// check adding in OnwerInformation
		OwnerInformationPage ownerInformationObject = new OwnerInformationPage(driver);
		ownerInformationObject.checkOwnerInformation("Hamda", "Ibrahim" + executionTime, "Tahounstr", "omarnia",
				"5637347");
		// Search for it and check search result
		homeObject.openFindOwnersPage();
		findOwnerObject.searchForOwner("Ibrahim" + executionTime);
		findOwnerObject.clickFindOwnerButton();
		ownerInformationObject.checkOwnerInformation("Hamda", "Ibrahim" + executionTime, "Tahounstr", "omarnia",
				"5637347");
		// Click new Pet
		ownerInformationObject.clickaddNewPetBtN();
		// Leave all Fields blank
		AddNewPetPage newPetObject = new AddNewPetPage(driver);
		newPetObject.addPet("", "", "bird");
		// Check Error messages in the two fields
		newPetObject.checkErrorMsgs("is required", "is required");
	}

	@Test
	// Validate that user cannot add pet in case that dateformat isnot correct
	public void invalidAddUniquePetTest_ValidNameInvalidDateFormat() {
		long executionTime = System.currentTimeMillis();
		HomePage homeObject = new HomePage(driver);
		homeObject.openFindOwnersPage();
		FindOwnersPage findOwnerObject = new FindOwnersPage(driver);
		findOwnerObject.openAddOwnerPage();
		AddOwnersPage addOwnerObject = new AddOwnersPage(driver);
		addOwnerObject.setOwnerData("Huda", "Shich" + executionTime, "ShichStr", "Bamberg", "64577875");
		// check adding in OnwerInformation
		OwnerInformationPage ownerInformationObject = new OwnerInformationPage(driver);
		ownerInformationObject.checkOwnerInformation("Huda", "Shich" + executionTime, "ShichStr", "Bamberg",
				"64577875");
		// Search for it and check search result
		homeObject.openFindOwnersPage();
		findOwnerObject.searchForOwner("Shich" + executionTime);
		findOwnerObject.clickFindOwnerButton();
		ownerInformationObject.checkOwnerInformation("Huda", "Shich" + executionTime, "ShichStr", "Bamberg",
				"64577875");
		// Click new Pet
		ownerInformationObject.clickaddNewPetBtN();
		// Fill fields but date with wrong format
		AddNewPetPage newPetObject = new AddNewPetPage(driver);
		newPetObject.addPet("saber", "gedgregreger", "bird");
		// Check
		newPetObject.checkErrorMsgs(null, null);

	}
}
