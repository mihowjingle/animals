package com.animals;

import io.restassured.RestAssured;
import org.jooby.test.JoobyRule;
import org.junit.ClassRule;
import org.junit.Test;

/**
 * @author jooby generator
 */
public class AppTest {

    /**
     * One app/server for all the test of this class. If you want to start/stop a new server per test,
     * remove the static modifier and replace the {@link ClassRule} annotation with {@link Rule}.
     */
    @ClassRule
    public static JoobyRule app = new JoobyRule(new App());

    @Test
    public void gsonStackOverflowError() {

        RestAssured.given()
                .contentType("application/json")
                .body("{\"id\": null,\"name\":\"Doggo\"}")
                .post("/animals")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
