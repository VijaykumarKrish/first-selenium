package com.celllabs.json;

import com.celllabs.TestCase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDetails {
    public static Map<String, String> userDetailsMap = new HashMap<>();
    public static String wrongPasswordEmail = null;
    public static String wrongPassword = null;
    public static String noAtSymbolEmail = null;
    public static String noAtSymbolPassword = null;
    public static String noDotEmail = null;
    public static String noDotPassword = null;


    public static void divideLoginScreen(List<TestCase> cases){
        for (TestCase testCase : cases) {
            switch(testCase.getTest()){
                case "wrongPassword":
                    userDetailsMap.put("wrongPasswordEmail",testCase.getEmail());
                    userDetailsMap.put("wrongPassword", testCase.getPassword());
                    break;
                case "No@":
                    userDetailsMap.put("noAtSymbolEmail",testCase.getEmail());
                    userDetailsMap.put("noAtSymbolPassword", testCase.getPassword());
                    break;
                case "No.":
                    userDetailsMap.put("noDotEmail",testCase.getEmail());
                    userDetailsMap.put("noDotPassword", testCase.getPassword());
                    break;
            }
            System.out.println(testCase);
        }
    }
    public static void divideForgotScreen(List<TestCase> cases){
        for (TestCase testCase : cases) {
            switch (testCase.getTest()){
                case "wrongLastName":
                    userDetailsMap.put("wrongNameLast",testCase.getLastName());
                    userDetailsMap.put("wrongNamePhoneNumber",testCase.getPhoneNumber());
                    userDetailsMap.put("wrongNameEmail",testCase.getEmail());
                    break;
                case "wrongPhone":
                    userDetailsMap.put("wrongPhoneName", testCase.getLastName());
                    userDetailsMap.put("wrongPhoneNumber", testCase.getPhoneNumber());
                    userDetailsMap.put("wrongPhoneEmail", testCase.getEmail());
                    break;
                case "noMatch":
                    userDetailsMap.put("noForgotPassword", testCase.getPassword());
                    userDetailsMap.put("noForgotConfirmPassword", testCase.getConfirmPassword());
                    break;
                case "password<6char":
                    userDetailsMap.put("noForgotPassword", testCase.getPassword());
                    userDetailsMap.put("noForgotConfirmPassword", testCase.getConfirmPassword());
                    break;

            }
        }
    }
    public static void divideUserScreenWise(String screen, List<TestCase> cases){
        System.out.println("Screen: " + screen);

    }

}
