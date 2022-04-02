package it.omicronacademy.freeclassjava.services;

import it.omicronacademy.freeclassjava.entities.Studente;
import it.omicronacademy.freeclassjava.repositories.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudenteService {

    private final StudenteRepository studenteRepository;

    @Autowired
    public StudenteService(StudenteRepository studenteRepository) {
        this.studenteRepository = studenteRepository;
    }

    public List<Studente> lista() {
        return studenteRepository.findAll();
    }

    public Studente studente(Long idStudente) {
        Optional<Studente> optionalStudente = studenteRepository.findById(idStudente);

        if (optionalStudente.isEmpty()) {
            throw new IllegalStateException("Lo studente con ID " + idStudente + " non esiste!");
        }

        return optionalStudente.get();
    }

    public Studente crea(Studente studente) {
        return studenteRepository.save(studente);
    }

    public Studente aggiorna(Studente studente) {
        Studente studenteInDB = studente(studente.getId());

        studenteInDB.setNome(studente.getNome());
        studenteInDB.setEmail(studente.getEmail());
        studenteInDB.setDataNascita(studente.getDataNascita());

        return studenteRepository.save(studenteInDB);
    }

    public Studente cancella(Long idStudente) {
        Studente studente = studente(idStudente);

        studenteRepository.deleteById(idStudente);

        return studente;
    }
}
