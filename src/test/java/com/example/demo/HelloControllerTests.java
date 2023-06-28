package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HelloController.class)
public class HelloControllerTests {
	@Autowired
	MockMvc mockMvc;

	// First Use Case
	// When pointing a browser at the URI, /hello, the endpoint should return the string "Hello World"
	@Test
	void sayHello_noArgs_returnsHelloWorld() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Hello, World!"));
	}

	// Second Use Case
	@Test
	void sayHello_withArgs_returnsHelloName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello?name=Jim"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Hello, Jim!"));
	}
}
