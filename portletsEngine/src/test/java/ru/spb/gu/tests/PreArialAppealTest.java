package ru.spb.gu.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import utils.TestStarter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.spb.gu.app.ModuleGroups.*;
import static ru.spb.gu.app.Modules.*;
import static ru.spb.gu.pages.servicePortlets.armIogEmployee.Locators.*;
import static ru.spb.gu.pages.servicePortlets.armIogEmployee.searchServicesAndApplications.Locators.*;

@TestInstance(Lifecycle.PER_CLASS)
public class PreArialAppealTest extends TestStarter {

    @Test
    void searchApplicationById(){
        homePage.openModule(SERVICE, ARMIOGVEMPLOYEE);
        search.byAppId("14048944");
        assertTrue(additionalChecks.isElementContains("14048944", foundApplication));
    }

    // Перед тестированием нужно гененрить обращения, иначе, что искать.
    @ParameterizedTest
    @CsvFileSource(resources = "/dataTest/sourceSearchByApplication.csv", encoding = "Windows-1251", delimiter = ';', numLinesToSkip = 1)
    void searchByApplication(String state, String serviceType, String date){
        homePage.openModule(SERVICE, ARMIOGVEMPLOYEE);
        mainActions.checkForEntriesOnThePage();
        search.byApp(state, serviceType,date);
        mainActions.checkAppBy(state);
    }

    @ParameterizedTest
    @CsvSource({"Ф, Иванов , Иван, Иванович, 01.01.2001"})
    void searchByApplicant(String applicant, String lastName, String firstName, String patronymic, String birthday){
        homePage.openModule(SERVICE, ARMIOGVEMPLOYEE);
        mainActions.checkForEntriesOnThePage();
        search.byApplicant(applicant, lastName, firstName, patronymic, birthday);
        mainActions.checkAppBy(applicant, lastName, firstName, patronymic);
    }

    @Test
    void openNewApplication() throws InterruptedException {
        homePage.openModule(SERVICE, ARMIOGVEMPLOYEE);
        armIogvEmploee.openTab(newApplicatonTab);
        newApplicatoins.openNewApplication("13575058");
        applicationCard.openDecisionInfo();
    }



}
