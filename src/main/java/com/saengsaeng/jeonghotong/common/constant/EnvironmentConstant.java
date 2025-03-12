package com.saengsaeng.jeonghotong.common.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.saengsaeng.jeonghotong.common.constant.EnvironmentConstant.Constants.DEV_ENV;
import static com.saengsaeng.jeonghotong.common.constant.EnvironmentConstant.Constants.LOCAL_ENV;

@Getter
@AllArgsConstructor
public enum EnvironmentConstant {
    DEV(DEV_ENV),
    LOCAL(LOCAL_ENV);

    private final String value;

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Constants {
        public static final String DEV_ENV = "dev";
        public static final String LOCAL_ENV = "local";
    }
}
