package com.nikhil.resttests.controllers;

import com.nikhil.resttests.model.BetEvent;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Arrays.asList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class BetController {

    @RequestMapping(value = "/bets/{id}", method = GET)
    public BetEvent getBets(@PathVariable("id") String id) {
        return BetEvent.builder()
                .id(id)
                .data(BetEvent.Data.builder()
                        .leagueId(35)
                        .homeTeam("Norway")
                        .visitingTeam("England")
                        .build())
                .odds(asList(BetEvent.Odd.builder()
                                .price("1.3")
                                .name("1")
                        .ck(2.9d)
                                .build(),
                        BetEvent.Odd.builder()
                                .price("5.25")
                                .name("X")
                                .ck(93.23d)
                                .build()
                ))
                .build();

    }
}
