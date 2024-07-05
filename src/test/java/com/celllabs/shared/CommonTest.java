package com.celllabs.shared;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.celllabs.App;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.celllabs.TestCase;
import com.celllabs.TestData;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Slf4j
public class CommonTest {
    public static Map<String, List<TestCase>> testCases;
    public static Map<String, String> userDetailsMap;

    public static ExtentTest test;
    public static ExtentReports report;
    public static void setUpReport() {
        report = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        report.attachReporter(spark);
//        return report;
    }
    public static void conditionCheck(String expected, String actual, String msg,ExtentTest test){
        if(expected.equalsIgnoreCase(actual)){
            test.pass(msg);
        }else{
            test.fail( msg);
        }
    }
    public static void fontCasesReport(String expected, String actual, String msg,ExtentTest test){
        if(actual.contains(expected)){
            test.pass(msg);
        }else{
            test.fail( msg);
        }
    }
    private static String preprocessJsonFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines()
                    .filter(line -> !line.trim().startsWith("//"))
                    .collect(Collectors.joining("\n"));
        }
    }
    public static void readFromJsonFile(String filePath){
        String configFile = System.getProperty("configFile");
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory().enable(JsonParser.Feature.ALLOW_COMMENTS));

        try {
            TestData testData = objectMapper.readValue(new File(configFile), TestData.class);
            TestData.setUserData(testData);
        } catch (IOException e) {
            log.error("Exception ",e);
        }
    }
    public static ExtentTest createTest(String title){
        return report.createTest(title);
    }

    public static void checkLoginStatus(String type, ExtentTest test) {
        if (App.driver.getCurrentUrl().equalsIgnoreCase(App.baseUrl + "#/home/systems")) {
            test.pass("login with correct "+type+" and correct password successful");
            Common.navigateTo(App.baseUrl + "#/home/more");
            Common.clickLogOutButton();
        } else if (App.driver.getCurrentUrl().equalsIgnoreCase(App.baseUrl + "#/select-team")) {
            test.pass("login with correct "+type+" and correct password successful");
            Common.clickTeam();
            Common.navigateTo(App.baseUrl + "#/home/more");
            Common.clickLogOutButton();
        } else {
            test.fail("login with correct "+type+" and correct password failed");
        }
    }
    public static void showPasswordButtonStatus(String path, String type,String message, ExtentTest test){
        App.sleep(1000);
        String inputType = Common.cssSelect(path).getAttribute("type");

        if(inputType.equalsIgnoreCase(type)){
            test.pass("password "+message+" button passed");
        }else{
            test.fail("password "+message+" button failed");
        }

        System.out.println(inputType);
    }

    public static void clickOnLogOutButton(){
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-more > ion-content > main > footer > article > button.logout-button.logout-button").click();
        App.sleep(1000);
    }
}
