package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {
	@GetMapping("/calc")
	public String calculate(@RequestParam int[] numbers, @RequestParam String operator) {
		int result = 0;
		switch (operator){
			case "add":
				for (int i = 0; i < numbers.length; i++) {
					result += numbers[i];
				}
				break;
			case "subtract":
				result=numbers[0];
				for (int i = 1; i < numbers.length; i++) {
					result -= numbers[i];
				}
				break;
			case "multiply":
				result=numbers[0];
				for (int i = 1; i < numbers.length; i++) {
					result *= numbers[i];
				}
				break;
			case "divide":
				result=numbers[0];
				for (int i = 1; i < numbers.length; i++) {
					result /= numbers[i];
				}
				break;
		}
		return String.format("The result is %s.",result);
	}
}
