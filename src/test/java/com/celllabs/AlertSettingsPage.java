package com.celllabs;

import com.celllabs.shared.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentTest;

import java.util.List;

import static com.celllabs.App.*;

public class AlertSettingsPage {
    protected static void clickSystem(String number) {
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-systems > ion-content > main > section > app-system-card:nth-child(" + number + ") > section > div > img:nth-child(2)").click();
    }

    protected static void goToAlertSetting() {
        Common.cssSelect("body > app-root > ion-app > app-menu > ion-menu > main > section > app-options-btn:nth-child(1)").click();
        sleep(2000);
        refresh();
        sleep(2000);
    }
    protected static void noActivity(String status, String call, String text, ExtentTest test) {
        List<WebElement> alertsList = driver.findElements(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > section > app-alert-settings-block"));
        for (int index = 0; index < alertsList.size(); index++) {
            WebElement element = alertsList.get(index);
            String alertText = element.findElement(By.cssSelector("section > article > h3")).getText();
            if(alertText.equalsIgnoreCase("No Activity")){
                test.info("no activity test started");
                String activateStatus = element.findElement(By.cssSelector("section > article > span > p")).getText();
                switch (activateStatus){
                    case "Activated":
                        if(status.equalsIgnoreCase("on")){
                            String prevCallValue = element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle > input")).getAttribute("value");
                            if(prevCallValue.equalsIgnoreCase("on") && call.equalsIgnoreCase("off")){
                                element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle")).click();
                                test.pass("no activity call changed test");
                            }else if(!prevCallValue.equalsIgnoreCase("on") && call.equalsIgnoreCase("on")) {
                                element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle")).click();
                                test.pass("no activity call changed test");
                            }

                            String prevTextValue = element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle > input")).getAttribute("value");
                            if(prevTextValue.equalsIgnoreCase("on") && text.equalsIgnoreCase("off")){
                                element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle")).click();
                                test.pass("no activity text changed test");
                            }else if(!prevTextValue.equalsIgnoreCase("on") && text.equalsIgnoreCase("on")) {
                                element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle")).click();
                                test.pass("no activity text changed test");
                            }
                        }else{
                            element.findElement(By.cssSelector("section > article:nth-child(1) > span > ion-toggle")).click();
                            test.pass("no activity disabled test");
                        }
                        break;
                    default:
                        if(status.equalsIgnoreCase("on")){
                            element.findElement(By.cssSelector("section > article:nth-child(1) > span > ion-toggle")).click();
                            String prevCallValue = element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle > input")).getAttribute("value");
                            if(prevCallValue.equalsIgnoreCase("on") && call.equalsIgnoreCase("off")){
                                element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle")).click();
                                test.pass("no activity text changed test");
                            }else if(!prevCallValue.equalsIgnoreCase("on") && call.equalsIgnoreCase("on")) {
                                element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle")).click();
                                test.pass("no activity text changed test");
                            }

                            String prevTextValue = element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle > input")).getAttribute("value");
                            if(prevTextValue.equalsIgnoreCase("on") && text.equalsIgnoreCase("off")){
                                element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle")).click();
                                test.pass("no activity call changed test");
                            }else if(!prevTextValue.equalsIgnoreCase("on") && text.equalsIgnoreCase("on")) {
                                element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle")).click();
                                test.pass("no activity call changed test");
                            }
                        }
                        break;
                }
                break;
            }
        }

    }
    protected static void helpButton(String status, String call, String text, ExtentTest test){
        List<WebElement> alertsList = driver.findElements(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > section > app-alert-settings-block"));
        for (int index = 0; index < alertsList.size(); index++) {
            WebElement element = alertsList.get(index);
            String alertText = element.findElement(By.cssSelector("section > article > h3")).getText();

            if(alertText.equalsIgnoreCase("Help Button")){
                test.info("Help Button test started");
                String activateStatus = element.findElement(By.cssSelector("section > article > span > p")).getText();
                switch (activateStatus){
                    case "Activated":
                        if(status.equalsIgnoreCase("on")){
                            String prevCallValue = element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle > input")).getAttribute("value");
                            if(prevCallValue.equalsIgnoreCase("on") && call.equalsIgnoreCase("off")){
                                element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle")).click();
                                test.pass("Help Button call changed test");
                            }else if(!prevCallValue.equalsIgnoreCase("on") && call.equalsIgnoreCase("on")) {
                                element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle")).click();
                                test.pass("Help Button call changed test");
                            }

                            String prevTextValue = element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle > input")).getAttribute("value");
                            System.out.println(prevTextValue);
                            if(prevTextValue.equalsIgnoreCase("on") && text.equalsIgnoreCase("off")){
                                element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle")).click();
                                test.pass("Help Button text changed test");
                            }else if(!prevTextValue.equalsIgnoreCase("on") && text.equalsIgnoreCase("on")) {
                                element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle")).click();
                                test.pass("Help Button text changed test");
                            }
                        }else{
                            element.findElement(By.cssSelector("section > article:nth-child(1) > span > ion-toggle")).click();
                            test.pass("Help Button disabled test");
                        }
                        break;
                    default:
                        if(status.equalsIgnoreCase("on")){
                            element.findElement(By.cssSelector("section > article:nth-child(1) > span > ion-toggle")).click();
                            String prevCallValue = element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle > input")).getAttribute("value");
                            if(prevCallValue.equalsIgnoreCase("on") && call.equalsIgnoreCase("off")){
                                element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle")).click();
                                test.pass("Help Button call changed test");
                            }else if(!prevCallValue.equalsIgnoreCase("on") && call.equalsIgnoreCase("on")) {
                                element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle")).click();
                                test.pass("Help Button call changed test");
                            }

                            String prevTextValue = element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle > input")).getAttribute("value");
                            if(prevTextValue.equalsIgnoreCase("on") && text.equalsIgnoreCase("off")){
                                element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle")).click();
                                test.pass("Help Button text changed test");
                            }else if(!prevTextValue.equalsIgnoreCase("on") && text.equalsIgnoreCase("on")) {
                                element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle")).click();
                                test.pass("Help Button text changed test");
                            }
                        }
                        break;
                }
                break;
            }
        }
    }
    protected static void fallDetection(String status, String call, String text, ExtentTest test){
        List<WebElement> alertsList = driver.findElements(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > section > app-alert-settings-block"));
        for (int index = 0; index < alertsList.size(); index++) {
            WebElement element = alertsList.get(index);
            String alertText = element.findElement(By.cssSelector("section > article > h3")).getText();
            System.out.println(element+" ****** "+alertText);
            if(alertText.equalsIgnoreCase("Fall Detection")){
                test.info("Fall Detection test started");
                String activateStatus = element.findElement(By.cssSelector("section > article > span > p")).getText();
                System.out.println(activateStatus);
                switch (activateStatus){
                    case "Activated":
                        if(status.equalsIgnoreCase("on")){
                            String prevCallValue = element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle > input")).getAttribute("value");
                            if(prevCallValue.equalsIgnoreCase("on") && call.equalsIgnoreCase("off")){
                                element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle")).click();
                                test.pass("Fall Detection call changed test");
                            }else if(!prevCallValue.equalsIgnoreCase("on") && call.equalsIgnoreCase("on")) {
                                element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle")).click();
                                test.pass("Fall Detection call changed test");
                            }

                            String prevTextValue = element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle > input")).getAttribute("value");
                            System.out.println(prevTextValue);
                            if(prevTextValue.equalsIgnoreCase("on") && text.equalsIgnoreCase("off")){
                                element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle")).click();
                                test.pass("Fall Detection text changed test");
                            }else if(!prevTextValue.equalsIgnoreCase("on") && text.equalsIgnoreCase("on")) {
                                element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle")).click();
                                test.pass("Fall Detection text changed test");
                            }
                        }else{
                            element.findElement(By.cssSelector("section > article:nth-child(1) > span > ion-toggle")).click();
                            test.pass("Fall Detection disabled test");
                        }
                        break;
                    default:
                        if(status.equalsIgnoreCase("on")){
                            element.findElement(By.cssSelector("section > article:nth-child(1) > span > ion-toggle")).click();
                            String prevCallValue = element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle > input")).getAttribute("value");
                            if(prevCallValue.equalsIgnoreCase("on") && call.equalsIgnoreCase("off")){
                                element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle")).click();
                                test.pass("Fall Detection call changed test");
                            }else if(!prevCallValue.equalsIgnoreCase("on") && call.equalsIgnoreCase("on")) {
                                element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle")).click();
                                test.pass("Fall Detection call changed test");
                            }

                            String prevTextValue = element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle > input")).getAttribute("value");
                            if(prevTextValue.equalsIgnoreCase("on") && text.equalsIgnoreCase("off")){
                                element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle")).click();
                                test.pass("Fall Detection text changed test");
                            }else if(!prevTextValue.equalsIgnoreCase("on") && text.equalsIgnoreCase("on")) {
                                element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle")).click();
                                test.pass("Fall Detection text changed test");
                            }
                        }
                        break;
                }
                break;
            }
        }
    }

    protected static void temperature(String status, String call, String text, ExtentTest test){
        List<WebElement> alertsList = driver.findElements(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > section > app-alert-settings-block"));
        for (int index = 0; index < alertsList.size(); index++) {
            WebElement element = alertsList.get(index);
            String alertText = element.findElement(By.cssSelector("section > article > h3")).getText();

            if(alertText.equalsIgnoreCase("Temperature")){
                test.info("Temperature test started");
                String activateStatus = element.findElement(By.cssSelector("section > article > span > p")).getText();
                System.out.println(activateStatus);
                switch (activateStatus){
                    case "Activated":
                        if(status.equalsIgnoreCase("on")){
                            String prevCallValue = element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle > input")).getAttribute("value");
                            if(prevCallValue.equalsIgnoreCase("on") && call.equalsIgnoreCase("off")){
                                element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle")).click();
                                test.pass("Temperature call changed test");
                            }else if(!prevCallValue.equalsIgnoreCase("on") && call.equalsIgnoreCase("on")) {
                                element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle")).click();
                                test.pass("Temperature call changed test");
                            }

                            String prevTextValue = element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle > input")).getAttribute("value");
                            System.out.println(prevTextValue);
                            if(prevTextValue.equalsIgnoreCase("on") && text.equalsIgnoreCase("off")){
                                element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle")).click();
                                test.pass("Temperature text changed test");
                            }else if(!prevTextValue.equalsIgnoreCase("on") && text.equalsIgnoreCase("on")) {
                                element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle")).click();
                                test.pass("Temperature text changed test");
                            }
                        }else{
                            element.findElement(By.cssSelector("section > article:nth-child(1) > span > ion-toggle")).click();
                            test.pass("Temperature disabled test");
                        }
                        break;
                    default:
                        if(status.equalsIgnoreCase("on")){
                            element.findElement(By.cssSelector("section > article:nth-child(1) > span > ion-toggle")).click();
                            String prevCallValue = element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle > input")).getAttribute("value");
                            if(prevCallValue.equalsIgnoreCase("on") && call.equalsIgnoreCase("off")){
                                element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle")).click();
                                test.pass("Temperature call changed test");
                            }else if(!prevCallValue.equalsIgnoreCase("on") && call.equalsIgnoreCase("on")) {
                                element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle")).click();
                                test.pass("Temperature call changed test");
                            }

                            String prevTextValue = element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle > input")).getAttribute("value");
                            if(prevTextValue.equalsIgnoreCase("on") && text.equalsIgnoreCase("off")){
                                element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle")).click();
                                test.pass("Temperature text changed test");
                            }else if(!prevTextValue.equalsIgnoreCase("on") && text.equalsIgnoreCase("on")) {
                                element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle")).click();
                                test.pass("Temperature text changed test");
                            }
                        }
                        break;
                }
                break;
            }
        }
    }

    protected static void bedExits(String status, String call, String text, ExtentTest test){
        List<WebElement> alertsList = driver.findElements(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > section > app-bed-exit-alert-settings-block > section > app-alert-settings-block"));
        for (int index = 0; index < alertsList.size(); index++) {
            WebElement element = alertsList.get(index);
            String alertText = element.findElement(By.cssSelector("section > article > h3")).getText();

            if(alertText.equalsIgnoreCase("Bed Exits")){
                test.info("BedExits test started");
                String activateStatus = element.findElement(By.cssSelector("section > article > span > p")).getText();
                System.out.println(activateStatus);
                switch (activateStatus){
                    case "Activated":
                        if(status.equalsIgnoreCase("on")){
                            String prevCallValue = element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle > input")).getAttribute("value");
                            if(prevCallValue.equalsIgnoreCase("on") && call.equalsIgnoreCase("off")){
                                element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle")).click();
                                test.pass("Bed Exits call changed test");
                            }else if(!prevCallValue.equalsIgnoreCase("on") && call.equalsIgnoreCase("on")) {
                                element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle")).click();
                                test.pass("Bed Exits call changed test");
                            }

                            String prevTextValue = element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle > input")).getAttribute("value");
                            System.out.println(prevTextValue);
                            if(prevTextValue.equalsIgnoreCase("on") && text.equalsIgnoreCase("off")){
                                element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle")).click();
                                test.pass("Bed Exits text changed test");
                            }else if(!prevTextValue.equalsIgnoreCase("on") && text.equalsIgnoreCase("on")) {
                                element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle")).click();
                                test.pass("Bed Exits text changed test");
                            }
                        }else{
                            element.findElement(By.cssSelector("section > article:nth-child(1) > span > ion-toggle")).click();
                            test.pass("Bed Exits disabled test");
                        }
                        break;
                    default:
                        if(status.equalsIgnoreCase("on")){
                            element.findElement(By.cssSelector("section > article:nth-child(1) > span > ion-toggle")).click();
                            String prevCallValue = element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle > input")).getAttribute("value");
                            if(prevCallValue.equalsIgnoreCase("on") && call.equalsIgnoreCase("off")){
                                element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle")).click();
                                test.pass("Bed Exits call changed test");
                            }else if(!prevCallValue.equalsIgnoreCase("on") && call.equalsIgnoreCase("on")) {
                                element.findElement(By.cssSelector("section > article:nth-child(2) > ion-toggle")).click();
                                test.pass("Bed Exits call changed test");
                            }

                            String prevTextValue = element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle > input")).getAttribute("value");
                            if(prevTextValue.equalsIgnoreCase("on") && text.equalsIgnoreCase("off")){
                                element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle")).click();
                                test.pass("Bed Exits text changed test");
                            }else if(!prevTextValue.equalsIgnoreCase("on") && text.equalsIgnoreCase("on")) {
                                element.findElement(By.cssSelector("section > article:nth-child(3) > ion-toggle")).click();
                                test.pass("Bed Exits text changed test");
                            }
                        }
                        break;
                }
                break;
            }
        }
    }

    protected static void noActivity(String status, boolean call, boolean text) {
        String path;
        for (int i = 1; i < 6; i++) {
            path = "#main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > section > app-alert-settings-block:nth-child(" + i + ") > section";
            sleep(1000);
            boolean isPresent = Common.isElementPresent(By.cssSelector(path + " > article:nth-child(1) > h3"));
            sleep(1000);
            System.out.println("isPresent " + isPresent);
            System.out.println("alert " + findAlertOrder(path + " > article:nth-child(1) > h3").equalsIgnoreCase("No Activity"));
            if (isPresent && findAlertOrder(path + " > article:nth-child(1) > h3").equalsIgnoreCase("No Activity")) {

                switch(status){
                    case "Activated":
                        if(!Common.cssSelect(path + " > article:nth-child(1) > span > p").getText().equalsIgnoreCase("Activated")) {
                            Common.cssSelect(path + " > article:nth-child(1) > span > ion-toggle").click();
                        }
                        boolean isCallChecked = isChecked(path + " > article:nth-child(2) > ion-toggle > input");
                        boolean isTextChecked = isChecked(path+" > article:nth-child(3) > ion-toggle > input");

                        setAlert(path + " > article:nth-child(2) > ion-toggle", isCallChecked, call);

                        setAlert(path + " > article:nth-child(3) > ion-toggle", isTextChecked, text);

                        break;
                    default:
                        if(Common.cssSelect(path + " > article:nth-child(1) > span > p").getText().equalsIgnoreCase("Activated")) {
                            Common.cssSelect(path+" > article:nth-child(1) > span > ion-toggle").click();
                            Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > article > button").click();
                        }
                        break;
                }
                break;
            } else {
                System.out.println("nothing done");
            }
        }
        sleep(2000);
    }

    private static boolean isChecked(String path) {
       return driver.findElement(By.cssSelector(path)).getAttribute("value").equals("on");
    }

    private static void setAlert(String path, boolean newStatus, boolean prevStatus) {
        if (newStatus && !prevStatus) {
            Common.cssSelect(path).click();
            saveAlertChange();
        } else if (!newStatus && prevStatus) {
            Common.cssSelect(path).click();
            saveAlertChange();
        }
    }

    private static void saveAlertChange() {
        sleep(1000);
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > article > button").click();
        sleep(2000);
    }

    private static String findAlertOrder(String path) {
        switch (Common.cssSelect(path).getText()) {
            case "No Activity":
                return "No Activity";
            case "Help Button":
                return "Help Button";
            case "Fall Detection":
                return "Fall Detection";
            case "Temperature":
                return "Temperature";
            case "Bed Exits":
                return "Bed Exits";
            default:
                System.out.println("no alert type detected");
                return "UnKnown";
        }
    }

    protected static void helpButton(String status, boolean call, boolean text) {
        String path;
        for (int i = 1; i < 6; i++) {
         path = "#main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > section > app-alert-settings-block:nth-child("+ i +") > section";
            sleep(1000);
            boolean isPresent = Common.isElementPresent(By.cssSelector(path + " > article:nth-child(1) > h3"));
            sleep(1000);
            if (isPresent && findAlertOrder(path + " > article:nth-child(1) > h3").equalsIgnoreCase("Help Button")) {
                switch(status){
                    case "Activated":
                        if(!Common.cssSelect(path + " > article:nth-child(1) > span > p").getText().equalsIgnoreCase("Activated")) {
                            Common.cssSelect(path + " > article:nth-child(1) > span > ion-toggle").click();
                        }
                        boolean isCallChecked = isChecked(path + " > article:nth-child(2) > ion-toggle > input");
                        boolean isTextChecked = isChecked(path+" > article:nth-child(3) > ion-toggle > input");

                        setAlert(path + " > article:nth-child(2) > ion-toggle", isCallChecked, call);
                        setAlert(path + " > article:nth-child(3) > ion-toggle", isTextChecked, text);

                        break;
                    default:
                        if(Common.cssSelect(path + " > article:nth-child(1) > span > p").getText().equalsIgnoreCase("Activated")) {
                            Common.cssSelect(path+" > article:nth-child(1) > span > ion-toggle").click();
                            Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > article > button").click();
                        }
                        break;
                }
 if (Common.cssSelect(path + " > article:nth-child(1) > span > p").getText().equalsIgnoreCase(status)) {
                    boolean isCallChecked = isChecked(path + " > article:nth-child(2) > ion-toggle > input");
                    boolean isTextChecked = isChecked(path+" > article:nth-child(3) > ion-toggle > input");

                    setAlert(path + " > article:nth-child(2) > ion-toggle", isCallChecked, call);
                    setAlert(path + " > article:nth-child(3) > ion-toggle", isTextChecked, text);
                } else {

                }

                break;
            } else {
                System.out.println("nothing done");
            }
        }
        sleep(2000);
    }

    protected static void fallDetection(String status, boolean call, boolean text) {
        String path;
        for (int i = 1; i < 6; i++) {
            path = "#main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > section > app-alert-settings-block:nth-child("+ i +") > section";
            sleep(1000);
            boolean isPresent = Common.isElementPresent(By.cssSelector(path + " > article:nth-child(1) > h3"));
            sleep(1000);
            if (isPresent && findAlertOrder(path + " > article:nth-child(1) > h3").equalsIgnoreCase("Fall Detection")) {
                switch(status){
                    case "Activated":
                        if(!Common.cssSelect(path + " > article:nth-child(1) > span > p").getText().equalsIgnoreCase("Activated")) {
                            Common.cssSelect(path + " > article:nth-child(1) > span > ion-toggle").click();
                        }
                        boolean isCallChecked = isChecked(path + " > article:nth-child(2) > ion-toggle > input");
                        boolean isTextChecked = isChecked(path+" > article:nth-child(3) > ion-toggle > input");

                        setAlert(path + " > article:nth-child(2) > ion-toggle", isCallChecked, call);
                        setAlert(path + " > article:nth-child(3) > ion-toggle", isTextChecked, text);

                        break;
                    default:
                        if(Common.cssSelect(path + " > article:nth-child(1) > span > p").getText().equalsIgnoreCase("Activated")) {
                            Common.cssSelect(path+" > article:nth-child(1) > span > ion-toggle").click();
                            Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > article > button").click();
                        }
                        break;
                }
  if (Common.cssSelect(path + " > article:nth-child(1) > span > p").getText().equalsIgnoreCase(status)) {
                    boolean isCallChecked = isChecked(path + " > article:nth-child(2) > ion-toggle > input");
                    boolean isTextChecked = isChecked(path+" > article:nth-child(3) > ion-toggle > input");

                    setAlert(path + " > article:nth-child(2) > ion-toggle", isCallChecked, call);
                    setAlert(path + " > article:nth-child(3) > ion-toggle", isTextChecked, text);
                } else {

                }

                break;
            } else {
                System.out.println("nothing done");
            }
        }
        sleep(2000);
    }

    protected static void temperature(String status, boolean call, boolean text) {
        String path;
        for (int i = 1; i < 6; i++) {
            path = "#main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > section > app-alert-settings-block:nth-child("+ i +") > section";
            sleep(1000);
            boolean isPresent = Common.isElementPresent(By.cssSelector(path + " > article:nth-child(1) > h3"));
            sleep(1000);
            if (isPresent && findAlertOrder(path + " > article:nth-child(1) > h3").equalsIgnoreCase("Temperature")) {
                switch(status){
                    case "Activated":
                        if(!Common.cssSelect(path + " > article:nth-child(1) > span > p").getText().equalsIgnoreCase("Activated")) {
                            Common.cssSelect(path + " > article:nth-child(1) > span > ion-toggle").click();
                        }
                        boolean isCallChecked = isChecked(path + " > article:nth-child(2) > ion-toggle > input");
                        boolean isTextChecked = isChecked(path+" > article:nth-child(3) > ion-toggle > input");

                        setAlert(path + " > article:nth-child(2) > ion-toggle", isCallChecked, call);
                        setAlert(path + " > article:nth-child(3) > ion-toggle", isTextChecked, text);

                        break;
                    default:
                        if(Common.cssSelect(path + " > article:nth-child(1) > span > p").getText().equalsIgnoreCase("Activated")) {
                            Common.cssSelect(path+" > article:nth-child(1) > span > ion-toggle").click();
                            Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > article > button").click();
                        }
                        break;
                }
 if (Common.cssSelect(path + " > article:nth-child(1) > span > p").getText().equalsIgnoreCase(status)) {
                    boolean isCallChecked = isChecked(path + " > article:nth-child(2) > ion-toggle > input");
                    boolean isTextChecked = isChecked(path+" > article:nth-child(3) > ion-toggle > input");

                    setAlert(path + " > article:nth-child(2) > ion-toggle", isCallChecked, call);
                    setAlert(path + " > article:nth-child(3) > ion-toggle", isTextChecked, text);
                } else {

                }

                break;
            } else {
                System.out.println("nothing done");
            }
        }
        sleep(2000);
    }

    protected static void bedExits(String status, boolean call, boolean text) {
        String path;
//        for (int i = 1; i < 6; i++) {
            path = "#main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > section > app-bed-exit-alert-settings-block > section > app-alert-settings-block > section";
            sleep(1000);
            boolean isPresent = Common.isElementPresent(By.cssSelector(path + " > article:nth-child(1) > h3"));
            sleep(1000);
            if (isPresent && findAlertOrder(path + " > article:nth-child(1) > h3").equalsIgnoreCase("Bed Exits")) {
                switch(status){
                    case "Activated":
                        if(!Common.cssSelect(path + " > article:nth-child(1) > span > p").getText().equalsIgnoreCase("Activated")) {
                            Common.cssSelect(path + " > article:nth-child(1) > span > ion-toggle").click();
//                            cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > article > button").click();
                            saveAlertChange();
                        }
                        boolean isCallChecked = isChecked(path + " > article:nth-child(2) > ion-toggle > input");
                        boolean isTextChecked = isChecked(path+" > article:nth-child(3) > ion-toggle > input");

                        setAlert(path + " > article:nth-child(2) > ion-toggle", isCallChecked, call);
                        setAlert(path + " > article:nth-child(3) > ion-toggle", isTextChecked, text);

                        break;
                    default:
                        if(Common.cssSelect(path + " > article:nth-child(1) > span > p").getText().equalsIgnoreCase("Activated")) {
                            Common.cssSelect(path+" > article:nth-child(1) > span > ion-toggle").click();
                            Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > article > button").click();
                        }
                        break;
                }
 if (Common.cssSelect(path + " > article:nth-child(1) > span > p").getText().equalsIgnoreCase(status)) {
                    boolean isCallChecked = isChecked(path + " > article:nth-child(2) > ion-toggle > input");
                    boolean isTextChecked = isChecked(path+" > article:nth-child(3) > ion-toggle > input");

                    setAlert(path + " > article:nth-child(2) > ion-toggle", isCallChecked, call);
                    setAlert(path + " > article:nth-child(3) > ion-toggle", isTextChecked, text);
                } else {

                }

//                break;
            } else {
                System.out.println("nothing done");
            }
            sleep(2000);
//            12pm -3pm
        driver.findElement(By.xpath("#range-label > div.native-wrapper > div > div:nth-child(2)")).click();
//        cssSelect("#range-label > div.native-wrapper > div > div:nth-child(2)").click();
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > section > app-bed-exit-alert-settings-block > section > article > div.slider > ion-range > input");
        WebElement sliderHandleA = driver.findElement(By.cssSelector("#range-label > div.native-wrapper > div > div.range-knob-handle.range-knob-a.range-knob-min.ion-activatable.ion-focusable"));
        WebElement sliderHandleB = driver.findElement(By.cssSelector("#range-label > div.native-wrapper > div > div.range-knob-handle.range-knob-b.ion-activatable.ion-focusable"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(sliderHandleA).moveByOffset(100, 0).release().perform();

        //2pm - 8 pm
        // Move the second slider handle to the desired position (example: 10 PM, i.e., 41.67%)
        actions.clickAndHold(sliderHandleB).moveByOffset(200, 0).release().perform();

        // Print the updated values
        System.out.println("Slider Handle A value: " + sliderHandleA.getAttribute("aria-valuenow"));
        System.out.println("Slider Handle B value: " + sliderHandleB.getAttribute("aria-valuenow"));
//        }
        sleep(2000);
    }


    private static int checkAlertType(String path) {
        int num = Integer.parseInt(path.split("app-alert-settings-block:nth-child\\(")[1].split("\\)")[0]);

        switch (Common.cssSelect(path).getText()) {
            case "No Activity":
                isActivated("#main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > section > app-alert-settings-block:nth-child(" + num + ") > section > article:nth-child(1) > span > p");
                return num;
            case "Help Button":
                return num;
            case "Fall Detection":
                return num;
            case "Temperature":
                return num;
            case "Bed Exits":
                return num;
            default:
                System.out.println("no alert type detected");
                return num;
//                 #main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > section > app-alert-settings-block:nth-child(1)
//                 #main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > section > app-alert-settings-block:nth-child(2)
//                 #main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > section > app-alert-settings-block:nth-child(1) > section > article:nth-child(1)
//                 #main > app-home > ion-tabs > div > ion-router-outlet > app-alert-settings > ion-content > main > section > app-alert-settings-block:nth-child(2) > section > article:nth-child(1)

        }
    }

    private static void isActivated(String path) {
        if (Common.cssSelect(path).getText().equalsIgnoreCase("Activated")) {

        } else {

        }
    }

    protected static void goToEditSensorNames() {
        WebElement element;
        Common.cssSelect("body > app-root > ion-app > app-menu > ion-menu > main > section > app-options-btn:nth-child(2)").click();
        sleep(1000);
        refresh();
        sleep(1000);
        //check System
        boolean isPresent = Common.isElementPresent(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-sensor-names > ion-content > main > section > app-text-field.system-name.ng-valid.ng-touched.ng-dirty > main > article > h4"));
        if (isPresent) {
            Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-sensor-names > ion-content > main > section > app-text-field.system-name.ng-valid.ng-touched.ng-dirty > main > section > div > img").click();
            editSensorName("#system-name", "new Rooom");
        }
        //check toilet
        isPresent = Common.isElementPresent(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-sensor-names > ion-content > main > section > app-text-field:nth-child(2) > main > article > h4"));
        if (isPresent) {
            Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-sensor-names > ion-content > main > section > app-text-field:nth-child(2) > main > section > div > img").click();
            editSensorName("#medic-name-0", "new Toilet");
        }

        //check bedSensor
        isPresent = Common.isElementPresent(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-sensor-names > ion-content > main > section > app-text-field:nth-child(3) > main > article > h4"));
        if (isPresent) {
            Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-sensor-names > ion-content > main > section > app-text-field:nth-child(3) > main > section > div > img").click();
            editSensorName("#sleep-name-0", "new Bed Sensor");
        }
    }

    protected static void editSensorName(String path, String title) {
        Common.cssSelect(path).clear();
        Common.cssSelect(path).sendKeys(title);
    }
}
