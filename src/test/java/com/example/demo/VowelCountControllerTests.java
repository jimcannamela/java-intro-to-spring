package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(VowelCountController.class)
public class VowelCountControllerTests {
	@Autowired
	MockMvc mockMvc;
///vowelCount?word=apples      // returns 2

	@Test
	void vowelCountApples_Return2() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/vowelCount?word=apples"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("The result is 2."));
	}

///vowelCount?word=banana      // returns 3
@Test
void vowelCountBananas_Return3() throws Exception {
	mockMvc.perform(MockMvcRequestBuilders.get("/vowelCount?word=bananas"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("The result is 3."));
}
///vowelCount?word=mississippi // returns 4
@Test
void vowelCountMississippi_Return4() throws Exception {
	mockMvc.perform(MockMvcRequestBuilders.get("/vowelCount?word=mississippi"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("The result is 4."));
}
}
