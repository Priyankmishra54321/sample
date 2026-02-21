package com.db.logger;


import org.slf4j.Logger;

public class Log {

    private final Logger logger;

    public Log(Logger logger) {
        this.logger = logger;
    }

    public void info(String message) {
        logger.info(message);
    }

    public void info(String message, Object... args) {
        logger.info(message, args);
    }

    public void error(String message, Throwable ex) {
        logger.error(message, ex);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void warn(String message) {
        logger.warn(message);
    }
//    private String enrich(String message) {
//        return String.format(
//                "[traceId=%s] [userId=%s] %s",
//                MDC.get("traceId"),
//                MDC.get("userId"),
//                maskSensitive(message)
//        );
//    }
//    private String maskSensitive(String message) {
//        return message
//                .replaceAll("(password=)[^&\\s]+", "$1****")
//                .replaceAll("(token=)[^&\\s]+", "$1****");
//    }
}
