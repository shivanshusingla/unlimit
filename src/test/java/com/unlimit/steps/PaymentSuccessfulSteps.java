package com.unlimit.steps;

import com.unlimit.pages.BillPaymentPage;
import com.unlimit.pages.PaymentSuccessfulPage;
import com.unlimit.pages.RegisterUserPage;
import com.unlimit.utils.Config;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

public class PaymentSuccessfulSteps {

    PaymentSuccessfulPage paymentSuccessfulPage = new PaymentSuccessfulPage();

    @Then("^Verify payment successful message with amount should be (.*)$")
    public void verifyPaymentSuccessfulText(String expectedAmount) {
        SoftAssert softAssert = new SoftAssert();
        String actualPayeeName = paymentSuccessfulPage.getPayeeName();
        String expectedPayeeName = CreateUserSteps.recipientFirstName + " " + CreateUserSteps.recipientLastName;
        String actualAmount = paymentSuccessfulPage.getAmount();
        String actualFromAccountNumber = paymentSuccessfulPage.getFromAccountNumber();
        RegisterUserPage registerUserPage = new RegisterUserPage();
        if (!registerUserPage.checkIfErrorPresent()) {
            softAssert.assertEquals(actualPayeeName, expectedPayeeName, "Payee Name Successful Message");
            softAssert.assertEquals(actualAmount, expectedAmount, "Amount Successful Message");
            softAssert.assertEquals(actualFromAccountNumber, BillPaymentPage.recipientAccountNumber, "From Account Number");
            softAssert.assertAll();
        } else {
            Config.fail("Getting An internal error has occurred and has been logged & its not a suite issue.");
        }
    }
}
