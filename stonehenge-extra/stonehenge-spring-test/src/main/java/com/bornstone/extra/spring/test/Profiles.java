/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.bornstone.extra.spring.test;

/**
 * Spring profile 常用方法与profile名称。
 * 此特性在 DUBBO 当前版本下有冲突。TODO
 *
 * @author calvin
 */
public class Profiles {

    public static final String ACTIVE_PROFILE = "spring.profiles.active";
    public static final String DEFAULT_PROFILE = "spring.profiles.default";

    public static final String PRODUCTION = "idc";
    public static final String DEVELOPMENT = "dev";
    public static final String UNIT_TEST = "test";
    public static final String FUNCTIONAL_TEST = "functional";

    /**
     * 在Spring启动前，设置profile的环境变量。
     */
    public static void setProfileAsSystemProperty(String profile) {
        System.setProperty(ACTIVE_PROFILE, profile);
    }
}
