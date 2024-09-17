package com.emerson.eventsysten.repository;

import org.springframework.data.repository.CrudRepository;

import com.emerson.eventsysten.models.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
    Event findByCod(long cod);
}
