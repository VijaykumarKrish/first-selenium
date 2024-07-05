package com.celllabs.more;

import com.aventstack.extentreports.ExtentTest;
import com.celllabs.App;
import com.celllabs.Users;
import com.celllabs.shared.Common;
import com.celllabs.shared.CommonTest;
import junit.framework.TestCase;
import com.celllabs.TestData;
import com.celllabs.enums.ReturnType;
import com.celllabs.enums.UserType;

import java.util.List;
import java.util.Map;


import static com.celllabs.More.*;
import static com.celllabs.shared.Common.fontColor;


public class UsersTest extends TestCase {

    public static void addEditUserFont(int addEditType){
        ExtentTest test = null;
        if(addEditType == 0) {
            test = CommonTest.createTest("Add New User Font Test");

            //add new user title font test
            String actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > app-bar > main > ion-toolbar > section > h1", 0);
            CommonTest.fontCasesReport(fontColor, actual, "add new user title font test", test);
        }else{
            test = CommonTest.createTest("Edit User Font Test");

            //Edit User title font test
            String actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > app-bar > main > ion-toolbar > section > h1", 0);
            CommonTest.fontCasesReport(fontColor, actual, "Edit User title font test", test);
        }

        //user type label font test
        String actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(1) > app-multi-select > section > article > h3", 0);
        CommonTest.fontCasesReport(fontColor, actual, "user type label font test", test);

        //user type text field font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(1) > app-multi-select > section > article > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "user type text field font test", test);

        //first name label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > app-text-field:nth-child(2) > main > article > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "first name label font test", test);

        //first name input field font test
        actual = Common.checkFont("#first-name", 1);
        CommonTest.fontCasesReport(fontColor, actual, "first name label font test", test);

        //last name label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > app-text-field:nth-child(3) > main > article > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "last name label font test", test);

        //last name input field font test
        actual = Common.checkFont("#last-name", 1);
        CommonTest.fontCasesReport(fontColor, actual, "last name label font test", test);

        //phone number label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > app-text-field:nth-child(4) > main > article > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "phone number label font test", test);

        //phone number input field font test
        actual = Common.checkFont("#phone", 1);
        CommonTest.fontCasesReport(fontColor, actual, "phone number input font test", test);

        //email label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > app-text-field:nth-child(5) > main > article > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "email label font test", test);

        //email input field font test
        actual = Common.checkFont("#email", 1);
        CommonTest.fontCasesReport(fontColor, actual, "email input font test", test);

        //assign team label font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(6) > app-multi-select > section > article > h3", 0);
        CommonTest.fontCasesReport(fontColor, actual, "assign team label font test", test);

        //assign team text font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(6) > app-multi-select > section > article > h4", 0);
        CommonTest.fontCasesReport(fontColor, actual, "assign team text font test", test);

        //save button font test
        actual = Common.checkFont("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > app-save-delete-button > div > button", 0);
        CommonTest.fontCasesReport(fontColor, actual, "save button font test", test);

        CommonTest.report.flush();
    }

    public static void testAddUsers(){
//        setUpReport();
//        openChrome();

        List<TestData.AddUserTest> addUserList = TestData.getUserData().getAddUserTest();

        Users.moveToMorePage(addUserList.get(0).getEmail(),addUserList.get(0).getPassword());


        ExtentTest test = CommonTest.createTest("More Page Test");


        //logout button test
        CommonTest.clickOnLogOutButton();
        CommonTest.conditionCheck(App.baseUrl+"#/login", App.driver.getCurrentUrl(),"logout button test",test);

        Users.moveToMorePage(addUserList.get(0).getEmail(),addUserList.get(0).getPassword());
        clickOnUsersPage();

        //sorting
        String isSorted = Users.isUsersSort();
        CommonTest.conditionCheck("true",isSorted,"Sorting all users test",test);

        /* 1.admin 2.supervisors 3.caregivers
        delay - 0,15,30 */
        int userType = Integer.parseInt(addUserList.get(1).getUser());

        Users.changeAlertDelay(userType,addUserList.get(1).getUserName(), Integer.parseInt(addUserList.get(1).getDelay()));
        String actual = Users.checkDelay(userType, addUserList.get(1).getUserName());
        System.out.println("delay "+actual );
        CommonTest.conditionCheck(addUserList.get(1).getDelay(),actual.trim(), "Alert delay change value test", test);

        //add and edit buttons test
        String isTrue = Users.addEditButtonTest();
        CommonTest.conditionCheck("true",isTrue,"add and edit buttons test",test);

        //click on add user
        clickOnAddUser();
        addEditUserFont(0);

        /* first name */
        //No user type selected
        String isButtonEnable = addUser(UserType.NONE,addUserList.get(11).getFirstName(),addUserList.get(11).getLastName(),addUserList.get(11).getPhoneNumber(),addUserList.get(11).getEmail(),1, ReturnType.BUTTON);
        CommonTest.conditionCheck("false",isButtonEnable,"No user type selected test",test);


        //click on add user
//        clickOnAddUser();

        System.out.println("button "+ReturnType.BUTTON);
        System.out.println("url "+ReturnType.URL);

        //first name Less than 3 characters
        isButtonEnable = addUser(UserType.SUPERVISOR,addUserList.get(2).getFirstName(),addUserList.get(11).getLastName(),addUserList.get(11).getPhoneNumber(),addUserList.get(11).getEmail(),1, ReturnType.BUTTON);
        CommonTest.conditionCheck("false",isButtonEnable,"first name Less than 3 characters test",test);

        //first name Contains symbols, numbers, spaces, emojis
        isButtonEnable = addUser(UserType.SUPERVISOR,addUserList.get(3).getFirstName(),addUserList.get(11).getLastName(),addUserList.get(11).getPhoneNumber(),addUserList.get(11).getEmail(),1,ReturnType.BUTTON);
        CommonTest.conditionCheck("false",isButtonEnable,"first name Contains symbols, numbers, spaces, emojis test",test);

        /* last name */
        //Less than 3 characters1
        isButtonEnable = addUser(UserType.SUPERVISOR,addUserList.get(11).getFirstName(),addUserList.get(4).getLastName(),addUserList.get(11).getPhoneNumber(),addUserList.get(11).getEmail(),1,ReturnType.BUTTON);
        CommonTest.conditionCheck("false",isButtonEnable,"last name Less than 3 characters test",test);

        //Contains symbols, numbers, spaces, emojis
        isButtonEnable = addUser(UserType.SUPERVISOR,addUserList.get(11).getFirstName(),addUserList.get(5).getLastName(),addUserList.get(11).getPhoneNumber(),addUserList.get(11).getEmail(),1, ReturnType.BUTTON);
        CommonTest.conditionCheck("false",isButtonEnable,"last name Contains symbols, numbers, spaces, emojis test",test);

        /* Phone number */
        //Phone number Length more than 10
//        isButtonEnable = addUser(UserType.SUPERVISOR,addUserList.get(11).getFirstName(),"krish","966554383245","krishna.k@celllabs.com",1, ReturnType.BUTTON);
//        conditionCheck("false",isButtonEnable,"Phone number Length more than 10 test",test);

        //Phone number Length less than 10
        isButtonEnable = addUser(UserType.SUPERVISOR,addUserList.get(11).getFirstName(),addUserList.get(11).getLastName(),addUserList.get(6).getPhoneNumber(),addUserList.get(11).getEmail(),1,ReturnType.BUTTON);
        CommonTest.conditionCheck("false",isButtonEnable,"Phone number Length less than 10 test",test);

        //Phone number Length should be 10
        isButtonEnable = addUser(UserType.SUPERVISOR,addUserList.get(11).getFirstName(),addUserList.get(11).getLastName(),addUserList.get(7).getPhoneNumber(),addUserList.get(11).getEmail(),1,ReturnType.TEN);
        CommonTest.conditionCheck("true",isTrue,"Phone number Length should be 10 test",test);

        //Phone number Contains symbols, letters, spaces, emojis
        isButtonEnable = addUser(UserType.SUPERVISOR,addUserList.get(11).getFirstName(),addUserList.get(11).getLastName(),addUserList.get(8).getPhoneNumber(),addUserList.get(11).getEmail(),1,ReturnType.BUTTON);
        CommonTest.conditionCheck("false",isButtonEnable,"Phone number Contains symbols, numbers, spaces, emojis test",test);


        /* Email */
        //Doesn't contain an @ symbol
        isButtonEnable = addUser(UserType.SUPERVISOR,addUserList.get(11).getFirstName(),addUserList.get(11).getLastName(),addUserList.get(11).getPhoneNumber(),addUserList.get(9).getEmail(),1,ReturnType.BUTTON);
        CommonTest.conditionCheck("false",isButtonEnable,"Email Doesn't contain an @ symbol test",test);

        //Doesn't contain a .
        isButtonEnable = addUser(UserType.SUPERVISOR,addUserList.get(11).getFirstName(),addUserList.get(11).getLastName(),addUserList.get(11).getPhoneNumber(),addUserList.get(10).getEmail(),1,ReturnType.BUTTON);
        CommonTest.conditionCheck("false",isButtonEnable,"Email Doesn't contain a . symbol test",test);

        /* Assigning Systems */
        //Zero systems assigned
        isButtonEnable = addUser(UserType.SUPERVISOR,addUserList.get(11).getFirstName(),addUserList.get(11).getLastName(),addUserList.get(11).getPhoneNumber(),addUserList.get(11).getEmail(),0,ReturnType.BUTTON);
        CommonTest.conditionCheck("false",isButtonEnable,"Zero systems assigned test",test);

        /* Back arrow */
        //click back arrow to take to users page
        String url = clickOnBackButton("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-users > app-bar > main > ion-toolbar > ion-buttons.buttons-first-slot.sc-ion-buttons-md-h.sc-ion-buttons-md-s.md.hydrated > ion-back-button");
        CommonTest.conditionCheck(App.baseUrl+"#/home/more/users", url,"click back arrow to take to users page test",test);

        clickOnAddUser();

        /* Edge Cases */
        //All valid information enter, user clicks button for Supervisor
        url = addUser(UserType.SUPERVISOR,addUserList.get(11).getFirstName(),addUserList.get(11).getLastName(),addUserList.get(11).getPhoneNumber(),addUserList.get(11).getEmail(),1,ReturnType.URL);
        System.out.println("super visor "+url);
        CommonTest.conditionCheck(App.baseUrl+"#/home/more/users",url,"All valid information enter, user clicks button for Supervisor test",test);

        clickOnAddUser();

        //All valid information enter, user clicks button for Caregiver
        url = addUser(UserType.CAREGIVER,addUserList.get(12).getFirstName(),addUserList.get(12).getLastName(),addUserList.get(12).getPhoneNumber(),addUserList.get(12).getEmail(),1,ReturnType.URL);
        System.out.println("Caregiver "+url);
        CommonTest.conditionCheck(App.baseUrl+"#/home/more/users",url,"All valid information enter, user clicks button for Caregiver test",test);

        clickOnAddUser();

        //Valid information is filled out, but user clicks back button
        addUser(UserType.CAREGIVER,addUserList.get(13).getFirstName(),addUserList.get(13).getLastName(),addUserList.get(13).getPhoneNumber(),addUserList.get(13).getEmail(),1,ReturnType.BUTTON);
        url = clickOnBackButton("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-users > app-bar > main > ion-toolbar > ion-buttons.buttons-first-slot.sc-ion-buttons-md-h.sc-ion-buttons-md-s.md.hydrated > ion-back-button");
        CommonTest.conditionCheck(App.baseUrl+"#/home/more/users",url,"Valid information is filled out, but user clicks back button test",test);


        CommonTest.report.flush();

    }


    public static void testEditUsers(){
//        setUpReport();
//        openChrome();

        ExtentTest test = CommonTest.createTest("Edit User Test");

        List<TestData.EditUserTest> editUsersList = TestData.getUserData().getEditUserTest();

//        moveToMorePage(TestData.getUserData().getAddUserTest().get(0).getEmail(),TestData.getUserData().getAddUserTest().get(0).getPassword());
//        clickOnUsersPage();

        int SUPERVISOR = 2;
        int CAREGIVER = 3;
        int userType = Integer.parseInt(editUsersList.get(0).getUserType());


        Map<String, String> map = Users.selectEditUser(editUsersList.get(0).getUserName(), userType);
        addEditUserFont(1);

        //first name with less than 2 characters
        String isButtonEnable = Users.editUser(userType, editUsersList.get(1).getFirstName(), "","","",1, ReturnType.BUTTON, "");
        CommonTest.conditionCheck("false",isButtonEnable,"first name with less than 2 characters test",test);

        //first name Contains symbols, numbers, spaces, emojis
        isButtonEnable = Users.editUser(userType,editUsersList.get(2).getFirstName(),"","","",1, ReturnType.BUTTON, "");
        CommonTest.conditionCheck("false",isButtonEnable,"first name Contains symbols, numbers, spaces, emojis test",test);

        //last name with less than 3 characters
        isButtonEnable = Users.editUser(userType,editUsersList.get(0).getFirstName(),editUsersList.get(3).getLastName(),"","",1, ReturnType.BUTTON, "");
        CommonTest.conditionCheck("false",isButtonEnable,"last name with less than 2 characters test",test);

        //last name Contains symbols, numbers, spaces, emojis
        isButtonEnable = Users.editUser(userType,"",editUsersList.get(4).getLastName(),"","",1, ReturnType.BUTTON, "");
        CommonTest.conditionCheck("false",isButtonEnable,"last name Contains symbols, numbers, spaces, emojis test",test);

        //phone number should be 10
        isButtonEnable = Users.editUser(userType,"",editUsersList.get(0).getLastName(),editUsersList.get(5).getPhoneNumber(),"",1, ReturnType.TEN, "");
        CommonTest.conditionCheck("true",isButtonEnable,"phone number should be 10 test",test);

        //phone number Contains symbols, letters, spaces, emojis
        isButtonEnable = Users.editUser(userType,"","",editUsersList.get(6).getPhoneNumber(),"",1, ReturnType.BUTTON, "");
        CommonTest.conditionCheck("false",isButtonEnable,"phone number Contains symbols, letters, spaces, emojis test",test);

        //email Doesn't contain an @ symbol
        isButtonEnable = Users.editUser(userType,"","",editUsersList.get(0).getPhoneNumber(),editUsersList.get(7).getEmail(),1, ReturnType.BUTTON, "");
        CommonTest.conditionCheck("false",isButtonEnable,"email Doesn't contain an @ symbol test",test);

        //email Doesn't contain a .
        isButtonEnable = Users.editUser(userType,"","","",editUsersList.get(8).getEmail(),1, ReturnType.BUTTON, "");
        CommonTest.conditionCheck("false",isButtonEnable,"email Doesn't contain a . test",test);

        //Zero systems assigned
        isButtonEnable = Users.editUser(userType,"","","",editUsersList.get(0).getEmail(),0, ReturnType.BUTTON, "");
        CommonTest.conditionCheck("false",isButtonEnable,"Zero systems assigned test",test);

        //click back to Users page
        String url = clickOnBackButton("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > app-bar > main > ion-toolbar > ion-buttons.buttons-first-slot.sc-ion-buttons-md-h.sc-ion-buttons-md-s.md.hydrated > ion-back-button");
        CommonTest.conditionCheck(App.baseUrl+"#/home/more/users",url,"click back to Users page test",test);

        Common.navigateBack();

        //All valid information enter, user clicks button
        url = Users.editUser(userType,editUsersList.get(9).getFirstName(),editUsersList.get(9).getLastName(),editUsersList.get(9).getPhoneNumber(),editUsersList.get(9).getEmail(),1,ReturnType.URL, "click");
        CommonTest.conditionCheck(App.baseUrl+"#/home/more/users", url,"All valid information enter, user clicks button test",test);

        Common.navigateBack();

        //Valid information is filled out, but user clicks back button
        Users.editUser(userType,editUsersList.get(10).getFirstName(),editUsersList.get(10).getLastName(),editUsersList.get(10).getPhoneNumber(),editUsersList.get(10).getEmail(),1, ReturnType.URL, "");
        url = clickOnBackButton("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > app-bar > main > ion-toolbar > ion-buttons.buttons-first-slot.sc-ion-buttons-md-h.sc-ion-buttons-md-s.md.hydrated > ion-back-button");
        CommonTest.conditionCheck(App.baseUrl+"#/home/more/users", url,"Valid information is filled out, but user clicks back button test",test);

        Common.navigateBack();

        //No information is changed
        isButtonEnable = Users.editUser(Integer.parseInt(map.get("user")),map.get("firstName"),map.get("lastName"),map.get("phone"),map.get("email"),0, ReturnType.BUTTON, "");
        CommonTest.conditionCheck("false",isButtonEnable,"No information is changed test",test);

        //Information is changed and then changed back

        isButtonEnable = Users.infoChangedBack(userType,editUsersList.get(10).getFirstName(),editUsersList.get(10).getLastName(),editUsersList.get(10).getPhoneNumber(),editUsersList.get(10).getEmail(),1,map);
//        isButtonEnable = editUser(SUPERVISOR,"abc","","","",1);
        CommonTest.conditionCheck("false",isButtonEnable,"Information is changed and then changed back test",test);


//        editUser(CAREGIVER,"dfg","","","",1, ReturnType.URL, "");
        CommonTest.report.flush();

    }

}