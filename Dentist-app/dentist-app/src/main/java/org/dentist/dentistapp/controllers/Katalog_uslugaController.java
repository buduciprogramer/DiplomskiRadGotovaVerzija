package org.dentist.dentistapp.controllers;

import org.dentist.dentistapp.entities.Katalog_usluga;
import org.dentist.dentistapp.entities.Pacijent;
import org.dentist.dentistapp.services.Katalog_uslugaService;
import org.dentist.dentistapp.services.PacijentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Set;


@Controller
    public class Katalog_uslugaController {

    @Autowired
    private Katalog_uslugaService katalog_uslugaService;

        @Autowired
        private PacijentService pacijentService;

    @GetMapping("/katalog_usluga")
    public String pregledUsluga(Model model){
        List<Katalog_usluga> katalog_uslugaList = katalog_uslugaService.getAllKatalog_usluga();
        model.addAttribute("listaKatalogUsluga",katalog_uslugaList);
        return "katalog_usluga";
    }

    @GetMapping("/dodaj_katalog_uslugu_forma")
    public String dodajKatalogUsluguForma(Model model) {
        Katalog_usluga katalog_usluga = new Katalog_usluga();
        model.addAttribute("katalogUsluga", katalog_usluga);
        return "ku_forma";
    }

    @GetMapping("/prodaj_katalog_uslugu")
    public String prodajKatalogUslugu(Model model){
        KatalogUsluga katalogUsluga = new KatalogUsluga();
        model.addAttribute("katalogUsluga", katalogUsluga);

        List<Katalog_usluga> katalog_uslugaList = katalog_uslugaService.getAllKatalog_usluga();
        model.addAttribute("usluge",katalog_uslugaList);

        List<Pacijent>pacijentList=pacijentService.getAllPacijent();
        model.addAttribute("pacijenti",pacijentList);
        return "prodaj_uslugu_forma";
    }


    @PostMapping("/dodaj_katalog_uslugu")
    public String dodajKatalogUsluga(@ModelAttribute("katalogUsluga") Katalog_usluga katalog_usluga){
        try {
            katalog_uslugaService.saveUsluge(katalog_usluga);
            return "redirect:/katalog_usluga";
        }catch (Exception e){
            return "redirect:/error";
        }
    }

    @PostMapping("/prodaj_katalog_uslugu")
    public String prodajKatalogUslugu(@ModelAttribute("katalogUsluga") KatalogUsluga katalogUsluga){
        int pacijentId=katalogUsluga.getPacijentId();
        int katalogUslugaID=katalogUsluga.getUslugaId();

        Pacijent pacijent = pacijentService.findById(pacijentId);
        Katalog_usluga katalog_usluga=katalog_uslugaService.getByID(katalogUslugaID);

        Set<Katalog_usluga>ku=pacijent.getKatalog_usluga();
        ku.add(katalog_usluga);
        pacijent.setKatalog_usluga(ku);

        pacijentService.savePacijent(pacijent);

        Set<Pacijent>pacijents=katalog_usluga.getPacijent();
        pacijents.add(pacijent);

        katalog_uslugaService.saveUsluge(katalog_usluga);

        return "redirect:/katalog_usluga";
    }


    class KatalogUsluga {
        int uslugaId;
        int pacijentId;

        public KatalogUsluga() {
        }

        public int getUslugaId() {
            return uslugaId;
        }

        public void setUslugaId(int uslugaId) {
            this.uslugaId = uslugaId;
        }

        public int getPacijentId() {
            return pacijentId;
        }

        public void setPacijentId(int pacijentId) {
            this.pacijentId = pacijentId;
        }
    }
}
