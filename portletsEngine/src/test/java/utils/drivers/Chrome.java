package utils.drivers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.TestBase;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class Chrome{

    TestBase testBase;
    public WebDriver webDriver;

    public WebDriver initChromeDriver(TestBase testBase) {
        this.testBase = testBase;
        chromeDriver();
        return webDriver;
    }

    private void chromeDriver() {
        ChromeDriverManager
                .getInstance()
                .proxy(testBase.getProxyHost())
                .proxyUser(testBase.getProxyUserName())
                .proxyPass(testBase.getProxyPassword())
                .setup();
        webDriver = new ChromeDriver(chrome());
        WebDriverRunner.setWebDriver(webDriver);
        setProxyAuthorizationPlagin();
    }

    /* Подключения профиля браузера при необходимости */
    public DesiredCapabilities chrome() {
        ChromeOptions options = new ChromeOptions();
        List<File> files = new ArrayList<>();
        String fileName = "plugins/chrome/Proxy-Auto-Auth_v2.0.crx";
        files.add(new File(Chrome.class.getClassLoader().getResource(fileName).getFile()));
        fileName = "plugins/chrome/CryptoPro-Extension-for-CAdES-Browser-Plug-in_v1.2.3.crx";
        files.add(new File(Chrome.class.getClassLoader().getResource(fileName).getFile()));
        options.addExtensions(files);
//        options.addArguments("test-type");
        options.addArguments(testBase.getProfile());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        return capabilities;
    }

    private void setProxyAuthorizationPlagin() {
        if (!$("#login").has(Condition.visible)) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!$("#login").has(Condition.visible))
            switchTo().window("Options - Proxy Auto Auth");
        $("#login").setValue(testBase.getProxyUserName());
        $("#password").setValue(testBase.getProxyPassword());
        $("#save").click();
    }
}
