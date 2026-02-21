package com.db.logger;

import org.slf4j.LoggerFactory;

public class Logger {

    private Logger() {
    }

    public static Log getLogger(Class<?> clazz) {
        return new Log(LoggerFactory.getLogger(clazz));
    }

}
