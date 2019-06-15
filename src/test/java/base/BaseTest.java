package base;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BaseTest {

    @BeforeClass
    private void testSetUp(){
        System.setProperty("envType",getTextFromFile("environment.txt"));
        System.out.println("test setup--  "+System.getProperty("envType"));
    }

    public static String getTextFromFile(String filename) {
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
