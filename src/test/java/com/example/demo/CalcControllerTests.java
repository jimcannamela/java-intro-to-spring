package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.RestController;

@WebMvcTest(CalcController.class)
public class CalcControllerTests {
	@Autowired
	MockMvc mockMvc;

///calc?numbers=3,4,5&operator=add       // returns 12
@Test
void calculateAddNumbers_returns12() throws Exception {
	mockMvc.perform(MockMvcRequestBuilders.get("/calc?numbers=3,4,5&operator=add"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("The result is 12."));
}
///calc?numbers=25,4,3&operator=subtract // returns 18
@Test
void calculateSubtractNumbers_returns18() throws Exception {
	mockMvc.perform(MockMvcRequestBuilders.get("/calc?numbers=25,4,3&operator=subtract"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("The result is 18."));
}
///calc?numbers=3,3,3&operator=multiply  // returns 27
@Test
void calculateMultiplyNumbers_returns27() throws Exception {
	mockMvc.perform(MockMvcRequestBuilders.get("/calc?numbers=3,3,3&operator=multiply"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("The result is 27."));
}
///calc?numbers=20,5&operator=divide     // returns 4
@Test
void calculateDivideNumbers_returns4() throws Exception {
	mockMvc.perform(MockMvcRequestBuilders.get("/calc?numbers=20,5&operator=divide"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("The result is 4."));
}
}
