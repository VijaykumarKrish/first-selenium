package com.celllabs;

import com.celllabs.enums.ReturnType;
import com.celllabs.enums.UserType;
import com.celllabs.shared.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class More {
    public static void clickOnMore(){
        Common.waitBySelector("#tab-button-more").click();
    }
    public static void morePageFont(){
        //more title font
        WebElement element = Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-more > app-bar > main > ion-toolbar > section > h1");
        String moreTitleFont =  App.getCssProps(element, "name");
        String moreTitleFontSize =  App.getCssProps(element, "size");
        App.js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 "+moreTitleFont+" "+moreTitleFontSize+" ')); node.style.cssText = 'color:#FF0000'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-more > app-bar > main > ion-toolbar > section > h1').appendChild(node);");

        element = Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-more > ion-content > section > article > app-options-btn:nth-child(1) > article > p");
        String usersFont =  App.getCssProps(element, "name");
        String usersFontSize =  App.getCssProps(element, "size");
        App.js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 "+usersFont+" "+usersFontSize+" ')); node.style.cssText = 'color:#FF0000'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-more > ion-content > section > article > app-options-btn:nth-child(1) > article > p').appendChild(node);");

        element = Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-more > ion-content > section > article > app-options-btn:nth-child(2) > article > p");
        String falseFont =  App.getCssProps(element, "name");
        String falseFontSize =  App.getCssProps(element, "size");
        App.js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 "+falseFont+" "+falseFontSize+" ')); node.style.cssText = 'color:#FF0000'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-more > ion-content > section > article > app-options-btn:nth-child(2) > article > p').appendChild(node);");

        element = Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-more > ion-content > section > button");
        String logOutFont =  App.getCssProps(element, "name");
        String logOutFontSize =  App.getCssProps(element, "size");
        App.js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 "+logOutFont+" "+logOutFontSize+" ')); node.style.cssText = 'color:#13d471'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-more > ion-content > section > button').appendChild(node);");

    }
    public static void clickOnUsersPage(){
        App.sleep(1000);
//        cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-more > ion-content > section > article > app-options-btn:nth-child(1) > article").click();
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-more > ion-content > main > section > app-options-btn:nth-child(1) > section").click();
        App.sleep(2000);
    }
    public static String addUserCheck(String userType,String firstName,String lastName,String phoneNumber,String email,int i) {
        App.sleep(2000);
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(1) > section > header > button").click();
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(1) > app-multi-select > section > article").click();

        WebElement element = Common.cssSelect("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(1) > app-multi-select > section > article.custom-scrollbar");
        List<WebElement> paraList = element.findElements(By.tagName("p"));
        if(paraList.size() > 1){
            if(userType.equalsIgnoreCase("Caregiver")){
                Common.cssSelect("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(1) > app-multi-select > section > article.custom-scrollbar > p:nth-child(2)").click();
            }else{
                Common.cssSelect("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(1) > app-multi-select > section > article.custom-scrollbar > p:nth-child(1)").click();
            }
        }else{
            Common.cssSelect("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(1) > app-multi-select > section > article.custom-scrollbar > p").click();
        }


        Common.cssSelect("#first-name").sendKeys(firstName);
        Common.cssSelect("#last-name").sendKeys(lastName);
        Common.cssSelect("#phone").sendKeys(phoneNumber);
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > app-text-field:nth-child(5) > main > article > input").sendKeys(email);

        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(6) > app-multi-select > section > article > h4").click();
        Common.cssSelect("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(6) > app-multi-select > section > article.custom-scrollbar > p:nth-child("+i+")").click();

        App.sleep(1000);
        return "";
    }
    public static void clickOnAddUser(){
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(1) > section > header > button").click();
    }
    public static String clickOnBackButton(String path){
        App.sleep(1000);
        Common.cssSelect(path).click();
        App.sleep(1000);
        return App.driver.getCurrentUrl();
    }
    public static String addUser(UserType userType, String firstName, String lastName, String phoneNumber, String email, int assignTeam, ReturnType returnType){
        App.refresh();
        App.sleep(2000);
        WebElement element;
//        cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(1) > app-multi-select > section > article").click();
        if(userType != UserType.NONE) {
            Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(1) > app-multi-select > section > article").click();
            App.sleep(1000);
            element = Common.cssSelect("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(1) > app-multi-select > section > article.custom-scrollbar");
            List<WebElement> paraList = element.findElements(By.tagName("p"));
            if (paraList.size() > 1) {
                if (userType == UserType.CAREGIVER) {
                    Common.cssSelect("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(1) > app-multi-select > section > article.custom-scrollbar > p:nth-child(2)").click();
                } else {
                    Common.cssSelect("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(1) > app-multi-select > section > article.custom-scrollbar > p:nth-child(1)").click();
                }
            } else {
                Common.cssSelect("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(1) > app-multi-select > section > article.custom-scrollbar > p").click();
            }
        }

        Common.cssSelect("#first-name").sendKeys(firstName);
        Common.cssSelect("#last-name").sendKeys(lastName);
        Common.cssSelect("#phone").sendKeys(phoneNumber);
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > app-text-field:nth-child(5) > main > article > input").sendKeys(email);

        element = Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(6) > app-multi-select > section > article > h4");
        if(assignTeam != 0 && element.getText().trim().equalsIgnoreCase("--")) {
            element.click();
            App.sleep(1000);
            Common.cssSelect("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(6) > app-multi-select > section > article.custom-scrollbar > p:nth-child(" + assignTeam + ")").click();
            App.sleep(1000);
            Common.cssSelect("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(6) > app-multi-select > section > article:nth-child(2) > h4").click();
            App.sleep(1000);
        }
//        sleep(1000);
//        cssSelect("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(6) > app-multi-select > section > article:nth-child(2)").click();
//        sleep(1000);

        if(ReturnType.URL.equals(returnType)){

            App.sleep(1000);
            Common.waitBySelector("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-users > ion-content > main > app-save-delete-button > div > button").sendKeys(Keys.ENTER);
//            cssSelect("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-users > ion-content > main > app-save-delete-button > div > button.primary-button").click();
            App.sleep(2000);
            return App.driver.getCurrentUrl();
        }else if(ReturnType.TEN == returnType){
            String phone = Common.cssSelect("#phone").getAttribute("value");
            if (phone.length() == 10 && Common.isElementPresent(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > div > button.primary-button")))
                return "true";
            return "false";
        }
        else{
            if(Common.isElementPresent(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > div > button.primary-button"))){
                return "true";
            }
            return "false";
        }
//        cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > div > button").click();
    }
    public static void falseAlerts(){
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-more > ion-content > section > article > app-options-btn:nth-child(2) > article").click();
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-false-alerts > new-app-bar > main > section > article > app-select > section > article").click();
        App.sleep(1000);
        Common.cssSelect("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-false-alerts > new-app-bar > main > section > article > app-select > section > article.custom-scrollbar > p:nth-child(2)").click();
        App.sleep(1000);
        Common.cssSelect("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-false-alerts > new-app-bar > main > section > article > app-select > section > article.custom-scrollbar > p:nth-child(1)").click();
    }
}
