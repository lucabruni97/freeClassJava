package it.omicronacademy.freeclassjava.controller;

import it.omicronacademy.freeclassjava.entities.Studente;
import it.omicronacademy.freeclassjava.services.StudenteService;
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
        List<Studente> studenteList = studenteService.lista();
        return ResponseEntity.ok(studenteList);
    }

    @PostMapping
    public ResponseEntity crea(@RequestBody Studente studente) {
        Studente studenteCreato = studenteService.crea(studente);
        return ResponseEntity.ok(studenteCreato);
    }

    @PutMapping
    public ResponseEntity aggiorna(@RequestBody Studente studente) {
        Studente studenteAggiornato = studenteService.aggiorna(studente);
        return ResponseEntity.ok(studenteAggiornato);
    }

    @DeleteMapping("{idStudente}")
    public ResponseEntity cancella(@PathVariable Long idStudente) {
        Studente studenteCancellato = studenteService.cancella(idStudente);
        return ResponseEntity.ok(studenteCancellato);
    }
}
