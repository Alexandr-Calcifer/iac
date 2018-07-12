package utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.spb.gu.app.AdditionalChecks;
import ru.spb.gu.app.MainActions;
import ru.spb.gu.pages.authorization.Authorization;
import ru.spb.gu.pages.servicePortlets.armIogEmployee.ARMIogvEmploee;
import ru.spb.gu.pages.servicePortlets.armIogEmployee.newApplications.ApplicationCard;
import ru.spb.gu.pages.servicePortlets.armIogEmployee.newApplications.NewApplicatoins;
import ru.spb.gu.pages.servicePortlets.armIogEmployee.searchServicesAndApplications.Search;
import ru.spb.gu.pages.techSupport.Support;
import ru.spb.gu.pages.title.HomePage;
import utils.drivers.DriverType;

public class TestStarter extends TestBase {

    @BeforeAll
    public void init(){
        webDriver = DriverType.Chrome.getDriver(this);
//        webDriver = DriverType.Firefox.getDriver(this);
//        webDriver = DriverType.IE.getDriver(this);
        authorization = new Authorization(webDriver);
        mainActions = new MainActions(webDriver);
        homePage = new HomePage(webDriver);
        support = new Support(webDriver);
        additionalChecks = new AdditionalChecks(webDriver);
        search = new Search(webDriver);
        armIogvEmploee = new ARMIogvEmploee(webDriver);
        newApplicatoins = new NewApplicatoins(webDriver);
        applicationCard = new ApplicationCard(webDriver);

        authorization.openPageAuthorisation(url_pre);
        authorization.byUser(admin, passwordAdmin);
    }

    @AfterAll
    public void exit(){
        mainActions.logOut();
        mainActions.webDriverClose();
    }


}
