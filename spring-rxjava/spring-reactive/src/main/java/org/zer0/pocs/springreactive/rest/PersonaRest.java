package org.zer0.pocs.springreactive.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@RestController
@RequestMapping("/persona")
public class PersonaRest {

	@PostMapping
	public Completable registrarPersona(@RequestBody Persona persona) {
		System.out.println("persona:"+persona.getNombres());
		return Maybe.just("Test").flatMapCompletable(
					t->{
						return Completable.complete();
					}
				);
	}
	
	@GetMapping("/{id}")
	public Single<String> recuperarPersona(@PathVariable String id) {
		System.out.println("id:"+id);
		return Single.just("Saludo");
	}
	
	
	
	
}
