package com.unlimit.utils;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.FileReader;
import java.util.Properties;

public class Config {

    public static WebDriver driver;
    public static Logger log = LoggerFactory.getLogger(Config.class);

    public static void fail(String error) {
        log.error(error);
        Assert.fail(error);
    }

    public static String getPropertyValue(String key) {
        Properties properties = null;
        try {
            FileReader fileReader = new FileReader(System.getProperty("user.dir") + "/src/main/resources/config.properties");
            properties = new Properties();
            properties.load(fileReader);
        } catch (Exception e) {
            fail(e.toString());
        }
        return properties.getProperty(key);
    }
}
