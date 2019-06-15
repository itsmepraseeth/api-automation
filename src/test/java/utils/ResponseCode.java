package utils;

/**
 * This interface defines all the Response Code Constants
 *
 */

public interface ResponseCode {

    int OK = 200;

    int CREATED = 201;

    int ACCEPTED = 202;

    int PARTIAL_INFORMATION = 203;

    int NO_RESPONSE = 204;

    int BAD_REQUEST = 400;

    int UNAUTHORIZED = 401;

    int PAYMENT_REQUIRED = 402;

    int FORBIDDEN = 403;

    int NOT_FOUND = 404;

    int METHOD_NOT_ALLOWED = 405;

    int CONFLICT = 409;

    int PRE_CONDITION_FAIL = 412;

    int INTERNAL_ERROR = 500;

    int NOT_IMPLEMENTED = 501;

    int SERVICE_TEMP_OVERLOADED = 502;

    int GATEWAY_TIMEOUT = 503;

    int MOVED = 301;

    int FOUND = 302;

    int METHOD = 303;

    int NOT_MODIFIED = 304;

    int TEMPORARY_REDIRECT = 307;


}
