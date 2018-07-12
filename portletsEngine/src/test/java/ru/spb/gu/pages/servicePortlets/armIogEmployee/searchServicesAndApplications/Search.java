package ru.spb.gu.pages.servicePortlets.armIogEmployee.searchServicesAndApplications;

import org.openqa.selenium.WebDriver;
import ru.spb.gu.app.MainActions;


import static com.codeborne.selenide.Selenide.$;
import static ru.spb.gu.pages.servicePortlets.armIogEmployee.Locators.*;
import static ru.spb.gu.pages.servicePortlets.armIogEmployee.searchServicesAndApplications.Locators.*;

public class Search extends MainActions{

    public Search(WebDriver webDriver) {
        super(webDriver);
    }

    public void byAppId(String appId){
        click(cancelFilter).click(applyFilter);
        waitForElementPresent(searchField);
        click(searchServicesTab)
            .inputText(searchField, appId)
            .click(searchButton);
    }

    private Search select(String locator, String value) {
        $(locator).click();
        $(inputField).setValue(value).pressEnter();
        return this;
    }

    private Search selectDate(String locator, String date) {
        $(locator).clear();
        $(locator).sendKeys(date);
        $(locator).pressEnter();
        return this;
    }

    public void selectState(String locator, String value) {
        $(locator).click();
        $(inputField).setValue(value).pressEnter();
        click(applyFilter);
    }

    public void byApp(String state, String serviceTypeName, String date) {
        click(cancelFilter).click(applyFilter);
        openFilter(searchBlockByApplication);
        select(stateService, state)
            .select(serviceType, serviceTypeName)
            .selectDate(dateForm, date);
        click(applyFilter);
    }

    public void byApplicant(String applicant, String lastName, String firstName, String patronymic, String birthday) {
        click(cancelFilter).click(applyFilter);
        openFilter(searchBlockByApplicant);
        select(applicantType, applicant);
        inputText(lastNameField, lastName)
                .inputText(firstNameField, firstName)
                .inputText(patronymicField, patronymic);
        selectDate(birthdayField, birthday);
        click(applyFilter);
    }

    private void openFilter(String filter) {
        if(hasClass(filter,"collapsed")){
            $(filter).click();
        }
    }
}
