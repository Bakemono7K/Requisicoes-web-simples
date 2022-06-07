package br.com.coder.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {
		
	@GetMapping(path = "/sum/{a}/{b}")
	public Integer sum(@PathVariable int a, @PathVariable int b) {
		return a + b;
	}
	@GetMapping(path = "/subtraction")
	public Integer sub(@RequestParam(name = "a") int a, @RequestParam(name = "b") int b) {
		return a - b;
	}
}
