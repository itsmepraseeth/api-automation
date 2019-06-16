package com.company.project.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class contains the testNG annotation methods which are needed to be run with respect to the test script
 */

public class BaseTest {

    private static final Logger logger= LoggerFactory.getLogger("Base test ");

    /**
     * This method will set the execution environment passed by the user to the system properties
     */
    @BeforeTest
    private void testSetUp(){
        System.setProperty("envType",getTextFromFile("environment.txt"));
        logger.info("Provided environment- "+System.getProperty("envType"));
    }

     private String getTextFromFile(String filename) {
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
