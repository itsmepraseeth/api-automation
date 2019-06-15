package com.company.project.validations;

import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * this classs is used to validate the result related to cuisines' details
 */

public class CuisinesDataVaildation {

    private static final Logger logger= LoggerFactory.getLogger("Cuisines details validation ");

    public boolean validateCuisinesDataByCity(Response response){
        List<Map> cuisines = response.jsonPath().get("cuisines.cuisine");
        boolean flag = false;
        for (Map cuisine : cuisines) {
            logger.info(cuisine.get("cuisine_id") + "\n" + cuisine.get("cuisine_name"));
            flag = !cuisine.get("cuisine_id").toString().isEmpty()&& cuisine.get("cuisine_name").toString().isEmpty();
        }
        return flag;

    }
}
