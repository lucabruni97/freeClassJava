package it.omiconacademy.freeclassjava.controller;

import it.omiconacademy.freeclassjava.entities.Corso;
import it.omiconacademy.freeclassjava.service.CorsoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/corso")
public class CorsoController {
    /**
     * Logger
     */
    private static final Logger log = LoggerFactory.getLogger(CorsoController.class);
    private final CorsoService corsoService;

    @Autowired
    public CorsoController(CorsoService corsoService) {
        this.corsoService = corsoService;
    }

    @GetMapping
    public ResponseEntity lista() {
        return ResponseEntity.ok(corsoService.lista());
    }

    @GetMapping("{idCorso}")
    public ResponseEntity corso(@PathVariable Long idCorso) {
        return ResponseEntity.ok(corsoService.corso(idCorso));
    }

    @PostMapping
    public ResponseEntity crea(@RequestBody Corso corso) {
        try {
            Corso nuovoCorso = corsoService.crea(corso);
            return ResponseEntity.ok(nuovoCorso);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            log.error("Errore in fase di creazione corso", e);
            return ResponseEntity.internalServerError().body("Ops, qualcosa è andato storto!");
        }
    }

    @PutMapping
    public ResponseEntity aggiorna(@RequestBody Corso corso) {
        try {
            Corso nuovoCorso = corsoService.aggiorna(corso);
            return ResponseEntity.ok(nuovoCorso);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            log.error("Errore in fase di aggiornamento corso", e);
            return ResponseEntity.internalServerError().body("Ops, qualcosa è andato storto!");
        }
    }

    @DeleteMapping("{idCorso}")
    public ResponseEntity cancella(@PathVariable Long idCorso) {
        try {
            Corso nuovoCorso = corsoService.cancella(idCorso);
            return ResponseEntity.ok(nuovoCorso);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            log.error("Errore in fase di aggiornamento corso", e);
            return ResponseEntity.internalServerError().body("Ops, qualcosa è andato storto!");
        }
    }

    @PutMapping("{idCorso}/aggiungi/{idStudente}")
    public ResponseEntity aggiungiStudente(@PathVariable Long idCorso, @PathVariable Long idStudente) {
        try {
            Corso nuovoCorso = corsoService.aggiungiStudente(idCorso, idStudente);
            return ResponseEntity.ok(nuovoCorso);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            log.error("Errore in fase di aggiunta studente al corso", e);
            return ResponseEntity.internalServerError().body("Ops, qualcosa è andato storto!");
        }
    }

    @PutMapping("{idCorso}/rimuovi/{idStudente}")
    public ResponseEntity rimuoviStudente(@PathVariable Long idCorso, @PathVariable Long idStudente) {
        try {
            Corso nuovoCorso = corsoService.rimuoviStudente(idCorso, idStudente);
            return ResponseEntity.ok(nuovoCorso);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            log.error("Errore in fase di rimozione studente al corso", e);
            return ResponseEntity.internalServerError().body("Ops, qualcosa è andato storto!");
        }
    }
}
