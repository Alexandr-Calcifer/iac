package ru.spb.gu.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import utils.TestStarter;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.spb.gu.app.ModuleGroups.*;
import static ru.spb.gu.app.Modules.*;
import static ru.spb.gu.pages.techSupport.Locators.*;

@TestInstance(Lifecycle.PER_CLASS)
public class TechSupportTest extends TestStarter {

    @Test
    void removeApplication() {
        homePage.openModule(TECH, TECHSUPPORT);
        int appCount = support.actionForApplication(remove,"14048944");
        assertTrue(additionalChecks.isElementContains("Удалено"+appCount+" обращений.", comment));
    }

    @Test
    void recoverApplication() {
        homePage.openModule(TECH, TECHSUPPORT);
        int appCount = support.actionForApplication(recover,"14048944");
        assertTrue(additionalChecks.isElementContains("Восстановлено"+appCount+" обращений.", comment));
    }
}
