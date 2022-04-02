package it.omicronacademy.freeclassjava.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "studente")
public class Studente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "dataNascita")
    private LocalDate dataNascita;

    public Studente() {
    }

    public Studente(String nome, String email, LocalDate dataNascita) {
        this.nome = nome;
        this.email = email;
        this.dataNascita = dataNascita;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Studente)) return false;
        Studente studente = (Studente) o;
        return Objects.equals(id, studente.id) && Objects.equals(nome, studente.nome) && Objects.equals(email, studente.email) && Objects.equals(dataNascita, studente.dataNascita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, dataNascita);
    }

    @Override
    public String toString() {
        return "Studente: {"
                + "\"id\":\"" + id + "\""
                + ", \"nome\":\"" + nome + "\""
                + ", \"email\":\"" + email + "\""
                + ", \"dataNascita\":" + dataNascita
                + "}";
    }
}
