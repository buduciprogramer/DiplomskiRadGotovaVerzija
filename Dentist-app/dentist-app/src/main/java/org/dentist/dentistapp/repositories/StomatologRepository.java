package org.dentist.dentistapp.repositories;

import org.dentist.dentistapp.entities.Stomatolog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StomatologRepository extends JpaRepository<Stomatolog,Integer> {
    Stomatolog findByUsername(String username);
}
