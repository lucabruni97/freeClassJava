package it.omiconacademy.freeclassjava.service;

import it.omiconacademy.freeclassjava.entities.Corso;
import it.omiconacademy.freeclassjava.entities.Studente;
import it.omiconacademy.freeclassjava.repository.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CorsoService {

    private final CorsoRepository corsoRepository;
    private final StudenteService studenteService;

    @Autowired
    public CorsoService(CorsoRepository corsoRepository, StudenteService studenteService) {
        this.corsoRepository = corsoRepository;
        this.studenteService = studenteService;
    }

    public List<Corso> lista() {
        return corsoRepository.findAll();
    }

    public Corso corso(Long idCorso) {
        Optional<Corso> optionalCorso = corsoRepository.findById(idCorso);

        if (optionalCorso.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Il corso con id " + idCorso + " non esiste!");
        }

        return optionalCorso.get();
    }

    public Corso crea(Corso corso) {
        if (corso.getId() != null) {
            throw new IllegalStateException("L'ID non deve essere valorizzato per un nuovo corso!");
        }

        return corsoRepository.save(corso);
    }

    public Corso aggiorna(Corso corso) {
        Corso corsoInDB = corso(corso.getId());

        if (corso.getTitolo() != null && !corso.getTitolo().equals(corsoInDB.getTitolo())) {
            corsoInDB.setTitolo(corso.getTitolo());
        }
        if (corso.getDescrizione() != null && !corso.getDescrizione().equals(corsoInDB.getDescrizione())) {
            corsoInDB.setDescrizione(corso.getDescrizione());
        }
        if (corso.getDataInizio() != null && !corso.getDataInizio().equals(corsoInDB.getDataInizio())) {
            corsoInDB.setDataInizio(corso.getDataInizio());
        }
        if (corso.getDataFine() != null && !corso.getDataFine().equals(corsoInDB.getDataFine())) {
            corsoInDB.setDataFine(corso.getDataFine());
        }

        return corsoRepository.save(corsoInDB);
    }

    public Corso cancella(Long idCorso) {
        Corso corso = corso(idCorso);

        corsoRepository.deleteById(idCorso);

        return corso;
    }

    public Corso aggiungiStudente(Long idCorso, Long idStudente) {
        Corso corso = corso(idCorso);
        Studente studente = studenteService.studente(idStudente);

        corso.aggiungiStudente(studente);

        return corsoRepository.save(corso);
    }

    public Corso rimuoviStudente(Long idCorso, Long idStudente) {
        Corso corso = corso(idCorso);
        Studente studente = studenteService.studente(idStudente);

        corso.rimuoviStudente(studente);

        return corsoRepository.save(corso);
    }
}
