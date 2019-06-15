package com.company.project.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiConfig;
import utils.ApiUtils;
import utils.ResponseCode;

import static io.restassured.RestAssured.given;

public class CuisinesDetails implements ResponseCode {

    private static final Logger logger= LoggerFactory.getLogger("Post API Test Class");

    int cityId=4;

    @Test
    public void getCuisinesDetailsForCity(){
        RestAssured.baseURI= ApiConfig.getHost();
        String uri=String.format(ApiConfig.getCityCuisinesDetails(),cityId);
        Response response= ApiUtils.getApiResponse(OK,uri);

    }
}
