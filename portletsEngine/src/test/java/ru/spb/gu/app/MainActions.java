package ru.spb.gu.app;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.spb.gu.pages.servicePortlets.armIogEmployee.searchServicesAndApplications.Search;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.spb.gu.pages.servicePortlets.armIogEmployee.Locators.searchServicesTab;
import static ru.spb.gu.pages.servicePortlets.armIogEmployee.searchServicesAndApplications.Locators.*;
import static ru.spb.gu.pages.title.Locators.logOut;

public class MainActions {

    public WebDriver webDriver;
    private Search search;

    public MainActions(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public MainActions click(String locator){
        waitForElementPresent(locator);
        for (SelenideElement element: $$(locator)) {
            element.click();
        }
        return this;
    }

    public MainActions waitForElementPresent(String someLocator){
        WebDriverWait waitForOne = new WebDriverWait(webDriver, 10);
        waitForOne.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(someLocator)));
        return this;
    }

    public void webDriverClose() {
        webDriver.close();
    }

    public MainActions logOut(){
        waitForElementPresent(logOut);
        click(logOut);
        return this;
    }

    public void closeWebDriver(){
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {webDriver.close(); webDriver = null;}));
    }

    public MainActions inputText(String locator, String text) {
        for (SelenideElement element: $$(locator)) {
            if(element.has(Condition.visible)) {
                element.setValue(text);
            }
        }
        return this;
    }

    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrolling(SelenideElement selenideElement) {
        sleep(500);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView(true);"
                ,selenideElement);
    }

    public boolean checkForEntriesOnThePage() {
        waitForElementPresent(serviceIdList);
        assertTrue(!$(serviceIdList).getText().contains("Ничего не найдено"));
        return true;
    }

    public void doubleClick(String locator) {
        waitForElementPresent(locator);
        $(locator).click();
        $(locator).click();
    }

    public void checkAppBy(String applicant, String lastName, String firstName, String patronymic) {
        waitForElementPresent(serviceIdList);
        assertTrue(!$(serviceIdList).getText().contains("Ничего не найдено"));
        doubleClick(serviceIdList);
        int n = Integer.parseInt($$(".dataTables_paginate.paging_simple_numbers span .paginate_button").last().getText());
        for(int i = 0; i < n; i++) {
            sleep(200);
            for (SelenideElement element: $$("#applicationTable tbody tr")) {
                assertTrue(element.getText().contains(applicant));
                assertTrue(element.getText().contains(lastName));
                assertTrue(element.getText().contains(firstName));
                assertTrue(element.getText().contains(patronymic));
            }
            if($("span .paginate_button.current + .paginate_button").has(visible)) {
                click("span .paginate_button.current + .paginate_button");
            }
        }
    }

    public boolean hasClass(String css, String className) {
        return $(css).getAttribute("class").contains(className);
    }

    public void checkAppBy(String state) {
        waitForElementPresent(serviceIdList);
        assertTrue(!$(serviceIdList).getText().contains("Ничего не найдено"));
        doubleClick(serviceIdList);
        int n = Integer.parseInt($$(".dataTables_paginate.paging_simple_numbers span .paginate_button").last().getText());
        for(int i = 0; i < n; i++) {
            sleep(200);
            for (SelenideElement element : $$("#requestTable tbody tr")) {
                switch (state){
                    case "Активные": assertTrue(element.getAttribute("backgroundColor").contains("rgb(0, 191, 255)"));
                    break;
                    case "Новые": assertTrue(element.getAttribute("backgroundColor").contains("rgb(0, 191, 255)"));
                    break;
                    case "В работе": assertTrue(element.getAttribute("backgroundColor").contains("rgb(253, 233, 16)"));
                    break;
                    case "Закрыты": if(element.getText().contains("положительное решение")){
                                        assertTrue(element.getAttribute("backgroundColor").contains("rgb(0, 255, 127)"));
                                    }else assertTrue(element.getAttribute("backgroundColor").contains("rgb(255, 99, 71)"));
                }

            }
            if($("span .paginate_button.current + .paginate_button").has(visible)) {
                click("span .paginate_button.current + .paginate_button");
            }
        }
    }
}
