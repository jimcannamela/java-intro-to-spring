package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VowelCountController {
	@GetMapping("/vowelCount")
	public String vowelCount(@RequestParam String word){
		int result = 0;
		String[] letters = word.toLowerCase().split("");
		String vowels = "aeiou";
		for (int i = 0; i < letters.length; i++) {
			if (vowels.indexOf(letters[i]) >= 0) {
				result++;
			}
		}
		return String.format("The result is %s.",result);
	}
}
