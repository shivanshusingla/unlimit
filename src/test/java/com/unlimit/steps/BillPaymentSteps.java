package com.unlimit.steps;

import com.unlimit.pages.BillPaymentPage;
import com.unlimit.pages.CommonPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class BillPaymentSteps {

    private CommonPage commonPage = new CommonPage();
    private BillPaymentPage billPaymentPage = new BillPaymentPage();

    @And("^Enter payee details$")
    public void enterPayeeDetails() {
        billPaymentPage.enterPayeeDetails();
    }

    @Given("^Enter amount of dollar (.*)$")
    public void enterAmount(String amount) {
        billPaymentPage.enterAmount(amount);
    }

    @And("^Get recipient account number$")
    public void getRecipientAccountNumber() {
        billPaymentPage.getAccountNumber();
    }
}
