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

    private Config config = new Config();

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
            CreateUserSteps.senderUserName = CreateUserSteps.senderUserName + new Random().nextInt();
            return true;
        }
        return false;
    }
}
