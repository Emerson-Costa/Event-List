package com.emerson.eventsysten.models;

import java.io.Serializable;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//Entidade da tabela @Entity
@Entity
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Gera o Id de maneira automática
    private long cod;

    private String name;
    private String locale;
    private String data;
    private String hour;

    /* Relação entre evento e convidados */
    @OneToMany // Um Evento para muitos convidados
    private List<Guest> guests;

    public Event(String name, String locale, String data, String hour) {
        this.name = name;
        this.locale = locale;
        this.data = data;
        this.hour = hour;
    }

    // Lembrar que a classe sempre deverá obter um construtor padrão
    public Event() {
    }

    public long getCod() {
        return cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

}
