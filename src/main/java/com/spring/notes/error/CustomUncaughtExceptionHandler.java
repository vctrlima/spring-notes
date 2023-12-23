package com.spring.notes.error;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final Logger LOGGER = Logger.getLogger(CustomUncaughtExceptionHandler.class.getName());

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        LOGGER.log(Level.SEVERE, "Uncaught exception in thread: " + t.getName(), e);
    }
}
