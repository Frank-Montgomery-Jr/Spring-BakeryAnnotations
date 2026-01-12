package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.services.MuffinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/muffin")
public class MuffinController {
    
    @Autowired
    private MuffinService muffinService;

    @PostMapping
    public ResponseEntity<Muffin> create(@RequestBody Muffin muffin) {
        return new ResponseEntity<>(muffinService.create(muffin), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Muffin> read(@PathVariable Long id) {
        return new ResponseEntity<>(muffinService.read(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Muffin>> readAll() {
        return new ResponseEntity<>(muffinService.readAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Muffin> update(@PathVariable Long id, @RequestBody Muffin muffin) {
        return new ResponseEntity<>(muffinService.update(id, muffin), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        muffinService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
