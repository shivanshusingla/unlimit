package com.unlimit.steps;

import com.unlimit.pages.CommonPage;
import com.unlimit.utils.Browser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CommonSteps {

    private CommonPage commonPage = new CommonPage();
    String welcomeText;

    @Given("^Open Url - (.*)$")
    public void openUrl(String url) {
        Browser.openUrl(url);
    }

    @Given("^Click on (.*) button$")
    public void clickOnButton(String buttonName) {
        commonPage.clickOnButton(buttonName);
    }
}
