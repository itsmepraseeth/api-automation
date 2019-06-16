package com.company.project.validations;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import utils.ApiUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * this class is used to validate the result related to cuisines' details
 */

public class CuisinesDataVaildation {

    private static final Logger logger= LoggerFactory.getLogger("Cuisines details validation ");

    public boolean validateCuisinesDataByCity(Response response){
        Assert.assertTrue(ApiUtils.isJSONValid(response.asString()),"The given String is not a valid JSON");
        List<Map> cuisines = response.jsonPath().get("cuisines.cuisine");
        long nullCount = cuisines.stream().filter(cuisine -> cuisine.get("cuisine_id") == null || cuisine.get("cuisine_name") == null).count();

        logger.info("Null value count in cuisines data-  "+nullCount);
        return nullCount==0;
    }
}
