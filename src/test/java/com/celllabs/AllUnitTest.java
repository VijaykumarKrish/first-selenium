package com.celllabs;

import com.celllabs.shared.Common;
import junit.framework.TestCase;
import com.celllabs.more.UsersTest;
import org.testng.annotations.Test;


import java.net.URL;

import static com.celllabs.App.*;
import static com.celllabs.More.clickOnMore;

import static com.celllabs.shared.Common.openChrome;
import static com.celllabs.shared.CommonTest.*;
import static org.testng.AssertJUnit.assertTrue;


//@RunWith(Suite.class)
//@Suite.SuiteClasses({UsersTest.class, AccountTest.class, LoginPageTest.class, })
public class AllUnitTest {

//    @BeforeTest
    public void loadJsonInputs(){
        readFromJsonFile("testcases.json");
        Common.openChrome();
        setUpReport();
    }
    @Test
    public void sampleTest() {
        assertTrue("This test should always pass", true);
    }

    @Test()
    public void All() {

        loadJsonInputs();
//        openChrome();
//        setUpReport();


        System.out.println("reading completed....");

        //login screen
        //LoginPageTest.testLoginScreenFont();
        //LoginPageTest.testLoginScreen();

        //forgot screen
        //LoginPageTest.testForgotPasswordTest();

        //account page
        AccountTest.testClickAccountPage();

        UsersTest.testAddUsers();
        UsersTest.testEditUsers();

        clickOnMore();
        clickOnLogOutButton();
        sleep(2000);

        LoginPageTest.testFirstTimeUser();


    }

   /* @Test(priority = 1)
    public void loadJsonInputs(){
        readFromJsonFile("testcases.json");
        setUpReport();
        Common.openChrome();

    }*/

  /*  @Test(priority = 3)
    public void xmlTesting(){
//        System.setProperty(chromeDriver, chromeDriverPath);
        System.out.println("hello world1");
    }
    @Test(priority = 5)
    public void xmlTesting2(){
        System.out.println("testing hello world2");
    }

    @Test(priority = 4)
    public void xmlTesting3(){
        System.out.println("testing hello world3");
    }

    @Test(priority = 6)
    public void xmlTesting4(){
        System.out.println("testing hello world4");
    }*/

}
