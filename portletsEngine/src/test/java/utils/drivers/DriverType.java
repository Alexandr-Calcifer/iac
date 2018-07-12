package utils.drivers;

import org.openqa.selenium.WebDriver;
import utils.TestBase;

public enum DriverType {
    Chrome{
        public WebDriver getDriver(TestBase testBase){
            Chrome chrome = new Chrome();
            return chrome.initChromeDriver(testBase);
        }
    },
    Firefox{
        public WebDriver getDriver(TestBase testBase){
            FireFox fireFox = new FireFox();
            return fireFox.initFireFoxDriver(testBase);
        }
    },
    IE{
        public WebDriver getDriver(TestBase testBase){
            utils.drivers.IE ie = new IE();
            return ie.initIEDriver(testBase);
        }
    };

    public WebDriver getDriver(TestBase testBase){
        return null;
    }
}
