package com.spring.notes;

import com.spring.notes.error.CustomUncaughtExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotesApplication {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new CustomUncaughtExceptionHandler());
        SpringApplication.run(NotesApplication.class, args);
    }
}
