package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

/**
 * The class is intended to have generic methods to get responses for different types of api calls
 */

public class ApiUtils {

    static Logger logger= LoggerFactory.getLogger("API utils- ");

    public static Response getApiResponse(final int responseCode, final String uri) {
        logger.info("GET " + uri);
        Response res=given().header("user-key",ApiConfig.getApiKey()).get(uri).then().statusCode(responseCode).extract().response();
        logger.info(" Expected Response " + responseCode + " Observed Response " + res.getStatusCode()+"\n"+res.asString());
        return res;
    }

    public static boolean isJSONValid(String test) {
        try {
            new JSONObject(test);
        } catch (JSONException ex) {
            try {
                new JSONArray(test);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }

    public static Response postWithoutRequestBody(int responseCode, String uri) {
        System.out.println("POST : \n"+RestAssured.baseURI+uri);
        Response res = given().contentType("application/json").when().post(uri).then().statusCode(responseCode).extract().response();
        logger.info(" Expected Response " + responseCode + " Observed Response " + res.getStatusCode()+"\n"+res.asString());
        return res;
    }

    public static Response postWithRequestBody(int responseCode, String requestBody, String uri) {
        System.out.println("POST : \n"+ RestAssured.baseURI+uri);
        System.out.println("REQUEST BODY :\n"+requestBody);
        Response res = given().contentType("application/json").and().body(requestBody).when().post(uri).then().statusCode(responseCode).extract().response();
        logger.info(" Expected Response " + responseCode + " Observed Response " + res.getStatusCode()+"\n"+res.asString());
        return res;
    }

}
