package com.celllabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.celllabs.App.*;
import static com.celllabs.shared.Common.cssSelect;

public class EditSensorPage {
    public static void goToSystemSettings(int system){
        cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-systems > ion-content > main > section > app-system-card:nth-child("+system+") > section > div > img:nth-child(2)").click();
    }
    public static void clickEditSensorNames(){
        cssSelect("body > app-root > ion-app > app-menu > ion-menu > main > section > app-options-btn:nth-child(2) > section").click();
        sleep(1000);
        refresh();
    }
    public static String changeSystemName(String systemName){
        List<WebElement> sensorsList = driver.findElements(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-sensor-names > ion-content > main > section > app-text-field"));
        WebElement element;
        for (int index = 0; index < sensorsList.size(); index++) {
            element = sensorsList.get(index);
            String text = element.findElement(By.cssSelector("main > article > h4")).getText();

            if(text.equalsIgnoreCase("SYSTEM NAME")){
                element.findElement(By.cssSelector("main > section > div > img")).click();
                element.findElement(By.cssSelector("main > article > input")).clear();
                element.findElement(By.cssSelector("main > article > input")).sendKeys(systemName);

                element.findElement(By.cssSelector("main > section > article > img:nth-child(3)")).click();

                return cssSelect(".system-name > main:nth-child(1) > article:nth-child(1) > p:nth-child(2)").getText();
            }
            System.out.println(text);
        }
        return null;
    }
    public static String changeToiletSensorName(String systemName){
        sleep(1000);
        List<WebElement> sensorsList = driver.findElements(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-sensor-names > ion-content > main > section > app-text-field"));
        WebElement element;
        for (int index = 0; index < sensorsList.size(); index++) {
            element = sensorsList.get(index);
            System.out.println(element);
            String text = element.findElement(By.cssSelector("main > article > h4")).getText();

            if(text.equalsIgnoreCase("TOILET")){
                element.findElement(By.cssSelector("main > section > div > img")).click();
                element.findElement(By.cssSelector("main > article > input")).clear();
                element.findElement(By.cssSelector("main > article > input")).sendKeys(systemName);

                element.findElement(By.cssSelector("main > section > article > img:nth-child(2)")).click();

                return cssSelect(".custom-scrollbar > app-text-field:nth-child("+ (index+1) +") > main:nth-child(1) > article:nth-child(1) > p:nth-child(2)").getText();
            }
            System.out.println(text);
        }
        return null;
    }
    public static String changeBedSensorName(String systemName){
        sleep(1000);
        List<WebElement> sensorsList = driver.findElements(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-sensor-names > ion-content > main > section > app-text-field"));
        WebElement element;
        for (int index = 0; index < sensorsList.size(); index++) {
            element = sensorsList.get(index);
            String text = element.findElement(By.cssSelector("main > article > h4")).getText();

            if(text.equalsIgnoreCase("BED SENSOR")){
                element.findElement(By.cssSelector("main > section > div > img")).click();
                element.findElement(By.cssSelector("main > article > input")).clear();
                element.findElement(By.cssSelector("main > article > input")).sendKeys(systemName);

                element.findElement(By.cssSelector("main > section > article > img:nth-child(2)")).click();
                return cssSelect(".custom-scrollbar > app-text-field:nth-child("+ (index+1) +") > main:nth-child(1) > article:nth-child(1) > p:nth-child(2)").getText();
            }
            System.out.println(text);
        }
        return null;
    }
    private static String getText(WebElement element){
        return webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, By.cssSelector("main > article > p"))).getText();
    }

}
