package com.sardeni.browserstack.ios;

import com.sardeni.browserstack.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.id;

public class IosSearchTests extends TestBase {
    @Test
    @Tag("ios")
    @DisplayName("Проверка отображения email")
    void loginTestFlight (){
        step("Click button", () ->{
            $(id("Text Button")).click();
        });
        step("Write email on text area", () ->{
            $(id("Text Input")).click();
            $(id("Text Input")).sendKeys("sard@gmail.com");
            $(id("Text Input")).pressEnter();
        });
        step("Check result", () ->{
            assertEquals("sard@gmail.com", $(id("Text Output")).getText());
        });
    }
}

