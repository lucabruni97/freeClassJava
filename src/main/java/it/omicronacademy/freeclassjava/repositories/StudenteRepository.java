package it.omicronacademy.freeclassjava.repositories;

import it.omicronacademy.freeclassjava.entities.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudenteRepository extends JpaRepository<Studente, Long> {

    boolean existsByEmail(String email);
}
