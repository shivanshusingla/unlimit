package com.unlimit.pages;

import com.unlimit.utils.Config;
import com.unlimit.utils.UiHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {

    @FindBy(tagName = "h1")
    public WebElement h1Heading;
    private Config config = new Config();

    public CommonPage() {
        PageFactory.initElements(config.driver, this);
    }

    public String getH1Heading() {
        return UiHelper.getText(config, h1Heading, "H1 Heading");
    }

    public void clickOnButton(String buttonName) {
        UiHelper.click(config, config.driver.findElement(By.xpath("//input[@value='" + buttonName + "']")), buttonName + " Button");
    }
}
