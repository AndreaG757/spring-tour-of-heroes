package it.prova.herorestapi.service;

import it.prova.herorestapi.model.Hero;

import java.util.List;

public interface HeroService {

    List<Hero> listAllElements();

    Hero findById(Long id);

    Hero updateHero(Hero heroInstance);

    Hero insertHero(Hero heroInstance);

    void deleteHero(Hero heroInstance);

    List<Hero> findByName(String name);

}
