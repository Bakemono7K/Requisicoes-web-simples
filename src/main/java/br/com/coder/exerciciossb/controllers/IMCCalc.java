package br.com.coder.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.coder.exerciciossb.model.entities.IMC;

@RestController
@RequestMapping("/IMC")
public class IMCCalc {

	@GetMapping
	public String IMC(@RequestParam(name = "KG") double KG, @RequestParam(name = "height") double height) {
	    IMC imc = new IMC(KG, height);
		return imc.toString();
	}
	
	

	

}
