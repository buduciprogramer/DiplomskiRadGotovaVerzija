package org.dentist.dentistapp.repositories;

import org.dentist.dentistapp.entities.Obavljena_Usluga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Obavljena_UslugaRepository extends JpaRepository<Obavljena_Usluga,Integer> {

}

