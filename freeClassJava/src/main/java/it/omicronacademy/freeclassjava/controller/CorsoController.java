package it.omicronacademy.freeclassjava.controller;

import it.omicronacademy.freeclassjava.entities.Corso;
import it.omicronacademy.freeclassjava.services.CorsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/corso")
public class CorsoController {

    private final CorsoService corsoService;

    @Autowired
    public CorsoController(CorsoService corsoService) {
        this.corsoService = corsoService;
    }

    @GetMapping
    public ResponseEntity lista() {
        List<Corso> corsoList = corsoService.lista();
        return ResponseEntity.ok(corsoList);
    }

    @PostMapping
    public ResponseEntity crea(@RequestBody Corso corso) {
        Corso corsoCreato = corsoService.crea(corso);
        return ResponseEntity.ok(corsoCreato);
    }

    @PutMapping
    public ResponseEntity aggiorna(@RequestBody Corso corso) {
        Corso corsoAggiornato = corsoService.aggiorna(corso);
        return ResponseEntity.ok(corsoAggiornato);
    }

    @DeleteMapping("{idCorso}")
    public ResponseEntity cancella(@PathVariable Long idCorso) {
        Corso corsoCancellato = corsoService.cancella(idCorso);
        return ResponseEntity.ok(corsoCancellato);
    }

    @PutMapping("{idCorso}/aggiungi/{idStudente}")
    public ResponseEntity aggiungiStudente(@PathVariable Long idCorso, @PathVariable Long idStudente) {
        Corso corsoAggiornato = corsoService.aggiungiStudente(idCorso, idStudente);
        return ResponseEntity.ok(corsoAggiornato);
    }

    @PutMapping("{idCorso}/rimuovi/{idStudente}")
    public ResponseEntity rimuoviStudente(@PathVariable Long idCorso, @PathVariable Long idStudente) {
        Corso corsoAggiornato = corsoService.rimuoviStudente(idCorso, idStudente);
        return ResponseEntity.ok(corsoAggiornato);
    }
}
