package org.mconsta000.challenge.controller;

import java.io.IOException;

import org.mconsta000.challenge.service.FoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoesController {
    @Autowired
    FoesService foesService;

    @GetMapping("/foes")
    public String challenge(Model model) throws IOException {
        model.addAttribute("foes", foesService.listFoes().execute().body());
        return "foes_template";
    }
}