package ua.lviv.iot.seafood.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ua.lviv.iot.seafood.business.SeafoodService;
import ua.lviv.iot.seafood.model.Seafood;

@RequestMapping("/seafood")
@RestController
public class SeafoodController {

    private static AtomicInteger idCounter = new AtomicInteger();

    @Autowired
    private SeafoodService seafoodService;

    @GetMapping
    public List<Seafood> getSeafood() {
        return new LinkedList<Seafood>(seafoodService.getAll());
    }

    @GetMapping("/{id}")
    public Seafood getPieceOfSeafood(final @PathVariable("id") Integer seafoodId) {
        return seafoodService.getById(seafoodId);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updateSeafood(final @PathVariable("id") Integer seafoodId,
            final @RequestBody Seafood seafood) {
        Seafood previousSeafood = getPieceOfSeafood(seafoodId);
        if (seafoodService.checkForSeafoodExistence(seafoodId)) {
            Seafood seafoodToReturn = new Seafood(previousSeafood.getPriceInGryvnias(), previousSeafood.getProducer(),
                    previousSeafood.getSpeciesOfProduct(), previousSeafood.getConditionOfProduct());
            seafoodToReturn.setId(seafoodId);
            seafood.setId(seafoodId);
            seafoodService.update(seafood);
            return ResponseEntity.ok(seafoodToReturn);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<Seafood> deleteSeafood(final @PathVariable("id") Integer seafoodId) {
        if (seafoodService.checkForSeafoodExistence(seafoodId)) {
            seafoodService.deleteById(seafoodId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public Seafood createSeafood(final @RequestBody Seafood seafood) {
        seafood.setId(idCounter.incrementAndGet());
        seafoodService.add(seafood);
        return seafood;
    }
}