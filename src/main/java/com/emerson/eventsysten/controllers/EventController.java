package com.emerson.eventsysten.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.emerson.eventsysten.models.Event;
import com.emerson.eventsysten.repository.EventRepository;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(value = "/eventRegister", method = RequestMethod.GET)
    public String form() {
        return "event/eventForm";
    }

    @RequestMapping(value = "/eventRegister", method = RequestMethod.POST)
    public String form(Event event) {

        // Salva os registro no banco de dados
        eventRepository.save(event);

        return "redirect:/eventRegister";
    }

    // Busca os registos da base de dados e carrega a variável na view do projeto
    @RequestMapping(value = "/events")
    public ModelAndView eventsList() {
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Event> events = eventRepository.findAll();
        modelAndView.addObject("events", events);
        return modelAndView;
    }

    @RequestMapping(value = "/{cod}")
    public ModelAndView detailsEvents(@PathVariable("cod") Long cod) {
        Event event = eventRepository.findByCod(cod);
        ModelAndView modelAndView = new ModelAndView("event/detailsEvent");
        modelAndView.addObject("event", event);
        return modelAndView;
    }

}
