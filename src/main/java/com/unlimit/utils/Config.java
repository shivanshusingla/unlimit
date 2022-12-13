package com.unlimit.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
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

    public static String encodeFileToBase64Binary(File fileName) {
        File file = new File(String.valueOf(fileName));
        byte[] encoded = new byte[0];
        try {
            encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
        } catch (IOException e) {
            fail(e.toString());
        }
        return new String(encoded, StandardCharsets.US_ASCII);
    }

    public boolean isNetAvailable() {
        try {
            URL url = new URL("https://www.google.com");
            URLConnection conn = url.openConnection();
            InetAddress check = InetAddress.getByName("www.google.com");
            int count = 0;
            while (count == 5) {
                boolean isReachable = check.isReachable(3000);
                if (isReachable) {
                    return true;
                }
            }
            count++;
        } catch (Exception e) {
            try {
                wait(5000);
            } catch (InterruptedException interruptedException) {
                log.error(e.toString());
            }
        }
        return false;
    }
}
