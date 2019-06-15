package utils;

import java.util.ResourceBundle;

/**
 *
 * This class will return values from respective config files
 */

public class ApiConfig {
    private static ResourceBundle resourceBundle=ResourceBundle.getBundle("configs/"+System.getProperty("envType"));


    public static String getHost(){
        return resourceBundle.getString("host");
    }


}
