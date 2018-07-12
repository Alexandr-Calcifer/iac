package ru.spb.gu.pages.title;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.WebDriver;
import ru.spb.gu.app.MainActions;
import ru.spb.gu.app.ModuleGroups;
import ru.spb.gu.app.SelectorModules;
import ru.spb.gu.app.Modules;

import static com.codeborne.selenide.Selenide.$;
import static ru.spb.gu.pages.servicePortlets.armIogEmployee.searchServicesAndApplications.Locators.*;
import static ru.spb.gu.pages.title.Locators.*;


public class HomePage extends MainActions{

    private WebDriver webDriver;
    private MainActions mainActions ;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    private SelectorModules moduleGroups = new SelectorModules();

    public void openModule(ModuleGroups groups, Modules module) {
        waitForElementPresent(mainMenu);
        String[] menu = moduleGroups.getModule(groups, module);
        if(!$(mainMenuOpen).has(Condition.visible)){
            $(mainMenu).find(".sw").click();
            for (int i = 0; i < menu.length; i++) {
                if(!$(menu[i]).has(Condition.visible)){
                    scrolling($(menu[i]));
                }
                $(menu[i]).click();
            }
        }else{
            for (int i = 0; i < menu.length; i++) {
                $(menu[i]).click();
            }
        }
    }
}
