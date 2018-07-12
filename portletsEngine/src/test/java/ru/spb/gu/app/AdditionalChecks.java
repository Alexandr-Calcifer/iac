package ru.spb.gu.app;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class AdditionalChecks {

    private WebDriver webDriver;

    public AdditionalChecks(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public boolean isElementPresent(String elementPresent) {
        try {
            $(elementPresent);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementContains(String expected, String actual) {
        try {
            $(expected).toString().contains(actual);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
