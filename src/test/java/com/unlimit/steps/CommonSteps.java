package com.unlimit.steps;

import com.unlimit.pages.CommonPage;
import com.unlimit.utils.Browser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CommonSteps {

    String welcomeText;
    private CommonPage commonPage = new CommonPage();

    @Given("^Open Url - (.*)$")
    public void openUrl(String url) {
        Browser.openUrl(url);
    }

    @Given("^Click on (.*) button$")
    public void clickOnButton(String buttonName) {
        commonPage.clickOnButton(buttonName);
    }

    @Then("^Verify h1 heading text should be (.*)$")
    public void verifyH1Heading(String expectedWelcomeText) {
        String actualWelcomeText = commonPage.getH1Heading();
        Assert.assertEquals(actualWelcomeText, expectedWelcomeText, "Welcome User Text");
    }

    @And("Open a new tab")
    public void openANewTab() {
        Browser.openANewTab();
    }
}
