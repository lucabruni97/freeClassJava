package it.omicronacademy.freeclassjava.services;

import it.omicronacademy.freeclassjava.entities.Corso;
import it.omicronacademy.freeclassjava.entities.Studente;
import it.omicronacademy.freeclassjava.repositories.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            throw new IllegalStateException("Lo corso con ID " + idCorso + " non esiste!");
        }

        return optionalCorso.get();
    }

    public Corso crea(Corso corso) {
        return corsoRepository.save(corso);
    }

    public Corso aggiorna(Corso corso) {
        Corso corsoInDB = corso(corso.getId());

        corsoInDB.setTitolo(corso.getTitolo());
        corsoInDB.setDescrizione(corso.getDescrizione());
        corsoInDB.setDataInizio(corso.getDataInizio());
        corsoInDB.setDataFine(corso.getDataFine());

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
