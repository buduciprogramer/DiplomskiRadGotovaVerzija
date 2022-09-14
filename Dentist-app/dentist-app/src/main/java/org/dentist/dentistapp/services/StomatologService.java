package org.dentist.dentistapp.services;

import org.dentist.dentistapp.entities.Stomatolog;
import org.dentist.dentistapp.repositories.StomatologRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StomatologService {


    @Autowired
    private StomatologRepository stomatologRepository;


    public List<Stomatolog> getAllStomatologs() {
        List<Stomatolog> stomatologs = stomatologRepository.findAll();
        return stomatologs;
    }

    public Stomatolog saveStomatolog(Stomatolog stomatolog) {
        return stomatologRepository.save(stomatolog);
    }

    public Stomatolog getByUsername(String username) {
        return stomatologRepository.findByUsername(username);
    }

    public Stomatolog getById(int id){
        return stomatologRepository.getById(id);
    }


}


