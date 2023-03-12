package com.sardeni.browserstack.helpers;

import static com.sardeni.browserstack.helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

import com.sardeni.browserstack.config.BrowserStackConfig;
import org.aeonbits.owner.ConfigFactory;

public class Browserstack {

    public static String getVideoUrl(String sessionId) {
        BrowserStackConfig config = ConfigFactory.create(BrowserStackConfig.class);
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .log().all()
                .filter(withCustomTemplates())
                .auth().basic(config.getLogin(), config.getPassword())
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
