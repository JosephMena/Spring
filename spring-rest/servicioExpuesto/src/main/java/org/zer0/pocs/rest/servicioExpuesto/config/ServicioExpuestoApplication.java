package org.zer0.pocs.rest.servicioExpuesto.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="org.zer0.pocs.rest.servicioExpuesto")
public class ServicioExpuestoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioExpuestoApplication.class, args);
	}
}
