package com.unlimit.pages;

import com.unlimit.utils.Config;
import com.unlimit.utils.UiHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentSuccessfulPage {

    private Config config = new Config();

    @FindBy(id = "payeeName")
    public WebElement payeeName;

    @FindBy(id = "amount")
    public WebElement amount;

    @FindBy(id = "fromAccountId")
    public WebElement accountNumberDropdown;

    public PaymentSuccessfulPage() {
        PageFactory.initElements(config.driver, this);
    }

    public String getPayeeName() {
        return UiHelper.getText(config, payeeName, "Payee Name");
    }

    public String getAmount() {
        return UiHelper.getText(config, amount, "Amount");
    }

    public String getFromAccountNumber() {
        return UiHelper.getText(config, accountNumberDropdown, "From Account Number");
    }

}
