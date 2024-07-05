package com.celllabs;

import com.celllabs.shared.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage {
    protected static void homePageFont() {
        WebElement element = App.webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-systems > ion-content > main > div > app-search-bar > article > input")));
        String searchFont = App.getCssProps(element, "name");
        String searchFontSize = App.getCssProps(element, "size");

        App.js.executeScript("var elem = document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-systems > ion-content > main > div > app-search-bar > article > input'); elem.value = 'Search Systems " + searchFont + " " + searchFontSize + "'; elem.style.cssText='color: #FF0000'");


        element = App.webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-systems > ion-content > main > section > app-system-card:nth-child(1) > section > article:nth-child(2) > h3")));
        String systemNameFont = App.getCssProps(element, "name");
        String systemNameFontSize = App.getCssProps(element, "size");

        App.js.executeScript("var newNode = document.createElement('span');  newNode.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + systemNameFont + " " + systemNameFontSize + "')); document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-systems > ion-content > main > section > app-system-card:nth-child(1) > section > article:nth-child(2) > h3').appendChild(newNode); newNode.style.cssText='color: color:#13d471'");

        element = App.webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-systems > ion-content > main > section > app-system-card:nth-child(1) > section > h4")));
        String lastActivityFont = App.getCssProps(element, "name");
        String lastActivityFontSize = App.getCssProps(element, "size");
        App.js.executeScript("var newNode = document.createElement('span');  newNode.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + lastActivityFont + " " + lastActivityFontSize + "')); document.querySelector('#main > app-home > ion-tabs > div > ion-router-outlet > app-systems > ion-content > main > section > app-system-card:nth-child(1) > section > h4').appendChild(newNode); newNode.style.cssText='color: color:#13d471'");

        //alert Tab
        element = App.webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tab-button-alerts > p")));
        String alertTabFont = App.getCssProps(element, "name");
        String alertTabFontSize = App.getCssProps(element, "size");
        App.js.executeScript("var newNode = document.createElement('span');  newNode.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + alertTabFont + " " + alertTabFontSize + "')); document.querySelector('#tab-button-alerts > p').appendChild(newNode); newNode.style.cssText='color: #FF0000'");

        //system Tab
        element = App.webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tab-button-systems > p")));
        String systemsTabFont = App.getCssProps(element, "name");
        String systemsTabFontSize = App.getCssProps(element, "size");
        App.js.executeScript("var newNode = document.createElement('span');  newNode.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + systemsTabFont + " " + systemsTabFontSize + "')); document.querySelector('#tab-button-systems > p').appendChild(newNode); newNode.style.cssText='color: #FF0000'");

        //account Tab
        element = App.webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tab-button-my-account > p")));
        String accountTabFont = App.getCssProps(element, "name");
        String accountTabFontSize = App.getCssProps(element, "size");
        App.js.executeScript("var newNode = document.createElement('span');  newNode.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + accountTabFont + " " + accountTabFontSize + "')); document.querySelector('#tab-button-my-account > p').appendChild(newNode); newNode.style.cssText='color: #FF0000'");

        //more tab
        element = App.webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tab-button-more > p")));
        String moreTabFont = App.getCssProps(element, "name");
        String moreTabFontSize = App.getCssProps(element, "size");
        App.js.executeScript("var newNode = document.createElement('span');  newNode.appendChild(document.createTextNode('\u00a0\u00a0\u00a0 " + moreTabFont + " " + moreTabFontSize + "')); document.querySelector('#tab-button-more > p').appendChild(newNode); newNode.style.cssText='color: #FF0000'");

        App.sleep(2000);
        App.refresh();
    }

    protected static void checkBottomNavigation() {
        // alerts nav
        Common.cssSelect("#tab-button-alerts > p").click();
        App.sleep(3000);

        //account nav
        Common.cssSelect("#tab-button-my-account > p").click();
        App.sleep(3000);

        //more nav
        Common.cssSelect("#tab-button-more > p").click();
        App.sleep(3000);

        //home nav
        Common.cssSelect("#tab-button-systems > p").click();
    }
    protected static void homePage() {
        App.sleep(2000);
        Common.selectXpath("//*[@id=\"main\"]/app-home/ion-tabs/div/ion-router-outlet/app-systems/ion-content/main/section/app-system-card[1]/section").click();
        App.sleep(1000);

        App.driver.navigate().back();
        App.sleep(2000);
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-systems > ion-content > main > section > app-system-card:nth-child(1) > section > div > img:nth-child(2)").click();

        //click alert Settings
        Common.cssSelect("body > app-root > ion-app > app-menu > ion-menu > main > section > app-options-btn:nth-child(1) > article").click();
//
        App.driver.navigate().back();

        //edit sensor names
        App.sleep(1000);
        Common.cssSelect("body > app-root > ion-app > app-menu > ion-menu > main > section > app-options-btn:nth-child(2)").click();
        App.sleep(1000);
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-sensor-names > ion-content > main > section > app-text-field.system-name.ng-valid.ng-touched.ng-dirty > main > section > div > img").click();

    }
}
