//package com.db;
//
//import com.db.connection.DatabaseConnection;
//import com.db.logger.Log;
//import com.db.logger.Logger;
//import org.apache.catalina.LifecycleException;
//import org.apache.catalina.startup.Tomcat;
//import org.slf4j.bridge.SLF4JBridgeHandler;
//import com.db.properties.AbsCallProperties;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.io.File;
//@SpringBootApplication
//public class Main {
//
//    private static final Log log = Logger.getLogger(Main.class);
//@PostConstruct
//    public void init() {
//    System.out.println("Application started successfully");
//    }
//    public static void main(String[] args) {
//        try {
//
////            AbsCallProperties.loadProperties();
////
////            DatabaseConnection.getDataSource();
////
////            String port = AbsCallProperties.get("PORT");
////
////            log.info("Starting server on port: {}", port);
////
////            if (port == null || port.isEmpty()) {
////                port = String.valueOf(8080);
////            }
////
////            SLF4JBridgeHandler.removeHandlersForRootLogger();
////            SLF4JBridgeHandler.install();
////
////            Tomcat tomcat = new Tomcat();
////            tomcat.setPort(Integer.parseInt(port));
////            File webappDir = new File("src/main/webapp");
////
////            tomcat.addWebapp("", webappDir.getAbsolutePath());
////            tomcat.getConnector();
////            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
////                try {
////                    log.info("Shutdown initiated...");
////
////                    DatabaseConnection.shutdown();
////                    log.info("Database connections closed.");
////
////                    log.info("Stopping Tomcat...");
////                    tomcat.stop();
////                    tomcat.destroy();
////                } catch (Exception e) {
////                    log.error("Error during shutdown", e);
////                }
////            }));
////
////
////            tomcat.start();
////            tomcat.getServer().await();
//
//
////            log.info("Server started on port: {}", port);
//
//
//            SpringApplication.run(Main.class, args);
//
//        } catch (Exception e) {
//            log.error("Failed to start server", e);
//        }
//    }
//}
