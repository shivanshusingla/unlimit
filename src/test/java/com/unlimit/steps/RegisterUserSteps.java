package com.unlimit.steps;

import com.unlimit.pages.CommonPage;
import com.unlimit.pages.RegisterUserPage;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RegisterUserSteps {

    private RegisterUserPage userPage = new RegisterUserPage();
    private CommonPage commonPage = new CommonPage();

    @Given("^Click on Register link")
    public void clickOnRegisterLink() {
        userPage.clickOnRegisterLink();
    }

    @Then("^Enter sender details in field$")
    public void enterSenderDetails() {
        userPage.enterSenderDetails();
    }

    @But("^Check if user already present or not$")
    public void checkIfUserAlreadyPresent() {
        if (userPage.checkIfErrorPresent()) {
            userPage.clickOnRegisterLink();
            userPage.enterSenderDetails();
            commonPage.clickOnButton("Register");
        }
    }

}
