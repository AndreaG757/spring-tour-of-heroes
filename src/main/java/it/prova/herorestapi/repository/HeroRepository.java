package it.prova.herorestapi.repository;

import it.prova.herorestapi.model.Hero;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HeroRepository extends CrudRepository<Hero, Long> {
    List<Hero> findByName(String name);
}
