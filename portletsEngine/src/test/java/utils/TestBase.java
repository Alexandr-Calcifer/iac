package utils;

import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.spb.gu.app.AdditionalChecks;
import ru.spb.gu.app.MainActions;
import ru.spb.gu.pages.authorization.Authorization;
import ru.spb.gu.pages.servicePortlets.armIogEmployee.ARMIogvEmploee;
import ru.spb.gu.pages.servicePortlets.armIogEmployee.newApplications.ApplicationCard;
import ru.spb.gu.pages.servicePortlets.armIogEmployee.newApplications.NewApplicatoins;
import ru.spb.gu.pages.servicePortlets.armIogEmployee.searchServicesAndApplications.Search;
import ru.spb.gu.pages.techSupport.Support;
import ru.spb.gu.pages.title.HomePage;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestBase.class)
@TestPropertySource(locations = "classpath:pre.properties")
@EnableAsync
@ComponentScan("ru.spb.gu")
public class TestBase {

    @Value("${login}")
    protected String admin;
    @Value("${password}")
    protected String passwordAdmin;
    @Value("${url_pre}")
    protected String url_pre;
    @Value("${profile}")
    public String profile;

    private String file = "file";

    public String getFile() {
        return file;
    }

    public String getProfile() {
        return profile;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public String getProxyUserName() {
        return proxyUserName;
    }

    public String getProxyPassword() {
        return proxyPassword;
    }

    @Value("${proxy.ip}")

    public String proxyHost;
    @Value("${proxy.userName}")
    public String proxyUserName;
    @Value("${proxy.password}")
    public String proxyPassword;

//    public static ThreadLocal<WebDriver> thdLWebDriver = new ThreadLocal<>();
    public WebDriver webDriver;
    public Authorization authorization;
    public MainActions mainActions;
    public HomePage homePage;
    public Support support;
    public AdditionalChecks additionalChecks;
    public Search search;
    public ARMIogvEmploee armIogvEmploee;
    public NewApplicatoins newApplicatoins;
    public ApplicationCard applicationCard;

}
