package com.unlimit.steps;

import com.unlimit.utils.ApiHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateUserSteps {

    public static String senderFirstName, senderLastName, senderAddress, senderCity, senderState, senderZipCode, senderEmail, senderPhone, senderSSN, senderUserName, senderPassword;
    public static String recipientFirstName, recipientLastName, recipientAddress, recipientCity, recipientState, recipientZipCode, recipientEmail, recipientPhone, recipientUserName, recipientPassword;

    @Given("^Get response of api whose url is (.*)$")
    public void createAUser(String url) {
        ApiHelper.getResponse(url);
    }

    @Then("Get all details of sender")
    public void getSenderDetails() {
        senderFirstName = ApiHelper.getValue("results.name.first[0]");
        senderLastName = ApiHelper.getValue("results.name.last[0]");
        senderAddress = ApiHelper.getValue("results.location.street.number[0]") + ", " + ApiHelper.getValue("results.location.street.name[0]");
        senderCity = ApiHelper.getValue("results.location.city[0]");
        senderState = ApiHelper.getValue("results.location.state[0]");
        senderZipCode = ApiHelper.getValue("results.location.postcode[0]");
        senderEmail = ApiHelper.getValue("results.email[0]");
        senderPhone = ApiHelper.getValue("results.phone[0]");
        senderSSN = ApiHelper.getValue("results.cell[0]");
        senderUserName = ApiHelper.getValue("results.login.username[0]");
        senderPassword = ApiHelper.getValue("results.login.password[0]");
    }

    @Then("Get all details of recipient")
    public void getRecipientDetails() {
        recipientFirstName = ApiHelper.getValue("results.name.first[0]");
        recipientLastName = ApiHelper.getValue("results.name.last[0]");
        recipientAddress = ApiHelper.getValue("results.location.street.number[0]") + ", " + ApiHelper.getValue("results.location.street.name[0]");
        recipientCity = ApiHelper.getValue("results.location.city[0]");
        recipientState = ApiHelper.getValue("results.location.state[0]");
        recipientZipCode = ApiHelper.getValue("results.location.postcode[0]");
        recipientEmail = ApiHelper.getValue("results.email[0]");
        recipientPhone = ApiHelper.getValue("results.phone[0]");
        recipientUserName = ApiHelper.getValue("results.login.username[0]");
        recipientPassword = ApiHelper.getValue("results.login.password[0]");
    }

}
