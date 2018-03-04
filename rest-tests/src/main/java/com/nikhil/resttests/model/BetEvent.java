package com.nikhil.resttests.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;

import java.util.List;

/**
 * Model class that should spit out the following json
 *
 * "id": "390",
 "data": {
 "leagueId": 35,
 "homeTeam": "Norway",
 "visitingTeam": "England",
 },
 "odds": [{
 "price": "1.30",
 "name": "1"
 },
 {
 "price": "5.25",
 "name": "X"
 }]
 */

@Builder
@Value
public class BetEvent {
    @Value
    @Builder
    public static class Data {
        private int leagueId;
        private String homeTeam;
        private String visitingTeam;
    }

    @Value
    @Builder
    public static class Odd {
        private String price;
        private String name;
        private double ck;
    }

    private String id;
    private Data data;
    private List<Odd> odds;
}
