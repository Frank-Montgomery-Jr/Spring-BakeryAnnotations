package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.services.BakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/baker")
public class BakerController {
    
    @Autowired
    private BakerService bakerService;

    @PostMapping
    public ResponseEntity<Baker> create(@RequestBody Baker baker) {
        return new ResponseEntity<>(bakerService.create(baker), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Baker> read(@PathVariable Long id) {
        return new ResponseEntity<>(bakerService.read(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Baker>> readAll() {
        return new ResponseEntity<>(bakerService.readAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Baker> update(@PathVariable Long id, @RequestBody Baker baker) {
        return new ResponseEntity<>(bakerService.update(id, baker), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        bakerService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}