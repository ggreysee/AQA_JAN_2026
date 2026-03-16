package org.prog.session16;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class RestTest {
    @Test
    public void myRestTest() {
        RestAssured
                .given()
                .baseUri("https://randomuser.me/")
                .basePath("/api/")
                .queryParam("noinfo")
                .queryParam("inc", "gender,name,nat,location")
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("results[0].location.street.name",Matchers.not(Matchers.emptyString()))
                .body("results[0].location.street.number",Matchers.not(Matchers.nullValue()));
    }
}