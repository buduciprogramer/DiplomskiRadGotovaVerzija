package org.dentist.dentistapp.controllers;

import org.dentist.dentistapp.entities.Katalog_usluga;
import org.dentist.dentistapp.entities.Pacijent;

import org.dentist.dentistapp.entities.Stomatolog;
import org.dentist.dentistapp.model.Role;
import org.dentist.dentistapp.services.PacijentService;
import org.dentist.dentistapp.services.StomatologService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class PacijentController {

    @Autowired
    private PacijentService pacijentService;

    @Autowired
    private StomatologService stomatologService;

    @GetMapping("/pregled_pacijenata")
    public String pregledPacijenata(Model model) {
        List<Pacijent> pacijentList = pacijentService.getAllPacijent();
        model.addAttribute("listaPacijenata", pacijentList);
        return "pregled_pacijenata";
    }

    @GetMapping("/dodaj_pacijenta_forma")
    public String dodajPacijentaForma(Model model) {
        Pacijent pacijent = new Pacijent();
        model.addAttribute("pacijent", pacijent);

        List<Stomatolog> stomatolozi = stomatologService.getAllStomatologs();
        model.addAttribute("stomatolozi", stomatolozi);

        Katalog_usluga katalog_usluga=new Katalog_usluga();
        model.addAttribute("katalog_usluga",katalog_usluga);



        return "pacijent_forma";


    }

    @PostMapping("/dodaj_pacijenta")
    public String dodajPacijenta(@ModelAttribute("pacijent") Pacijent pacijent) {
        try {
            pacijent.setRole(Role.PACIJENT);

            int id = Integer.parseInt(pacijent.getStomatolog());

            Stomatolog stomatolog = stomatologService.getById(id);

            Set<Stomatolog> set = new HashSet<>();
            set.add(stomatolog);

            pacijent.setStomatolozi(set);

            pacijentService.savePacijent(pacijent);

            Set<Pacijent> pacijenti = stomatolog.getPacijenti();
            pacijenti.add(pacijent);

            stomatolog.setPacijenti(pacijenti);

            stomatologService.saveStomatolog(stomatolog);



            return "redirect:/pregled_pacijenata";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }
}


