package org.dentist.dentistapp.repositories;

import org.dentist.dentistapp.entities.Katalog_usluga;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface Katalog_uslugaRepository extends JpaRepository<Katalog_usluga,Integer> {

}
