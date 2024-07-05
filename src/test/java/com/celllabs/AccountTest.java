package com.celllabs;



import com.aventstack.extentreports.ExtentTest;
import com.celllabs.shared.Common;
import com.celllabs.shared.CommonTest;
import junit.framework.TestCase;

import java.util.List;

import static com.celllabs.Account.*;
import static com.celllabs.shared.Common.fontColor;

public class AccountTest extends TestCase {

    public static void accountPageFont(){
        ExtentTest test = CommonTest.createTest("Account Page Font Test");

        //account title font test
        String actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > app-bar > main > ion-toolbar > section > h1", 0);
        CommonTest.fontCasesReport(fontColor, actual, "account title font test", test);

        //account name label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(1) > main > article.main > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "account name label font test", test);

        //account name text font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(1) > main > article.main > p", 0);
        CommonTest.fontCasesReport(fontColor, actual, "account name text font test", test);

        //account email label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(2) > main > article.main > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "account email label font test", test);

        //account email text font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(2) > main > article.main > p", 0);
        CommonTest.fontCasesReport(fontColor, actual, "account email text font test", test);

        //account phone number label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(3) > main > article.main > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "account phone number label font test", test);

        //account phone number text font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(3) > main > article.main > p", 0);
        CommonTest.fontCasesReport(fontColor, actual, "account phone number text font test", test);

        //account password label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(4) > main > article.main > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "account password label font test", test);

        //account password text font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > article > app-text-field:nth-child(4) > main > article.main > p", 0);
        CommonTest.fontCasesReport(fontColor, actual, "account password text font test", test);

        //account number font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > div > h3:nth-child(1)", 0);
        CommonTest.fontCasesReport(fontColor, actual, "account number font test", test);

        //account type font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-my-account > ion-content > section > div > h3:nth-child(2)", 0);
        CommonTest.fontCasesReport(fontColor, actual, "account type font test", test);

        CommonTest.report.flush();
    }
    public static void accountEditFNFont(){
        ExtentTest test = CommonTest.createTest("Account Edit FN Font Test");

        //account title font test
        String actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-name > app-bar > main > ion-toolbar > section > h1", 0);
        CommonTest.fontCasesReport(fontColor, actual, "account title font test", test);

        //edit account title font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-name > ion-content > main > app-edit-section > main > section > h3", 0);
        CommonTest.fontCasesReport(fontColor, actual, "edit account name title font test", test);

        //first name label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-name > ion-content > main > app-edit-section > main > section > article > app-text-field > main > article > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "first name label font test", test);

        //first name text font test
        actual = Common.checkFont("#first", 0);
        CommonTest.fontCasesReport(fontColor, actual, "first name text font test", test);

        //last name label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-name > ion-content > main > app-edit-section > main > section > article > div:nth-child(2) > app-text-field > main > article > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "last name label font test", test);

        //last name text font test
        actual = Common.checkFont("#second", 0);
        CommonTest.fontCasesReport(fontColor, actual, "last name text font test", test);

        //enter password label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-name > ion-content > main > app-edit-section > main > section > article > div:nth-child(3) > app-text-field > main > article > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "enter password label font test", test);

        //enter password input field font test
        actual = Common.passwordFieldFont("#password", "#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-name > ion-content > main > app-edit-section > main > section > article > div:nth-child(3) > app-text-field > main > section > img", 1);
        CommonTest.fontCasesReport(fontColor, actual, "enter password input field font test", test);

        //submit button font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-name > ion-content > main > app-edit-section > main > button", 0);
        CommonTest.fontCasesReport(fontColor, actual, "submit button font test", test);

        CommonTest.report.flush();
    }
    public static void accountEditEmailFont(){
        ExtentTest test = CommonTest.createTest("Account Edit Email Font Test");

        //edit email title font test
        String actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-email > app-bar > main > ion-toolbar > section > h1", 0);
        CommonTest.fontCasesReport(fontColor, actual, "edit email title font test", test);

        //edit account title font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-email > ion-content > main > app-edit-section > main > section > h3", 0);
        CommonTest.fontCasesReport(fontColor, actual, "edit account email title font test", test);

        //new email label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-email > ion-content > main > app-edit-section > main > section > article > app-text-field > main > article > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "new email label font test", test);

        //new email text font test
        actual = Common.checkFont("#first", 0);
        CommonTest.fontCasesReport(fontColor, actual, "new email text font test", test);

        //confirm new email label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-email > ion-content > main > app-edit-section > main > section > article > div:nth-child(2) > app-text-field > main > article > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "confirm new email label font test", test);

        //confirm new email text font test
        actual = Common.checkFont("#second", 0);
        CommonTest.fontCasesReport(fontColor, actual, "confirm new email text font test font", test);

        //enter password label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-email > ion-content > main > app-edit-section > main > section > article > div:nth-child(3) > app-text-field > main > article > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "enter password label font test", test);

        //enter password input field font test
        actual = Common.passwordFieldFont("#password", "#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-email > ion-content > main > app-edit-section > main > section > article > div:nth-child(3) > app-text-field > main > section > img", 1);
        CommonTest.fontCasesReport(fontColor, actual, "enter password input field font test", test);

        //submit button font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-email > ion-content > main > app-edit-section > main > button",0);
        CommonTest.fontCasesReport(fontColor, actual, "submit button font test", test);

        CommonTest.report.flush();
    }
    public static void accountEditPhoneFont(){
        ExtentTest test = CommonTest.createTest("Account Edit Phone Font Test");

        //account title font test
        String actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-phone > app-bar > main > ion-toolbar > section > h1", 0);
        CommonTest.fontCasesReport(fontColor, actual, "account title font test", test);

        //edit phone number title font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-phone > ion-content > main > app-edit-section > main > section > h3", 0);
        CommonTest.fontCasesReport(fontColor, actual, "edit phone number title font test", test);

        //new phone number label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-phone > ion-content > main > app-edit-section > main > section > article > app-text-field > main > article > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "new phone number label font test", test);

        //new phone number text font test
        actual = Common.checkFont("#first", 0);
        CommonTest.fontCasesReport(fontColor, actual, "new phone number text font test", test);

        //confirm new phone number label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-phone > ion-content > main > app-edit-section > main > section > article > div:nth-child(2) > app-text-field > main > article > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "confirm new phone number label font test", test);

        //confirm new phone number text font test
        actual = Common.checkFont("#second", 0);
        CommonTest.fontCasesReport(fontColor, actual, "confirm new phone number text font test", test);

        //enter password label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-phone > ion-content > main > app-edit-section > main > section > article > div:nth-child(3) > app-text-field > main > article > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "enter password label font test", test);

        //enter password text font test
        actual = Common.passwordFieldFont("#password","#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-phone > ion-content > main > app-edit-section > main > section > article > div:nth-child(3) > app-text-field > main > section > img", 1);
        CommonTest.fontCasesReport(fontColor, actual, "enter password text font test", test);

        //submit button font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-phone > ion-content > main > app-edit-section > main > button",0);
        CommonTest.fontCasesReport(fontColor, actual, "submit button font test", test);

        CommonTest.report.flush();
    }
    public static void accountEditPasswordFont(){
        ExtentTest test = CommonTest.createTest("Account Edit Password Font Test");

        //account title font test
        String actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-phone > app-bar > main > ion-toolbar > section > h1", 0);
        CommonTest.fontCasesReport(fontColor, actual, "account title font test", test);

        //edit password title font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-password > ion-content > main > section > h3", 0);
        CommonTest.fontCasesReport(fontColor, actual, "edit password title font test", test);

        //new password label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-password > ion-content > main > section > article > app-text-field > main > article > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "new password label font test", test);

        //new password input field font test
        actual = Common.passwordFieldFont("#new-password", "#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-password > ion-content > main > section > article > app-text-field > main > section > img", 1);
        CommonTest.fontCasesReport(fontColor, actual, "new password label font test", test);

        //Reenter new password label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-password > ion-content > main > section > article > div:nth-child(2) > app-text-field > main > article > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "Reenter new password label font test", test);

        //Reenter new password input field font test
        actual = Common.passwordFieldFont("#confirm-new-password", "#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-password > ion-content > main > section > article > div:nth-child(2) > app-text-field > main > section > img", 1);
        CommonTest.fontCasesReport(fontColor, actual, "Reenter new password input field font test", test);

        //current password label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-password > ion-content > main > section > article > div:nth-child(3) > app-text-field > main > article > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "current password label font test", test);

        //current password input field font test
        actual = Common.passwordFieldFont("#current-password", "#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-password > ion-content > main > section > article > div:nth-child(3) > app-text-field > main > section > img", 1);
        CommonTest.fontCasesReport(fontColor, actual, "current password input field font test", test);

        //submit button font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-edit-password > ion-content > main > button",0);
        CommonTest.fontCasesReport(fontColor, actual, "submit button font test", test);

        CommonTest.report.flush();
    }
//    @Test
    public static void testClickAccountPage(){
//     setUpReport();
//
//        openChrome();
        Common.goToLoginPage();

        List<TestData.AccountTest> accountList = TestData.getUserData().getAccountTest();
        App.createLogin(accountList.get(0).getEmail(),accountList.get(0).getPassword());


        ExtentTest test = CommonTest.createTest("Account Page Test");

        App.sleep(2000);
        if(App.driver.getCurrentUrl().equalsIgnoreCase(App.baseUrl+"#/select-team")){
            Common.cssSelect("#main > app-select-team > ion-content > main > section > article > app-options-btn:nth-child(1)").click();
            App.sleep(1000);
            Common.cssSelect("#main > app-select-team > ion-content > main > button").click();
            App.sleep(1000);
        }
        String url = clickOnAccount();
        CommonTest.conditionCheck(App.baseUrl+"#/home/my-account",url,"click on account page test",test);

        //account page font
        accountPageFont();

        /*test with first name */

        clickOnEditFirstName();
        accountEditFNFont();

        //case1: first name with numbers
        String isButtonEnable = editSensorName(accountList.get(1).getFirstName(),accountList.get(0).getLastName(),accountList.get(0).getPassword(),0);
        CommonTest.conditionCheck("false",isButtonEnable, "first name with numbers test", test);

        //case2: first name with symbols
        isButtonEnable = editSensorName(accountList.get(2).getFirstName(),accountList.get(0).getLastName(),accountList.get(0).getPassword(),0);
        CommonTest.conditionCheck("false",isButtonEnable, "first name with symbols test", test);

        //case3: first name with spaces
        isButtonEnable = editSensorName(accountList.get(3).getFirstName(),accountList.get(0).getLastName(),accountList.get(0).getPassword(),0);
        CommonTest.conditionCheck("false",isButtonEnable, "first name with spaces test", test);

        /*test with last name*/

        //case4: last name with numbers
        isButtonEnable = editSensorName(accountList.get(0).getFirstName(),accountList.get(4).getLastName(),accountList.get(0).getPassword(),0);
        CommonTest.conditionCheck("false",isButtonEnable, "last name with numbers test", test);

        //case5: last name with symbols
        isButtonEnable = editSensorName(accountList.get(0).getFirstName(),accountList.get(5).getLastName(),accountList.get(0).getPassword(),0);
        CommonTest.conditionCheck("false",isButtonEnable, "last name with symbols test", test);

        //case6: last name with spaces
        isButtonEnable = editSensorName(accountList.get(0).getFirstName(),accountList.get(6).getLastName(),accountList.get(0).getPassword(),0);
        CommonTest.conditionCheck("false",isButtonEnable, "last name with spaces test", test);

       //case7: short password
       isButtonEnable = editSensorName(accountList.get(0).getFirstName(),accountList.get(0).getLastName(),accountList.get(7).getPassword(),0);
       CommonTest.conditionCheck("false",isButtonEnable, "short password test", test);

        //case8: incorrect password
        url = editSensorName(accountList.get(0).getFirstName(),accountList.get(0).getLastName(),accountList.get(8).getPassword(),1);
        CommonTest.conditionCheck(App.baseUrl+"#/home/my-account/edit-name",url, "incorrect password test", test);

        //case9: correct password
        url = editSensorName(accountList.get(9).getFirstName(),accountList.get(9).getLastName(),accountList.get(0).getPassword(),1);
        CommonTest.conditionCheck(App.baseUrl+"#/home/my-account",url, "correct password test", test);

         /*edit account email*/

        test = CommonTest.createTest("Edit Account email Test");
        clickOnEditAccEmail();
        accountEditEmailFont();

        //case1: email without @ symbol
        isButtonEnable = editAccEmail(accountList.get(10).getEmail(),accountList.get(10).getConfirmEmail(),accountList.get(0).getPassword(),0);
        CommonTest.conditionCheck("false",isButtonEnable, "email without @ test", test);

        //case2: email without .
        isButtonEnable = editAccEmail(accountList.get(11).getEmail(),accountList.get(11).getConfirmEmail(),accountList.get(0).getPassword(),0);
        CommonTest.conditionCheck("false",isButtonEnable, "email without . test", test);

        //case3: different emails
        isButtonEnable = editAccEmail(accountList.get(12).getEmail(),accountList.get(12).getConfirmEmail(),accountList.get(0).getPassword(),0);
        CommonTest.conditionCheck("false",isButtonEnable, "different emails test", test);


       //case4: short password
       isButtonEnable = editAccEmail(accountList.get(15).getEmail(),accountList.get(15).getConfirmEmail(),accountList.get(13).getPassword(),0);
       CommonTest.conditionCheck("false",isButtonEnable, "short password test", test);

        //case5: wrong password
        url = editAccEmail(accountList.get(15).getEmail(),accountList.get(15).getConfirmEmail(),accountList.get(14).getPassword(),1);
        CommonTest.conditionCheck(App.baseUrl+"#/home/my-account/edit-email",url, "wrong password test", test);

        //case6: correct details
        url = editAccEmail(accountList.get(15).getEmail(),accountList.get(15).getConfirmEmail(),accountList.get(0).getPassword(),1);
        CommonTest.conditionCheck(App.baseUrl+"#/home/my-account",url, "correct details test", test);

        /*edit account phone num */

        test = CommonTest.createTest("Edit Account Phone Test");
        clickOnEditPhone();
        accountEditPhoneFont();

        //case1: phone number with less than 10 digits   9030503750
        isButtonEnable = editPhoneNum(accountList.get(16).getPhoneNumber(),accountList.get(16).getConfirmPhoneNumber(),accountList.get(0).getPassword(),0);
        CommonTest.conditionCheck("false",isButtonEnable, "phone number with less than 10 digits test", test);

        //case2: phone number should be 10 digits
//        url = editPhoneNum(accountList.get(17).getPhoneNumber(),accountList.get(17).getConfirmPhoneNumber(),accountList.get(0).getPassword(),1);
//        conditionCheck("true",isTrue, "phone number should be 10 digits test", test);

        //case3: different phone numbers
        isButtonEnable = editPhoneNum(accountList.get(17).getPhoneNumber(),accountList.get(17).getConfirmPhoneNumber(),accountList.get(0).getPassword(),0);
        CommonTest.conditionCheck("false",isButtonEnable, "different phone numbers test", test);

       //case4: short password
       isButtonEnable = editPhoneNum(accountList.get(20).getPhoneNumber(),accountList.get(20).getConfirmPhoneNumber(),accountList.get(18).getPassword(),0);
       CommonTest.conditionCheck("false",isButtonEnable, "short password test", test);

        //case4: wrong password
        url = editPhoneNum(accountList.get(20).getPhoneNumber(),accountList.get(20).getConfirmPhoneNumber(),accountList.get(19).getPassword(),1);
        CommonTest.conditionCheck(App.baseUrl+"#/home/my-account/edit-phone", url, "wrong password test", test);

        //case5: phone number should be 10 digits 9030503751
        url = phoneNumberShouldBe10(accountList.get(20).getPhoneNumber(),accountList.get(20).getConfirmPhoneNumber(),accountList.get(0).getPassword());
        CommonTest.conditionCheck(App.baseUrl+"#/home/my-account",url, "phone number should be 10 digits test", test);

//        url = editPhoneNum(accountList.get(21).getPhoneNumber(),accountList.get(21).getConfirmPhoneNumber(),accountList.get(0).getPassword(),1);
//        conditionCheck(baseUrl+"#/home/my-account",url, "correct details test", test);

        /* edit account password */

        test = CommonTest.createTest("Edit Account Password Test");
        clickOnEditPassword();
        accountEditPasswordFont();

        //case1: new and confirm passwords are different
        isButtonEnable = editPassword(accountList.get(21).getNewPassword(),accountList.get(21).getConfirmPassword(),accountList.get(0).getPassword(),0);
        CommonTest.conditionCheck("false",isButtonEnable, "new and confirm passwords are different test", test);

       //case2: short password
       isButtonEnable = editPassword(accountList.get(24).getNewPassword(),accountList.get(24).getConfirmPassword(),accountList.get(22).getPassword(),0);
       CommonTest.conditionCheck("false",isButtonEnable, "short password test", test);

        //case3: incorrect password
        url = editPassword(accountList.get(24).getNewPassword(),accountList.get(24).getConfirmPassword(),accountList.get(23).getPassword(),1);
        CommonTest.conditionCheck(App.baseUrl+"#/home/my-account/edit-password",url, "incorrect password test", test);

        //case4: correct details
        url = editPassword(accountList.get(24).getNewPassword(),accountList.get(24).getConfirmPassword(),accountList.get(0).getPassword(),1);
        CommonTest.conditionCheck(App.baseUrl+"#/login",url, "correct details test", test);

        CommonTest.report.flush();
    }

}
