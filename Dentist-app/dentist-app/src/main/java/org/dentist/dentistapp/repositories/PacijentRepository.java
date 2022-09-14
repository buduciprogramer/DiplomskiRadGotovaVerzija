package org.dentist.dentistapp.repositories;

import org.dentist.dentistapp.entities.Pacijent;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PacijentRepository extends JpaRepository<Pacijent,Integer> {

}

