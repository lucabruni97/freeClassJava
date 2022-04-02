package it.omiconacademy.freeclassjava.controller;

import it.omiconacademy.freeclassjava.entities.Studente;
import it.omiconacademy.freeclassjava.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/studente")
public class StudenteController {

    private final StudenteService studenteService;

    @Autowired
    public StudenteController(StudenteService studenteService) {
        this.studenteService = studenteService;
    }

    @GetMapping
    public ResponseEntity lista() {
        List<Studente> studenti = studenteService.lista();
        return ResponseEntity.ok(studenti);
    }

    @GetMapping("{idStudente}")
    public ResponseEntity studente(@PathVariable Long idStudente) {
        Studente studente = studenteService.studente(idStudente);
        return ResponseEntity.ok(studente);
    }

    @PostMapping
    public ResponseEntity crea(@RequestBody Studente studente) {
        return ResponseEntity.ok(studenteService.crea(studente));
    }

    @PutMapping
    public ResponseEntity aggiorna(@RequestBody Studente studente) {
        return ResponseEntity.ok(studenteService.aggiorna(studente));
    }

    @DeleteMapping("{isStudente}")
    public ResponseEntity cancella(@PathVariable Long isStudente) {
        return ResponseEntity.ok(studenteService.cancella(isStudente));
    }
}
