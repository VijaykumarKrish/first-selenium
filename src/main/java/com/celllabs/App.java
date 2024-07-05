package com.celllabs;



import com.celllabs.shared.Common;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class App {
//    public static final String chromeDriverPath = "D:\\selenium\\chrome\\chromedriver-win64-1\\chromedriver.exe";
    public static final String chromeDriverPath = "D:\\selenium\\chrome\\chromedriver-win64\\chromedriver.exe";
    public static final String chromeDriver = "webdriver.chrome.driver";
    public static final String firefoxDriver = "webdriver.gecko.driver";
    public static final String firefoxDriverPath = "D:\\selenium\\firefox\\geckodriver-v0.34.0-win64\\geckodriver.exe";
    public static WebDriver driver = null;
//    public static ChromeDriver driver = null;
//    public static RemoteWebDriver driver = null;
    public static WebDriverWait webDriverWait = null;
//    public static String baseUrl = "https://ui.care.life/";
//    public static String baseUrl = "https://office.celllabs.com/";
    public static String baseUrl = "https://stage-ui.care.life/";
//    public static String baseUrl = "http://localhost:8100/";
    public static final String homeUrl = baseUrl+"#/home/systems";
    public static final String loginUrl = baseUrl+"#/login";
    public static final String verifyUserUrl = baseUrl+"#/forgot-password/verify-user";
    public static final String teamUrl = baseUrl+"#/select-team";
    public static JavascriptExecutor js = null;

   /* public App() {
        System.setProperty(chromeDriver, chromeDriverPath);
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(baseUrl);
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
    }*/
    private static String preprocessJsonFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines()
                    .filter(line -> !line.trim().startsWith("//"))
                    .collect(Collectors.joining("\n"));
        }
    }

  /*  public static void main(String[] args) throws ExecutionException, InterruptedException {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Preprocess the JSON file to remove comments
            String jsonContent = preprocessJsonFile("testcases.json");

            // Read JSON content into a Map
            Map<String, List<TestCase>> testCases = objectMapper.readValue(
                    jsonContent, new TypeReference<Map<String, List<TestCase>>>() {});

            // Process the test cases
            for (Map.Entry<String, List<TestCase>> entry : testCases.entrySet()) {
                String screen = entry.getKey();
                List<TestCase> cases = entry.getValue();

                System.out.println("Screen: " + screen);
                for (TestCase testCase : cases) {
                    System.out.println(testCase);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }







      *//*  System.setProperty(chromeDriver, chromeDriverPath);
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//      WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl);

        driver.manage().window().maximize();*//*

//       just for example
//      writeAllTests(driver);

        sleep(10000);

//         font font checking
        sleep(2000);
        checkFontForLogin();
        sleep(5 * 1000);
//        checkFontForgotPassword();
//        sleep(5 * 1000);
//        checkFontForFirstTimeUser();
//        sleep(5000);
//        navigateToLogin();
//        sleep(1000);

        // for login page
        writeTestCasesForLogin();
//        forgotPasswordPage();
//        firstTimeUserPage();

        sleep(1000);

//        for different screens
        checkDimension();

    }*/

    protected static void checkFontForFirstTimeUser() {
        navigateToLogin();
        sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element;
        WebElement secondClickHereLink = driver.findElement(By.xpath("//*[@id=\"main\"]/app-login/ion-content/main/section/article[2]/div[2]/p[2]/span"));

        secondClickHereLink.click();
        sleep(2000);
        refresh();
        element = driver.findElement(By.id("email"));
        element.sendKeys("surya.obulareddy@celllabs.com");
        element = driver.findElement(By.cssSelector("#phone"));
        element.sendKeys("9678543217");

        // for account verification title
        element = driver.findElement(By.cssSelector("#main > app-verify-account > ion-content > main > article:nth-child(1) > h3"));
        String accountTitleFont = getCssProps(element, "name");
        String accountTitleFontSize = getCssProps(element, "size");
        js.executeScript("var node= document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + accountTitleFont + " " + accountTitleFontSize + "')); node.style.cssText='color:#FF0000'; document.querySelector('#main > app-verify-account > ion-content > main > article:nth-child(1) > h3').appendChild(node);");

        // for subtitle
        element = driver.findElement(By.cssSelector("#main > app-verify-account > ion-content > main > article:nth-child(1) > h4"));
        String subTitleFont = getCssProps(element, "name");
        String subTitleFontSize = getCssProps(element, "size");
        js.executeScript("var node= document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + subTitleFont + " " + subTitleFontSize + "')); node.style.cssText='color:#FF0000'; document.querySelector('#main > app-verify-account > ion-content > main > article:nth-child(1) > h4').appendChild(node);");

        //for email
        element = driver.findElement(By.cssSelector("#main > app-verify-account > ion-content > main > article:nth-child(2) > div:nth-child(1) > app-text-field > main > article > h4"));
        String emaileFont = getCssProps(element, "name");
        String emailFontSize = getCssProps(element, "size");
        js.executeScript("var node= document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + emaileFont + " " + emailFontSize + "')); node.style.cssText='color:#FF0000'; document.querySelector('#main > app-verify-account > ion-content > main > article:nth-child(2) > div:nth-child(1) > app-text-field > main > article > h4').appendChild(node);");

        element = driver.findElement(By.id("email"));
        String emailFieldFont = getCssProps(element, "name");
        String emailFieldFontSize = getCssProps(element, "size");

        js.executeScript("var email= document.getElementById('email'); email.value = email.value+' \u00a0\u00a0\u00a0 " + emailFieldFont + " " + emailFieldFontSize + "'; email.style.cssText='color:#13d471';");

        //for phone number
        element = driver.findElement(By.cssSelector("#main > app-verify-account > ion-content > main > article:nth-child(2) > div:nth-child(3) > app-text-field > main > article > h4"));
        String phoneNumberFont = getCssProps(element, "name");
        String phoneNumberFontSize = getCssProps(element, "size");
        js.executeScript("var node= document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + phoneNumberFont + " " + phoneNumberFontSize + "')); node.style.cssText='color:#FF0000'; document.querySelector('#main > app-verify-account > ion-content > main > article:nth-child(2) > div:nth-child(3) > app-text-field > main > article > h4').appendChild(node);");

        element = driver.findElement(By.cssSelector("#phone"));
//        element.sendKeys("9678543217");
        String phoneFieldFont = getCssProps(element, "name");
        String phoneFieldFontSize = getCssProps(element, "size");
        js.executeScript("var phone= document.getElementById('phone'); phone.value = phone.value+' \u00a0\u00a0\u00a0 " + phoneFieldFont + " " + phoneFieldFontSize + "'; phone.style.cssText='color:#13d471';");

        element = driver.findElement(By.cssSelector("#main > app-verify-account > ion-content > main > button"));
        String buttonFont = getCssProps(element, "name");
        String buttonFontSize = getCssProps(element, "size");
        js.executeScript("var node= document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + buttonFont + " " + buttonFontSize + "')); node.style.cssText='color:#FF0000'; document.querySelector('#main > app-verify-account > ion-content > main > button').appendChild(node);");


    }

    protected static void checkFontForgotPassword() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element;
        element = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main\"]/app-login/ion-content/main/section/article[2]/div[2]/p[1]/span")));
        element.click();
        sleep(2000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("last-name"))).sendKeys("local");
        driver.findElement(By.id("phone-number")).sendKeys("2890");

        driver.findElement(By.id("Email")).sendKeys("surya.obulareddy@celllabs.com");

        // for forgot password title
        element = driver.findElement(By.cssSelector("#main > app-verify-user > ion-content > main > article:nth-child(1) > h3"));
        String forgotTitleFont = getCssProps(element, "name");
        String forgotTitleSize = getCssProps(element, "size");

        js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + forgotTitleFont + " " + forgotTitleSize + "')); node.style.cssText = 'color:#FF0000;'; document.querySelector('#main > app-verify-user > ion-content > main > article:nth-child(1) > h3').appendChild(node)");

        // for Enter details sub title
        element = driver.findElement(By.cssSelector("#main > app-verify-user > ion-content > main > article:nth-child(1) > h4"));
        String enterDetailsFont = getCssProps(element, "name");
        String enterDetailsSize = getCssProps(element, "size");

        js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + enterDetailsFont + " " + enterDetailsSize + "')); node.style.cssText = 'color:#FF0000'; document.querySelector('#main > app-verify-user > ion-content > main > article:nth-child(1) > h4').appendChild(node);");

        element = driver.findElement(By.cssSelector("#main > app-verify-user > ion-content > main > article:nth-child(2) > app-text-field:nth-child(1) > main > article > h4"));
        String lastNameFont = getCssProps(element, "name");
        String lastNameSize = getCssProps(element, "size");

        js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + lastNameFont + " " + lastNameSize + "')); node.style.cssText = 'color:#FF0000'; document.querySelector('#main > app-verify-user > ion-content > main > article:nth-child(2) > app-text-field:nth-child(1) > main > article > h4').appendChild(node);");

        // for last name
        element = driver.findElement(By.cssSelector("#main > app-verify-user > ion-content > main > article:nth-child(2) > app-text-field:nth-child(1) > main > article > h4"));
        String lastNameFieldFont = getCssProps(element, "name");
        String lastNameFieldSize = getCssProps(element, "size");


        js.executeScript("var lastName = document.getElementById('last-name'); lastName.value = lastName.value+'\u00a0\u00a0\u00a0 " + lastNameFieldFont + " " + lastNameFieldSize + "'; lastName.style.cssText = 'color:#13d471';");

        // for phone number
        element = driver.findElement(By.cssSelector("#main > app-verify-user > ion-content > main > article:nth-child(2) > app-text-field:nth-child(2) > main > article > h4"));
        String phoneNumberFont = getCssProps(element, "name");
        String phoneNumberSize = getCssProps(element, "size");

        js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + phoneNumberFont + " " + phoneNumberSize + "')); node.style.cssText = 'color:#FF0000'; document.querySelector('#main > app-verify-user > ion-content > main > article:nth-child(2) > app-text-field:nth-child(2) > main > article > h4').appendChild(node);");

        element = driver.findElement(By.id("phone-number"));
        String phoneNumberFieldFont = getCssProps(element, "name");
        String phoneNumberFieldSize = getCssProps(element, "size");

        js.executeScript("var phoneNumber = document.getElementById('phone-number'); phoneNumber.value = phoneNumber.value+'\u00a0\u00a0\u00a0 " + phoneNumberFieldFont + " " + phoneNumberFieldSize + "'; phoneNumber.style.cssText = 'color:#13d471';");


        // for email
        element = driver.findElement(By.cssSelector("#main > app-verify-user > ion-content > main > article:nth-child(2) > div > app-text-field > main > article > h4"));
        String emailFont = getCssProps(element, "name");
        String emailSize = getCssProps(element, "size");

        js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + emailFont + " " + emailSize + "')); node.style.cssText = 'color:#FF0000'; document.querySelector('#main > app-verify-user > ion-content > main > article:nth-child(2) > div > app-text-field > main > article > h4').appendChild(node);");

        element = driver.findElement(By.id("email"));
        String emailFieldFont = getCssProps(element, "name");
        String emailFieldSize = getCssProps(element, "size");

        js.executeScript("var email = document.getElementById('Email'); email.value = email.value+'\u00a0\u00a0\u00a0 " + emailFieldFont + " " + emailFieldSize + "'; email.style.cssText = 'color:#13d471';");

        element = driver.findElement(By.cssSelector("#main > app-verify-user > ion-content > main > button"));
        String buttonFont = getCssProps(element, "name");
        String buttonSize = getCssProps(element, "size");

        js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + buttonFont + " " + buttonSize + "')); node.style.cssText = 'color:#FF0000'; document.querySelector('#main > app-verify-user > ion-content > main > button').appendChild(node);");
    }


    private static void checkDimension() {
        Dimension initial_size = driver.manage().window().getSize();
        // 832
        int height = initial_size.getHeight();
        //1552
        int width = initial_size.getWidth();
        System.out.println("height " + height);
        System.out.println("width " + width);
        driver.manage().window().setSize(new Dimension(1024, 768));
        sleep(3000);
        driver.manage().window().fullscreen();
        sleep(3000);

        //iphone SE
        driver.manage().window().setSize(new Dimension(375, 667));
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 200)
                .perform();
        sleep(3000);

        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 200)
                .perform();
        sleep(1000);
        //iphone XR
        driver.manage().window().setSize(new Dimension(414, 896));
        sleep(3000);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 200)
                .perform();
        sleep(1000);

        //iphone 14 pro max
        /*driver.manage().window().setSize(new Dimension(430, 932));
        sleep(3000);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 200)
                .perform();
        sleep(1000);

        //pixel 7
        driver.manage().window().setSize(new Dimension(412, 915));
        sleep(2000);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 200)
                .perform();
        sleep(1000);*/

        //Samsung Galaxy S8+
        driver.manage().window().setSize(new Dimension(360, 740));
        sleep(2000);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 200)
                .perform();
        sleep(1000);

        //Nest Hub
        driver.manage().window().setSize(new Dimension(1024, 600));
        sleep(2000);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 200)
                .perform();
        sleep(1000);

        //Asus Zenbook Fold
        driver.manage().window().setSize(new Dimension(853, 1280));
        sleep(2000);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 200)
                .perform();
        sleep(2000);
        driver.manage().window().maximize();
    }

    protected static void checkFontForLogin() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element;
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("email"))).sendKeys("surya.obulareddy@celllabs.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        sleep(1000);
        element = driver.findElement(By.xpath("//*[@id=\"main\"]/app-login/ion-content/main/section/article[2]/div[1]/app-text-field/main/article/h4"));

        String emailFont = getCssProps(element, "name");
        String emailColor = getCssProps(element, "color");
        String emailFontSize = getCssProps(element, "size");

        js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('   " + emailFontSize + " " + emailFont + "')); node.style.cssText= 'color: #FF0000;'; document.querySelector('#main > app-login > ion-content > main > section > article:nth-child(2) > div.text-field > app-text-field > main > article > h4').appendChild(node)");

        element = driver.findElement(By.id("email"));
        String emailFieldFont = getCssProps(element, "name");
        String emailFieldColor = getCssProps(element, "color");
        String emailFieldSize = getCssProps(element, "size");

        js.executeScript("var email = document.getElementById('email'); email.style.cssText= 'color: #13d471;';  email.value = email.value+'\u00a0\u00a0\u00a0 " + emailFieldSize + " " + emailFieldFont + "';");

        element = driver.findElement(By.xpath("//*[@id=\"main\"]/app-login/ion-content/main/section/article[2]/div[1]/div/app-text-field/main/article/h4"));
        String passwordFont = getCssProps(element, "name");
        String passwordColor = getCssProps(element, "color");
        String passwordSize = getCssProps(element, "size");

        js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('   " + passwordSize + " " + passwordFont + "')); node.style.cssText= 'color: #FF0000;'; document.querySelector('#main > app-login > ion-content > main > section > article:nth-child(2) > div.text-field > div > app-text-field > main > article > h4').appendChild(node)");

        element = driver.findElement(By.id("password"));
        String passwordFieldFont = getCssProps(element, "name");
        String passwordFieldColor = getCssProps(element, "color");
        String passwordFieldSize = getCssProps(element, "size");

        js.executeScript("var password = document.getElementById('password'); password.style.cssText= 'color: #13d471;';  password.value = password.value+'\u00a0\u00a0\u00a0 " + passwordFieldSize + " " + passwordFieldFont + "';");
        showPassword();

        element = driver.findElement(By.className("primary-button"));
        String loginFont = getCssProps(element, "name");
        String loginColor = getCssProps(element, "color");
        String loginSize = getCssProps(element, "size");

        js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0\u00a0 " + loginSize + " " + loginFont + "')); node.style.cssText= 'color: #FF0000;'; document.querySelector('#main > app-login > ion-content > main > section > article:nth-child(2) > div.buttons > button').appendChild(node)");

        element = driver.findElement(By.xpath("//*[@id=\"main\"]/app-login/ion-content/main/section/article[2]/div[2]/p[1]"));
        String forgotFont = getCssProps(element, "name");
        String forgotColor = getCssProps(element, "color");
        String forgotSize = getCssProps(element, "size");

        js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0\u00a0 " + forgotSize + " " + forgotFont + "')); node.style.cssText= 'color: #FF0000;'; document.querySelector('#main > app-login > ion-content > main > section > article:nth-child(2) > div.buttons > p:nth-child(2)').appendChild(node)");

        element = driver.findElement(By.xpath("//*[@id=\"main\"]/app-login/ion-content/main/section/article[2]/div[2]/p[2]"));
        String firstTimeUserFont = getCssProps(element, "name");
        String firstTimeUserColor = getCssProps(element, "color");
        String firstTimeUserSize = getCssProps(element, "size");

        js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0\u00a0 " + firstTimeUserSize + " " + firstTimeUserFont + "')); node.style.cssText= 'color: #FF0000;'; document.querySelector('#main > app-login > ion-content > main > section > article:nth-child(2) > div.buttons > p:nth-child(3)').appendChild(node)");

        element = driver.findElement(By.className("version-block"));
        String versionFont = getCssProps(element, "name");
        String versionColor = getCssProps(element, "color");
        String versionSize = getCssProps(element, "size");

        js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0\u00a0 " + versionSize + " " + versionFont + "')); node.style.cssText= 'color: #FF0000;'; document.querySelector('#main > app-login > ion-content > main > section > article:nth-child(2) > p').appendChild(node)");
       /* element = driver.findElement(By.cssSelector("app-text-field[formcontrolname='userId'] article > h4"));
        String fontFamily = getCssProps(element, "name");
        System.out.println("font-family " + fontFamily);
        String color = getCssProps(element, "color");
        System.out.println("color " + color);
        String textAlign = getCssProps(element, "alignment");
        System.out.println("text-align " + textAlign);
        String fontSize = getCssProps(element, "size");
        System.out.println("font-size " + fontSize);*/
    }

    public static String getCssProps(WebElement element, String property) {

        String value = "";

        switch (property) {
            case "color":
                value = element.getCssValue("color");
                break;
            case "size":
                value = element.getCssValue("font-size");
                break;
            case "alignment":
                value = element.getCssValue("text-align");
                break;
            case "font":
                value = element.getCssValue("font-family");
                break;
            default:
                break;
        }

        return value;
    }

    public static void testWriteTestCasesForLogin(int i, String email, String password) {

        createLogin(email, password);
        sleep(1000);
        createTestCase(i);

        sleep(1000);
    }

    public static void writeTestCasesForLogin() {
        WebElement element;

        // case1: username without @ symbol
        String email1 = "surya.obulareddycelllabs.com";
        String password1 = "123456";

        // case2: username without .
        String email2 = "surya.obulareddy@celllabscom";
        String password2 = "123456";

        // case3: wrong email
        String email3 = "surya.obulareddy123@celllabs.com";
        String password3 = "123456";

        // case4: wrong password
        String email4 = "surya.obulareddy@celllabs.com";
        String password4 = "1234567";

        // case5: wrong username and password
        String email5 = "surya.obulareddy123@celllabs.com";
        String password5 = "123456789";

        //correct username and password
        String email = "surya.obulareddy@celllabs.com";
        String password = "123456";

        for (int i = 1; i <= 6; i++) {
            String currentEmail = null;
            String currentPassword = null;
            sleep(2000);
            switch (i) {
                case 1:
                    currentEmail = email1;
                    currentPassword = password1;
                    break;
                case 2:
                    currentEmail = email2;
                    currentPassword = password2;
                    break;
                case 3:
                    currentEmail = email3;
                    currentPassword = password3;
                    break;
                case 4:
                    currentEmail = email4;
                    currentPassword = password4;
                    break;
                case 5:
                    currentEmail = email5;
                    currentPassword = password5;
                    break;
                default:
                    currentEmail = email;
                    currentPassword = password;
                    break;

            }
            createLogin(currentEmail, currentPassword);
            if (i == 6) {
                sleep(2000);
            }
            createTestCase(i);
        }
        sleep(1000);
        logout();

        // for forgot password

        checkFontForgotPassword();
        sleep(5 * 1000);
        refresh();

        forgotPasswordPage();

//        navigateToLogin();

        String currentEmail = "surya.obulareddy@celllabs.com";
        String currentPassword = "123456";
//        createLogin(currentEmail, currentPassword);
        sleep(2000);
        navigateToLogin();
        sleep(2000);


        checkFontForFirstTimeUser();
        sleep(5000);
        refresh();
        firstTimeUserPage(currentEmail);
    }

    protected static void firstTimeUserPage(String email) {
//        WebElement secondClickHereLink = driver.findElement(By.xpath("//*[@id=\"main\"]/app-login/ion-content/main/section/article[2]/div[2]/p[2]/span"));
//
//        secondClickHereLink.click();
        sleep(2000);
        refresh();

        driver.findElement(By.id("email")).sendKeys(email);
        sleep(2000);
        WebElement btnElement = driver.findElement(By.className("primary-button"));
        btnElement.click();

        sleep(1000);
//        logout();
    }

    protected static void testForgotPasswordPage(String type, int i, String lastName, String phoneNumber, String email) {
        refresh();
        switch (type) {
            case "lastName":
                webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("phone-number"))).sendKeys(phoneNumber);
                webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("Email"))).sendKeys(email);
                if (i == 0) {
                    webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("last-name"))).sendKeys(lastName);
                    if (!isDisable())
                        js.executeScript("var newNode = document.createElement('p'); newNode.appendChild(document.createTextNode('last name does not have any numbers')); newNode.style.cssText = 'font-size: 24px; color: #FF0000;'; document.getElementsByTagName('article')[0].appendChild(newNode)");
                } else if (i == 1) {
                    webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("last-name"))).sendKeys(lastName);
                    if (!isDisable())
                        js.executeScript("var newNode = document.createElement('p'); newNode.appendChild(document.createTextNode('last name does not have symbols')); newNode.style.cssText = 'font-size: 24px; color: #FF0000;'; document.getElementsByTagName('article')[0].appendChild(newNode);");
                } else {
                    webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("last-name"))).sendKeys(lastName);
                    if (!isDisable())
                        js.executeScript("var newNode = document.createElement('p'); newNode.appendChild(document.createTextNode('last name does not have combination of numbers and letters')); newNode.style.cssText = 'font-size: 24px; color: #FF0000;'; document.getElementsByTagName('article')[0].appendChild(newNode);");
                }
                break;
            case "phoneNum":
                webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("last-name"))).sendKeys(lastName);
                driver.findElement(By.id("Email")).sendKeys(email);
                if (i == 0) {
                    driver.findElement(By.id("phone-number")).sendKeys(phoneNumber);
                    if (!isDisable())
                        js.executeScript("var newNode = document.createElement('p'); newNode.appendChild(document.createTextNode('mobile number less than 4 digits')); newNode.style.cssText = 'font-size: 24px; color: #FF0000;'; document.getElementsByTagName('article')[0].appendChild(newNode)");
                } else {
                    driver.findElement(By.id("phone-number")).sendKeys(phoneNumber);
                    if (!isDisable())
                        js.executeScript("var newNode = document.createElement('p'); newNode.appendChild(document.createTextNode('mobile number more than 4 digits')); newNode.style.cssText = 'font-size: 24px; color: #FF0000;'; document.getElementsByTagName('article')[0].appendChild(newNode)");
                }

                break;
            case "email":
                webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("last-name"))).sendKeys(lastName);
                driver.findElement(By.id("phone-number")).sendKeys(phoneNumber);
                if (i == 0) {
                    driver.findElement(By.id("Email")).sendKeys(email);
                    if (!isDisable())
                        js.executeScript("var newNode = document.createElement('p'); newNode.appendChild(document.createTextNode('@ is missing')); newNode.style.cssText = 'font-size: 24px; color: #FF0000;'; document.getElementsByTagName('article')[0].appendChild(newNode)");
                } else {
                    driver.findElement(By.id("Email")).sendKeys(email);
                    js.executeScript("var newNode = document.createElement('p'); newNode.appendChild(document.createTextNode('. is missing')); newNode.style.cssText = 'font-size: 24px; color: #FF0000;'; document.getElementsByTagName('article')[0].appendChild(newNode)");
                    clickButton();
                }
                break;
            default:
                if (i == 0) {
                    driver.findElement(By.id("last-name")).sendKeys(lastName);
                    driver.findElement(By.id("phone-number")).sendKeys(phoneNumber);
                    driver.findElement(By.id("Email")).sendKeys(email);
                    if (!isDisable())
                        js.executeScript("var newNode = document.createElement('p'); newNode.appendChild(document.createTextNode('wrong details entered')); newNode.style.cssText = 'font-size: 24px; color: #FF0000;'; document.getElementsByTagName('article')[0].appendChild(newNode);");
                } else {
                    webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("last-name"))).sendKeys(lastName);
                    driver.findElement(By.id("phone-number")).sendKeys(phoneNumber);
                    driver.findElement(By.id("Email")).sendKeys(email);
                }

        }
        sleep(1000);
      /*  // case: wrong details
        sleep(1000);

         sleep(2000);

        // case 5: correct details

        sleep(1000);*/

    }

    protected static void forgotPasswordPage() {
        WebElement element;
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        element = selectXpath("//*[@id=\"main\"]/app-login/ion-content/main/section/article[2]/div[2]/p[1]/a");
//        element.click();
        sleep(2000);

        //case 1: last name with numbers or symbols
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    Common.selectById("last-name").sendKeys("local123");
                    break;
                case 1:
                    Common.selectById("last-name").sendKeys("local@");
                    break;
                case 2:
                    Common.selectById("last-name").sendKeys("local@123");
                    break;

            }
            Common.selectById("phone-number").sendKeys("2890");
            Common.cssSelect("#main > app-verify-user > ion-content > main > article:nth-child(2) > div > app-text-field > main > article > input").sendKeys("surya.obulareddy@celllabs.com");

            System.out.println("button enabled " + isDisable());
            if (!isDisable()) {
                if (i == 0) {
                    js.executeScript("var newNode = document.createElement('p'); newNode.appendChild(document.createTextNode('last name does not have any numbers')); newNode.style.cssText = 'font-size: 24px; color: #FF0000;'; document.getElementsByTagName('article')[0].appendChild(newNode)");
                } else if (i == 1) {
                    js.executeScript("var newNode = document.createElement('p'); newNode.appendChild(document.createTextNode('last name does not have symbols')); newNode.style.cssText = 'font-size: 24px; color: #FF0000;'; document.getElementsByTagName('article')[0].appendChild(newNode);");
                } else {
                    js.executeScript("var newNode = document.createElement('p'); newNode.appendChild(document.createTextNode('last name does not have combination of numbers and letters')); newNode.style.cssText = 'font-size: 24px; color: #FF0000;'; document.getElementsByTagName('article')[0].appendChild(newNode);");
                }
            }
            sleep(2000);
            refresh();
        }

        sleep(2000);

        //case 2: mobile number case
        for (int i = 0; i < 2; i++) {
            Common.selectById("last-name").sendKeys("local");
            switch (i) {
                case 0:
                    Common.selectById("phone-number").sendKeys("123");
                    break;
                case 1:
                    Common.selectById("phone-number").sendKeys("12345");
                    break;
            }
            Common.selectById("Email").sendKeys("surya.obulareddy@celllabs.com");
            if (!isDisable()) {
                js.executeScript("var newNode = document.createElement('p'); newNode.appendChild(document.createTextNode('mobile number must be 4 digits')); newNode.style.cssText = 'font-size: 24px; color: #FF0000;'; document.getElementsByTagName('article')[0].appendChild(newNode)");
            }
            sleep(1000);
            refresh();

        }

        //case 3: check email case
        for (int i = 0; i < 2; i++) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("last-name"))).sendKeys("local");
            driver.findElement(By.id("phone-number")).sendKeys("2890");
            switch (i) {
                case 0:
                    driver.findElement(By.id("Email")).sendKeys("surya.obulareddy@celllabscom");
                    break;
                case 1:
                    driver.findElement(By.id("Email")).sendKeys("surya.obulareddycelllabs.com");
                    break;
            }
            clickButton();
            if (i == 0) {
                js.executeScript("var newNode = document.createElement('p'); newNode.appendChild(document.createTextNode('. is missing')); newNode.style.cssText = 'font-size: 24px; color: #FF0000;'; document.getElementsByTagName('article')[0].appendChild(newNode)");
            } else {
                js.executeScript("var newNode = document.createElement('p'); newNode.appendChild(document.createTextNode('@ is missing')); newNode.style.cssText = 'font-size: 24px; color: #FF0000;'; document.getElementsByTagName('article')[0].appendChild(newNode)");
            }
            sleep(1000);
            refresh();
        }


        // case 4: wrong details
        sleep(1000);
        refresh();
        driver.findElement(By.id("last-name")).sendKeys("local");
        driver.findElement(By.id("phone-number")).sendKeys("1235");
        driver.findElement(By.id("Email")).sendKeys("surya.obulareddy@celllabs.com");
        element = driver.findElement(By.className("primary-button"));
        js.executeScript("var newNode = document.createElement('p'); newNode.appendChild(document.createTextNode('wrong details entered')); newNode.style.cssText = 'font-size: 24px; color: #FF0000;'; document.getElementsByTagName('article')[0].appendChild(newNode);");
        sleep(2000);


        // case 5: correct details
        refresh();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("last-name"))).sendKeys("local");
        driver.findElement(By.id("phone-number")).sendKeys("2890");
        driver.findElement(By.id("Email")).sendKeys("surya.obulareddy@celllabs.com");
        element = driver.findElement(By.className("primary-button"));

        sleep(1000);

       /* element.click();
        sleep(1000);
        refresh();
        sleep(15 * 1000);
        WebElement btnElement = driver.findElement(By.className("primary-button"));
        btnElement.click();

        sleep(1000);
        refresh();
        driver.findElement(By.id("newpassword")).sendKeys("123456");
        driver.findElement(By.id("confirmpassword")).sendKeys("123456");

        sleep(1000);
        btnElement  = driver.findElement(By.className("primary-button"));
//        sleep(1000);
        btnElement.click();*/

    }

    public static void showPassword() {
        WebElement showButton = driver.findElement(By.cssSelector("#main > app-login > ion-content > main > section > article:nth-child(2) > div.text-field > div > app-text-field > main > section > img"));
        showButton.click();
    }

    private static void clickButton() {
        WebElement btnElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.className("primary-button")));
        btnElement.click();
    }

    protected static void refresh() {
        driver.navigate().refresh();
        sleep(1000);
    }

    private static boolean isDisable() {
        return Common.isElementPresent(By.className("primary-button"));
    }

    protected static void navigateToLogin() {
        driver.navigate().to(baseUrl + "/#/login");
    }


    protected static void logout() {
        driver.navigate().to(baseUrl + "#/home/more");
        sleep(1500);
        driver.findElement(By.className("logout-button")).click();
        sleep(2000);
    }

    public static String createLogin(String email, String password) {
        sleep(2000);
        refresh();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("email"))).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        showPassword();
        sleep(2000);
        WebElement element = driver.findElement(By.className("primary-button"));
        element.click();
        sleep(5000);
        Common.takeScreenShot(Common.baseScreenShotPath+"Login"+(++Common.screenShotNum)+".png");

        return driver.getCurrentUrl();

    }

    private static void createTestCase(int i) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (driver.getCurrentUrl().equalsIgnoreCase(baseUrl + "#/login")) {
            switch (i) {
                case 1:
                    js.executeScript("var newNode = document.createElement('p'); newNode.appendChild(document.createTextNode('@ is missing')); newNode.style.cssText = 'font-size: 24px; color: #FF0000;'; document.getElementsByTagName('article')[2].appendChild(newNode);");
                    break;
                case 2:
                    js.executeScript("var newNode = document.createElement('p'); newNode.appendChild(document.createTextNode('. is missing')); newNode.style.cssText = 'font-size: 24px; color: #FF0000;'; document.getElementsByTagName('article')[2].appendChild(newNode);");
                    break;
                case 3:
                    js.executeScript("var newNode = document.createElement('p'); newNode.appendChild(document.createTextNode('Wrong email')); newNode.style.cssText = 'font-size: 24px; color: #FF0000;'; document.getElementsByTagName('article')[2].appendChild(newNode);");
                    break;
                case 4:
                    js.executeScript("var newNode = document.createElement('p'); newNode.appendChild(document.createTextNode('Wrong password')); newNode.style.cssText = 'font-size: 24px; color: #FF0000;'; document.getElementsByTagName('article')[2].appendChild(newNode);");
                    break;
                case 5:
                    js.executeScript("var newNode = document.createElement('p'); newNode.appendChild(document.createTextNode('User name and Password wrong')); newNode.style.cssText = 'font-size: 24px; color: #FF0000;'; document.getElementsByTagName('article')[2].appendChild(newNode);");
                    break;
            }
        } else if (driver.getCurrentUrl().equalsIgnoreCase(baseUrl + "#/home/systems")) {
            System.out.println("test case " + i + " successfull");
        } else {
            System.out.println("test case " + i + " failed");
        }
    }

    public static void sleep(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static void homePageFont() {
        WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-systems > ion-content > main > div > app-search-bar > article > input")));
        String searchFont = getCssProps(element, "name");
        String searchFontSize = getCssProps(element, "size");

        js.executeScript("var elem = document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-systems > ion-content > main > div > app-search-bar > article > input'); elem.value = 'Search Systems " + searchFont + " " + searchFontSize + "'; elem.style.cssText='color: #FF0000'");


        element = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-systems > ion-content > main > section > app-system-card:nth-child(1) > section > article:nth-child(2) > h3")));
        String systemNameFont = getCssProps(element, "name");
        String systemNameFontSize = getCssProps(element, "size");

        js.executeScript("var newNode = document.createElement('span');  newNode.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + systemNameFont + " " + systemNameFontSize + "')); document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-systems > ion-content > main > section > app-system-card:nth-child(1) > section > article:nth-child(2) > h3').appendChild(newNode); newNode.style.cssText='color: color:#13d471'");

        element = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-systems > ion-content > main > section > app-system-card:nth-child(1) > section > h4")));
        String lastActivityFont = getCssProps(element, "name");
        String lastActivityFontSize = getCssProps(element, "size");
        js.executeScript("var newNode = document.createElement('span');  newNode.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + lastActivityFont + " " + lastActivityFontSize + "')); document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-systems > ion-content > main > section > app-system-card:nth-child(1) > section > h4').appendChild(newNode); newNode.style.cssText='color: color:#13d471'");

        //alert Tab
        element = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tab-button-alerts > p")));
        String alertTabFont = getCssProps(element, "name");
        String alertTabFontSize = getCssProps(element, "size");
        js.executeScript("var newNode = document.createElement('span');  newNode.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + alertTabFont + " " + alertTabFontSize + "')); document.querySelector('#tab-button-alerts > p').appendChild(newNode); newNode.style.cssText='color: #FF0000'");

        //system Tab
        element = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tab-button-systems > p")));
        String systemsTabFont = getCssProps(element, "name");
        String systemsTabFontSize = getCssProps(element, "size");
        js.executeScript("var newNode = document.createElement('span');  newNode.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + systemsTabFont + " " + systemsTabFontSize + "')); document.querySelector('#tab-button-systems > p').appendChild(newNode); newNode.style.cssText='color: #FF0000'");

        //account Tab
        element = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tab-button-my-account > p")));
        String accountTabFont = getCssProps(element, "name");
        String accountTabFontSize = getCssProps(element, "size");
        js.executeScript("var newNode = document.createElement('span');  newNode.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + accountTabFont + " " + accountTabFontSize + "')); document.querySelector('#tab-button-my-account > p').appendChild(newNode); newNode.style.cssText='color: #FF0000'");

        //more tab
        element = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tab-button-more > p")));
        String moreTabFont = getCssProps(element, "name");
        String moreTabFontSize = getCssProps(element, "size");
        js.executeScript("var newNode = document.createElement('span');  newNode.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + moreTabFont + " " + moreTabFontSize + "')); document.querySelector('#tab-button-more > p').appendChild(newNode); newNode.style.cssText='color: #FF0000'");

        sleep(2000);
        refresh();
    }

    protected static void homePage() {
        sleep(2000);
        Common.selectXpath("//*[@id=\"main\"]/app-home/ion-tabs/div/ion-router-outlet/app-systems/ion-content/main/section/app-system-card[1]/section").click();
        sleep(1000);
        System.out.println("url "+driver.getCurrentUrl());
        if (driver.getCurrentUrl().contains(baseUrl + "#/home/systems/")) {
            System.out.println("ok");
            driver.navigate().back();
        } else {
            System.out.println("there is problem");
        }
        sleep(2000);
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-systems > ion-content > main > section > app-system-card:nth-child(1) > section > div > img:nth-child(2)").click();

        //click alert Settings
//            cssSelect("body > app-root > ion-app > app-menu > ion-menu > main > section > app-options-btn:nth-child(1) > article").click();

        //edit sensor names
        sleep(1000);
        Common.cssSelect("body > app-root > ion-app > app-menu > ion-menu > main > section > app-options-btn:nth-child(2)").click();
        sleep(1000);
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-sensor-names > ion-content > main > section > app-text-field.system-name.ng-valid.ng-touched.ng-dirty > main > section > div > img").click();

    }

    protected static void checkBottomNavigation() {
        // alerts
        Common.cssSelect("#tab-button-alerts > p").click();
        sleep(3000);
        if (driver.getCurrentUrl().contains(baseUrl + "#/home/alerts")) {
            driver.navigate().back();
        } else {
            System.out.println("there is problem in navigating to alerts page");
        }
        sleep(3000);
        //account
        Common.cssSelect("#tab-button-my-account > p").click();
        sleep(3000);
        if (driver.getCurrentUrl().contains(baseUrl + "#/home/my-account")) {
            driver.navigate().back();
        } else {
            System.out.println("there is problem in navigating to account page");
        }
        sleep(3000);

        //more
        Common.cssSelect("#tab-button-more > p").click();
        sleep(3000);
        if (driver.getCurrentUrl().contains(baseUrl + "#/home/more")) {
            driver.navigate().back();
        } else {
            System.out.println("there is problem in navigating to more page");
        }
        sleep(3000);


    }

    private static void writeAllTests(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
        driver.findElement(By.id("email")).sendKeys("surya.obulareddy@celllabs.com");
        driver.findElement(By.id("password")).sendKeys("123456");

        WebElement element = driver.findElement(By.className("primary-button"));
        element.click();
        Thread.sleep(2000);

        driver.navigate().to(baseUrl + "/#/home/more");
        Thread.sleep(2000);
        WebElement usersElement = driver.findElement(By.cssSelector("app-options-btn[ng-reflect-label='Users']"));
        usersElement.click();
        Thread.sleep(2000);

        WebElement h4Element = driver.findElement(By.cssSelector("article[_ngcontent-ng-c719058403='']"));

        h4Element.click();
        Thread.sleep(2000);

        //1 test case
//      WebElement dropdownContainer = driver.findElement(By.className("custom-scrollbar"));
//      List<WebElement> dropdownOptions = dropdownContainer.findElements(By.tagName("p"));
//      WebElement selectElement = driver.findElement(By.cssSelector("p[_ngcontent-ng-c719058403='']"));
//      selectElement.click();


//      String selectElement = "//article[@class='custom-scrollbar']/p[text()='30 min']"; // XPath of the element to be selected
//      WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
//      WebElement elem = driver.findElement(By.xpath(selectElement));
//      Select select = new Select(elem);
//      select.selectByVisibleText("30 min");
        String durationNumber = "3";
        String cssSelector = "article.custom-scrollbar > p:nth-child(" + durationNumber + ")";
        WebElement elem = driver.findElement(By.cssSelector(cssSelector)); // Find the second element
        elem.click();
        Thread.sleep(2000);
        WebElement superVisorsClick = driver.findElement(By.cssSelector("app-user-block[ng-reflect-user-role='13'] header h3"));
        superVisorsClick.click();
        Thread.sleep(2000);

//      scrollDown(driver);

        String supervisorsName = "Vinod Balagoni";
        WebElement supervisorsDropdownClick = driver.findElement(By.cssSelector("app-user-tile[ng-reflect-name='" + supervisorsName + "'] article[_ngcontent-ng-c719058403='']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", supervisorsDropdownClick);
        Thread.sleep(1000);
        supervisorsDropdownClick.click();

        WebElement elem1 = driver.findElement(By.cssSelector(cssSelector)); // Find the second element
        elem1.click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().to(baseUrl + "/#/home/alerts");
        Thread.sleep(1000);
        WebElement addAlertClick = driver.findElement(By.cssSelector("app-add-button[ng-reflect-button-name='Add Alert']"));
        addAlertClick.click();
        Thread.sleep(1000);
        driver.findElement(By.id("description")).sendKeys("New Alert");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("app-multi-select")).click();
        Thread.sleep(1000);
        String SystemNumber = "3";
        String systemSelector = "article.custom-scrollbar > p:nth-child(" + SystemNumber + ")";
        driver.findElement(By.cssSelector(systemSelector)).click();
        Thread.sleep(1000);
        driver.findElement(By.id("what-happened")).sendKeys("i am adding this alert for testing purpose");

    }

    public static void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    public static void scrollToMiddle(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long windowHeight = (long) js.executeScript("return window.innerHeight");
        long fullHeight = (long) js.executeScript("return document.body.scrollHeight");
        long middle = fullHeight / 2 - windowHeight / 2;
        js.executeScript("window.scrollTo(0, arguments[0])", middle);
    }

    public static void scrollToMiddleOfCustomScrollbar(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Execute JavaScript to find the custom scrollbar element
        String script = "return document.querySelector('.custom-scrollbar')";
        Object scrollbarElement = js.executeScript(script);

        if (scrollbarElement != null) {
            // Get the height of the scrollbar
            Long scrollbarHeight = (Long) js.executeScript("return arguments[0].clientHeight", scrollbarElement);
            // Calculate the position to scroll to (middle)
            Long middlePosition = scrollbarHeight / 2;
            // Scroll the custom scrollbar to the middle position
            js.executeScript("arguments[0].scrollTop = arguments[1]", scrollbarElement, middlePosition);
        } else {
            System.out.println("Custom scrollbar element not found!");
        }
    }

}