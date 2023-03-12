package com.sardeni.browserstack.tests.android;

import com.sardeni.browserstack.tests.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;

@Tag("android")
public class AndroidSearchTests extends TestBase {

    @Test
    @DisplayName("Проверка поля поиска")
    void searchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Sardinia");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Проверка текста на кнопке в форме входа")
    void checkButtonLogIn() {

        step("Click on the NavBar Menu button", () -> {
            $(id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        });
        step("Check button log in", () -> {
            $(id("org.wikipedia.alpha:id/explore_overflow_account_name")).shouldHave(text("Log in to Wikipedia"));
            $(id("org.wikipedia.alpha:id/explore_overflow_account_name")).click();
        });

        step("Check text on button at login form", () -> {
            $(id("org.wikipedia.alpha:id/login_button")).shouldHave(text("Log in"));
        });
    }
}
