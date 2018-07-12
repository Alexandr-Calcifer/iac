package ru.spb.gu.pages.techSupport;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import ru.spb.gu.app.MainActions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static ru.spb.gu.pages.techSupport.Locators.*;

public class Support extends MainActions{

    private WebDriver webDriver;

    public Support(WebDriver webDriver) {
        super(webDriver);
//        mainAction = new MainActions(this.webDriver);
    }


    private SelenideElement openAction(String action) {
        if (hasClass(action, "collapsed"))
            click(action);
        return $(action);
    }

    public int actionForApplication(String action, String idApplication) {
        String[] appQuantity;
        openAction(action);
        inputText(textField, idApplication);
        click(sendButton);
        appQuantity = idApplication.split(",");
        if($(comment).getText().contains(idApplication+" Удалено 0 обращений.") && action.contains("Three")){
            actionForApplication(recover, idApplication);
            if($(comment).getText().contains(idApplication+" Восстановлено 0 обращений.")){
                return 0;
            }
        }
        return appQuantity.length;
    }


}
