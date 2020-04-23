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

import ua.lviv.iot.seafood.business.SeafoodSupplierService;
import ua.lviv.iot.seafood.model.SeafoodSupplier;

@RequestMapping("/seafoodsuppliers")
@RestController
public class SeafoodSupplierController {

    private static AtomicInteger idCounter = new AtomicInteger();

    @Autowired
    private SeafoodSupplierService seafoodSupplierService;

    @GetMapping
    public List<SeafoodSupplier> getSeafoodSuppliers() {
        return new LinkedList<SeafoodSupplier>(seafoodSupplierService.getAll());
    }

    @GetMapping("/{id}")
    public SeafoodSupplier getSeafoodSupplier(final @PathVariable("id") Integer supplierId) {
        return seafoodSupplierService.getById(supplierId);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updateSeafoodSupplier(final @PathVariable("id") Integer supplierId,
            final @RequestBody SeafoodSupplier seafoodSupplier) {
        SeafoodSupplier previousSeafoodSupplier = getSeafoodSupplier(supplierId);
        if (seafoodSupplierService.checkForSeafoodSupplierExistence(supplierId)) {
            SeafoodSupplier seafoodSupplierToReturn = new SeafoodSupplier(previousSeafoodSupplier.getNameOfSupplier(),
                    previousSeafoodSupplier.getCountryOfSupplier());
            seafoodSupplierToReturn.setId(supplierId);
            seafoodSupplier.setId(supplierId);
            seafoodSupplierService.update(seafoodSupplier);
            return ResponseEntity.ok(seafoodSupplierToReturn);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<SeafoodSupplier> deleteSeafoodSupplier(final @PathVariable("id") Integer supplierId) {
        if (seafoodSupplierService.checkForSeafoodSupplierExistence(supplierId)) {
            seafoodSupplierService.deleteById(supplierId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public SeafoodSupplier createSeafoodSupplier(final @RequestBody SeafoodSupplier seafoodSupplier) {
        seafoodSupplier.setId(idCounter.incrementAndGet());
        seafoodSupplierService.add(seafoodSupplier);
        return seafoodSupplier;
    }
}