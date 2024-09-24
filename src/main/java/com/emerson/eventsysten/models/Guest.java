package com.emerson.eventsysten.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Guest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String rg;
    private String guestName;

    /* Relação entre convidados e evento */
    @ManyToOne // Muitos convidados para um só evento
    private Event event;

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}
