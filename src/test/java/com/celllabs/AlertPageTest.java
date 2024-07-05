package com.celllabs;

import com.aventstack.extentreports.ExtentTest;
import com.celllabs.shared.Common;
import com.celllabs.shared.CommonTest;
import junit.framework.TestCase;

public class AlertPageTest extends TestCase {

    public void testAlert(){
//        CommonTest.setUpReport();
//        Common.openChrome();
        App.createLogin("pranay.prasad@celllabs.com","123456");

        if(App.driver.getCurrentUrl().equalsIgnoreCase(App.teamUrl)){
            Common.cssSelect("#main > app-select-team > ion-content > main > section > article > app-options-btn:nth-child(1) > section").click();
            Common.cssSelect("#main > app-select-team > ion-content > main > button").click();
        }

        AlertPage.clickOnAlert();
        ExtentTest test = CommonTest.createTest("Alert Month test");
        String output = AlertPage.clickOnMonth("may","#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > new-app-bar > main > section > article > app-select > section > article");
        CommonTest.conditionCheck("may",output,"clicked on month test", test);


//        checkAlertFont();
//        checkAlertFilter();

        //for resolve alert
        test = CommonTest.createTest("Add Alert test");
        //1.add 2.edit 3.update

        AlertPage.changeAlert("new resolve alert testing","1","testing using selenium",1);
        output = AlertPage.checkChangeAlert("new resolve alert testing");
        CommonTest.conditionCheck("true",output,"add alert test",test);

        AlertPage.editAlert("new resolve alert testing","test resolve1","1","selenium test");
        output = AlertPage.checkChangeAlert("test resolve1");
        CommonTest.conditionCheck("true",output,"edit alert test",test);

        AlertPage.deleteAlert("test resolve1");
        output = AlertPage.checkChangeAlert("test resolve1");
        CommonTest.conditionCheck("false",output,"delete alert test",test);

        AlertPage.clickOnMonth("april","#main > app-home > ion-tabs > div > ion-router-outlet > app-alerts > new-app-bar > main > section > article > app-select > section > article");
        //type: 1.resolve alert  2.false alert
        output = AlertPage.acknowledgeAlert("No Activity","used for testing resolve alert",1);
        CommonTest.conditionCheck("true",output,"acknowledge alert test",test);

        //for false alert
//        changeAlert("new false alert","1","testing using selenium",1);
        output = AlertPage.acknowledgeAlert("No Activity","used for testing false alert",2);
        CommonTest.conditionCheck("true",output,"acknowledge alert test",test);

        //for restoring
        AlertPage.clickOnMonth("april", "#main > app-home > ion-tabs > div > ion-router-outlet > app-false-alerts > new-app-bar > main > section > article > app-select > section > article");
        AlertPage.restoreAlert("No Activity", "for testing restore");
    }

}