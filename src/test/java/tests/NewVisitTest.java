package tests;

import org.testng.annotations.Test;

import pages.AddNewPetPage;
import pages.AddOwnersPage;
import pages.FindOwnersPage;
import pages.HomePage;
import pages.NewVisitPage;
import pages.OwnerInformationPage;
import pages.PageBase;

public class NewVisitTest extends TestBase {

	@Test
	public void userCanAddVisit() {

		long executionTime = System.currentTimeMillis();
		HomePage homeObject = new HomePage(driver);
		homeObject.openFindOwnersPage();
		FindOwnersPage findOwnerObject = new FindOwnersPage(driver);
		findOwnerObject.openAddOwnerPage();
		AddOwnersPage addOwnerObject = new AddOwnersPage(driver);
		addOwnerObject.setOwnerData("Mahran", "Sahran" + executionTime, "berlinerstr", "bochum", "2345678");
		// check adding owner in OnwerInformation
		OwnerInformationPage ownerInformationObject = new OwnerInformationPage(driver);
		ownerInformationObject.checkOwnerInformation("Mahran", "Sahran" + executionTime, "berlinerstr", "bochum",
				"2345678");
		// Serach for omwer and check results
		homeObject.openFindOwnersPage();
		findOwnerObject.searchForOwner("Sahran" + executionTime);
		findOwnerObject.clickFindOwnerButton();
		ownerInformationObject.checkOwnerInformation("Mahran", "Sahran" + executionTime, "berlinerstr", "bochum",
				"2345678");
		// Click new Pet button
		ownerInformationObject.clickaddNewPetBtN();
		// Filling Data of adding pet
		AddNewPetPage newPetObject = new AddNewPetPage(driver);
		newPetObject.addPet("khawaga", "1950-11-11", "cat");
		// Check Added Pet
		ownerInformationObject.checkPetInfos("khawaga", "1950-11-11", "cat");
		// click Add visit button
		ownerInformationObject.clickAddVisitBtN();
		// Add visit
		NewVisitPage newVisitObject = new NewVisitPage(driver);
		newVisitObject.addVisit("Halsschmerz");
		// check infos of added visit
		PageBase pageBaseObject = new PageBase(driver);
		ownerInformationObject.checkVisitInfo(pageBaseObject.addMoreYear(1), "Halsschmerz");

	}

	// Validate that user cannot creat visit in case that description field is blank
	@Test
	public void cannotAddVisitRequiredFieldBlank() {
		long executionTime = System.currentTimeMillis();
		HomePage homeObject = new HomePage(driver);
		homeObject.openFindOwnersPage();
		FindOwnersPage findOwnerObject = new FindOwnersPage(driver);
		findOwnerObject.openAddOwnerPage();
		AddOwnersPage addOwnerObject = new AddOwnersPage(driver);
		addOwnerObject.setOwnerData("Shawal", "Ramdan" + executionTime, "berlinStr", "Wattenscheid", "5464654");
		// check adding owner in OnwerInformation
		OwnerInformationPage ownerInformationObject = new OwnerInformationPage(driver);
		ownerInformationObject.checkOwnerInformation("Shawal", "Ramdan" + executionTime, "berlinStr", "Wattenscheid",
				"5464654");
		// Serach for omwer and check results
		homeObject.openFindOwnersPage();
		findOwnerObject.searchForOwner("Ramdan" + executionTime);
		findOwnerObject.clickFindOwnerButton();
		ownerInformationObject.checkOwnerInformation("Shawal", "Ramdan" + executionTime, "berlinStr", "Wattenscheid",
				"5464654");
		// Click new Pet button
		ownerInformationObject.clickaddNewPetBtN();
		// Filling Data of adding pet
		AddNewPetPage newPetObject = new AddNewPetPage(driver);
		newPetObject.addPet("Fawzy", "1940-11-10", "cat");
		// Check Added Pet
		ownerInformationObject.checkPetInfos("Fawzy", "1940-11-10", "cat");
		// click Add visit button
		ownerInformationObject.clickAddVisitBtN();
		// Add visit while description is blank
		NewVisitPage newVisitObject = new NewVisitPage(driver);
		newVisitObject.addVisit("");
		newVisitObject.checkErrorMSgs(null, "must not be empty");
	}

	// Validate that user cannot add visit in case that date format isnot correct
	@Test
	public void cannotAddVisitDFNotCorrect() {
		long executionTime = System.currentTimeMillis();

		HomePage homeObject = new HomePage(driver);
		homeObject.openFindOwnersPage();
		FindOwnersPage findOwnerObject = new FindOwnersPage(driver);
		findOwnerObject.openAddOwnerPage();
		AddOwnersPage addOwnerObject = new AddOwnersPage(driver);
		addOwnerObject.setOwnerData("Tamer", "Kady" + executionTime, "kölnerstr", "bambenberg", "7555443");
		// check adding owner in OnwerInformation
		OwnerInformationPage ownerInformationObject = new OwnerInformationPage(driver);
		ownerInformationObject.checkOwnerInformation("Tamer", "Kady" + executionTime, "kölnerstr", "bambenberg",
				"7555443");
		// Serach for omwer and check results
		homeObject.openFindOwnersPage();
		findOwnerObject.searchForOwner("Kady" + executionTime);
		findOwnerObject.clickFindOwnerButton();
		ownerInformationObject.checkOwnerInformation("Tamer", "Kady" + executionTime, "kölnerstr", "bambenberg",
				"7555443");
		// Click new Pet button
		ownerInformationObject.clickaddNewPetBtN();
		// Filling Data of adding pet
		AddNewPetPage newPetObject = new AddNewPetPage(driver);
		newPetObject.addPet("Fawaz", "1970-11-15", "cat");
		// Check Added Pet
		ownerInformationObject.checkPetInfos("Fawaz", "1970-11-15", "cat");
		// click Add visit button
		ownerInformationObject.clickAddVisitBtN();
		// Add visit while DateFormat isnot correct
		NewVisitPage newVisitObject = new NewVisitPage(driver);

		newVisitObject.addVisitDFNotCorrect("09/30/2021", "kalt");
		newVisitObject.checkErrorMSgs(null, null);
	}
}
