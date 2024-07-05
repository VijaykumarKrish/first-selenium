package com.celllabs;

import com.celllabs.shared.Common;
import junit.framework.TestCase;

import static com.celllabs.App.createLogin;
import static com.celllabs.HomePage.*;

public class HomePageTest extends TestCase {


//    public void test(){
//        Common.openChrome();
//        createLogin("pranay.prasad@celllabs.com","123456");
//    }
//    public void test1(){
//        homePageFont();
//    }
    public void testHomePage(){
//        Common.openChrome();
//        createLogin("pranay.prasad@celllabs.com","123456");
//        homePageFont();
        checkBottomNavigation();
        homePage();
        /*App app = new App();
        app.createLogin("surya.obulareddy@celllabs.com","123456");
        app.homePageFont();
        app.checkBottomNavigation();
        app.homePage();
*/

    }

}