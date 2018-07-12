package ru.spb.gu.pages.servicePortlets;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.WebDriver;
import ru.spb.gu.app.CryptoPro;
import ru.spb.gu.app.MainActions;

import static com.codeborne.selenide.Selenide.$;

public class Signature extends MainActions {

    CryptoPro cryptoPro = new CryptoPro();

    public Signature(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean startProcessing() throws InterruptedException {
        Thread.sleep(1000);
        $("#startProcessing").click();
        Thread.sleep(1000);
        cryptoPro.cryptoProCSP("Подтверждение доступа");
        $("[value='CD338AA3F06FD46A281DDB64EF71614415EEB9FA']").click();
        Thread.sleep(1000);
        cryptoPro.cryptoProCSP("КриптоПро CSP");
        Thread.sleep(1000);
        cryptoPro.cryptoProCSP("КриптоПро CSP");
        Thread.sleep(1000);
        if($("#finishProcessing").has(Condition.visible)){
            return true;
        }else {
            return false;
        }
    }
}
