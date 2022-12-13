package com.unlimit.pages;

import com.unlimit.steps.CreateUserSteps;
import com.unlimit.utils.Config;
import com.unlimit.utils.UiHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class RegisterUserPage {

    @FindBy(linkText = "Register")
    public WebElement registerLink;
    @FindBy(id = "customer.firstName")
    public WebElement userNameField;
    @FindBy(id = "customer.lastName")
    public WebElement lastNameField;
    @FindBy(id = "customer.address.street")
    public WebElement address;
    @FindBy(id = "customer.address.city")
    public WebElement city;
    @FindBy(id = "customer.address.state")
    public WebElement state;
    @FindBy(id = "customer.address.zipCode")
    public WebElement zipCode;
    @FindBy(id = "customer.phoneNumber")
    public WebElement phoneNumber;
    @FindBy(id = "customer.ssn")
    public WebElement ssn;
    @FindBy(id = "customer.username")
    public WebElement username;
    @FindBy(id = "customer.password")
    public WebElement password;
    @FindBy(id = "repeatedPassword")
    public WebElement confirmPassword;
    @FindBy(id = "firstname")
    public WebElement userFirstNameField;
    @FindBy(id = "lastname")
    public WebElement userLastNameField;
    @FindBy(id = "email_address")
    public WebElement userEmailField;
    @FindBy(id = "password")
    public WebElement userPassword;
    @FindBy(id = "password-confirmation")
    public WebElement userPasswordConfirmation;
    private Config config = new Config();

    public RegisterUserPage() {
        PageFactory.initElements(config.driver, this);
    }

    public void enterSenderDetails() {
        UiHelper.enterData(config, userNameField, CreateUserSteps.senderFirstName, "First Name:");
        UiHelper.enterData(config, lastNameField, CreateUserSteps.senderLastName, "Last Name:");
        UiHelper.enterData(config, address, CreateUserSteps.senderAddress, "Address:");
        UiHelper.enterData(config, city, CreateUserSteps.senderCity, "City:");
        UiHelper.enterData(config, state, CreateUserSteps.senderState, "State:");
        UiHelper.enterData(config, zipCode, CreateUserSteps.senderZipCode, "Zip Code:");
        UiHelper.enterData(config, phoneNumber, CreateUserSteps.senderPhone, "Phone #:");
        UiHelper.enterData(config, ssn, CreateUserSteps.senderSSN, "SSN:");
        UiHelper.enterData(config, username, CreateUserSteps.senderUserName, "Username:");
        UiHelper.enterData(config, password, CreateUserSteps.senderPassword, "Password:");
        UiHelper.enterData(config, confirmPassword, CreateUserSteps.senderPassword, "Confirm:");
    }

    public void enterRecipientDetails() {
        UiHelper.enterData(config, userNameField, CreateUserSteps.recipientFirstName, "First Name:");
        UiHelper.enterData(config, lastNameField, CreateUserSteps.recipientLastName, "Last Name:");
        UiHelper.enterData(config, address, CreateUserSteps.recipientAddress, "Address:");
        UiHelper.enterData(config, city, CreateUserSteps.recipientCity, "City:");
        UiHelper.enterData(config, state, CreateUserSteps.recipientState, "State:");
        UiHelper.enterData(config, zipCode, CreateUserSteps.recipientZipCode, "Zip Code:");
        UiHelper.enterData(config, phoneNumber, CreateUserSteps.recipientPhone, "Phone #:");
        UiHelper.enterData(config, ssn, CreateUserSteps.recipientSSN, "SSN:");
        UiHelper.enterData(config, username, CreateUserSteps.recipientUserName, "Username:");
        UiHelper.enterData(config, password, CreateUserSteps.recipientPassword, "Password:");
        UiHelper.enterData(config, confirmPassword, CreateUserSteps.recipientPassword, "Confirm:");
    }

    public void clickOnRegisterLink() {
        UiHelper.click(config, registerLink, "Register Link");
    }

    public boolean checkIfErrorPresent() {
        WebElement errorMessage = null;
        try {
            errorMessage = config.driver.findElement(By.className("error"));
        } catch (NoSuchElementException e) {
            config.log.warn("Error message not found!");
        }
        if (errorMessage != null) {
            String errorMsg = UiHelper.getText(config, errorMessage, "Error Message");
            if (errorMsg.contains("internal error")) {
                config.fail("Getting An internal error has occurred and has been logged.");
            }
            CreateUserSteps.senderUserName = CreateUserSteps.senderUserName + new Random().nextInt();
            return true;
        }
        return false;
    }

    public void enterUserDetails() {
        UiHelper.enterData(config, userFirstNameField, CreateUserSteps.senderFirstName, "First Name");
        UiHelper.enterData(config, userLastNameField, CreateUserSteps.senderLastName, "Last Name");
        UiHelper.enterData(config, userEmailField, CreateUserSteps.senderEmail, "Email");
        UiHelper.enterData(config, userPassword, CreateUserSteps.senderPassword, "Password");
        UiHelper.enterData(config, userPasswordConfirmation, CreateUserSteps.senderPassword, "Confirm Password");
    }
}
