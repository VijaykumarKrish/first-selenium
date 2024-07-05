package com.celllabs;

import com.aventstack.extentreports.ExtentTest;
import com.celllabs.shared.Common;
import com.celllabs.shared.CommonTest;
import junit.framework.TestCase;
import com.celllabs.enums.ReturnType;



import java.util.List;

import static com.celllabs.App.*;
import static com.celllabs.LoginPage.*;
import static com.celllabs.shared.Common.fontColor;
import static com.celllabs.shared.CommonTest.*;
import static com.celllabs.shared.CommonTest.fontCasesReport;

public class LoginPageTest extends TestCase {


//    @BeforeEach
//    public void init() {
//        Common.openChrome();
//    }

    public static void testLoginScreenFont(){
        ExtentTest test = createTest("Login Page Font Test");

        /* 0-label font, 1-inputFont */
       //email or phoneNumber label font
       String actual = Common.checkFont("#main > app-login > ion-content > main > section > article:nth-child(2) > div.text-field > app-text-field > main > article > h4", 0);
        fontCasesReport(fontColor, actual, "email or phoneNumber label font test", test);

       //email or phoneNumber Field test
        actual = Common.checkFont("#email", 1);
        fontCasesReport(fontColor, actual, "email or phoneNumber Field test", test);

        //password label font test
        actual = Common.checkFont("#main > app-login > ion-content > main > section > article:nth-child(2) > div.text-field > div > app-text-field > main > article > h4", 0);
        fontCasesReport(fontColor, actual, "password label font test", test);

        //password Field font test
        actual = Common.passwordFieldFont("#password", "#main > app-login > ion-content > main > section > article:nth-child(2) > div.text-field > div > app-text-field > main > section > img", 0);
        fontCasesReport(fontColor, actual, "password Field font test", test);

        //login button font test
        actual = Common.checkFont("#main > app-login > ion-content > main > section > article:nth-child(2) > div.buttons > button", 0);
        fontCasesReport(fontColor, actual, "login button font test", test);

        //forgot password font test
        actual = Common.checkFont("#main > app-login > ion-content > main > section > article:nth-child(2) > div.buttons > p:nth-child(2)", 0);
        fontCasesReport(fontColor, actual, "forgot password font test", test);

        //first time user font test
        actual = Common.checkFont("#main > app-login > ion-content > main > section > article:nth-child(2) > div.buttons > p:nth-child(3)", 0);
        fontCasesReport(fontColor, actual, "first time user font test", test);

        //click here font test
        actual = Common.checkFont("#main > app-login > ion-content > main > section > article:nth-child(2) > div.buttons > p:nth-child(3) > span", 0);
        fontCasesReport(fontColor, actual, "click here font test", test);

        //version font test
        actual = Common.checkFont("#main > app-login > ion-content > main > section > article:nth-child(2) > p", 0);
        fontCasesReport(fontColor, actual, "version font test", test);

        report.flush();
    }
    public static void testLoginScreen() {
//        setUpReport();
        ExtentTest test = createTest("Login Page Test");

        test.info("logging test case started");
//        Common.openChrome();
        List<TestData.LoginScreen> loginList = TestData.getUserData().getLoginScreen();
        //wrong password and correct email
        String url = createLogin(loginList.get(0).getEmail(), loginList.get(1).getPassword());
        conditionCheck(baseUrl + "#/login", url, "wrong password and correct email test", test);

        //email without @
        createLogin(loginList.get(2).getEmail(), loginList.get(0).getPassword());
        conditionCheck(baseUrl + "#/login", url, "email without @ and correct password test", test);

        //email without .
        createLogin(loginList.get(3).getEmail(), loginList.get(0).getPassword());
        conditionCheck(baseUrl + "#/login", url, "email without . and correct password test", test);

        //Correct password, wrong email
        createLogin(loginList.get(4).getEmail(), loginList.get(0).getPassword());
        conditionCheck(baseUrl + "#/login", url, "Correct password and wrong email test", test);


        //correct details
        createLogin(loginList.get(0).getEmail(), loginList.get(0).getPassword());
        checkLoginStatus("email", test);


        //correct phone number and correct password
        createLogin(loginList.get(5).getPhoneNumber(), loginList.get(0).getPassword());
        checkLoginStatus("phone number", test);


        //password show/hide test
        boolean isTrue = showHideLoginPassword("#password", "#main > app-login > ion-content > main > section > article:nth-child(2) > div.text-field > div > app-text-field > main > section > img", "");
        conditionCheck("true",String.valueOf(isTrue), "Login password show hide button test", test);


        url = forgotPasswordPageClick();
        conditionCheck(baseUrl + "#/forgot-password/verify-user", url, "forgot password click test", test);
        Common.navigateBack();

        url = firstTimeUserClick();
        conditionCheck(baseUrl + "#/signup/verify-account", url, "first time user click test", test);
        Common.navigateBack();

        String actual = checkCurrentVersion();
        conditionCheck(loginList.get(6).getVersion(), actual, "version check test", test);

        report.flush();
    }
    public static void forgotPasswordFontTest(){
        ExtentTest test = CommonTest.createTest("Forgot Page Font Test");

        /* verify user screen font */

        //forgot password title font test
        String actual = Common.checkFont("#main > app-verify-user > ion-content > main > article:nth-child(1) > h3", 0);
        fontCasesReport(fontColor,actual,"forgot password title font test", test);

        //enter details sub title font test
        actual = Common.checkFont("#main > app-verify-user > ion-content > main > article:nth-child(1) > h4", 0);
        fontCasesReport(fontColor,actual,"enter details sub title font test", test);

        //last name label font test
        actual = Common.checkFont("#main > app-verify-user > ion-content > main > article:nth-child(2) > app-text-field:nth-child(1) > main > article > h4", 0);
        fontCasesReport(fontColor,actual,"last name label font test", test);

        //last name input field font test
        actual = Common.checkFont("#last-name", 1);
        fontCasesReport(fontColor,actual,"last name input field font test", test);

        //last 4-digit phone label font test
        actual = Common.checkFont("#main > app-verify-user > ion-content > main > article:nth-child(2) > app-text-field:nth-child(2) > main > article > h4", 0);
        fontCasesReport(fontColor,actual,"last 4-digit phone label font test", test);

        //last 4-digit phone input field font test
        actual = Common.checkFont("#phone-number", 1);
        fontCasesReport(fontColor,actual,"last 4-digit phone input field font test", test);

        //email label font test
        actual = Common.checkFont("#main > app-verify-user > ion-content > main > article:nth-child(2) > div > app-text-field > main > article > h4", 0);
        fontCasesReport(fontColor,actual,"email label font test", test);

        //email input field font test
        actual = Common.checkFont("#Email", 1);
        fontCasesReport(fontColor,actual,"email input field font test", test);

        //verification button font test
        actual = Common.checkFont("#main > app-verify-user > ion-content > main > button", 0);
        fontCasesReport(fontColor,actual,"verification button font test", test);

        report.flush();

    }
    public static void validateOtpFontTest(int forgotFirstUserType){
        sleep(2000);
        ExtentTest test = null;
        if(forgotFirstUserType == 0){
            test = CommonTest.createTest("Forgot Password Validate Otp Font Test");
        }else{
            test = CommonTest.createTest("First Time User Validate Otp Font Test");
        }

        //verification title font test
        String actual = Common.checkFont("#main > app-validate-otp > ion-content > section > article:nth-child(1) > h3", 0);
        fontCasesReport(fontColor,actual,"verification title font test", test);

        //code sent to email title font
        actual = Common.checkFont("#main > app-validate-otp > ion-content > section > article:nth-child(1) > h4:nth-child(2)",0);
        fontCasesReport(fontColor, actual, "code sent to email title font test", test);

        //enter code title font test
        actual = Common.checkFont("#main > app-validate-otp > ion-content > section > article:nth-child(1) > h4:nth-child(3)",0);
        fontCasesReport(fontColor, actual, "enter code title font test", test);

        //verification code label test
        actual = Common.checkFont("#main > app-validate-otp > ion-content > section > article:nth-child(2) > div > app-text-field > main > article > h4",0);
        fontCasesReport(fontColor, actual, "verification code label test", test);

        //verification code input filed test
        actual = Common.checkFont("#otp",1);
        fontCasesReport(fontColor, actual, "verification code input filed test", test);

        //continue button font test
        actual = Common.checkFont("#main > app-validate-otp > ion-content > section > button",0);
        fontCasesReport(fontColor, actual, "continue button font test", test);
        report.flush();
    }
    public static void forgotPwdChangePwdFont(){
        ExtentTest test = CommonTest.createTest("Forgot Password Recovery Font Test");

        //password recovery title font test
        String actual = Common.checkFont("#main > app-set-password > ion-content > section > article:nth-child(1) > h3",0);
        fontCasesReport(fontColor, actual, "password recovery title font test", test);

        //enter password title font test
        actual = Common.checkFont("#main > app-set-password > ion-content > section > article:nth-child(1) > h4",0);
        fontCasesReport(fontColor, actual, "enter password title font test", test);

        //new password label font test
        actual = Common.checkFont("#main > app-set-password > ion-content > section > article:nth-child(2) > app-text-field > main > article > h4",0);
        fontCasesReport(fontColor, actual, "new password label font test", test);

        //new password input field test
        actual = Common.passwordFieldFont("#newpassword","#main > app-set-password > ion-content > section > article:nth-child(2) > app-text-field > main > section > img", 0);
        fontCasesReport(fontColor, actual, "new password input field test", test);

        //Reenter password label font test
        actual = Common.checkFont("#main > app-set-password > ion-content > section > article:nth-child(2) > div > app-text-field > main > article > h4",0);
        fontCasesReport(fontColor, actual, "Reenter password label font test", test);

        //Reenter password input field test
        actual = Common.passwordFieldFont("#confirmpassword","#main > app-set-password > ion-content > section > article:nth-child(2) > div > app-text-field > main > section > img", 0);
        fontCasesReport(fontColor, actual, "new password label font test", test);

        //Reset password button font test
        actual = Common.checkFont("#main > app-set-password > ion-content > section > button",0);
        fontCasesReport(fontColor, actual, "Reset password button font test", test);

        report.flush();
    }
    public static void verifyAccountFontTest(){
        ExtentTest test = CommonTest.createTest("Verify Account Font Test");

        //account verification title font test
        String actual = Common.checkFont("#main > app-verify-account > ion-content > main > article:nth-child(1) > h3",0);
        fontCasesReport(fontColor, actual, "account verification title font test", test);

        //enter email or phone subtitle font test
        actual = Common.checkFont("#main > app-verify-account > ion-content > main > article:nth-child(1) > h4",0);
        fontCasesReport(fontColor, actual, "enter email or phone subtitle font test", test);

        //email label font test
        actual = Common.checkFont("#main > app-verify-account > ion-content > main > article:nth-child(2) > div:nth-child(1) > app-text-field > main > article > h4",0);
        fontCasesReport(fontColor, actual, "email label font test", test);


        //email input field font test
        refresh();
        actual = Common.checkFont("#email",1);
        fontCasesReport(fontColor, actual, "email input field font test", test);

        //Or text font test
        actual = Common.checkFont("#main > app-verify-account > ion-content > main > article:nth-child(2) > p",0);
        fontCasesReport(fontColor, actual, "Or text font test", test);

        //phone number label font test
        actual = Common.checkFont("#main > app-verify-account > ion-content > main > article:nth-child(2) > div:nth-child(3) > app-text-field > main > article > h4",0);
        fontCasesReport(fontColor, actual, "phone number label font test", test);

        //phone number input field font test
        actual = Common.checkFont("#phone",1);
        fontCasesReport(fontColor, actual, "phone number input field font test", test);

        //send verification code button font test
        actual = Common.checkFont("#main > app-verify-account > ion-content > main > button",0);
        fontCasesReport(fontColor, actual, "send verification code button font test", test);

        report.flush();
    }
    public static void setPasswordFont(){
        ExtentTest test = CommonTest.createTest("First Time User SetPassword Font Test");

        //create account title font test
        String actual = Common.checkFont("#main > app-set-password > ion-content > section > article:nth-child(1) > h3",0);
        fontCasesReport(fontColor, actual, "create account title font test", test);

        //account number title font test
        actual = Common.checkFont("#main > app-set-password > ion-content > section > article:nth-child(1) > h4",0);
        fontCasesReport(fontColor, actual, "account number title font test", test);

        //user account number font test
        actual = Common.checkFont("#main > app-set-password > ion-content > section > article:nth-child(1) > h5",0);
        fontCasesReport(fontColor, actual, "user account number font test", test);

        //new password label font test
        actual = Common.checkFont("#main > app-set-password > ion-content > section > article:nth-child(2) > app-text-field > main > article > h4",0);
        fontCasesReport(fontColor, actual, "new password label font test", test);

        //new password input field font test
        actual = Common.passwordFieldFont("#newpassword", "#main > app-set-password > ion-content > section > article:nth-child(2) > app-text-field > main > section > img",0);
        fontCasesReport(fontColor, actual, "new password input field font test", test);

        //Reenter password label font test
        actual = Common.checkFont("#main > app-set-password > ion-content > section > article:nth-child(2) > div > app-text-field > main > article > h4",0);
        fontCasesReport(fontColor, actual, "Reenter password label font test", test);

        //Reenter password input field font test
        actual = Common.passwordFieldFont("#confirmpassword", "#main > app-set-password > ion-content > section > article:nth-child(2) > div > app-text-field > main > section > img", 0);
        fontCasesReport(fontColor, actual, "Reenter password input field font test", test);

        //signup button font test
        actual = Common.checkFont("#main > app-set-password > ion-content > section > button", 0);
        fontCasesReport(fontColor, actual, "signup button font test", test);

        report.flush();
    }
    public static void accountDetailsFont(){
        ExtentTest test = CommonTest.createTest("Account Details Font Test");

        //account details title font test
        String actual = Common.checkFont("#main > app-account-details > ion-content > section > article > h3", 0);
        fontCasesReport(fontColor, actual, "account details title font test", test);

        //account number title font test
        actual = Common.checkFont("#main > app-account-details > ion-content > section > article > div:nth-child(2) > h4", 0);
        fontCasesReport(fontColor, actual, "account number title font test", test);

        //user account number font test
        actual = Common.checkFont("#main > app-account-details > ion-content > section > article > div:nth-child(2) > p", 0);
        fontCasesReport(fontColor, actual, "user account number font test", test);

        //Administrator title font test
        actual = Common.checkFont("#main > app-account-details > ion-content > section > article > div:nth-child(3) > h4", 0);
        fontCasesReport(fontColor, actual, "Administrator title font test", test);

        //Administrator name font test
        actual = Common.checkFont("#main > app-account-details > ion-content > section > article > div:nth-child(3) > p", 0);
        fontCasesReport(fontColor, actual, "Administrator name font test", test);

        //first and last name title font test
        actual = Common.checkFont("#main > app-account-details > ion-content > section > article > div:nth-child(4) > h4", 0);
        fontCasesReport(fontColor, actual, "first and last name title font test", test);

        //first and last name font test
        actual = Common.checkFont("#main > app-account-details > ion-content > section > article > div:nth-child(4) > p", 0);
        fontCasesReport(fontColor, actual, "first and last name font test", test);

        //email title font test
        actual = Common.checkFont("#main > app-account-details > ion-content > section > article > div:nth-child(5) > h4", 0);
        fontCasesReport(fontColor, actual, "email title font test", test);

        //email name font test
        actual = Common.checkFont("#main > app-account-details > ion-content > section > article > div:nth-child(5) > p", 0);
        fontCasesReport(fontColor, actual, "email name font test", test);

        //phone number title font test
        actual = Common.checkFont("#main > app-account-details > ion-content > section > article > div:nth-child(6) > h4", 0);
        fontCasesReport(fontColor, actual, "phone number title font test", test);

        //phone number name font test
        actual = Common.checkFont("#main > app-account-details > ion-content > section > article > div:nth-child(6) > p", 0);
        fontCasesReport(fontColor, actual, "phone number name font test", test);

        //continue button font test
        actual = Common.checkFont("#main > app-account-details > ion-content > section > button", 0);
        fontCasesReport(fontColor, actual, "continue button font test", test);

        report.flush();
    }
    public static void testForgotPasswordTest() {
//        setUpReport();
//        openChrome();
        List<TestData.ForgotScreen> forgotList = TestData.getUserData().getForgotScreen();
        Common.goToLoginPage();
        ExtentTest test = createTest("Forgot Password Page Test");

        test.info("forgot password page test case started");


        forgotPasswordPageClick();
        forgotPasswordFontTest();



        //Wrong name, correct phone & email
        String url = forgotPassword(forgotList.get(1).getLastName(), forgotList.get(0).getPhoneNumber(), forgotList.get(0).getEmail(), 2);
        conditionCheck(verifyUserUrl, url, "Wrong name, correct phone & email test", test);

        //Wrong phone, correct name & email
        url = forgotPassword(forgotList.get(0).getLastName(), forgotList.get(2).getPhoneNumber(), forgotList.get(0).getEmail(), 2);
        conditionCheck(verifyUserUrl, url, "Wrong phone, correct name & email test", test);

        //Wrong email, correct name & phone
        url = forgotPassword(forgotList.get(0).getLastName(), forgotList.get(0).getPhoneNumber(), forgotList.get(3).getEmail(), 2);
        conditionCheck(verifyUserUrl, url, "Wrong email, correct name & phone test", test);

        //correct email, name & phone
        url = forgotPassword(forgotList.get(0).getLastName(), forgotList.get(0).getPhoneNumber(), forgotList.get(0).getEmail(), 2);
        conditionCheck(baseUrl+"#/forgot-password/validate-otp/"+forgotList.get(0).getEmail(), url, "correct email, name & phone test", test);

        /* forgot password validate otp page */
        validateOtpFontTest(0);

        //invalid input
        url = Common.takeInputFromUrl(0);
        conditionCheck(baseUrl+"#/forgot-password/validate-otp/"+forgotList.get(0).getEmail(),url,"invalid verification input test",test);

        //valid input
        url = Common.takeInputFromUrl(1);
        conditionCheck(baseUrl+"#/forgot-password/set-password",url,"valid verification input test",test);

        /* forgot password validate otp page */
        forgotPwdChangePwdFont();

        //passwords don't match
        url = testPasswords(forgotList.get(4).getPassword(),forgotList.get(4).getConfirmPassword(),0);
        conditionCheck(baseUrl+"#/forgot-password/set-password",url,"passwords don't match test",test);

        //Passwords match but are fewer than 6 characters
        String isButtonEnable = testPasswords(forgotList.get(5).getPassword(),forgotList.get(5).getConfirmPassword(),1);
        conditionCheck("false",isButtonEnable,"Passwords match but are fewer than 6 characters",test);

        //password show/hide test
        boolean isTrue = showHideLoginPassword("#newpassword", "#main > app-set-password > ion-content > section > article:nth-child(2) > app-text-field > main > section > img","forgot");
        conditionCheck("true",String.valueOf(isTrue), "Forgot password show hide password button test", test);

        isTrue = showHideLoginPassword("#confirmpassword", "#main > app-set-password > ion-content > section > article:nth-child(2) > div > app-text-field > main > section > img","forgot");
        conditionCheck("true",String.valueOf(isTrue), "Forgot password show hide confirm password button test", test);


        //passwords match
        url = testPasswords(forgotList.get(6).getPassword(),forgotList.get(6).getConfirmPassword(),0);
        conditionCheck(baseUrl+"#/login",url,"passwords match test",test);


        report.flush();
    }

//    @Test
    public static void testFirstTimeUser() {
//        setUpReport();
        ExtentTest test = createTest("FirstTime User Test");

        test.info("firstTimeUser test case started");

        List<TestData.FirstTimeUserTest> firstTimeUsersList = TestData.getUserData().getFirstTimeUserTest();
//        openChrome();

        firstTimeUserClick();
        verifyAccountFontTest();

        int email = 1;
        int phone = 2;

        String userEmail = firstTimeUsersList.get(3).getEmail();
        String userPhone = firstTimeUsersList.get(7).getPhoneNumber();

        //Existing email address
        String url = firstTimeUserVerify(firstTimeUsersList.get(0).getEmail(),email, ReturnType.URL);
        conditionCheck(baseUrl + "#/signup/verify-account", url,"Existing email address test",test);

        //Non-existent email address
        url = firstTimeUserVerify(firstTimeUsersList.get(1).getEmail(),email, ReturnType.URL);
        conditionCheck(baseUrl + "#/signup/verify-account", url,"Non-existent email address test",test);

        //Improperly formatted email address
        String isButtonEnable = firstTimeUserVerify(firstTimeUsersList.get(2).getEmail(),email, ReturnType.BUTTON);
        conditionCheck("false", isButtonEnable,"Improperly formatted email address test",test);

        //Correct email address
        url = firstTimeUserVerify(userEmail,email, ReturnType.URL);
        conditionCheck(baseUrl + "#/signup/validate-otp/"+userEmail, url,"Existing email address test",test);

        Common.navigateBack();

        //Existing phone number
        url = firstTimeUserVerify(firstTimeUsersList.get(4).getPhoneNumber(), phone, ReturnType.URL);
        conditionCheck(baseUrl+"#/signup/verify-account", url,"Existing phone number test",test);

        //Non-existent phone number
        url = firstTimeUserVerify(firstTimeUsersList.get(5).getPhoneNumber(), phone, ReturnType.URL);
        conditionCheck(baseUrl+"#/signup/verify-account", url,"Non-existent phone number test",test);

        //Improperly formatted phone number
        url = firstTimeUserVerify(firstTimeUsersList.get(6).getPhoneNumber(), phone, ReturnType.URL);
        conditionCheck(baseUrl+"#/signup/verify-account", url,"Improperly formatted phone number test",test);

        //Correct phone number
        url = firstTimeUserVerify(userPhone, phone, ReturnType.URL);
        conditionCheck(baseUrl+"#/signup/validate-otp/"+userPhone, url,"Correct phone number test",test);

        validateOtpFontTest(1);

        //wrong code
        //url = Common.takeInput(0);
        url = Common.takeInputFromUrl(0);
        conditionCheck(baseUrl+"#/signup/validate-otp/"+userPhone,url,"invalid verification input test",test);

        //correct code
//        url = Common.takeInput(1);
        url = Common.takeInputFromUrl(1);
        conditionCheck(baseUrl+"#/signup/set-password",url,"valid verification input test",test);

        setPasswordFont();

        /*set password*/
        //passwords don't match case
        isButtonEnable = createUserPassword(firstTimeUsersList.get(8).getPassword(), firstTimeUsersList.get(8).getConfirmPassword(), ReturnType.BUTTON);
        conditionCheck("false",isButtonEnable,"set passwords don't match case test",test);

        //Passwords match but are fewer than 6 characters
        isButtonEnable = createUserPassword(firstTimeUsersList.get(9).getPassword(), firstTimeUsersList.get(9).getConfirmPassword(), ReturnType.BUTTON);
        conditionCheck("false",isButtonEnable,"Passwords match but are fewer than 6 characters test",test);

        //passwords match case
        url = createUserPassword(firstTimeUsersList.get(10).getPassword(), firstTimeUsersList.get(10).getConfirmPassword(), ReturnType.URL);
        conditionCheck(baseUrl+"#/signup/account-details",url,"set passwords match test",test);

        accountDetailsFont();

        url = accountDetailsClick();
        conditionCheck(baseUrl+"#/login",url,"account Details Click test",test);

        report.flush();

    }

}
