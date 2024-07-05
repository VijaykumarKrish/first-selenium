package com.celllabs;

import com.celllabs.enums.ReturnType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

import static com.celllabs.App.*;
import static com.celllabs.More.*;
import static com.celllabs.shared.Common.*;

public class Users {
    public static void changeAlertDelay(int type, int delay) {
        if (type == 1) {
            cssSelect("#undefined > section > div > div").click();
            if (delay == 0) {
                cssSelect("#undefined > section > div > div > app-select > section > article.custom-scrollbar > p:nth-child(1)").click();
            } else if (delay == 15) {
                cssSelect("#undefined > section > div > div > app-select > section > article.custom-scrollbar > p:nth-child(2)").click();
            } else {
                cssSelect("#undefined > section > div > div > app-select > section > article.custom-scrollbar > p:nth-child(3)").click();
            }
        }
    }

    public static String checkAdminAlertDelay() {
        return cssSelect("#undefined > section > div > div > app-select > section > article > h4").getText().trim().split("min")[0];
    }

    public static String checkDelay(int type, String name) {
        sleep(1000);
        if (type == 2) {
            String isExpanded = cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(2) > section > header > app-label-dropdown").getAttribute("ng-reflect-is-open");
            if (isExpanded!= null && isExpanded.equalsIgnoreCase("false")) {
                cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(2) > section > header > app-label-dropdown > h3").click();
            }
            List<WebElement> supervisorsList = driver.findElements(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(2) > section > article > div"));
            for (int index = 0; index < supervisorsList.size(); index++) {
                WebElement element = supervisorsList.get(index);
                String actualName = element.findElement(By.cssSelector("app-user-tile > main > section > article > h3")).getText();
                if (actualName.equalsIgnoreCase(name)) {
                    return element.findElement(By.cssSelector("app-user-tile > main > section > article > div > app-select > section > article > h4")).getText().trim().split("min")[0];
                }
            }
        } else {
            String isExpanded = cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(3) > section > header > app-label-dropdown").getAttribute("ng-reflect-is-open");
            if (isExpanded.equalsIgnoreCase("false")) {
                cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(3) > section > header > app-label-dropdown > h3").click();
            }
            List<WebElement> careGiversList = driver.findElements(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(3) > section > article > div"));
            for (int index = 0; index < careGiversList.size(); index++) {
                WebElement element = careGiversList.get(index);
                String actualName = element.findElement(By.cssSelector("app-user-tile > main > section > article > h3")).getText();
                if (actualName.equalsIgnoreCase(name)) {
                    return element.findElement(By.cssSelector("app-user-tile > main > section > article > div > app-select > section > article > h4")).getText().trim().split("min")[0];
                }
            }
        }
        return "";
    }

    public static void changeAlertDelay(int type, String name, int delay) {
        refresh();
        if (type == 2) {
            cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(2) > section > header > app-label-dropdown > h3").click();
            List<WebElement> supervisorsList = driver.findElements(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(2) > section > article > div"));
            for (int index = 0; index < supervisorsList.size(); index++) {
                WebElement element = supervisorsList.get(index);
                String actualName = element.findElement(By.cssSelector("app-user-tile > main > section > article > h3")).getText();
                if (actualName.equalsIgnoreCase(name)) {
                    element.findElement(By.cssSelector("app-user-tile > main > section > article > div > app-select")).click();
                    sleep(2000);
                    if (delay == 0) {
                        element.findElement(By.cssSelector("app-user-tile > main > section > article > div > app-select > section > article.custom-scrollbar > p:nth-child(1)")).click();
                    } else if (delay == 15) {
                        element.findElement(By.cssSelector("app-user-tile > main > section > article > div > app-select > section > article.custom-scrollbar > p:nth-child(2)")).click();
                    } else {
                        element.findElement(By.cssSelector("app-user-tile > main > section > article > div > app-select > section > article.custom-scrollbar > p:nth-child(3)")).click();
                    }
                    break;
                }
            }
        } else {
            cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(3) > section > header > app-label-dropdown > h3").click();
            List<WebElement> careGiversList = driver.findElements(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(3) > section > article > div"));
            for (int index = 0; index < careGiversList.size(); index++) {
                WebElement element = careGiversList.get(index);
                String actualName = element.findElement(By.cssSelector("app-user-tile > main > section > article > h3")).getText();
                if (actualName.equalsIgnoreCase(name)) {
                    element.findElement(By.cssSelector("app-user-tile > main > section > article > div > app-select")).click();
                    sleep(2000);
                    if (delay == 0) {
                        element.findElement(By.cssSelector("app-user-tile > main > section > article > div > app-select > section > article.custom-scrollbar > p:nth-child(1)")).click();
                    } else if (delay == 15) {
                        element.findElement(By.cssSelector("app-user-tile > main > section > article > div > app-select > section > article.custom-scrollbar > p:nth-child(2)")).click();
                    } else {
                        element.findElement(By.cssSelector("app-user-tile > main > section > article > div > app-select > section > article.custom-scrollbar > p:nth-child(3)")).click();
                    }
                }
            }

        }
        sleep(1000);
    }

    public static Map<String, String> selectEditUser(String name, int userType) {
        Map<String, String> editUserMap = new HashMap<>();
        waitBySelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(" + userType + ") > section > header > app-label-dropdown > h3").click();
        List<WebElement> usersList = driver.findElements(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(" + userType + ") > section > article > div"));
        for (int index = 0; index < usersList.size(); index++) {
            WebElement element = usersList.get(index);
            String actualName = element.findElement(By.cssSelector("app-user-tile > main > section > article > h3")).getText();
            if (actualName.equalsIgnoreCase(name)) {
                element.click();
                element.findElement(By.cssSelector("app-user-tile > main > button")).click();
                String user = waitBySelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(1) > app-multi-select > section > article > h4").getText();
                String firstName = waitBySelector("#first-name").getAttribute("value");
                String lastName = waitBySelector("#last-name").getAttribute("value");
                String phone = waitBySelector("#phone").getAttribute("value");
                String email = waitBySelector("#email").getAttribute("value");
                String assignedSystem = waitBySelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(6) > app-multi-select > section > article > h4").getText();


                int currUserType = getUserType(user);

                editUserMap.put("user", String.valueOf(currUserType));
                editUserMap.put("firstName", firstName);
                editUserMap.put("lastName", lastName);
                editUserMap.put("phone", phone);
                editUserMap.put("email", email);
                editUserMap.put("assignedSystem", assignedSystem);
//                    cssSelect("#first-name").clear();
//                    cssSelect("#first-name").sendKeys(firstName);
                   /* cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > app-text-field:nth-child(5) > main > article > input").clear();
                    cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > app-text-field:nth-child(5) > main > article > input").sendKeys(email);
                    cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > app-save-delete-button > div > button.primary-button").click();*/
                break;
            }
        }


//        editUserMap.put();
        return editUserMap;
    }

    public static String infoChangedBack(int userType, String firstName, String lastName, String ph, String email, int assignTeam, Map<String, String> existingUserMap) {
        String existingUser = waitBySelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(1) > app-multi-select > section > article > h4").getText();

        int prevUserType = getUserType(existingUser);

        String existingFName = existingUserMap.get("firstName");
        String existingLName = existingUserMap.get("lastName");
        String existingPhone = existingUserMap.get("phone");
        String existingEmail = existingUserMap.get("email");

        editUser(userType, firstName, lastName, ph, email, assignTeam, ReturnType.BUTTON, "");
        editUser(prevUserType, existingFName, existingLName, existingPhone, existingEmail, 0, ReturnType.BUTTON, "");

        if (isElementPresent(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > app-save-delete-button > div > button.primary-button"))) {
            return "true";
        }
        return "false";
    }

    private static int getUserType(String existingUser) {
        if (existingUser.equalsIgnoreCase("Supervisor")) return 2;
        else return 3;
    }

    public static String editUser(int userType, String firstName, String lastName, String ph, String email, int assignTeam, ReturnType returnType, String click) {

        selectUserType(userType);

        sendInput(firstName, "#first-name");
        sendInput(lastName, "#last-name");
        sendInput(ph, "#phone");
        sendInput(email, "#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > app-text-field:nth-child(5) > main > article > input");


        String text = cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(6) > app-multi-select > section > article > h4").getText();
        if (assignTeam != 0 && text.trim().equalsIgnoreCase("--")) selectAssignTeam();
        else if (assignTeam == 0 && !text.trim().equalsIgnoreCase("--")) selectAssignTeam();


        if (returnType == ReturnType.BUTTON) {
            if (isElementPresent(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > app-save-delete-button > div > button.primary-button"))) {
                return "true";
            }
            return "false";
        } else if (returnType == ReturnType.TEN) {
            String phone = cssSelect("#phone").getAttribute("value");
            if (phone.length() == 10 && isElementPresent(By.cssSelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > app-save-delete-button > div > button.primary-button")))
                return "true";
            return "false";
        } else {
            if (click.equalsIgnoreCase("click")) {
                cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > app-save-delete-button > div > button.primary-button").click();
            }
            sleep(2000);
            return driver.getCurrentUrl();
        }

    }

    private static void selectUserType(int userType) {
        sleep(1000);
        cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(1) > app-multi-select > section > article").click();
        sleep(1000);
        if (userType == 2) {
            waitBySelector("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(1) > app-multi-select > section > article.custom-scrollbar > p.selected");
        } else {
            waitBySelector("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(1) > app-multi-select > section > article.custom-scrollbar > p:nth-child(2)");
        }
        waitBySelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(1) > app-multi-select > section > article").click();
    }

    private static void sendInput(String inputName, String path) {
        sleep(1000);
        if (!inputName.isEmpty()) {
            waitBySelector(path).clear();
            waitBySelector(path).sendKeys(inputName);
        }
    }

    private static void selectAssignTeam() {
        sleep(1000);
        waitBySelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(6) > app-multi-select > section > article").click();
        waitBySelector("#main > app-home > ion-tabs > div.tabs-inner > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(6) > app-multi-select > section > article.custom-scrollbar > p").click();
        waitBySelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-add-users > ion-content > main > section > article:nth-child(6) > app-multi-select > section > article").click();
        sleep(1000);
    }

    public static void moveToMorePage(String email, String password) {
        createLogin(email, password);

        if (driver.getCurrentUrl().equalsIgnoreCase(teamUrl)) {
            waitBySelector("#main > app-select-team > ion-content > main > section > article > app-options-btn:nth-child(1) > section").click();
            sleep(1000);
            waitBySelector("#main > app-select-team > ion-content > main > button").click();
        }
        clickOnMore();
//        clickOnUsersPage();
        sleep(1000);
    }

    public static String searchUser(String searchString) {
        WebElement element = cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > div > app-search-bar > article > input");
        element.sendKeys(searchString);
        return "";
    }

    public static String addEditButtonTest() {
        boolean isAddNavigated = buttonNavigate("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(1) > section > header > button");

        String isExpanded = cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(2) > section > header > app-label-dropdown").getAttribute("ng-reflect-is-open");
        if (isExpanded != null && isExpanded.equalsIgnoreCase("false")) {
            cssSelect("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(2) > section > header > app-label-dropdown > h3 > img").click();
        }
        sleep(1000);
        selectById("0sid").click();
        sleep(1000);
        boolean isEditNavigated = buttonNavigate("#sid0 > button");

        if (isAddNavigated && isEditNavigated) {
            return "true";
        }
        return "false";
    }

    public static boolean buttonNavigate(String path) {
        cssSelect(path).click();
        sleep(1000);
        if (driver.getCurrentUrl().equalsIgnoreCase(baseUrl + "#/home/more/users/add-user")) {
            navigateBack();
            return true;
        }
        return false;
    }

    public static String isUsersSort() {
        //super visors
        waitBySelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(2) > section > header > app-label-dropdown > h3 > img").click();
        boolean isSuperVisSorted = users("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(2) > section > article > div");

        //care takers
        waitBySelector("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(3) > section > header > app-label-dropdown > h3 > img").click();
        boolean isCareSorted = users("#main > app-home > ion-tabs > div > ion-router-outlet > app-users > ion-content > main > section > div > app-user-block:nth-child(3) > section > article > div");

        if (isSuperVisSorted && isCareSorted) return "true";
        return "false";
    }

    public static boolean users(String path) {

        List<WebElement> allUsers = driver.findElements(By.cssSelector(path));

        List<String> allUsersList = new ArrayList<>();
        for (WebElement user : allUsers) {
            String text = user.findElement(By.cssSelector("app-user-tile > main > section > article > h3")).getText();
            allUsersList.add(text);
        }
        boolean sortedFlag = isSorted(allUsersList);
        if (!sortedFlag) return false;
        return true;
    }

    public static boolean isSorted(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).toLowerCase(Locale.ROOT).compareTo(list.get(i + 1).toLowerCase(Locale.ROOT)) > 0) {
                return false;
            }
        }
        return true;
    }
}
