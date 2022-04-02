package it.omiconacademy.freeclassjava.repository;

import it.omiconacademy.freeclassjava.entities.Studente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudenteRepository extends JpaRepository<Studente, Long> {
    boolean existsByEmail(String email);
}
