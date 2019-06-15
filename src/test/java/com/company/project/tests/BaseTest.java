package com.company.project.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BaseTest {

    private static final Logger logger= LoggerFactory.getLogger("Base test ");

    @BeforeTest
    private void testSetUp(){
        System.setProperty("envType",getTextFromFile("environment.txt"));
        logger.info("Provided environment- "+System.getProperty("envType"));
    }

    public String getTextFromFile(String filename) {
        String value = null;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(filename));
            value = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
