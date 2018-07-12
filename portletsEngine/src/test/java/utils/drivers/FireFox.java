package utils.drivers;


import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.TestBase;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FireFox {

    TestBase testBase;
    WebDriver webDriver;

    public WebDriver initFireFoxDriver(TestBase testBase) {
        this.testBase = testBase;
        fireFoxDriver();
        return webDriver;
    }

    private void fireFoxDriver(){
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\pupenkov\\Documents\\Java\\forJava\\drivers\\geckodriver-v0.21.0-win64\\geckodriver.exe");
//        webDriver = new FirefoxDriver(props(testBase.getProfile()));
        FirefoxDriverManager.getInstance()
                .proxy(this.testBase.getProxyHost())
                .proxyUser(this.testBase.getProxyUserName())
                .proxyPass(this.testBase.getProxyPassword())
                .setup();
        webDriver = new FirefoxDriver(props(testBase.getProfile()));
        WebDriverRunner.setWebDriver(webDriver);
    }

    private DesiredCapabilities props(String profileName) {
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        ProfilesIni allProfiles = new ProfilesIni();
        FirefoxProfile profile = allProfiles.getProfile(profileName);
        String fileName = "plugins/firefox/cryptopro_extension_for_cades_browser_plug_in-1.2.4-an+fx.xpi";
        profile.addExtension(new File(FireFox.class.getClassLoader().getResource(fileName).getFile()));
        dc.setCapability(FirefoxDriver.PROFILE, profile);
        return dc;
    }

}

