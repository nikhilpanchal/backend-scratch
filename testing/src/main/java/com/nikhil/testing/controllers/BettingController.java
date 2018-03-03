package com.nikhil.testing.controllers;

import com.nikhil.testing.models.BetEvents;

import static java.util.Arrays.asList;

@RestController
public class BettingController {

    /*
     * Returns a sample Bet Event.
     */
    public BetEvents getEvents() {
        return BetEvents.builder()
                .id("390")
                .data(BetEvents.Data.builder()
                        .leagueId(35)
                        .homeTeam("Norway")
                        .visitingTeam("England")
                        .build())
                .odds(asList(BetEvents.Odd.builder()
                        .name("1")
                        .price("1.30")
                        .build(), BetEvents.Odd.builder()
                        .name("X")
                        .price("5.25")
                        .build()))
                .build();
    }

}
