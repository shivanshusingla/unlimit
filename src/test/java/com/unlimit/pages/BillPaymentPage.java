package com.unlimit.pages;

import com.unlimit.steps.CreateUserSteps;
import com.unlimit.utils.Config;
import com.unlimit.utils.UiHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillPaymentPage {

    public static String recipientAccountNumber;
    @FindBy(name = "payee.name")
    public WebElement payeeName;

    @FindBy(name = "payee.address.street")
    public WebElement payeeAddress;

    @FindBy(name = "payee.address.city")
    public WebElement payeeCity;

    @FindBy(name = "payee.address.state")
    public WebElement payeeState;

    @FindBy(name = "payee.address.zipCode")
    public WebElement payeeZipCode;

    @FindBy(name = "payee.phoneNumber")
    public WebElement payeePhoneNumber;

    @FindBy(name = "payee.accountNumber")
    public WebElement accountNumber;

    @FindBy(name = "verifyAccount")
    public WebElement verifyAccount;

    @FindBy(name = "amount")
    public WebElement amount;

    @FindBy(name = "fromAccountId")
    public WebElement accountNumberDropdown;
    private Config config = new Config();

    public BillPaymentPage() {
        PageFactory.initElements(config.driver, this);
    }

    public void enterPayeeDetails() {
        UiHelper.enterData(config, payeeName, CreateUserSteps.recipientFirstName + " " + CreateUserSteps.recipientLastName, "Payee Name:");
        UiHelper.enterData(config, payeeAddress, CreateUserSteps.recipientAddress, "Address:");
        UiHelper.enterData(config, payeeCity, CreateUserSteps.recipientCity, "City:");
        UiHelper.enterData(config, payeeState, CreateUserSteps.recipientState, "State:");
        UiHelper.enterData(config, payeeZipCode, CreateUserSteps.recipientZipCode, "Zip Code:");
        UiHelper.enterData(config, payeePhoneNumber, CreateUserSteps.recipientPhone, "Phone #:");
        UiHelper.enterData(config, accountNumber, recipientAccountNumber, "Account #:");
        UiHelper.enterData(config, verifyAccount, recipientAccountNumber, "Verify Account #:");
    }

    public void enterAmount(String amountValue) {
        UiHelper.enterData(config, amount, amountValue, "Amount $:");
    }

    public String getPayeeName() {
        return UiHelper.getText(config, payeeName, "Payee Name");
    }

    public String getAccountNumber() {
        recipientAccountNumber = UiHelper.getTextOfSelectedOption(config, accountNumberDropdown, "Account Number Dropdown");
        return recipientAccountNumber;
    }

    public String getAmount() {
        return UiHelper.getText(config, amount, "Amount");
    }

    public String getFromAccountNumber() {
        return UiHelper.getText(config, accountNumberDropdown, "From Account Number");
    }

}
