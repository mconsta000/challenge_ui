package org.mconsta000.challenge.controller;

import java.io.IOException;

import org.mconsta000.challenge.service.PartiesService;
import org.mconsta000.challenge.service.model.PartyEncounterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ChallengeController
 */
@Controller
public class ChallengeController {
    @Autowired
    PartiesService partiesService;

    @RequestMapping(value="/parties/{partyId}/encounters/{encounterId}/",method=RequestMethod.GET)
    public String populateParty(@PathVariable(name="partyId") Integer partyId, 
        @PathVariable(name="encounterId") Integer encounterId, 
        Model model) throws IOException{
        if (partyId != null && encounterId != null) {
            PartyEncounterModel party = partiesService.getParyWithChallenge(partyId,encounterId).execute().body();
            model.addAttribute("challenge_calc", party.getParty().getEncounters().get(0).getChallenge());
        }
        return "challenge_template :: challenge_frag";
    }
}