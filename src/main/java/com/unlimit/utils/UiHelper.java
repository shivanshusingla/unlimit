package com.unlimit.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UiHelper {

    public static void click(Config config, WebElement element, String... description) {
        try {
            Actions actions = new Actions(config.driver);
            actions.moveToElement(element).click().build().perform();
            config.log.info("Clicked on {}", description);
        } catch (Exception e) {
            config.fail(e.toString());
        }
    }

    public static void enterData(Config config, WebElement element, String data, String... fieldName) {
        try {
            element.clear();
            element.sendKeys(data);
            config.log.info("Entered data - {} in field name - {}", data, fieldName);
        } catch (Exception e) {
            config.fail(e.toString());
        }
    }

    public static String getText(Config config, WebElement element, String... description) {
        String text = null;
        try {
            text = element.getText();
            config.log.info("Text of {} element is {}", description, text);
        } catch (Exception e) {
            config.fail(e.toString());
        }
        return text;
    }

    public static String getTextOfSelectedOption(Config config, WebElement element, String... description) {
        String selectedOption = null;
        try {
            Select select = new Select(element);
            selectedOption = select.getFirstSelectedOption().getText();
            config.log.info("Text of first selected option is {}", description, selectedOption);
        } catch (Exception e) {
            config.fail(e.toString());
        }
        return selectedOption;
    }
}
