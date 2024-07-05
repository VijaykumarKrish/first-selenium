package com.celllabs;

import com.celllabs.shared.Common;
import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;

import org.openqa.selenium.devtools.v126.browser.Browser;
import org.openqa.selenium.devtools.v126.network.Network;
import org.openqa.selenium.devtools.v126.network.model.RequestWillBeSent;
import org.openqa.selenium.devtools.v126.network.model.Response;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.celllabs.ActivityPage.*;
import static com.celllabs.App.*;
import static com.celllabs.App.driver;


public class ActivityPageTest extends TestCase {

    protected static final ThreadLocal<List<RequestWillBeSent>> REQUESTS = ThreadLocal.withInitial(ArrayList::new);

    public void testActivity(){

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("devtools.version", "v1.0");
//        System.setProperty(chromeDriver, chromeDriverPath);
        System.setProperty(firefoxDriver, firefoxDriverPath);
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();
//        options.setCapability(CapabilityType);
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

//        options.addArguments("devtools.version", "v1.0");
//        FirefoxProfile profile = new FirefoxProfile();
//        profile.setPreference("devtools.chrome.enabled", true);
//        profile.setPreference("devtools.debugger.enabled", true);
//        options.setProfile(profile);
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
//        openChrome();
//        ChromeOptions options = new ChromeOptions();

//        options.addArguments("--auto-open-devtools-for-tabs");
//        options.addArguments("--remote-debugging-port=9222");
//        options.addArguments("--devtools");
//        driver = new FirefoxDriver(options);

        DevTools devTools = ((HasDevTools) driver).getDevTools();
        System.out.println(Browser.getVersion());
//        devTools.send(Browser.getVersion());
//        HttpClient client = null;
        
//        DevTools devTools1 = new DevTools(devTools2 -> {},new Connection(client,"http"));

        devTools.createSession();
//        devTools.getDomains().network();
//        devTools.createSession();
//        devTools.createSession("");
//        devTools.getCdpSession();
//        devTools.send(Network.enable(true));
//        devTools.createSession();

//        driver.switchTo().window("devtools");
       /* v125Network v125Net = new v125Network(devTools);
        v125Net.createSeMessages(new RequestPaused());*/






        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

//        devTools.getDomains().network().
        devTools.addListener(Network.requestWillBeSent(),
                entry -> REQUESTS.get().add(entry));
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            Response response = responseReceived.getResponse();
            System.out.println("URL: " + response.getUrl());
            System.out.println("Status: " + response.getStatus());
            System.out.println("Response: " + response.getStatusText());
        });

        driver.get(baseUrl);



        driver.findElement(By.id("email")).sendKeys("pranay.prasad@celllabs.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        showPassword();
        sleep(2000);
        WebElement element = driver.findElement(By.className("primary-button"));
        element.click();

        String scriptToExecute = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
//        String netData = ((JavascriptExecutor)driver).executeScript(scriptToExecute).toString();
        driver.manage().window().maximize();


        //        WebDriverManager.chromedriver().setup();





        if(driver.getCurrentUrl().equalsIgnoreCase(teamUrl)){
            Common.cssSelect("#main > app-select-team > ion-content > main > section > article > app-options-btn:nth-child(1) > section").click();
            Common.cssSelect("#main > app-select-team > ion-content > main > button").click();
        }
//        goToActivityPage(2);
        clickSystem("2");


        Object json1 = js.executeScript("return JSON.stringify(network.getRequests())");

        js.executeScript("console.log('Opening Network Tab');");
        js.executeScript("const devtools = window.open('about:blank', '_blank');");
        js.executeScript("devtools.location.href = 'devtools://devtools/bundled/inspector.html';");

        // Switch to the DevTools window
        driver.switchTo().window("devtools");

        // Switch to the Network tab
        driver.findElement(By.cssSelector("li[aria-label='Network']")).click();

        // Perform actions to generate network requests (e.g., clicking links, submitting forms)
        driver.switchTo().window("devtools").findElement(By.cssSelector("button#reload")).click();

        // Extract network request data
        WebElement requestsTable = driver.findElement(By.cssSelector("div.network-log-grid"));
        for (WebElement requestRow : requestsTable.findElements(By.cssSelector("div.network-log-row"))) {
            String url = requestRow.findElement(By.cssSelector("a.network-log-url")).getAttribute("href");
            String method = requestRow.findElement(By.cssSelector("span.network-log-request-method")).getText();
            String status = requestRow.findElement(By.cssSelector("span.network-log-status-cell-text")).getText();
            System.out.println("URL: " + url);
            System.out.println("Method: " + method);
            System.out.println("Status: " + status);
            System.out.println("------------------------");
        }
//        activityCheck(14);
    }
}