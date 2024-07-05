package com.celllabs;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TestData {
    private static TestData userData = null;
    @JsonProperty("LoginScreen")
    private List<LoginScreen> loginScreen;
    @JsonProperty("ForgotScreen")
    private List<ForgotScreen> forgotScreen;
    @JsonProperty("AccountScreen")
    private List<AccountTest> accountTest;
    @JsonProperty("AddUserScreen")
    private List<AddUserTest> addUserTest;
    @JsonProperty("EditUserScreen")
    private List<EditUserTest> editUserTest;
    @JsonProperty("FirstTimeUserScreen")
    private List<FirstTimeUserTest> firstTimeUserTest;

    public static TestData getUserData(){
        return userData;
    }
    public static void setUserData(TestData testData){
        userData = testData;
    }

    @Data
    public static class LoginScreen {
        private String test;
        private String email;
        private String password;
        private String phoneNumber;
        private String version;

    }
    @Data
    public static class ForgotScreen {
        private String test;
        private String lastName;
        private String phoneNumber;
        private String email;
        private String password;
        private String confirmPassword;

    }
    @Data
    public static class AccountTest {
        private String test;
        private String email;
        private String password;
        private String firstName;
        private String lastName;
        private String confirmEmail;
        private String phoneNumber;
        private String confirmPhoneNumber;
        private String newPassword;
        private String confirmPassword;

    }
    @Data
    public static class AddUserTest {
        private String test;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String email;
        private String userName;
        private String user;
        private String password;
        private String delay;
    }
    @Data
    public static class EditUserTest {
        private String test;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String email;
        private String userType;
        private String userName;

    }
    @Data
    public static class FirstTimeUserTest {
        private String test;
        private String email;
        private String phoneNumber;
        private String password;
        private String confirmPassword;
    }
}
