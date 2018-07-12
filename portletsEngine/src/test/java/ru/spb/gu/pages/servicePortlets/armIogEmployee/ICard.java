package ru.spb.gu.pages.servicePortlets.armIogEmployee;

import com.codeborne.selenide.Condition;
import ru.spb.gu.app.CryptoPro;

import java.awt.*;

import static com.codeborne.selenide.Selenide.$;

public interface ICard {

    default void openApplicantData(){
        $("#applicantData").shouldBe(Condition.visible).click();
    }

    default void openAttachedDocs(){
        $("#attachedDocs(").shouldBe(Condition.visible).click();
    }

    default void openDocsRequest(boolean processing){
        if(processing){
            $("#docsRequest").click();
        }
    }

    default void openAdditionalInfo(){
        $("#additionalInfo(").shouldBe(Condition.visible).click();
    }

    default void openServiceInfo() {
        $("#serviceInfo").shouldBe(Condition.visible).click();
    }

    default void openDecisionInfo(boolean processing){
        if(processing){
            $("#decisionInfo").click();
        }
    }
}
