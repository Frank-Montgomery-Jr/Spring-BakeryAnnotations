package com.zipcodewilmington.bakery.services;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.repositories.MuffinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MuffinService {
    
    @Autowired
    private MuffinRepository muffinRepository;

    public Muffin create(Muffin muffin) {
        return muffinRepository.save(muffin);
    }

    public Muffin read(Long id) {
        return muffinRepository.findById(id).get();
    }

    public Iterable<Muffin> readAll() {
        return muffinRepository.findAll();
    }

    public Muffin update(Long id, Muffin newMuffinData) {
        Muffin originalMuffin = read(id);
        originalMuffin.setFlavor(newMuffinData.getFlavor());
        return muffinRepository.save(originalMuffin);
    }

    public void delete(Long id) {
        muffinRepository.deleteById(id);
    }
}
