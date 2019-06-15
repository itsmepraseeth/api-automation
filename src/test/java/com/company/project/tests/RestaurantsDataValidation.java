package com.company.project.tests;


import io.restassured.response.Response;

/**
 * this class is used to validate the result related to restaurant details
 */

public class RestaurantsDataValidation {


    public boolean validateRestaurantSearchQueryData(Response response) {
        response.jsonPath().get();
return true;
    }
}
