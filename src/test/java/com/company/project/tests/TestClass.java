package com.company.project.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import utils.ApiConfig;

import static io.restassured.RestAssured.get;


public class TestClass {

    private final static Logger logger= LoggerFactory.getLogger("test-- ");

//    @Test(groups = "testGroup")
    public void testMethod(){

        System.out.println("just a test method");
        RestAssured.baseURI= ApiConfig.getHost();
        String url="/v1/enterprise/1/indigo/user_rating?user_id=48469&access_token=7c7dcc15105d416d847e948597cbdc3c";
        Response res=get(url).then().statusCode(200).extract().response();
        logger.info(res.asString());
        String json = res.jsonPath().get("last_rated").toString();
        System.out.println(json);
    }

}
