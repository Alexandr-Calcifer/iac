package utils.drivers;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.TestBase;

public class IE {

    TestBase testBase;
    WebDriver webDriver;

    public WebDriver initIEDriver(TestBase testBase) {
        this.testBase = testBase;
        iEDriver();
        return webDriver;
    }

    private void iEDriver(){
        InternetExplorerDriverManager.getInstance()
                .proxy(this.testBase.getProxyHost())
                .proxyUser(this.testBase.getProxyUserName())
                .proxyPass(this.testBase.getProxyPassword())
                .arch32()
                .setup();
        webDriver = new InternetExplorerDriver();
        WebDriverRunner.setWebDriver(webDriver);
    }

}
