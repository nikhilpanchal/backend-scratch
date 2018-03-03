package com.nikhil.testing.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

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
@AllArgsConstructor
@NoArgsConstructor
public class BetEvents {
    @Builder
    public static class Data {
        private int leagueId;
        private String homeTeam;
        private String visitingTeam;
    }

    @Builder
    public static class Odd {
        private String price;
        private String name;
    }

    private String id;
    private Data data;
    private List<Odd> odds;
}
