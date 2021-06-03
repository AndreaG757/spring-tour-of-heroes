package it.prova.herorestapi.service;

import it.prova.herorestapi.model.Hero;
import it.prova.herorestapi.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroRepository repository;

    @Override
    public List<Hero> listAllElements() {
        return (List<Hero>) repository.findAll();
    }

    @Override
    public Hero findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Hero updateHero(Hero heroInstance) {
        return repository.save(heroInstance);
    }

    @Override
    public Hero insertHero(Hero heroInstance) {
        return repository.save(heroInstance);
    }

    @Override
    public void deleteHero(Hero heroInstance) {
        repository.delete(heroInstance);
    }

    @Override
    public List<Hero> findByName(String name) {
        return repository.findByName(name);
    }

}
