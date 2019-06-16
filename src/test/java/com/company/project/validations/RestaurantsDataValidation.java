package com.company.project.validations;


import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import utils.ApiConfig;
import utils.ApiUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * this class is used to validate the result related to restaurant details
 */

public class RestaurantsDataValidation {

    private static final Logger logger= LoggerFactory.getLogger("Restaurant data validation ");
    private String restaurantSearchQuery= ApiConfig.getRestaurantSearchQuery();

    public boolean validateRestaurantSearchQueryData(Response response) {
        Assert.assertTrue(ApiUtils.isJSONValid(response.asString()),"The given String is not a valid JSON");
        List<Map> restaurants = response.jsonPath().get("restaurants.restaurant");

        for (Map restaurant : restaurants) {
            logger.info("\n"+restaurant.get("name") + "\n" + restaurant.get("cuisines"));
            boolean flag = restaurant.get("name").toString().toLowerCase().contains(restaurantSearchQuery) || restaurant.get("cuisines").toString().toLowerCase().contains(restaurantSearchQuery);
            if (!flag)
                return false;
        }
        return true;
    }
}
