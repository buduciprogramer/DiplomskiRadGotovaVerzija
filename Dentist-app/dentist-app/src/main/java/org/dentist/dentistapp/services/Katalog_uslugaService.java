package org.dentist.dentistapp.services;


import org.dentist.dentistapp.entities.Katalog_usluga;
import org.dentist.dentistapp.repositories.Katalog_uslugaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Katalog_uslugaService {

    @Autowired
    private Katalog_uslugaRepository katalog_uslugaRepository;

    public List<Katalog_usluga>getAllKatalog_usluga(){
        List<Katalog_usluga>katalog_usluga=katalog_uslugaRepository.findAll();
        return katalog_usluga;
    }
    public Katalog_usluga saveUsluge(Katalog_usluga katalog_usluga){
        return katalog_uslugaRepository.save(katalog_usluga);
    }
    public Katalog_usluga getByID(int id){
        return katalog_uslugaRepository.getById(id);
    }

}



