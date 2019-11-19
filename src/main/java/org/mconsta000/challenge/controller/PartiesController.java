package org.mconsta000.challenge.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mconsta000.challenge.service.PartiesService;
import org.mconsta000.challenge.service.PlayersService;
import org.mconsta000.challenge.service.model.PartyModel;
import org.mconsta000.challenge.service.model.PlayerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * PartiesController
 */
@Controller
public class PartiesController {
    @Autowired
    PartiesService partiesService;

    @Autowired
    PlayersService playersService;

    @RequestMapping(value="/parties/{id}/",method=RequestMethod.GET)
    public String populateParty(@PathVariable(name="id") Integer id, Model model)
        throws IOException{
        if (id != null) {
            List<PlayerModel> players = new ArrayList<PlayerModel>();
            PartyModel party = partiesService.getParty(id).execute().body();
            for (Integer playerId : party.getPlayer()) {
                PlayerModel player = playersService.getPlayer(playerId).execute().body();
                players.add(player);
            }
            model.addAttribute("players", players);
        }
        return "party_template :: playersTable";
    }
}