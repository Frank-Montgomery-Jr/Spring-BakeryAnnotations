package com.zipcodewilmington.bakery.services;

import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.repositories.BakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BakerService {
    
    @Autowired
    private BakerRepository bakerRepository;

    public Baker create(Baker baker) {
        return bakerRepository.save(baker);
    }

    public Baker read(Long id) {
        return bakerRepository.findById(id).get();
    }

    public Iterable<Baker> readAll() {
        return bakerRepository.findAll();
    }

    public Baker update(Long id, Baker newBakerData) {
        Baker originalBaker = read(id);
        originalBaker.setName(newBakerData.getName());
        originalBaker.setEmployeeId(newBakerData.getEmployeeId());
        originalBaker.setSpecialty(newBakerData.getSpecialty());
        return bakerRepository.save(originalBaker);
    }

    public void delete(Long id) {
        bakerRepository.deleteById(id);
    }
}
