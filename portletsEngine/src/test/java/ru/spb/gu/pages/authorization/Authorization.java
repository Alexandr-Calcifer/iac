package ru.spb.gu.pages.authorization;

import static com.codeborne.selenide.Condition.visible;

import org.openqa.selenium.WebDriver;
import ru.spb.gu.app.MainActions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.spb.gu.pages.authorization.Locators.*;


public class Authorization extends MainActions{

    public Authorization(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPageAuthorisation(String str) {
        open(str);
    }

    public void byUser(String login, String password){
        $(loginName).shouldBe(visible).clear();
        $(loginName).shouldBe(visible).setValue(login);
        $(loginPassword).shouldBe(visible).clear();
        $(loginPassword).shouldBe(visible).setValue(password);
        if(!$(loginPassword).getText().contains(password)){
            $(loginPassword).shouldBe(visible).clear();
            $(loginPassword).shouldBe(visible).setValue(password);
        }
        $(logInSend).shouldBe(visible).click();
    }
}
