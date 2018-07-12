package ru.spb.gu.pages.servicePortlets.armIogEmployee;

import org.openqa.selenium.WebDriver;
import ru.spb.gu.app.MainActions;

public class ARMIogvEmploee extends MainActions {

    public ARMIogvEmploee(WebDriver webDriver) {
        super(webDriver);
    }

    public void openTab(String tab){
        click(tab);
    }
}
