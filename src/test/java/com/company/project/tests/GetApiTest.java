package com.company.project.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import utils.ApiUtils;
import utils.ResponseCode;

public class GetApiTest extends ApiUtils implements ResponseCode {

    private static final Logger logger= LoggerFactory.getLogger("Get API Test Class");

    @Test
    void orderDetails(){
        logger.info("testing");
    }
}
