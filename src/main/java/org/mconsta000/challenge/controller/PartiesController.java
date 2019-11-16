package org.mconsta000.challenge.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mconsta000.challenge.model.PartyModel;
import org.mconsta000.challenge.model.PlayerModel;
import org.mconsta000.challenge.service.PartiesService;
import org.mconsta000.challenge.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * PartiesController
 */
@Controller
public class PartiesController {
    @Autowired
    PartiesService partiesService;

    @Autowired
    PlayersService playersService;

    @GetMapping("/parties")
    public String challenge(@RequestParam(required=false) Integer id, Model model) throws IOException {
        model.addAttribute("parties", partiesService.listParties().execute().body());

        if (id != null) {
            List<PlayerModel> players = new ArrayList<PlayerModel>();
            PartyModel party = partiesService.getParty(id).execute().body();
            for (Integer playerId : party.getPlayer()) {
                PlayerModel player = playersService.getPlayer(playerId).execute().body();
                players.add(player);
            }
            model.addAttribute("players",players);
        }

        return "parties_template";
    }
}