package com.celllabs.shared;

import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v126.network.Network;
import org.openqa.selenium.devtools.v126.network.model.Headers;
import org.openqa.selenium.devtools.v126.network.model.RequestId;
import org.openqa.selenium.devtools.v126.network.model.Response;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.celllabs.App.*;

public class Common {
    private static FluentWait<ChromeDriver> wait = null;
    public static String baseScreenShotPath = "./screenshots/";

    private static String serverUrl = "https://stage-api.care.life/";
//    private static String serverUrl = "http://localhost:9000/";
    private static String verifyUser = serverUrl+"verify-user";
    private static String verifyAccount = serverUrl+"verify-account";
    public static int screenShotNum = 0;
    public static String otp = null;
    public static String fontColor = "Montserrat";


    public static WebDriver openChrome(){

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");

        System.setProperty(chromeDriver, chromeDriverPath);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions ops = new ChromeOptions();
        ops.setCapability("se:name", "My simple test1");

        capabilities.setCapability("browserVersion", "126");
        capabilities.setCapability("browserName", "chrome");
//        capabilities.setCapability("platformName", "Windows 11");
        capabilities.setPlatform(Platform.WIN11);


        capabilities.setCapability("se:name", "My simple test1");
//        capabilities.setCapability("visual", true); // To enable step by step screenshot
//        capabilities.setCapability("video", true);
       /* options.setCapability("visual", true);
        options.setCapability("video", true);*/
//        capabilities.setCapability("generateReport", true);
        try{
           // driver =  new RemoteWebDriver(new URL("http://localhost:4444"), ops);
            driver =  new ChromeDriver(ops);

        }catch (Exception e){
            e.printStackTrace();
        }

//        driver = new ChromeDriver(options);
//        driver = new ChromeDriver(options);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get(baseUrl);

        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
        takeScreenShot(baseScreenShotPath+"firsPage"+(++screenShotNum)+".png");





       /* wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(10))
                        .pollingEvery(Duration.ofMillis(1000))
                        .ignoring(ElementClickInterceptedException.class)
                        .ignoring(ElementNotInteractableException.class)
                        .ignoring(NoSuchElementException.class);*/



        Map<String, Object> headers = new HashMap<>();
        headers.put("selenium", "care-testing");
        ChromeDriver driver1 = driver1= (ChromeDriver) driver;;

        DevTools devTools =  driver1.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

        Logger logger = Logger.getLogger(RemoteWebDriver.class.getName());
        logger.setLevel(Level.WARNING);

        for (Handler handler : Logger.getLogger("").getHandlers()) {
            handler.setLevel(Level.WARNING);
        }

        devTools.addListener(Network.requestWillBeSent(), request -> {
            if(request.getRequest().getUrl().contains(baseUrl+"systems?type=full&teamId=")) {
                System.out.println("request123 " + request.getRequest().getHeaders());
            }
        });


        devTools.addListener(Network.responseReceived(), response -> {
            RequestId requestId = response.getRequestId();
            Response res = response.getResponse();
            if(res.getUrl().contains(serverUrl+"systems?type=full&teamId=")){
                System.out.println("headers "+res.getHeaders());

                String responseBody1 = devTools.send(Network.getResponseBody(requestId)).getBody();
                System.out.println("responseBody "+responseBody1);
                System.out.println("requestId "+requestId);
            }

            if(res.getUrl().equalsIgnoreCase(verifyUser) ||
                    res.getUrl().equalsIgnoreCase(verifyAccount)){

                System.out.println("headers1 "+res.getHeaders());
                String responseBody = devTools.send(Network.getResponseBody(requestId)).getBody();
                JSONObject object = new JSONObject(responseBody);
                if(object.has("successMessage")) otp = object.getString("successMessage");
                System.out.println("responseBody1 "+responseBody);
            }
        });


        return driver;
    }
    public static void takeScreenShot(String path){
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(path);

            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void callGetReq() throws IOException {
        URL url = new URL("http://localhost:9000");

        HttpRequest request = new HttpRequest(HttpMethod.GET,"/getUserInfo");
        request.addQueryParameter("username","krishna.k@celllabs.com");
        HttpClient client = HttpClient.Factory.createDefault().createClient(url);
        HttpResponse response = client.execute(request);
        System.out.println(response);
    }
    private static void callPostReq() throws IOException {
        URL url = new URL("http://localhost:9000");

        HttpRequest request = new HttpRequest(HttpMethod.POST,"/set-password");
        Map<String, String> map = new HashMap<>();
        map.put("accountNumber","A7AR215L");

        request.setHeader("Content-Type", "application/json");
        request.setContent(Contents.asJson(map));

        HttpClient client = HttpClient.Factory.createDefault().createClient(url);

        HttpResponse response = client.execute(request);
        System.out.println(response);
    }


    public static WebElement waitBySelector(String path) {
        WebElement webElement = webDriverWait.until(driver -> driver.findElement(By.cssSelector(path)));
        return webElement;

    }

    public static void openFirefox(){
      /*  System.setProperty(firefoxDriver, firefoxDriverPath);
         driver = new FirefoxDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(baseUrl);

        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;*/
    }
    public static WebElement cssSelect(String path) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(path)));
    }
    public static WebElement selectBySelector(String path) {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(path)));
    }
    public static WebElement selectElement(String path) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(path))));
    }
    public static WebElement selectXpath(String path) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
    }
    public static WebElement selectById(String id) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }
    public static boolean isElementPresent(By by) {
        boolean isPresent = true;
        try {
            driver.findElement(by);
        } catch (NoSuchElementException e) {
            isPresent = false;
        }
        return isPresent;
    }
    public static void  navigateBack(){
        sleep(1000);
        driver.navigate().back();
        sleep(2000);
    }
    public static void  navigateTo(String url){
        driver.navigate().to(url);
        sleep(2000);
    }

    public static void clickButton(String path){
        sleep(1000);
        cssSelect(path).click();

    }
    public static void clickHideButton(String path){
        sleep(2000);
        cssSelect(path).click();
        sleep(2000);
    }
    public static void clickLogOutButton(){
        cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-more > ion-content > main > footer > article > button.logout-button").click();
        sleep(2000);
    }

    public static void clickTeam(){
        cssSelect("#main > app-select-team > ion-content > main > section > article > app-options-btn:nth-child(1)").click();
    }

    public static void goToLoginPage(){
        sleep(2000);
        driver.navigate().to(baseUrl+"#/login");
        sleep(2000);
    }
    public static void clear(WebElement element){
        sleep(1000);
        if(element.getAttribute("value") != null)  element.clear();
    }
    public static String takeInputFromUrl(int type){
        sleep(2000);
        clear(selectById("otp"));
        if(type == 0){
            selectById("otp").sendKeys("123456");
        }else{
            sleep(1000);
            if(otp != null) selectById("otp").sendKeys(otp);
        }
        cssSelect("#main > app-validate-otp > ion-content > section > button").click();
        sleep(2000);
        return driver.getCurrentUrl();
    }

    public static String takeInput(int type){
        sleep(1000);
        String inputValue = "";
        while(inputValue.length() != 6){
            inputValue = selectById("otp").getAttribute("value");
            sleep(5000);
        }

        System.out.println(inputValue);
        cssSelect("#main > app-validate-otp > ion-content > section > button").click();
        sleep(2000);
        if(type == 0) selectById("otp").clear();

        return driver.getCurrentUrl();

    }
    public static String passwordFieldFont(String elementPath, String showHideBtnPath, int type){
        if(type == 1) {
            driver.navigate().refresh();
            sleep(2000);
        }

        WebElement element = cssSelect(elementPath);
        if(element.isDisplayed()) element.sendKeys("password font check");

        String font = element.getCssValue("font-family");
        cssSelect(showHideBtnPath).click();

        if(element.getAttribute("value") != null){
            element.clear();
        }
        return font;
    }

    public static String checkFont(String path, int type){
        WebElement element = selectBySelector(path);
        String font = null;
        if(type == 1) {
            element.sendKeys("fontCheck");
            sleep(200);
            font = element.getCssValue("font-family");
            if(element.getAttribute("value") != null) {
                element.clear();
                element.clear();
            }
        }else{
            font = element.getCssValue("font-family");
        }

        return font;
    }




}
