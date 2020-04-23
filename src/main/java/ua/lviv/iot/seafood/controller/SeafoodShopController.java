package ua.lviv.iot.seafood.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.seafood.business.SeafoodShopService;
import ua.lviv.iot.seafood.model.SeafoodShop;

@RequestMapping("/seafoodshops")
@RestController
public class SeafoodShopController {

    private static AtomicInteger idCounter = new AtomicInteger();

    @Autowired
    private SeafoodShopService seafoodShopService;

    @GetMapping
    public List<SeafoodShop> getSeafoodShops() {
        return new LinkedList<SeafoodShop>(seafoodShopService.getAll());
    }

    @GetMapping("/{id}")
    public SeafoodShop getSeafoodShop(final @PathVariable("id") Integer shopId) {
        return seafoodShopService.getById(shopId);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updateSeafoodShop(final @PathVariable("id") Integer shopId,
            final @RequestBody SeafoodShop seafoodShop) {
        SeafoodShop previousSeafoodShop = getSeafoodShop(shopId);
        if (seafoodShopService.checkForSeafoodShopExistence(shopId)) {
            SeafoodShop seafoodShopToReturn = new SeafoodShop(previousSeafoodShop.getNameOfShop(),
                    previousSeafoodShop.getLocationOfShop());
            seafoodShopToReturn.setId(shopId);
            seafoodShop.setId(shopId);
            seafoodShopService.update(seafoodShop);
            return ResponseEntity.ok(seafoodShopToReturn);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<SeafoodShop> deleteSeafoodShop(final @PathVariable("id") Integer shopId) {
        if (seafoodShopService.checkForSeafoodShopExistence(shopId)) {
            seafoodShopService.deleteById(shopId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public SeafoodShop createSeafoodShop(final @RequestBody SeafoodShop seafoodShop) {
        seafoodShop.setId(idCounter.incrementAndGet());
        seafoodShopService.add(seafoodShop);
        return seafoodShop;
    }
}