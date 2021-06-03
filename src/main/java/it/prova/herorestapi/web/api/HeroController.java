package it.prova.herorestapi.web.api;

import it.prova.herorestapi.model.Hero;
import it.prova.herorestapi.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/heroes")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @GetMapping
    public ResponseEntity<List<Hero>> listAllHeroes() {
        return ResponseEntity.ok(heroService.listAllElements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hero> findById(@PathVariable(required = true) Long id) throws Exception {
        Hero heroInstance = heroService.findById(id);

        if (heroInstance == null)
            throw new Exception("Hero not found!");

        return ResponseEntity.ok(heroInstance);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Hero>> findByName(@RequestParam("name") String name) throws Exception {
        List<Hero> heroInstance = heroService.findByName(name);

        if (heroInstance == null)
            throw new Exception("Hero not found!");

        return ResponseEntity.ok(heroInstance);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Hero> createNewUtente(@RequestBody Hero heroInput) {
        return ResponseEntity.ok(heroService.insertHero(heroInput));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hero> updateUtente(@RequestBody Hero heroInput, @PathVariable(required = true) Long id) throws Exception {
        Hero heroInstance = heroService.findById(id);

        if (heroInstance == null)
            throw new Exception("Hero not found!");

        heroInput.setId(id);
        return ResponseEntity.ok(heroInput);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUtente(@PathVariable(required = true) Long id) throws Exception {
        Hero heroInstance = heroService.findById(id);

        if (heroInstance == null)
            throw new Exception("Hero not found!");

        heroService.deleteHero(heroInstance);
    }

}
