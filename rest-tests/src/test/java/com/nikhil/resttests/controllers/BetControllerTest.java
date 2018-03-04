package com.nikhil.resttests.controllers;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;


public class BetControllerTest {

    @Test
    public void whenRequested_ShouldReturnExpectedLeagueId() {
        get("/bets/390")
                .then()
                .statusCode(200)
                .assertThat()
                .body("data.leagueId", equalTo(35));
    }

    @Test
    public void whenRequested_shouldReturnExpectedPrices() {
        get("/bets/390")
                .then()
                .statusCode(200)
                .assertThat()
                .body("odds.price", hasItems("1.3", "5.25"));
    }

    @Test
    public void whenRequested_shouldReturnExpectedJsonResponseFormat() {
        get("/bets/390")
                .then()
                .statusCode(200)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("sample_response.json"));
    }

    @Test
    public void whenRequest_shouldReturnExpectedDoubleValues() {
        get("/bets/390")
                .then()
                .statusCode(200)
                .assertThat()
                .body("odds.ck", hasItems(2.9f, 93.23f));
    }

    @Test
    public void whenRequested_shouldReturnAnExpectedBetEvent() {
        ValidatableResponse response = get("/bets/400").then().statusCode(200).assertThat()
                .body("id", equalTo("400"))
                .body("data.leagueId", equalTo(35))
                .body("data.homeTeam", equalTo("Norway"))
                .body("data.visitingTeam", equalTo("England"));

        response
                .body("odds[0].price", equalTo("1.3"),
                        "odds[0].name", equalTo("1"),
                        "odds[0].ck", equalTo(2.9f)
                );
    }
}
