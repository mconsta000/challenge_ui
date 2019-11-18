package org.mconsta000.challenge.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mconsta000.challenge.controller.model.EncounterModel;
import org.mconsta000.challenge.service.EncountersService;
import org.mconsta000.challenge.service.FoeEncountersService;
import org.mconsta000.challenge.service.FoesService;
import org.mconsta000.challenge.service.model.EncountersModel;
import org.mconsta000.challenge.service.model.FoeEncounterModel;
import org.mconsta000.challenge.service.model.FoeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EncounterController {
    @Autowired
    EncountersService encounterService;

    @Autowired
    FoeEncountersService foeEncounterServices;

    @Autowired
    FoesService foesService;

    @RequestMapping(value="/encounters/{id}/",method=RequestMethod.GET)
    public String populateEncounter(@PathVariable(name="id") Integer id, Model model)
        throws IOException{
        if (id != null) {
            List<EncounterModel> foeEncounters = new ArrayList<EncounterModel>();
            EncountersModel encounter = encounterService.getEncounter(id).execute().body();
            for (Integer foeEncounterId : encounter.getFoes()) {
                FoeEncounterModel foeEncounter = foeEncounterServices.getFoeEncounter(foeEncounterId).execute().body();
                FoeModel foe = foesService.getFoe(foeEncounter.getFoe()).execute().body();

                EncounterModel em = new EncounterModel();
                em.setName(foe.getName());
                em.setXp(foe.getXp());
                em.setCount(foeEncounter.getCount());

                foeEncounters.add(em);
            }
            model.addAttribute("foeEncounter", foeEncounters);
        }
        return "encounter_template";
    }
}