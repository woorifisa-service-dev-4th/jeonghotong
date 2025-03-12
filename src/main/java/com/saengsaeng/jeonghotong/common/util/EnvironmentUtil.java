package com.saengsaeng.jeonghotong.common.util;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

import static com.saengsaeng.jeonghotong.common.constant.EnvironmentConstant.Constants.DEV_ENV;
import static com.saengsaeng.jeonghotong.common.constant.EnvironmentConstant.Constants.LOCAL_ENV;

@Component
@RequiredArgsConstructor
public class EnvironmentUtil {

    private final Environment environment;

    public String getCurrentProfile() {
        return getActiveProfiles()
                .filter(profile -> profile.equals(DEV_ENV))
                .findFirst()
                .orElse(LOCAL_ENV);
    }

    public boolean isDevProfile() {
        return getActiveProfiles().anyMatch(DEV_ENV::equals);
    }

    public boolean isLocalProfile() {
        return getActiveProfiles().anyMatch(LOCAL_ENV::equals);
    }

    private Stream<String> getActiveProfiles() {
        return Stream.of(environment.getActiveProfiles());
    }
}
