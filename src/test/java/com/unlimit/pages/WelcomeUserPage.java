package com.unlimit.pages;

import com.unlimit.utils.Config;
import com.unlimit.utils.UiHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomeUserPage {

    private Config config = new Config();

    @FindBy(linkText = "Bill Pay")
    public WebElement billPayLink;

    public WelcomeUserPage() {
        PageFactory.initElements(config.driver, this);
    }

    public void clickOnBillPayLink() {
        UiHelper.click(config, billPayLink, "Bill Pay Link");
    }

}
