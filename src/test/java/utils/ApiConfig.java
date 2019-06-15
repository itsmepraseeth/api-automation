package utils;

import java.util.ResourceBundle;

/**
 *
 * This class will return values from respective config files
 */

public class ApiConfig {

//    private static ResourceBundle resourceBundle=ResourceBundle.getBundle("configs/"+System.getProperty("envType"));
    private static ResourceBundle resourceBundle=ResourceBundle.getBundle("configs/env1");


    public static String getHost(){
        return resourceBundle.getString("host");
    }

    public static String getApiKey(){
        return resourceBundle.getString("apiKey");
    }

    public static String getRestaurantSearchQueryApi(){
        return resourceBundle.getString("restaurantSearchQueryApi");
    }

    public static String getCityCuisinesDetails(){
        return resourceBundle.getString("cityCuisinesDetailsApi");
    }


}
