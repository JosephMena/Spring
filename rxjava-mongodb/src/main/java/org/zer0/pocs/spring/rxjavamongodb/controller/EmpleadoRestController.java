package org.zer0.pocs.spring.rxjavamongodb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleado")
public class EmpleadoRestController {

	@GetMapping
	public String test() {
		return "test";
	}
	
	
}
