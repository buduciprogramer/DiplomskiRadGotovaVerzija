package org.dentist.dentistapp.controllers;


import org.dentist.dentistapp.entities.Obavljena_Usluga;
import org.dentist.dentistapp.services.Obavljena_UslugaService;
import org.dentist.dentistapp.services.StomatologService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


    @Controller
    public class Obavljena_UslugaController {


    @Autowired
    private Obavljena_UslugaService obavljena_uslugaService;

    @Autowired
    private StomatologService stomatologService;

    @GetMapping("/obavljene_usluge")
    public String pregledObavljenihUsluga(Model model) {
        List<Obavljena_Usluga> Obavljena_UslugaList = obavljena_uslugaService.getAllObavljena_Usluga();
        model.addAttribute("listaObavljenihUsluga", Obavljena_UslugaList);
        return "obavljene_usluge";
    }

    @GetMapping("/dodaj_obavljenu_uslugu_forma")
    public String dodajObavljenuUsluguForma(Model model) {
        Obavljena_Usluga obavljena_usluga = new Obavljena_Usluga();
        model.addAttribute("obavljenaUsluga", obavljena_usluga);
        return "ou_forma";
    }

    @PostMapping("/dodaj_obavljenu_uslugu")
    public String saveObavljena_Usluga(@ModelAttribute("obavljenaUsluga") Obavljena_Usluga obavljena_usluga) {
        try {
            obavljena_uslugaService.saveObavljena_Usluga(obavljena_usluga);

            return "redirect:/obavljene_usluge";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }


    }







