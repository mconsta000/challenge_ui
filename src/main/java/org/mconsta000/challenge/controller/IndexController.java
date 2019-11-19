package org.mconsta000.challenge.controller;

import java.io.IOException;
import java.util.List;

import org.mconsta000.challenge.controller.model.IndexModel;
import org.mconsta000.challenge.service.EncountersService;
import org.mconsta000.challenge.service.PartiesService;
import org.mconsta000.challenge.service.model.EncountersModel;
import org.mconsta000.challenge.service.model.PartyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * IndexController
 */
@Controller
public class IndexController {
    @Autowired
    PartiesService partiesService;

    @Autowired
    EncountersService encountersService;

    @ModelAttribute("parties")
    public List<PartyModel> populateParties() throws IOException{
        return partiesService.listParties().execute().body();
    }

    @ModelAttribute("encounters")
    public List<EncountersModel> populateEncounters() throws IOException{
        return encountersService.listEncounters().execute().body();
    }

    @RequestMapping(value="/",method=RequestMethod.GET)
    public ModelAndView challenge(Model model) throws IOException {
        return new ModelAndView("index_template","indexModel",new IndexModel());
    }
}