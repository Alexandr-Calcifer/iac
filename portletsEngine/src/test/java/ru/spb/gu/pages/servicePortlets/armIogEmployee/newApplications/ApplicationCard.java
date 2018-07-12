package ru.spb.gu.pages.servicePortlets.armIogEmployee.newApplications;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import ru.spb.gu.app.MainActions;
import ru.spb.gu.pages.servicePortlets.Signature;
import ru.spb.gu.pages.servicePortlets.armIogEmployee.ICard;

public class ApplicationCard extends MainActions implements ICard{

    private boolean isStatr;
    private Signature signature;

    public ApplicationCard(WebDriver webDriver) {
        super(webDriver);
        signature = new Signature(webDriver);
    }

    public void openDecisionInfo() throws InterruptedException {
        if(isStatr){
            openDecisionInfo(isStatr);
        }else {
            isStatr = signature.startProcessing();
            openDecisionInfo(isStatr);
            Assertions.assertTrue(isStatr, "Обращение не взято в обработку");
        }
    }
}
