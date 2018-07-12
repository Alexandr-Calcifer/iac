package ru.spb.gu.pages.servicePortlets.armIogEmployee.newApplications;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import ru.spb.gu.app.MainActions;
import ru.spb.gu.pages.servicePortlets.armIogEmployee.ICard;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.spb.gu.pages.servicePortlets.armIogEmployee.searchServicesAndApplications.Locators.*;

public class NewApplicatoins extends MainActions{

    boolean processing;

    public NewApplicatoins(WebDriver webDriver) {
        super(webDriver);
    }

    public void refresh(){
        click("updateRequest");
    }

    public void openNewApplication(String idApp){
        waitForElementPresent(serviceIdList);
        int n = Integer.parseInt($$(".dataTables_paginate.paging_simple_numbers span .paginate_button").last().getText());
        for(int i = 0; i < n; i++) {
            sleep(200);
            for (SelenideElement element : $$("#requestTable tbody tr")) {
                if (element.getText().contains(idApp)) {
                    element.shouldBe(visible).click();
                    element.click();
                    assertTrue($(".breadcrumb .active").getText().contains(idApp));
                    return;
                }
            }
            if($("span .paginate_button.current + .paginate_button").has(visible)) {
                click("span .paginate_button.current + .paginate_button");
            }
        }
    }
}
