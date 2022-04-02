package it.omiconacademy.freeclassjava.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "corso")
public class Corso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "titolo")
    private String titolo;
    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "dataInizio")
    private LocalDate dataInizio;
    @Column(name = "dataFine")
    private LocalDate dataFine;
    @ManyToMany
    @JoinTable(name = "studente_corso", joinColumns = @JoinColumn(name = "idCorso"), inverseJoinColumns = @JoinColumn(name = "idStudente"))
    private Set<Studente> studenti = new HashSet<>();

    public Corso() {
    }

    public Corso(String titolo, String descrizione, LocalDate dataInizio, LocalDate dataFine, Set<Studente> studenti) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.studenti = studenti;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public Set<Studente> getStudenti() {
        return studenti;
    }

    public void setStudenti(Set<Studente> studenti) {
        this.studenti = studenti;
    }

    public void aggiungiStudente(Studente studente) {
        // if (this.studenti == null) {
        // this.studenti = new HashSet<>();
        // }
        this.studenti.add(studente);
    }

    public void rimuoviStudente(Studente studente) {
        /*
         * if (this.studenti == null) {
         * this.studenti = new HashSet<>();
         * } else {
         */
        this.studenti.remove(studente);
        // }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Corso))
            return false;
        Corso corso = (Corso) o;
        return Objects.equals(id, corso.id) && Objects.equals(titolo, corso.titolo)
                && Objects.equals(descrizione, corso.descrizione) && Objects.equals(dataInizio, corso.dataInizio)
                && Objects.equals(dataFine, corso.dataFine) && Objects.equals(studenti, corso.studenti);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titolo, descrizione, dataInizio, dataFine, studenti);
    }

    @Override
    public String toString() {
        return "Corso: {"
                + "\"id\":\"" + id + "\""
                + ", \"titolo\":\"" + titolo + "\""
                + ", \"descrizione\":\"" + descrizione + "\""
                + ", \"dataInizio\":" + dataInizio
                + ", \"dataFine\":" + dataFine
                + ", \"studenti\":" + studenti
                + "}";
    }
}
