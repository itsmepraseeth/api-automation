package com.company.project.tests;

import com.company.project.validations.RestaurantsDataValidation;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiConfig;
import utils.ApiUtils;
import utils.ResponseCode;


/**
 * This class is used to fetch data related to restaurants
 */

public class RestaurantDetails extends BaseTest implements ResponseCode {

    private static final Logger logger= LoggerFactory.getLogger("Restaurant details");

    RestaurantsDataValidation dataValidation=new RestaurantsDataValidation();

    /**
     * This method will fetch and validate the details of restaurants filtered with search query
     */
    @Test
    void searchRestaurantsWithQuery(){
        logger.info("Fetching data for restaurants with search query");
        RestAssured.baseURI= ApiConfig.getHost();
        String uri=String.format(ApiConfig.getRestaurantSearchQueryApi(),ApiConfig.getRestaurantSearchQuery());
        Response response=ApiUtils.getApiResponse(OK,uri);
        Assert.assertTrue(dataValidation.validateRestaurantSearchQueryData(response),"Search query results for restaurants have produced invalid response");
    }
}