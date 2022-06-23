package tests;

import org.testng.annotations.Test;

import pages.AddOwnersPage;
import pages.EditOwnerPage;
import pages.FindOwnersPage;
import pages.HomePage;
import pages.OwnerInformationPage;

public class EditOwnerTest extends TestBase {

	@Test

	public void userCanEditOwner() {
		long executionTime = System.currentTimeMillis();
		HomePage homeObject = new HomePage(driver);
		homeObject.openFindOwnersPage();
		FindOwnersPage findOwnerObject = new FindOwnersPage(driver);
		findOwnerObject.openAddOwnerPage();
		AddOwnersPage addOwnerObject = new AddOwnersPage(driver);
		addOwnerObject.setOwnerData("Gaber", "Hager" + executionTime, "Nahriaaa", "Tantaaa", "01234239");
		// check adding in OnwerInformation
		OwnerInformationPage ownerInformationObject = new OwnerInformationPage(driver);
		ownerInformationObject.checkOwnerInformation("Gaber", "Hager" + executionTime, "Nahriaaa", "Tantaaa",
				"01234239");
		// Edit Owner
		ownerInformationObject.clickEditOwnerButton();
		EditOwnerPage editOwnerObject = new EditOwnerPage(driver);
		editOwnerObject.editOwner("Margerin", "Hegrin" + executionTime, "kölnstrasse", "köln", "457432");
		// Check Editing In OwnerInformation
		ownerInformationObject.checkOwnerInformation("Margerin", "Hegrin" + executionTime, "kölnstrasse", "köln",
				"457432");
		// Search for edited Owner
		homeObject.openFindOwnersPage();
		findOwnerObject.searchForOwner("Hegrin" + executionTime);
		findOwnerObject.clickFindOwnerButton();
		ownerInformationObject.checkOwnerInformation("Margerin", "Hegrin" + executionTime, "kölnstrasse", "köln",
				"457432");
	}
}
