package com.celllabs;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testLoginPage(App app)
    {
//        App app = new App();
        //without @
        String email1 = "carecare.life";
        String password1 = "123456";

        //without .
        String email2 = "care@carelife";
        String password2 = "123456";

        //wrong email
        String email3 = "care123@care.life";
        String password3 = "123456";

        //wrong password
        String email4 = "care@care.life";
        String password4 = "12345678";

        //wrong user name and password
        String email5 = "care456@care.life";
        String password5 = "94123456";

        //correct user name and password
        String email6 = "surya.obulareddy@celllabs.com";
        String password6 = "123456";

        String[] emails = {email1,email2,email3,email4,email5,email6};
        String[] passwords = {password1,password2,password3,password4,password5,password6};

        app.sleep(3000);
        for (int i = 0; i < 6; i++) {
            app.testWriteTestCasesForLogin(i+1,emails[i],passwords[i]);
        }
        app.sleep(2000);
        app.logout();

        //forgot password
        forgotPasswordPage(app);

        app.navigateToLogin();
        app.sleep(2000);
        //first time user
        app.checkFontForFirstTimeUser();
        app.sleep(5000);
        app.refresh();

        app.firstTimeUserPage(email6);
    }

    private void forgotPasswordPage(App app) {
        app.checkFontForgotPassword();
        app.sleep(5 * 1000);
        app.refresh();
        String lastName = "local";
        String phoneNumber = "2890";
        String email = "surya.obulareddy@celllabs.com";

        //case 1: last name with numbers or symbols
        String lastName1 = "local123";
        String lastName2 = "local@";
        String lastName3 = "local123@";

        String[] lastNames = {lastName1,lastName2,lastName3};
        for (int i = 0; i < 3; i++) {
            app.testForgotPasswordPage("lastName",i,lastNames[i],phoneNumber,email);
        }
        //case 2: mobile number cases
        String phoneNumber1 = "123";
        String phoneNumber2 = "12345";

        String[] phoneNumbersArr = {phoneNumber1,phoneNumber2};
        for (int i = 0; i < 2; i++) {
            app.testForgotPasswordPage("phoneNum",i,lastName,phoneNumbersArr[i],email);
        }

        //case 3:email cases
        String email1 = "carecare.life";
        String email2 = "care@carelife";

        String[] emailsArr = {email1,email2};
        for (int i = 0; i < 2; i++) {
            switch (i){
                case 0:
                    app.testForgotPasswordPage("email",i,lastName,phoneNumber,emailsArr[i]);
                    break;
                case 1:
                    app.testForgotPasswordPage("email",i,lastName,phoneNumber,emailsArr[i]);
                    break;
            }
        }

        //wrong details and correct details
        for (int i = 0; i < 2; i++) {
            if(i == 0){
                app.testForgotPasswordPage("",i,lastNames[i],phoneNumbersArr[i],emailsArr[i]);
            }else{
                app.testForgotPasswordPage("",i,lastName,phoneNumber,email);
            }
        }
        app.sleep(2000);
    }

  /*  public void testLoginFont(){
        App app = new App();
        app.sleep(5000);
        app.checkFontForLogin();
        testLoginPage(app);
    }*/


}
