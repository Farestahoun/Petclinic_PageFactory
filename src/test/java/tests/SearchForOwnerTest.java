package tests;

import org.testng.annotations.Test;

import pages.AddOwnersPage;
import pages.FindOwnersPage;
import pages.HomePage;
import pages.OwnerInformationPage;
import pages.OwnersPage;

public class SearchForOwnerTest extends TestBase {

	// Validate that user can search for unique added owner successfully
	@Test
	public void testUniqueOwner() {
		long time = System.currentTimeMillis();
		HomePage homeObject = new HomePage(driver);
		homeObject.openFindOwnersPage();
		FindOwnersPage findOwnerObject = new FindOwnersPage(driver);
		findOwnerObject.openAddOwnerPage();
		AddOwnersPage addOwnerObject = new AddOwnersPage(driver);
		addOwnerObject.setOwnerData("Michaelk12", ("Timpek345" + time), "frfr", "Tanta", "01272564239");
		OwnerInformationPage ownerInformationObject = new OwnerInformationPage(driver);
		ownerInformationObject.checkOwnerInformation("Michaelk12", "Timpek345" + time, "frfr", "Tanta", "01272564239");
		homeObject.openFindOwnersPage();
		findOwnerObject.searchForOwner("Timpek345" + time);
		findOwnerObject.clickFindOwnerButton();
		ownerInformationObject.checkOwnerInformation("Michaelk12", "Timpek345" + time, "frfr", "Tanta", "01272564239");
	}

	// Validate that user can search for Nonunique added owner successfully
	@Test
	public void testNonUniqueOwner() throws InterruptedException {
		FindOwnersPage findOwnerObject = new FindOwnersPage(driver);
		AddOwnersPage addOwnerObject = new AddOwnersPage(driver);
		HomePage homeObject = new HomePage(driver);
		OwnersPage ownersObject = new OwnersPage(driver);
		homeObject.openFindOwnersPage();
		for (int i = 0; i < 2; i++) {
			homeObject.openFindOwnersPage();
			findOwnerObject.openAddOwnerPage();
			addOwnerObject.setOwnerData("hamber", "shamber", "khanger", "banger", "0127284239");
		}
		OwnerInformationPage ownerInformationObject = new OwnerInformationPage(driver);
		ownerInformationObject.checkOwnerInformation("hamber", "shamber", "khanger", "banger", "0127284239");
		homeObject.openFindOwnersPage();
		findOwnerObject.searchForOwner("shamber");
		findOwnerObject.clickFindOwnerButton();
		ownersObject.checkOfAddedOwners("hamber shamber");
		ownersObject.checkOfAddedOwners("hamber shamber");
		ownersObject.clickFirstRow();
		// clickMethod(ownersObject.firstrowName);
		ownerInformationObject.checkOwnerInformation("hamber", "shamber", "khanger", "banger", "0127284239");
	}

	// Validate that no results displays and error message display in case that user
	// search for not present user
	@Test
	public void userCannotSearchForNotPresentOwner() {
		HomePage homeObject = new HomePage(driver);
		homeObject.openFindOwnersPage();
		FindOwnersPage findOwnerObject = new FindOwnersPage(driver);
		findOwnerObject.searchForOwner("Am56437458yg5");
		findOwnerObject.clickFindOwnerButton();
		findOwnerObject.checkSearchErrorMsg("has not been found");
	}

}
