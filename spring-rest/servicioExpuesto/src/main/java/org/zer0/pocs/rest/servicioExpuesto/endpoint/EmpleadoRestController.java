package org.zer0.pocs.rest.servicioExpuesto.endpoint;

import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zer0.pocs.rest.servicioExpuesto.db.DBDatos;
import org.zer0.pocs.rest.servicioExpuesto.dto.Empleado;

import io.reactivex.Flowable;

@RestController
@RequestMapping("/empleados")
public class EmpleadoRestController {

	@GetMapping
	@
	public Flowable<Empleado> getEmpleados(){
		Stream<Empleado> empleados=DBDatos.getEmpleados();
		return Flowable.fromIterable(empleados::iterator);
	}
	
}
