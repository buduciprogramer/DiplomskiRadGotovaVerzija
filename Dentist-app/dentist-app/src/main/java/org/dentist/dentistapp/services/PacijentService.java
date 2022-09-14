package org.dentist.dentistapp.services;

import org.dentist.dentistapp.entities.Pacijent;
import org.dentist.dentistapp.repositories.PacijentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacijentService {

    @Autowired
    private PacijentRepository pacijentRepository;

    public List<Pacijent> getAllPacijent(){
        List<Pacijent> pacijent = pacijentRepository.findAll();
        return pacijent;
    }

    public Pacijent savePacijent(Pacijent pacijent){
        return pacijentRepository.save(pacijent);
    }


    public String loginPacijent(Pacijent pacijent) {
        return loginPacijent(pacijent);
    }

    public Pacijent findById(int id) {
        return pacijentRepository.getById(id);
    }
}










