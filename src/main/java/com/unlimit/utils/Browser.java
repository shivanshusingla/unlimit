package com.unlimit.utils;

public class Browser {

    private static Config config;

    public static void openUrl(String url){
        config.log.info("Open url - {}",url);
        config.driver.get(url);

    }
}
