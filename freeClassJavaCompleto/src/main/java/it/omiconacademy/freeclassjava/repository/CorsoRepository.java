package it.omiconacademy.freeclassjava.repository;

import it.omiconacademy.freeclassjava.entities.Corso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorsoRepository extends JpaRepository<Corso, Long> {
}
