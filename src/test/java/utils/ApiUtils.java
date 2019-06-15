package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

/**
 * The class is intended to have generic methods to get responses for different types of api calls
 */

public class ApiUtils {

    static Logger logger= LoggerFactory.getLogger("API utils- ");

    public static Response getApiResponse(final int responseCode, final String url) {
        logger.info("GET " + url);
        final Response res = get(url);
        logger.info("GET " + url + " Expected Response " + responseCode
                + " Observed Response " + res.getStatusCode());
        assertEquals(res.getStatusCode(), responseCode);
        return res;
    }

    public static Response postWithoutRequestBody(int responseCode, String url) {
        System.out.println("POST : \n"+RestAssured.baseURI+url);
        Response res = given().contentType("application/json").when().post(url);
        assertEquals(res.getStatusCode(), responseCode);
        return res;
    }

    public static Response postWithRequestBody(int responseCode, String requestBody, String url) {
        System.out.println("POST : \n"+ RestAssured.baseURI+url);
        System.out.println("REQUEST BODY :\n"+requestBody);
        Response res = given().contentType("application/json").and().body(requestBody).when().post(url);
        assertEquals(res.getStatusCode(), responseCode);
        return res;
    }

}
