package com.fleaPark.services.persistence.dao;

import org.hibernate.cfg.AnnotationConfiguration;

public class ConfigUtil {
    private static AnnotationConfiguration config;

    private static ConfigUtil instance = null;

    public AnnotationConfiguration getConfig() {
        return config;
    }

    public static void setConfig(AnnotationConfiguration config) {
        ConfigUtil.config = config;
    }

    public synchronized static ConfigUtil getInstance() {
        if (instance == null) {
            instance = new ConfigUtil();
        }
        return instance;
    }

    private ConfigUtil() {
        config = new AnnotationConfiguration();
        config.configure("hibernate.cfg.xml");
    }

}
