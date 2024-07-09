package com.cfa.controller;

import com.cfa.entity.Lettre;
import com.cfa.repository.LettreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lettres")
public class LettreController {

    @Autowired
    private LettreRepository lettreRepository;

    @GetMapping
    public List<Lettre> getAllLettres() {
        return lettreRepository.findAll();
    }


    @GetMapping("/{id}")
    public Optional<Lettre> getLettreById(@PathVariable Integer id) {
        return lettreRepository.findById(id);
    }

    @PostMapping
    public Lettre createLettre(@RequestBody Lettre lettre) {
        lettre.setCreationDate(new Date());
        return lettreRepository.save(lettre);
    }

    @PutMapping("/{id}")
    public Lettre updateLettre(@PathVariable Integer id, @RequestBody Lettre lettreDetails) {
        Optional<Lettre> optionalLettre = lettreRepository.findById(id);

        if (optionalLettre.isPresent()) {
            Lettre lettre = optionalLettre.get();
            lettre.setMessage(lettreDetails.getMessage());
            lettre.setTreatmentDate(new Date());
            return lettreRepository.save(lettre);
        }

        return null; // Vous pouvez gérer cela avec des exceptions et des réponses HTTP appropriées
    }

    @DeleteMapping("/{id}")
    public void deleteLettre(@PathVariable Integer id) {
        lettreRepository.deleteById(id);
    }
}
