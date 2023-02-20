package drivers;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:${env}.properties",
        "classpath:secret.properties"
})

public interface Config extends org.aeonbits.owner.Config {
    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("baseURL")
    String baseUrl();

    @Key("appURL")
    String appUrl();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("project")
    String projectName();

    @Key("build")
    String buildName();

    @Key("name")
    String testName();
}