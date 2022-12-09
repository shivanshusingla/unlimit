package com.unlimit.utils;

import org.openqa.selenium.WindowType;

public class Browser {

    private static Config config;

    public static void openUrl(String url) {
        config.log.info("Open url - {}", url);
        config.driver.get(url);
    }

    public static void openANewTab() {
        config.driver.switchTo().newWindow(WindowType.TAB);
    }
}
