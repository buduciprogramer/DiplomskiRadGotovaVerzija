package org.dentist.dentistapp.services;

import org.dentist.dentistapp.entities.Obavljena_Usluga;
import org.dentist.dentistapp.entities.Pacijent;
import org.dentist.dentistapp.entities.Stomatolog;
import org.dentist.dentistapp.repositories.Obavljena_UslugaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Obavljena_UslugaService {

    @Autowired
    private Obavljena_UslugaRepository obavljena_uslugaRepository;


    public List<Obavljena_Usluga> getAllObavljena_Usluga() {
        List<Obavljena_Usluga> obavljena_usluga = obavljena_uslugaRepository.findAll();
        return obavljena_usluga;
    }


    public Obavljena_Usluga saveObavljena_Usluga(Obavljena_Usluga obavljena_usluga) {
        return obavljena_uslugaRepository.save(obavljena_usluga);
    }


    public String loginObavljena_Usluga(Obavljena_Usluga obavljena_usluga) {
        return null;
    }

}


