package com.risby.todoapp;

import com.risby.todoapp.sample.CountryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

// @SpringbootTest
//   - looks for and uses class with @SpringBootApplication to start application context
//   - Autowires and scans entire application
//   - Allows for testing entire application
//     - as opposed to @WebMvcTest that only loads the web layer of the application
@SpringBootTest
class TodoappApplicationTests {

	@Autowired
	private CountryController countryController;

	@Test
	void contextLoads() {
		// sanity check to test context is loading beans correctly
		assertThat(countryController).isNotNull();
	}

}
