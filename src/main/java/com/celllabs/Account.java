package com.celllabs;

import com.celllabs.shared.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Account {
    public static String clickOnAccount(){
        Common.selectXpath("//*[@id=\"tab-button-my-account\"]/img").click();
        App.sleep(1000);
        return App.driver.getCurrentUrl();
    }
    public static void accountFont(){
        //account title font
        WebElement element = Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > app-bar > main > ion-toolbar > section > h1");
        String accountFontName =  App.getCssProps(element, "name");
        String accountFontSize =  App.getCssProps(element, "size");
        App.js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 "+accountFontName+" "+accountFontSize+" ')); node.style.cssText = 'color:#FF0000'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > app-bar > main > ion-toolbar > section > h1').appendChild(node);");

        //name font
        element = Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(1) > main > article.main > h4");
        String nameFont =  App.getCssProps(element, "name");
        String nameFontSize =  App.getCssProps(element, "size");
        App.js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 "+nameFont+" "+nameFontSize+" ')); node.style.cssText = 'color:#FF0000'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(1) > main > article.main > h4').appendChild(node);");

        element = Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(1) > main > article.main > p");
        String SystemFont =  App.getCssProps(element, "name");
        String SystemFontSize =  App.getCssProps(element, "size");
        App.js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 "+SystemFont+" "+SystemFontSize+" ')); node.style.cssText = 'color:#FF0000'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(1) > main > article.main > p').appendChild(node);");

        //email font
        element = Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(2) > main > article.main > h4");
        String emailTitleFont =  App.getCssProps(element, "name");
        String emailTitleFontSize =  App.getCssProps(element, "size");
        App.js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 "+emailTitleFont+" "+emailTitleFontSize+" ')); node.style.cssText = 'color:#FF0000'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(2) > main > article.main > h4').appendChild(node);");

        element = Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(2) > main > article.main > p");
        String emailFont =  App.getCssProps(element, "name");
        String emailFontSize =  App.getCssProps(element, "size");
        App.js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 "+emailFont+" "+emailFontSize+" ')); node.style.cssText = 'color:#FF0000'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(2) > main > article.main > p').appendChild(node);");

        //phone number
        element = Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(3) > main > article.main > h4");
        String phoneNumTitleFont =  App.getCssProps(element, "name");
        String phoneNumTitleFontSize =  App.getCssProps(element, "size");
        App.js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 "+phoneNumTitleFont+" "+phoneNumTitleFontSize+" ')); node.style.cssText = 'color:#FF0000'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(3) > main > article.main > h4').appendChild(node);");

        element = Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(3) > main > article.main > p");
        String phoneFont =  App.getCssProps(element, "name");
        String phoneFontSize =  App.getCssProps(element, "size");
        App.js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 "+phoneFont+" "+phoneFontSize+" ')); node.style.cssText = 'color:#FF0000'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(3) > main > article.main > p').appendChild(node);");

        //password
        element = Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(4) > main > article.main > h4");
        String passwordTitleFont =  App.getCssProps(element, "name");
        String passwordTitleFontSize =  App.getCssProps(element, "size");
        App.js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 "+passwordTitleFont+" "+passwordTitleFontSize+" ')); node.style.cssText = 'color:#FF0000'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(4) > main > article.main > h4').appendChild(node);");

        //account number
        element = Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > div > h3:nth-child(1)");
        String accountNumFont =  App.getCssProps(element, "name");
        String accountNumFontSize =  App.getCssProps(element, "size");
        App.js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 "+accountNumFont+" "+accountNumFontSize+" ')); node.style.cssText = 'color:#FF0000'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > div > h3:nth-child(1)').appendChild(node);");

        //account type
        element = Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > div > h3:nth-child(2)");
        String accountTypeFont =  App.getCssProps(element, "name");
        String accountTypeFontSize =  App.getCssProps(element, "size");
        App.js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 "+accountTypeFont+" "+accountTypeFontSize+" ')); node.style.cssText = 'color:#FF0000'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > div > h3:nth-child(2)').appendChild(node);");
        App.sleep(2000);
        App.refresh();
    }
    public static void checkAccountPage(){
        //edit system name
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(1) > main > section > img").click();
    }
    protected static String editName(String accountName,String lastName,String password, int type){
        boolean isPresent = Common.isElementPresent(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(1) > main > section > img"));
        if(isPresent){
            Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(1) > main > section > img").click();
            Common.cssSelect("#first-name").sendKeys(accountName);
            Common.cssSelect("#last-name").sendKeys(lastName);
            Common.cssSelect("#password").sendKeys(password);
            Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-name > ion-content > main > section > article > div > app-text-field > main > section > img").click();

            isPresent = Common.isElementPresent(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-name > ion-content > main > button.primary-button"));
            if(isPresent && type == 1){
                Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-name > ion-content > main > button.primary-button").click();
                App.sleep(2000);
                return "";
            }else{

            }
            if(isPresent){
                Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-name > ion-content > main > button.primary-button").click();
            }else{

            }
            App.sleep(2000);

//            refresh();
        }
        return "";
    }
    public static void clickOnEditFirstName(){
        boolean isPresent = Common.isElementPresent(By.cssSelector("app-my-account.ion-page > ion-content:nth-child(2) > section:nth-child(1) > article:nth-child(1) > app-text-field:nth-child(1) > main:nth-child(1) > section:nth-child(3) > img:nth-child(1)"));
        System.out.println(isPresent);
        if(isPresent){
            Common.cssSelect("app-my-account.ion-page > ion-content:nth-child(2) > section:nth-child(1) > article:nth-child(1) > app-text-field:nth-child(1) > main:nth-child(1) > section:nth-child(3) > img:nth-child(1)").click();
        }
    }
    public static String editSensorName(String accountName,String lastName,String password, int type){
//        refresh();
        App.sleep(1000);
        WebElement element = Common.cssSelect("#first");
        Common.clear(element);
        element.sendKeys(accountName);

        element = Common.cssSelect("#second");
        Common.clear(element);
        element.sendKeys(lastName);

        element = Common.cssSelect("section.custom-scrollbar:nth-child(1) > article:nth-child(2) > div:nth-child(3) > app-text-field:nth-child(1) > main:nth-child(1) > article:nth-child(1) > input");
        Common.clear(element);
        element.sendKeys(password);
        Common.cssSelect("section.custom-scrollbar:nth-child(1) > article:nth-child(2) > div:nth-child(3) > app-text-field:nth-child(1) > main:nth-child(1) > section:nth-child(2) > img:nth-child(1)").click();

        App.sleep(2000);
        boolean isPresent = Common.isElementPresent(By.cssSelector("app-edit-name.ion-page > ion-content:nth-child(2) > main:nth-child(1) > app-edit-section:nth-child(1) > main:nth-child(1) > button:nth-child(2).primary-button"));

        switch (type){
            case 0:
                if(!isPresent){
                    return "false";
                }
                return "true";
            default:
                if(isPresent){
                    Common.cssSelect("app-edit-name.ion-page > ion-content:nth-child(2) > main:nth-child(1) > app-edit-section:nth-child(1) > main:nth-child(1) > button:nth-child(2).primary-button").click();
                    App.sleep(2000);
                }
                return App.driver.getCurrentUrl();
        }
       /* isPresent = isElementPresent(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-name > ion-content > main > button.primary-button"));
        if(isPresent && type == 1){
            cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-name > ion-content > main > button.primary-button").click();
            sleep(1000);
            return "false";

        }else{

        }
        sleep(2000);
        refresh();*/
    }
    public static void clickOnEditAccEmail(){
        boolean isPresent = Common.isElementPresent(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(2) > main > section > img"));
        if(isPresent) {
            Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(2) > main > section > img").click();
        }
    }
    public static String editAccEmail(String email,String confirmEmail, String password, int type){
//        refresh();
        App.sleep(2000);
        WebElement element = Common.cssSelect("#first");
        Common.clear(element);
        element.sendKeys(email);

        element = Common.cssSelect("#second");
        Common.clear(element);
        element.sendKeys(confirmEmail);

        element = Common.cssSelect("section.custom-scrollbar:nth-child(1) > article:nth-child(2) > div:nth-child(3) > app-text-field:nth-child(1) > main:nth-child(1) > article:nth-child(1) > input");
        Common.clear(element);
        element.sendKeys(password);

        Common.cssSelect("section.custom-scrollbar:nth-child(1) > article:nth-child(2) > div:nth-child(3) > app-text-field:nth-child(1) > main:nth-child(1) > section:nth-child(2) > img:nth-child(1)").click();

        boolean isPresent = Common.isElementPresent(By.cssSelector("app-edit-email.ion-page > ion-content:nth-child(2) > main:nth-child(1) > app-edit-section:nth-child(1) > main:nth-child(1) > button:nth-child(2).primary-button"));

        switch (type){
            case 0:
                if(!isPresent){
                    return "false";
                }
                return "true";
            default:
                if(isPresent){
                    App.sleep(1000);
                    Common.cssSelect("app-edit-email.ion-page > ion-content:nth-child(2) > main:nth-child(1) > app-edit-section:nth-child(1) > main:nth-child(1) > button:nth-child(2).primary-button").click();
                    App.sleep(1000);
                }
                return App.driver.getCurrentUrl();
        }
//        cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-email > ion-content > main > button").click();
    }
    public static void clickOnEditPhone(){
        boolean isPresent = Common.isElementPresent(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(3) > main > section > img"));
        if(isPresent){
            App.sleep(1000);
            Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(3) > main > section > img").click();
        }
    }
    protected static String phoneNumberShouldBe10(String phoneNum, String confirmPhone, String password){
        App.sleep(1000);
        enterEditAccountDetails(phoneNum, confirmPhone, password);
        String existPhone = Common.cssSelect("#first").getAttribute("value");
        String existConfirmPhone = Common.cssSelect("#second").getAttribute("value");
        if(existPhone.length() == 10 && existConfirmPhone.length() == 10){
            Common.cssSelect("app-edit-phone.ion-page > ion-content:nth-child(2) > main:nth-child(1) > app-edit-section:nth-child(1) > main:nth-child(1) > button:nth-child(2)").click();
            App.sleep(1000);
            return App.driver.getCurrentUrl();
        }
        return App.driver.getCurrentUrl();
    }
    public static String editPhoneNum(String phoneNum, String confirmPhone, String password, int type){
        App.sleep(2000);
        enterEditAccountDetails(phoneNum, confirmPhone, password);

        boolean isPresent = Common.isElementPresent(By.cssSelector("app-edit-phone.ion-page > ion-content:nth-child(2) > main:nth-child(1) > app-edit-section:nth-child(1) > main:nth-child(1) > button:nth-child(2).primary-button"));

        switch (type){
            case 0:
                if(!isPresent){
                    return "false";
                }
                return "true";
            default:
                if(isPresent){
                    Common.cssSelect("app-edit-phone.ion-page > ion-content:nth-child(2) > main:nth-child(1) > app-edit-section:nth-child(1) > main:nth-child(1) > button:nth-child(2)").click();
                    App.sleep(1000);
                }
                return App.driver.getCurrentUrl();
        }

//        cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-phone > ion-content > main > button").click();
    }

    private static void enterEditAccountDetails(String phoneNum, String confirmPhone, String password) {
        WebElement element = Common.cssSelect("#first");
        Common.clear(element);
        element.sendKeys(phoneNum);

        element = Common.cssSelect("#second");
        Common.clear(element);
        element.sendKeys(confirmPhone);

        element = Common.cssSelect("section.custom-scrollbar:nth-child(1) > article:nth-child(2) > div:nth-child(3) > app-text-field:nth-child(1) > main:nth-child(1) > article:nth-child(1) > input");
        Common.clear(element);
        element.sendKeys(password);

        Common.cssSelect("section.custom-scrollbar:nth-child(1) > article:nth-child(2) > div:nth-child(3) > app-text-field:nth-child(1) > main:nth-child(1) > section:nth-child(2) > img:nth-child(1)").click();
    }

    public static void clickOnEditPassword(){
        boolean isPresent = Common.isElementPresent(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(4) > main > section > img"));
        if(isPresent){
            Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(4) > main > section > img").click();
        }
    }
    public static String editPassword(String newPassword, String confirmPassword, String currPassword, int type){
        App.sleep(2000);
        WebElement element = Common.cssSelect("#new-password");
        Common.clear(element);
        element.sendKeys(newPassword);

        element = Common.cssSelect("#confirm-new-password");
         Common.clear(element);
        element.sendKeys(confirmPassword);

        element = Common.cssSelect("#current-password");
         Common.clear(element);
        element.sendKeys(currPassword);

        //show passwords
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-password > ion-content > main > section > article > app-text-field > main > section > img").click();
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-password > ion-content > main > section > article > div:nth-child(2) > app-text-field > main > section > img").click();
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-password > ion-content > main > section > article > div:nth-child(3) > app-text-field > main > section > img").click();

        boolean isPresent = Common.isElementPresent(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-password > ion-content > main > button.primary-button"));
        switch (type){
            case 0:
                if(!isPresent){
                    return "false";
                }
                return "true";
            default:
                if(isPresent){
                    Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-password > ion-content > main > button").click();
                    App.sleep(2000);
                }
                return App.driver.getCurrentUrl();
        }
//        cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-password > ion-content > main > section > article > div:nth-child(3) > app-text-field > main > section > img").click();

    }
}
