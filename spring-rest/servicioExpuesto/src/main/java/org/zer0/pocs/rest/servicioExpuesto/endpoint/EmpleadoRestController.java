package org.zer0.pocs.rest.servicioExpuesto.endpoint;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zer0.pocs.rest.servicioExpuesto.db.DBDatos;
import org.zer0.pocs.rest.servicioExpuesto.dto.Empleado;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

@RestController
@RequestMapping("/empleados")
public class EmpleadoRestController {

	@GetMapping
	@ResponseBody
	public Flowable<Empleado> getEmpleados(){
		Stream<Empleado> empleados=DBDatos.getEmpleados();
		return Flowable.fromIterable(empleados::iterator);
	}
	
	@GetMapping("/{dni}")
	@ResponseBody
	public Maybe<Empleado> getEmpleado(@PathVariable("dni") String dni){
		Maybe<Empleado> oMaybe=Maybe.create((emitter)->{
			Optional<Empleado> empleadoOptional=DBDatos.getEmpleados()
								.filter(empleado->empleado.getDni().equals(dni))
								.findFirst();
			if(empleadoOptional.isPresent()) {
				emitter.onSuccess(empleadoOptional.get());
			}else {
				emitter.onComplete();
			}
		});
		return oMaybe;
	}
	
	
	@PostMapping
	public Completable saveEmpleado(@RequestBody Optional<Empleado> empleado) {
		DBDatos.saveEmpleado(empleado);
		return Completable.complete();
	}
	
	@GetMapping("/contrato")
	@ResponseBody
	public Flowable<Empleado> getEmpleadosContratoMayorNmeses(@RequestParam int nroMeses) {
		Stream<Empleado> empleados=DBDatos.getEmpleados();
		Stream<Empleado> empleadosContratoMayorNMeses=empleados
				.filter(empleado->empleado.getContratoActual().getPeriodoEnMeses()>=nroMeses);
		return Flowable.fromIterable(empleadosContratoMayorNMeses::iterator);
	}
	
}
