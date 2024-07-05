package com.celllabs;

import com.aventstack.extentreports.ExtentTest;
import com.celllabs.shared.Common;
import com.celllabs.shared.CommonTest;
import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.celllabs.More.*;

public class MoreTest extends TestCase {
    public void testMore(){
//        CommonTest.setUpReport();

//       Common.openChrome();
        ExtentTest test = CommonTest.createTest("More Page Test");
//        createLogin("shivani.p@celllabs.com","123456",driver1);
        createLogin("pranay.prasad@celllabs.com","123456", App.driver);

//        if(driver1.getCurrentUrl().equalsIgnoreCase(teamUrl)){
//           driver1.findElement(By.cssSelector("#main > app-select-team > ion-content > main > section > article > app-options-btn:nth-child(1) > section")).click();
//            driver1.findElement(By.cssSelector("#main > app-select-team > ion-content > main > button")).click();
//        }
        if(App.driver.getCurrentUrl().equalsIgnoreCase(App.teamUrl)){
            Common.cssSelect("#main > app-select-team > ion-content > main > section > article > app-options-btn:nth-child(1) > section").click();
            Common.cssSelect("#main > app-select-team > ion-content > main > button").click();
        }
        clickOnMore();
        clickOnUsersPage();
       // editUser(2,"shivani pandra","hhhv","shivani.p@celllabs.com");

//        clickOnMore();
//        morePageFont();



//        clickOnUsersPage();

//        addUser("caregiver","krishna","k","9665543862","krishna.k@celllabs.com",1);
//        falseAlerts();

    }
    public static String createLogin(String email, String password, WebDriver driver) {
        App.sleep(3000);
        App.refresh();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("email"))).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        App.showPassword();
        App.sleep(2000);
        WebElement element = driver.findElement(By.className("primary-button"));
        element.click();
        App.sleep(5000);
//        if (driver.getCurrentUrl().equalsIgnoreCase(baseUrl + "#/home/systems")) {
        return driver.getCurrentUrl();
//        } else {
//            return false;
//        }
//        sleep(2000);
    }

}