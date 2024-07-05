package com.celllabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.celllabs.App.*;
import static com.celllabs.shared.Common.cssSelect;
import static com.celllabs.shared.Common.isElementPresent;

public class AlertPage {
    public static void checkAlertFont() {
        WebElement element = cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > new-app-bar > main > section > h1");
        String alertsFont = getCssProps(element, "name");
        String alertsFontSize = getCssProps(element, "size");

        js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + alertsFont + " " + alertsFontSize + "')); node.style.cssText = 'font-size: 24px; color: #FF0000;'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > new-app-bar > main > section > h1').appendChild(node)");

        //month font
        element = cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > new-app-bar > main > section > article > app-select > section > article > h4");
        String monthFont = getCssProps(element, "name");
        String monthFontSize = getCssProps(element, "size");

        js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + monthFont + " " + monthFontSize + "')); node.style.cssText = 'font-size: 20px;color: #FF0000;'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > new-app-bar > main > section > article').appendChild(node)");

        //filter font
        element = cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > app-alert-filters > section > alert-header > section > article > span");
        String filterFont = getCssProps(element, "name");
        String filterFontSize = getCssProps(element, "size");
        js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + filterFont + " " + filterFontSize + "')); node.style.cssText = 'font-size: 20px;color: #FF0000;'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > app-alert-filters > section > alert-header > section > article').insertAdjacentElement('beforebegin', node)");

        //add alert font
        element = cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > app-alert-filters > section > alert-header > section > app-add-button > section > article:nth-child(1) > span");
        String addAlertFont = getCssProps(element, "name");
        String addAlertFontSize = getCssProps(element, "size");
        js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + addAlertFont + " " + addAlertFontSize + "')); node.style.cssText = 'font-size: 20px;color: #FF0000;margin-left:60rem'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > app-alert-filters > section > alert-header > section > article').insertAdjacentElement('afterend', node);");

        //check temperature boxes font
        element = cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile:nth-child(1) > article > alert-top-content > main > section > article:nth-child(1) > h4");
        String tempTitleFont = getCssProps(element, "name");
        String tempTitleFontSize = getCssProps(element, "size");
        js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + tempTitleFont + " " + tempTitleFontSize + "')); node.style.cssText = 'margin-right: 10rem'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile:nth-child(1) > article > alert-top-content > main > section > article:nth-child(1) > h4').insertAdjacentElement('afterend', node);");

        //sensor name font
        element = cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile:nth-child(1) > article > alert-top-content > main > section > article:nth-child(2) > div > h5");
        String sensorNameFont = getCssProps(element, "name");
        String sensorNameFontSize = getCssProps(element, "size");
        js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + sensorNameFont + " " + sensorNameFontSize + "')); node.style.cssText = 'margin-right: 10rem'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile:nth-child(1) > article > alert-top-content > main > section > article:nth-child(2) > div > h5').insertAdjacentElement('afterend', node);");


        boolean isPresent = isElementPresent(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile:nth-child(1) > article > alert-bottom-content > section > unresolved-alert > div > button"));
        if (isPresent) {
            //Acknowledge font
            element = cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile:nth-child(1) > article > alert-bottom-content > section > unresolved-alert > div > button");
            String ackBtnFont = getCssProps(element, "name");
            String ackBtnFontSize = getCssProps(element, "size");
            js.executeScript("var node = document.createElement('span'); node.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + ackBtnFont + " " + ackBtnFontSize + "')); node.style.cssText = 'color: #FF0000;'; document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile:nth-child(1) > article > alert-bottom-content > section > unresolved-alert > div > button').appendChild(node);");

        } else {
            System.out.println("Acknowledge button is nt available");
        }

        sleep(3000);
        refresh();
    }

    protected static void clickOnAlert() {
        cssSelect("#tab-button-alerts > p").click();

    }

    protected static void checkAlertFilter() {
        //check month drop down
        cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > new-app-bar > main > section > article > app-select > section > article > h4 > img").click();
        sleep(1000);
        cssSelect("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-alerts > new-app-bar > main > section > article > app-select > section > article.custom-scrollbar > p:nth-child(2)").click();
        sleep(1000);
        cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > new-app-bar > main > section > article > app-select > section > article > h4 > img").click();
        sleep(1000);
        cssSelect("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-alerts > new-app-bar > main > section > article > app-select > section > article.custom-scrollbar > p:nth-child(1)").click();
        sleep(1000);

        //check filter
        checkFilter();




       /* //false check
        clickAcknowledge("testing false using selenium");
       cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile:nth-child(1) > article > alert-bottom-content > section > unresolved-alert > article > acknowledged-alert > article > alert-options > alert-tile-buttons > article > button.secondary-button").click();

        //resolve check
        clickAcknowledge("testing resolve using selenium");
        cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile:nth-child(1) > article > alert-bottom-content > section > unresolved-alert > article > acknowledged-alert > article > alert-options > alert-tile-buttons > article > button.primary-button").click();
*/
    }

    protected static void changeAlert(String title, String systemNum, String description, int type) {
        //add alert
        if (type == 1) {
            cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > app-alert-filters > section > alert-header > section > button").click();
            cssSelect("#description").sendKeys(title);
            cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-alert > ion-content > main > section > article:nth-child(3) > app-multi-select > section > article").click();
            cssSelect("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-alert > ion-content > main > section > article:nth-child(3) > app-multi-select > section > article.custom-scrollbar > p:nth-child(" + systemNum + ")").click();
            cssSelect("#what-happened").sendKeys(description);
            sleep(1000);
            cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-alert > ion-content > main > app-save-delete-button > div > button").click();
            sleep(2000);
        } else if (type == 2) {
            sleep(2000);
            cssSelect("#description").clear();
            cssSelect("#description").sendKeys(title);
            cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-alert > ion-content > main > section > article:nth-child(3) > app-multi-select > section > article").click();
            cssSelect("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-alert > ion-content > main > section > article:nth-child(3) > app-multi-select > section > article.custom-scrollbar > p:nth-child(" + systemNum + ")").click();
            cssSelect("#what-happened").clear();
            cssSelect("#what-happened").sendKeys(description);

            cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-alert > ion-content > main > app-save-delete-button > div > button.primary-button").click();
        } else {
            refresh();
            cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-alert > ion-content > main > app-save-delete-button > div > button.delete-btn").click();
            cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-alert > ion-content > main > app-delete-card > ion-card > section > div > button.delete-btn").click();
        }

        //click on filter
        cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > app-alert-filters > section > alert-header > section > article").click();
        cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > app-alert-filters > section > article > system-type-alert-filter > section > article > button.unselected-button").click();
        sleep(1000);

    }

    protected static String checkChangeAlert(String title) {
        List<WebElement> resolveList = driver.findElements(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile"));
        for (int index = 0; index < resolveList.size(); index++) {
            WebElement element = resolveList.get(index);
            String alertTitle = element.findElement(By.cssSelector("article > alert-top-content > main > section > article:nth-child(1) > h4")).getText();
            if (alertTitle.equalsIgnoreCase(title)) {
                return "true";
            }
        }
        return "false";
    }

    protected static void editAlert(String title, String newTitle, String system, String description) {
        sleep(3000);
        /*refresh();
        sleep(3000);*/
        List<WebElement> resolveList = driver.findElements(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile"));
        for (int index = 0; index < resolveList.size(); index++) {
            WebElement element = resolveList.get(index);
            String alertTitle = element.findElement(By.cssSelector("article > alert-top-content > main > section > article:nth-child(1) > h4")).getText();
            if (alertTitle.equalsIgnoreCase(title)) {
                element.findElement(By.cssSelector("article > alert-top-content > main > section > article:nth-child(2) > img")).click();
                changeAlert(newTitle, system, description, 2);
                break;
            }
        }
    }

    protected static void deleteAlert(String title) {
        List<WebElement> resolveList = driver.findElements(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile"));
        for (int index = 0; index < resolveList.size(); index++) {
            WebElement element = resolveList.get(index);
            String alertTitle = element.findElement(By.cssSelector("article > alert-top-content > main > section > article:nth-child(1) > h4")).getText();
            if (alertTitle.equalsIgnoreCase(title)) {
                element.findElement(By.cssSelector("article > alert-top-content > main > section > article:nth-child(2) > img")).click();
                changeAlert(title, "", "", 3);
                break;
            }
        }
    }

    protected static String acknowledgeAlert(String title, String ackMsg, int type) {
        sleep(2000);
        if (type == 2) {
            cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > app-alert-filters > section > alert-header > section > article").click();
        }
        cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > app-alert-filters > section > article > system-type-alert-filter > section > article > button.unselected-button").click();

        List<WebElement> unResolvedList = driver.findElements(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile"));

        boolean ackBtn = isElementPresent(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile:nth-child(1) > article > alert-bottom-content > section > unresolved-alert > div > button"));
        if (ackBtn) {
            cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile:nth-child(1) > article > alert-bottom-content > section > unresolved-alert > div > button").click();
        }
        sleep(1000);

        //click resolve
        for (int index = 0; index < unResolvedList.size(); index++) {
            WebElement element = unResolvedList.get(index);
            System.out.println("element "+element);
            String alertText = element.findElement(By.cssSelector("article > alert-top-content > main > section > article > h4")).getText();
            if (alertText.equalsIgnoreCase(title)) {
                element.findElement(By.cssSelector("alert-bottom-content")).click();
                element.findElement(By.cssSelector("alert-bottom-content > section > unresolved-alert > article > acknowledged-alert > article > alert-options > input")).sendKeys(ackMsg);

                if (type == 1) {
                    cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile:nth-child(1) > article > alert-bottom-content > section > unresolved-alert > article > acknowledged-alert > article > alert-options > alert-tile-buttons > article > button.resolve-button").click();
                    cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile:nth-child(1) > article > alert-bottom-content > section > unresolved-alert > article > acknowledged-alert > mark-resolve-or-false-alert > section > alert-tile-buttons > article > button").click();
                    sleep(5000);
//                    cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > app-alert-filters > section > alert-header > section > article > span").click();
                    cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > app-alert-filters > section > article > system-type-alert-filter > section > article > button.unselected-button").click();
                    cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > app-alert-filters > section > alert-header > section > article > span").click();

                    sleep(1000);
                    List<WebElement> resolvedList = driver.findElements(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile"));
                    for(WebElement webElement : resolvedList){
                        alertText = webElement.findElement(By.cssSelector("article > alert-top-content > main > section > article:nth-child(1) > h4")).getText();
                        if(alertText.equalsIgnoreCase(title)){
                            return "true";
                        }
                    }
                    sleep(2000);
                    return "false";
                } else {
                    cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile:nth-child(1) > article > alert-bottom-content > section > unresolved-alert > article > acknowledged-alert > article > alert-options > alert-tile-buttons > article > button.secondary-button").click();
                    cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile:nth-child(1) > article > alert-bottom-content > section > unresolved-alert > article > acknowledged-alert > mark-resolve-or-false-alert > section > alert-tile-buttons > article > button").click();
                    sleep(2000);
                    driver.navigate().to(baseUrl + "#/home/more");
                    cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-more > ion-content > main > section > app-options-btn:nth-child(2)").click();
                    List<WebElement> falseList = driver.findElements(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-false-alerts > ion-content > main > section > article > div > app-alert-tile"));
                    for(WebElement webElement : falseList){
                        alertText = element.findElement(By.cssSelector("article > alert-top-content > main > section > article:nth-child(1) > h4")).getText();
                        if(alertText.equalsIgnoreCase(title)){
                            return "true";
                        }
                    }

                    sleep(2000);
                    return "false";
                }
            }
        }
        sleep(1000);
        return "";
    }

    protected static String restoreAlert(String title, String restoreMsg){
        List<WebElement> falseList = driver.findElements(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-false-alerts > ion-content > main > section > article > div > app-alert-tile"));
        System.out.println(falseList.size());
        for (WebElement webElement : falseList){
            System.out.println(webElement);
            String alertText = webElement.findElement(By.cssSelector("article > alert-top-content > main > section > article:nth-child(1) > h4")).getText();
            if(alertText.equalsIgnoreCase(title)){
                webElement.findElement(By.cssSelector("article > alert-bottom-content > section > resolved-or-reportedfalse-alert > section > acknowledge-resolve-alert")).click();
                webElement.findElement(By.cssSelector("article > alert-bottom-content > section > resolved-or-reportedfalse-alert > section > article > button")).click();

                webElement.findElement(By.cssSelector("article > alert-bottom-content > section > resolved-or-reportedfalse-alert > section > div > div > input")).clear();
                webElement.findElement(By.cssSelector("article > alert-bottom-content > section > resolved-or-reportedfalse-alert > section > div > div > input")).sendKeys(restoreMsg);
                webElement.findElement(By.cssSelector("article > alert-bottom-content > section > resolved-or-reportedfalse-alert > section > div > div > div > img:nth-child(2)")).click();
                break;
            }
        }


        return "";
    }
    private static void checkFilter() {
        cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > app-alert-filters > section > alert-header > section > article").click();
        checkFilterForSensors();
        checkFilterForRoom();
    }

    private static void checkFilterForSensors() {
        cssSelect("#alert-filter1 > p").click();
        sleep(1000);
        cssSelect("#alert-filter2 > p").click();
        sleep(1000);
        cssSelect("#alert-filter3 > p").click();
        sleep(1000);
        cssSelect("#alert-filter4 > p").click();
        sleep(1000);
        cssSelect("#alert-filter5 > p").click();
        sleep(1000);
        cssSelect("#alert-filter6 > p").click();
        sleep(1000);
    }

    private static void checkFilterForRoom() {
        cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > app-alert-filters > section > article > system-type-alert-filter > section > div > app-select > section > article").click();
        sleep(1000);
        cssSelect("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-alerts > ion-content > main > section > app-alert-filters > section > article > system-type-alert-filter > section > div > app-select > section > article.custom-scrollbar > p:nth-child(2)").click();
        checkFilterForSensors();
    }

    private static void clickAcknowledge(String msg) {
        boolean isPresent = isElementPresent(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile:nth-child(1) > article > alert-bottom-content > section > unresolved-alert > div > button"));
        if (isPresent) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile:nth-child(1) > article > alert-bottom-content > section > unresolved-alert > div > button"))).click();
        }
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile:nth-child(1) > article > alert-bottom-content > section > unresolved-alert > article > acknowledged-alert"))).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > ion-content > main > section > article > div > app-alert-tile:nth-child(1) > article > alert-bottom-content > section > unresolved-alert > article > acknowledged-alert > article > alert-options > input"))).sendKeys(msg);
    }

    protected static String clickOnMonth(String month, String path) {
        cssSelect(path).click();
//        cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > new-app-bar > main > section > article > app-select > section > article").click();
//        cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-false-alerts > new-app-bar > main > section > article > app-select > section > article")
        List<WebElement> monthList = driver.findElements(By.cssSelector(path+".custom-scrollbar > p"));

        for (int index = 0; index < monthList.size(); index++) {
            WebElement element = monthList.get(index);
            if (element.getText().equalsIgnoreCase(month)) {
                element.click();
                break;
            }
        }
        sleep(1000);
        String monthText = cssSelect(path+" > h4").getText().trim();
        return monthText;

    }
}
