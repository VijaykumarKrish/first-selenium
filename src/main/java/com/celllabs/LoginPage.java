package com.celllabs;

import com.celllabs.enums.ReturnType;
import com.celllabs.shared.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.celllabs.shared.Common.clear;

public class LoginPage {
    protected static void testCasesForLogin(String email, String password){
        App.createLogin(email, password);
        App.sleep(1000);
//        createTestCase(i);

        App.sleep(1000);

    }

    protected static String testPasswords(String password,String confirmPassword, int type){
        enterPasswords(password, confirmPassword);

        boolean isButtonEnable = Common.isElementPresent(By.cssSelector("#main > app-set-password > ion-content > section > button.primary-button"));

       if(type == 1){
           if(isButtonEnable) return "true";
           else return "false";
       }
        if(isButtonEnable){
            App.sleep(1000);
            Common.cssSelect("#main > app-set-password > ion-content > section > button.primary-button").click();
            App.sleep(2000);
        }

        return App.driver.getCurrentUrl();
    }
    protected static boolean showHideLoginPassword(String path, String showHideBtnPath, String forgotType){
//        App.refresh();
        App.sleep(2000);
        WebElement element = Common.cssSelect(path);
        clear(element);
        element.sendKeys("123456");

        String inputType = Common.cssSelect(path).getAttribute("type");
        if(inputType.equalsIgnoreCase("text") && forgotType.equalsIgnoreCase("forgot")) Common.clickButton(showHideBtnPath);
        System.out.println("inputType "+inputType);
        boolean isClickable = true;

        int showHidePassword = 2;
        for (int index = 0; index < showHidePassword; index++) {
            Common.clickButton(showHideBtnPath);
            App.sleep(1000);
            String currentInputType = Common.cssSelect(path).getAttribute("type");
            System.out.println("currentInputType "+currentInputType);
            isClickable = isClickable && !currentInputType.equalsIgnoreCase(inputType);
            System.out.println(isClickable);
            inputType = currentInputType;
        }

        return isClickable;
    }
    private static void enterPasswords(String password,String confirmPassword) {
//        App.refresh();
        App.sleep(2000);
        WebElement element = Common.cssSelect("#newpassword");
        clear(element);
        element.sendKeys(password);
        Common.cssSelect("#main > app-set-password > ion-content > section > article:nth-child(2) > app-text-field > main > section > img").click();

        element = Common.cssSelect("#confirmpassword");
        clear(element);
        clear(element);
        element.sendKeys(confirmPassword);
        App.sleep(1000);
        Common.cssSelect("#main > app-set-password > ion-content > section > article:nth-child(2) > div > app-text-field > main > section > img").click();
        App.sleep(1000);
    }

    protected static String forgotPassword(String lastName,String num, String email,int type){
        App.sleep(2000);
        WebElement element = Common.selectById("last-name");
        clear(element);
        element.sendKeys(lastName);

        element = Common.selectById("phone-number");
        clear(element);
        element.sendKeys(num);

        element = Common.cssSelect("#main > app-verify-user > ion-content > main > article:nth-child(2) > div > app-text-field > main > article > input");
        clear(element);
        element.sendKeys(email);

        switch(type){
            case 1:
                if(Common.isElementPresent(By.cssSelector("#main > app-verify-user > ion-content > main > button.primary-user"))){
//            cssSelect("#main > app-verify-user > ion-content > main > button.primary-user").click();
                    return "true";
                }
//                refresh();
                return "false";
            default:
                App.sleep(1000);
                Common.cssSelect("#main > app-verify-user > ion-content > main > button.primary-button").click();
                App.sleep(2000);

                return App.driver.getCurrentUrl();

        }
    /*    if(isElementPresent(By.cssSelector("#main > app-verify-user > ion-content > main > button.primary-user"))){
//            cssSelect("#main > app-verify-user > ion-content > main > button.primary-user").click();
            return "true";
        }
        return "false";
//        return driver.getCurrentUrl();*/

    }

    protected static String setPassword(String password, String confirmPassword){
        App.sleep(2000);
        WebElement element = Common.cssSelect("#newpassword");
        element.clear();
        element.sendKeys(password);
        Common.cssSelect("#main > app-set-password > ion-content > section > article:nth-child(2) > app-text-field > main > section > img").click();

        element = Common.cssSelect("#confirmpassword");
        element.clear();
        element.sendKeys(confirmPassword);
        Common.cssSelect("#main > app-set-password > ion-content > section > article:nth-child(2) > div > app-text-field > main > section > img").click();

        if(Common.isElementPresent(By.cssSelector("#main > app-set-password > ion-content > section > button"))){
            Common.cssSelect("#main > app-set-password > ion-content > section > button").click();
            App.sleep(2000);
        }
        return App.driver.getCurrentUrl();
    }

    protected static String forgotPasswordPageClick(){
        WebElement element = Common.selectXpath("//*[@id=\"main\"]/app-login/ion-content/main/section/article[2]/div[2]/p[1]/span");
//        WebElement element = selectXpath("//*[@id=\"main\"]/app-login/ion-content/main/section/article[2]/div[2]/p[1]/a");
        element.click();
        App.sleep(1000);
        System.out.println(App.driver.getCurrentUrl());
        return App.driver.getCurrentUrl();
    }
    protected static String firstTimeUserClick(){
        App.sleep(1000);
        Common.cssSelect("#main > app-login > ion-content > main > section > article:nth-child(2) > div.buttons > p:nth-child(3) > span").click();
        App.sleep(1000);
        System.out.println(App.driver.getCurrentUrl());
        return App.driver.getCurrentUrl();
    }
    protected static String checkCurrentVersion(){
        return Common.cssSelect("#main > app-login > ion-content > main > section > article:nth-child(2) > p").getText();
    }
    protected static String createUserPassword(String password, String confirmPassword, ReturnType returnType){
//        refresh();
        App.sleep(2000);
        Common.cssSelect("#newpassword").clear();
        Common.cssSelect("#newpassword").sendKeys(password);

        Common.cssSelect("#confirmpassword").clear();
        Common.cssSelect("#confirmpassword").sendKeys(confirmPassword);
        App.sleep(1000);

        if(returnType == ReturnType.BUTTON){
            if(Common.isElementPresent(By.cssSelector("#main > app-set-password > ion-content > section > button.primary-button"))){
                return "true";
            }
            return "false";

        }
        Common.cssSelect("#main > app-set-password > ion-content > section > button.primary-button").click();
        App.sleep(2000);

        return App.driver.getCurrentUrl();
    }
    protected static String accountDetailsClick(){
        Common.cssSelect("#main > app-account-details > ion-content > section > button").click();
        App.sleep(2000);
        return App.driver.getCurrentUrl();
    }

    protected static String firstTimeUserVerify(String input,int type, ReturnType returnType){
        App.sleep(2000);
//        App.refresh();
        WebElement element;
        if(type == 1) {
            element = Common.cssSelect("#main > app-verify-account > ion-content > main > article:nth-child(2) > div:nth-child(1) > app-text-field > main > article > input");
            clear(element);
            clear(element);
            element.sendKeys(input);
        }else if(type == 2){
            element = Common.cssSelect("#phone");
            clear(element);
            clear(element);
            element.sendKeys(input);
        }
        if(returnType == ReturnType.BUTTON){
            if(Common.isElementPresent(By.cssSelector("#main > app-verify-account > ion-content > main > button.primary-button"))) {
                return "true";
            }
            else return "false";
        }

        App.sleep(1000);
        Common.cssSelect("#main > app-verify-account > ion-content > main > button").click();
        App.sleep(2000);

        return App.driver.getCurrentUrl();
    }
}
