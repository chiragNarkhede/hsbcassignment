package com.exchange.rateapi.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommonUtils {

    static Properties properties;
    private static String latestExchangeRate;
    private static String specificDateExchangeRate;

    public static void ReadFile()
    {
        properties = new Properties();
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//config.properties");
            properties.load(fileInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        latestExchangeRate = properties.getProperty("LATEST_FOREIGN_EXCHANGE_RATE");
        specificDateExchangeRate = properties.getProperty("SPECIFIC_DATE_EXCHANGE_RATE");
    }

    public static String getLatestExchageRateURL(){
        ReadFile();
        return latestExchangeRate;
    }

    public static String getSpecificDateExchangeRateURL(){
        return specificDateExchangeRate;
    }
}
