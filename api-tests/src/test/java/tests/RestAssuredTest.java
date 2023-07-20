package tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredTest {

    @Test
    void testRestAssuredAllureReport() {

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addFilter(new AllureRestAssured())
               .addFilter(new ResponseLoggingFilter(LogDetail.STATUS))
               .addFilter(new RequestLoggingFilter(LogDetail.HEADERS, true, System.out, false))
               .addFilter(new RequestLoggingFilter(LogDetail.METHOD, true, System.out, false))
               .addFilter(new RequestLoggingFilter(LogDetail.URI, true, System.out, false))
                .setContentType(ContentType.JSON)
                .build();

        given().header("authorization", "Bearer undefined")
                .get("https://alpha.peerspaceapp.com/v1/sso/grants?username=cGV0cm9hbmRydXNoY2hhayt0YWZzaWdudXA1NzIzQzUyRkFFODlAZ21haWwuY29t&timestamp=1658754736 ");


    }
}
