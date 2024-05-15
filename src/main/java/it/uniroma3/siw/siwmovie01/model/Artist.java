package it.uniroma3.siw.siwmovie01.model;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String cognome;
    private Date nascita;

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public Date getNascita() {
        return nascita;
    }

    public Long getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNascita(Date nascita) {
        this.nascita = nascita;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean equals(Object o) {
        Artist that = (Artist) o;
        return this.getNome().equals(that.getNome()) && this.getCognome().equals(that.getCognome())
                && this.getId() == that.getId() && this.getNascita() == that.getNascita();
    }

    public int hashCode() {
        return (int) (this.getNome().hashCode() + this.getCognome().hashCode() + this.getId()
                + this.getNascita().hashCode());
    }

}
