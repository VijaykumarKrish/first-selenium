package com.celllabs;

import com.celllabs.shared.Common;
import org.openqa.selenium.By;

public class ActivityPage {
    protected static void clickSystem(String number){
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-systems > ion-content > main > section > app-system-card:nth-child("+number+")").click();
    }
    protected static void goToActivityPage(int system){
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-systems > ion-content > main > section > app-system-card:nth-child("+system+")").click();
    }
    protected static void activityCheck(int dayOfMonth){
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-selected-system > ion-content > main > system-activity-tile").click();
//        cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-activity > app-bar > main > ion-toolbar > ion-buttons.buttons-last-slot.sc-ion-buttons-md-h.sc-ion-buttons-md-s.md.hydrated > article > app-calendar-button > article > button").click();
//        sleep(1000);
//        cssSelect("#ion-overlay-4 > div > app-calendar > main > section > ion-calendar > ion-calendar-month > div > div > div:nth-child("+(dayOfMonth+3)+") > button").click();
//        sleep(2000);
        checkOtherDate("#main > app-home > ion-tabs > div > ion-router-outlet > app-activity > ion-content > main > header > app-week-calendar > section > article:nth-child(4)");
        Common.navigateBack();
        //check sleep sensor exist
        boolean isExist = Common.isElementPresent(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-selected-system > ion-content > main > section:nth-child(2) > h3"));
        if(isExist){
            Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-selected-system > ion-content > main > section:nth-child(2) > article > system-sleep-sensors:nth-child(1)").click();
            App.sleep(1000);
            checkOtherDate("#main > app-home > ion-tabs > div > ion-router-outlet > app-sleep-details > ion-content > main > div > app-week-calendar > section > article:nth-child(4)");
            App.sleep(2000);
            Common.navigateBack();
        }
        //check Medic.life exist
        isExist = Common.isElementPresent(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-selected-system > ion-content > main > section:nth-child(3) > h3"));
        if(isExist){
            Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-selected-system > ion-content > main > section:nth-child(3) > article > system-medic-tile").click();
            clickOnMonth();
            checkOtherDate("#main > app-home > ion-tabs > div > ion-router-outlet > app-medic-life > ion-content > main > header > app-week-calendar > section > article:nth-child(4)");
            Common.navigateBack();
        }

    }

    private static void clickOnMonth() {
        Common.cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-medic-life > ion-content > main > div > section > medic-bottom > main > article > button:nth-child(1)").click();
        App.sleep(2000);
    }

    private static void checkOtherDate(String path) {
        Common.cssSelect(path).click();
        App.sleep(2000);
    }
}
