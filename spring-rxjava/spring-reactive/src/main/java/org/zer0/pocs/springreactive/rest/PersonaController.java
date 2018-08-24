package org.zer0.pocs.springreactive.rest;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zer0.pocs.springreactive.rest.exception.PersonaNotFoundException;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@RestController
@RequestMapping("/persona")
public class PersonaController {

	@PostMapping
	public Completable registrarPersona(@RequestBody Optional<Persona> persona) {
		
		persona.ifPresent((p)->{System.out.println(p.getNombres());System.out.println(p.getApellidos());});
		
		return Maybe.just("Test").flatMapCompletable(
					t->{
						return Completable.complete();
					}
				);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Single<Persona> recuperarPersona(@PathVariable Optional<String> id) {
		id.ifPresent(System.out::println);
		return id.map(
				(idPersona)->{
					if(idPersona.equals("X")) {
						return null;
					}else {
						Persona persona=new Persona();
						persona.setNombres("Joseph Cesar");
						persona.setApellidos("Mena Sihuacollo");
						return Single.just(persona);
					}
				}
			).orElseThrow(()->new PersonaNotFoundException("X"));
	}
	
	
	
}
