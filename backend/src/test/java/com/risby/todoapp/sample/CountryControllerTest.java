package com.risby.todoapp.sample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.risby.todoapp.http.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Only scans @Controller, @ControllerAdvice, @JsonComponent, etc
// Does not include @Component, @Service, @Repository
//   - These would need to be mocked
@WebMvcTest(CountryController.class)
// needed because WebMvcTest does not load our security configs
//   and by default, because security is on classpath, all paths are restricted w/o our configs
@Import(SecurityConfig.class)
class CountryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CountryRepo countryRepo;

    @Autowired
    ObjectMapper objectMapper;

    List<Country> countries = List.of(
            new Country(1,"USA"),
            new Country(2,"Mexico"),
            new Country(3,"Canada"));

    @Test
    void findAll() throws Exception {
        // Mocks CountryRepo, triggered by controller method
        Mockito
                .when(this.countryRepo.findAll())
                .thenReturn(this.countries);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/sample/countries"))
                .andExpectAll(
                        status().isOk(),
                        content().json(objectMapper.writeValueAsString(this.countries))
                );
    }

    @Test
    void findOne() throws Exception {
        Mockito
                .when(this.countryRepo.findById(2))
                .thenReturn(Optional.ofNullable(countries.get(2)));

        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/sample/countries/2"))
                .andExpectAll(
                        status().isOk(),
                        content().json(objectMapper.writeValueAsString(countries.get(2)))
                );
    }
}