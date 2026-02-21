package com.db.core;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CommonUtils {


    private CommonUtils() {
    }

    public static List<Object> list = new LinkedList<>();

    private static final ObjectMapper mapper = new ObjectMapper();


    public static ObjectMapper getMapper() {
        return mapper;
    }

    public static ExecutorService getExecutorService() {
        return Executors.newVirtualThreadPerTaskExecutor();
    }
}
