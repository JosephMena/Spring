package org.zer0.demo.servicio;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldService {
	
	@RequestMapping("/saludo")
	public String saludo(@RequestParam(value="name",defaultValue="Mundo") String name ){
		return "Hola "+name;
	}
}
