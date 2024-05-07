package com.risby.todoapp.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/sample/countries", produces="application/json")
public class CountryController {
    private final CountryRepo countryRepo;

    @Autowired
    public CountryController(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    @GetMapping
    ResponseEntity<List<Country>> findAll() {
        return new ResponseEntity<>(countryRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Country> findOne(@PathVariable(name="id") Integer id) {
        Optional<Country> countryOptional = this.countryRepo.findById(id);

        return countryOptional
                .map(country -> new ResponseEntity<>(country, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
