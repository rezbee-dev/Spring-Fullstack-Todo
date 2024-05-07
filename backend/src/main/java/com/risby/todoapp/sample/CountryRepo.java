package com.risby.todoapp.sample;

import org.springframework.data.repository.ListCrudRepository;

public interface CountryRepo extends ListCrudRepository<Country, Integer> {
}
