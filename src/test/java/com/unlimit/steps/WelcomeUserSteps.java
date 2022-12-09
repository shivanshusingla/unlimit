package com.unlimit.steps;

import com.unlimit.pages.CommonPage;
import com.unlimit.pages.WelcomeUserPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class WelcomeUserSteps {

    private CommonPage commonPage = new CommonPage();
    private WelcomeUserPage welcomeUserPage = new WelcomeUserPage();

    @Then("^Verify h1 heading text should be (.*)$")
    public void verifyH1HeadingText(String expectedWelcomeText) {
        String actualWelcomeText = commonPage.getH1Heading();
        expectedWelcomeText = expectedWelcomeText.replace("{}", "") + CreateUserSteps.senderUserName;
        Assert.assertEquals(actualWelcomeText, expectedWelcomeText, "Welcome User Text");
    }

    @And("Click on Bill Pay link")
    public void clickOnBillPayLink() {
        welcomeUserPage.clickOnBillPayLink();
    }
}
