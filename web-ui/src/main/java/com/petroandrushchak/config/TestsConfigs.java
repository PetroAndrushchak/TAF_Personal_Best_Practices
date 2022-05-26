package com.petroandrushchak.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:localRun.properties",
        "classpath:configs.properties",
})
public interface TestsConfigs extends Config {

    @Key("${environment}.${domain}.host")
    String host();

    String environment();
    String domain();

    boolean isRemoteSelenoidRun();

    String browser();
    boolean headless();
    String browserSizeType();

    String jiraUrl();

}
