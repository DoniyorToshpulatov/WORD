package org.example;

import org.example.controller.WordController;
import org.example.db.Database;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        Database.initTable();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(org.example.config.Config.class);
        WordController authController = (WordController) applicationContext.getBean("wordController");
        authController.start();

    }
}