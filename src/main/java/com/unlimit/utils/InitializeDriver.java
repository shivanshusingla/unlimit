package com.unlimit.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Locale;

public class InitializeDriver {
    public static WebDriver driver;

    public static WebDriver initializeDriver(String browserName) {
        String osName = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        Config.log.info("Suite Executing on {}", osName);
        Config.log.info("Opening {} Browser on {}", browserName, osName);
        if (osName.contains("mac")) {
            if (browserName.contains("chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "src/main/resources/drivers/ios/chromedriver");
                driver = new ChromeDriver();
            }
        }
        return driver;
    }
}
