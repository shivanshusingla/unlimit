package com.unlimit.utils;

import org.openqa.selenium.WindowType;

import java.time.Duration;

public class Browser {

    private static Config config;

    public static void openUrl(String url) {
        config.log.info("Open url - {}", url);
        config.driver.get(url);
        config.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    }

    public static void maximizeBrowser() {
        config.log.info("Maximize Browser");
        config.driver.manage().window().maximize();
    }

    public static void openANewTab() {
        config.driver.switchTo().newWindow(WindowType.TAB);
    }
}
