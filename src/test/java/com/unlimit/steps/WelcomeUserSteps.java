package com.unlimit.steps;

import com.unlimit.pages.CommonPage;
import com.unlimit.pages.WelcomeUserPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class WelcomeUserSteps {

    private CommonPage commonPage = new CommonPage();
    private WelcomeUserPage welcomeUserPage = new WelcomeUserPage();

    @Then("^Verify welcome heading should be (.*)$")
    public void verifyH1HeadingText(String expectedWelcomeText) {
        String actualWelcomeText = commonPage.getH1Heading();
        if (expectedWelcomeText.contains("{recipient}")) {
            expectedWelcomeText = expectedWelcomeText.replace("{recipient}", "") + CreateUserSteps.recipientUserName;
        } else {
            expectedWelcomeText = expectedWelcomeText.replace("{sender}", "") + CreateUserSteps.senderUserName;
        }
        Assert.assertEquals(actualWelcomeText, expectedWelcomeText, "Welcome User Text");
    }

    @And("Click on Bill Pay link")
    public void clickOnBillPayLink() {
        welcomeUserPage.clickOnBillPayLink();
    }

    @And("Click on Logout link")
    public void clickOnLogoutLink() {
        welcomeUserPage.clickOnLogoutLink();
    }

    @And("Click on Account Overview link")
    public void clickOnAccountOverviewLink() {
        welcomeUserPage.clickOnAccountsOverviewLink();
    }
}
