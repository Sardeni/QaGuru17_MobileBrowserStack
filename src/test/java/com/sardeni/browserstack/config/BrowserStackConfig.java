package com.sardeni.browserstack.config;

@BrowserStackConfig.LoadPolicy(BrowserStackConfig.LoadType.MERGE)
@org.aeonbits.owner.Config.Sources(
        {"system:properties",
                "classpath:${env}.properties",
                "classpath:secret.properties"})

public interface BrowserStackConfig extends org.aeonbits.owner.Config {
    @Key("login")
    String getLogin();

    @Key("password")
    String getPassword();

    @Key("baseURL")
    String getBaseUrl();

    @Key("appURL")
    String getAppUrl();

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getOsVersion();

    @Key("project")
    String getProjectName();

    @Key("build")
    String getBuildName();

    @Key("name")
    String getTestName();
}