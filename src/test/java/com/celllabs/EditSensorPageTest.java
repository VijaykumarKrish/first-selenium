package com.celllabs;


import com.aventstack.extentreports.ExtentTest;
import com.celllabs.shared.Common;
import junit.framework.TestCase;

import static com.celllabs.App.createLogin;
import static com.celllabs.shared.CommonTest.*;

public class EditSensorPageTest extends TestCase {

    public void testEditSensorNamesPage(){
        setUpReport();
        Common.openFirefox();
//        openChrome();
        createLogin("pranay.prasad@celllabs.com","123456");
        EditSensorPage.goToSystemSettings(1);
        EditSensorPage.clickEditSensorNames();

        ExtentTest test = createTest("Edit Sensor Page Test");
        test.pass("test started");


        String output = EditSensorPage.changeSystemName("01001ABAB12");
        if(output != null) assertEquals("01001ABAB12", output);
        conditionCheck("01001ABAB12",output,"test passed",test);

        //CLHGB
        String actual = EditSensorPage.changeToiletSensorName("CLHGB");
        if(actual != null) assertEquals("CLHGB", actual);

        //CL56789872
        output = EditSensorPage.changeBedSensorName("CL56789873");
        if(output != null) assertEquals("CL56789873", output);


        /*conditionCheck("Room 6", output);

        String output = changeSystemName("Room 6");
*/

    }

}