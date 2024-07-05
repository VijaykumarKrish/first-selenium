package com.celllabs;

import com.aventstack.extentreports.ExtentTest;
import com.celllabs.shared.Common;
import junit.framework.TestCase;


import static com.celllabs.AlertSettingsPage.*;
import static com.celllabs.App.*;
import static com.celllabs.shared.CommonTest.*;


public class AlertSettingsPageTest extends TestCase {

    public void testAlertSettings(){
        setUpReport();
//        openChrome();
        Common.openFirefox();
        createLogin("staging@celllabs.com","123456");

        System.out.println(driver.getCurrentUrl());
        if(driver.getCurrentUrl().equalsIgnoreCase(teamUrl)){
            Common.cssSelect("#main > app-select-team > ion-content > main > section > article > app-options-btn:nth-child(1) > section").click();
            Common.cssSelect("#main > app-select-team > ion-content > main > button").click();
        }

        clickSystem("2");


        goToAlertSetting();

        ExtentTest test = createTest("No Activity Alert Settings");
        noActivity("off","off","on", test);

        test = createTest("Help button Alert Settings");
        helpButton("off","off","on", test);

        test = createTest("Fall Detection Alert Settings");
        fallDetection("off","off","on", test);

        test = createTest("Temperature Alert Settings");
        temperature("off","off","on", test);

        test = createTest("Bed Exits Alert Settings");
        bedExits("off","off","on", test);

        report.flush();




        //status must be Activated or De-activated

        /* no activity */
//        ExtentTest test =  createTest("No Activity Test");


//        noActivity("Activated",false,false);

       /* test =  createTest("Help Button Test");
        helpButton("Activated",false,false, test);

        test =  createTest("Fall Detection Test");
        fallDetection("Activated",false,false, test);

        test =  createTest("Temperature Test");
        temperature("Activated",false,false, test);

        test =  createTest("Bed Exits Test");
        bedExits("Activated",false,false, test);*/

//        goToEditSensorNames();
    }
}