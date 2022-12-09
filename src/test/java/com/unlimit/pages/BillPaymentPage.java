package com.unlimit.pages;

import com.unlimit.utils.Config;
import com.unlimit.utils.UiHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillPaymentPage {

    private Config config = new Config();

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

    @FindBy(name = "payees.phoneNumber")
    public WebElement payeePhoneNumber;

    @FindBy(name = "verifyAccount")
    public WebElement verifyAccount;

    @FindBy(name = "amount")
    public WebElement amount;

    public BillPaymentPage() {
        PageFactory.initElements(config.driver, this);
    }

}
