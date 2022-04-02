package it.omiconacademy.freeclassjava.service;

import it.omiconacademy.freeclassjava.entities.Studente;
import it.omiconacademy.freeclassjava.exception.BadRequestException;
import it.omiconacademy.freeclassjava.exception.NotFoundException;
import it.omiconacademy.freeclassjava.repository.StudenteRepository;
import it.omiconacademy.freeclassjava.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
            throw new NotFoundException("Lo studente con id " + idStudente + " non esiste!");
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lo studente con id " + idStudente + " non esiste!");
        }

        return optionalStudente.get();
    }

    public Studente crea(Studente studente) {
        if (studente.getId() != null) {
            throw new BadRequestException("L'ID non deve essere valorizzato per un nuovo studente!");
        }

        if (!Validator.emailValida(studente.getEmail())) {
            throw new BadRequestException("Il formato dell'email non è corretto!");
        }

        if (studenteRepository.existsByEmail(studente.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email già utilizzata!");
        }

        return studenteRepository.save(studente);
    }

    public Studente aggiorna(Studente studente) {
        Studente studenteInDB = studente(studente.getId());

        if (!Validator.emailValida(studente.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Il formato dell'email non è corretto!");
        }

        if (!studenteInDB.getEmail().equals(studente.getEmail()) && studenteRepository.existsByEmail(studente.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email già utilizzata!");
        }

        if (studente.getNome() != null) {
            studenteInDB.setNome(studente.getNome());
        }
        if (studente.getEmail() != null) {
            studenteInDB.setEmail(studente.getEmail());
        }
        if (studente.getDataNascita() != null) {
            studenteInDB.setDataNascita(studente.getDataNascita());
        }

        return studenteRepository.save(studenteInDB);
    }

    public Studente cancella(Long idStudente) {
        Studente studente = studente(idStudente);

        studenteRepository.deleteById(idStudente);

        return studente;
    }
}
