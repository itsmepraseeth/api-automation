package com.company.project.tests;

import com.company.project.validations.CuisinesDataVaildation;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import utils.ApiConfig;
import utils.ApiUtils;
import utils.ResponseCode;


public class CuisinesDetails extends BaseTest implements ResponseCode {

    private static final Logger logger= LoggerFactory.getLogger("Cuisines details ");

    CuisinesDataVaildation dataVaildation= new CuisinesDataVaildation();
    int cityId=4;

    /**
     * This method will fetch and validate the details of cuisines filtered with city id
     */
    @Test
    public void getCuisinesDetailsForCity(){
        logger.info("Fetching cuisines data with respect to city ");
        RestAssured.baseURI= ApiConfig.getHost();
        String uri=String.format(ApiConfig.getCityCuisinesDetails(),cityId);
        Response response= ApiUtils.getApiResponse(OK,uri);
        dataVaildation.validateCuisinesDataByCity(response);
    }
}
