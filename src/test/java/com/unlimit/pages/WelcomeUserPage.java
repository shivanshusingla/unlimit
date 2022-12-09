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

    @FindBy(linkText = "Log Out")
    public WebElement logoutLink;

    @FindBy(linkText = "Accounts Overview")
    public WebElement accountsOverviewLink;

    public WelcomeUserPage() {
        PageFactory.initElements(config.driver, this);
    }

    public void clickOnBillPayLink() {
        UiHelper.click(config, billPayLink, "Bill Pay Link");
    }

    public void clickOnLogoutLink() {
        UiHelper.click(config, logoutLink, "Logout Link");
    }

    public void clickOnAccountsOverviewLink() {
        UiHelper.click(config, accountsOverviewLink, "Accounts Overview Link");
    }

}
