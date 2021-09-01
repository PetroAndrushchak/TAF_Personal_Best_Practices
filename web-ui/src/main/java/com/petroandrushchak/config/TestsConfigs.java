package com.petroandrushchak.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
//        "system:properties",
        "classpath:localRun.properties",
        "classpath:configs.properties",
})
public interface TestsConfigs extends Config {

    String environment();
    String domain();

    String testType();
    boolean idDomainSpecificFilterGoingToBeUsed();

    boolean isUserLoginCachingEnabled();
    boolean isSSHPortForwardingRequired();
    boolean isRemoteSelenoidRun();

    String browser();
    boolean headless();
    String browserSizeType();

    @Key("${environment}.${domain}.host")
    String host();

    String jiraUrl();

}
