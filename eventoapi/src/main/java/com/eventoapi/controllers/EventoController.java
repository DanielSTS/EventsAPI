package com.eventoapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventoapi.repository.EventoRepository;


import com.eventoapi.models.Evento;

@RestController
@RequestMapping(value="/eventos")
public class EventoController {
	
	@Autowired
	private EventoRepository er;

	@GetMapping("/eventos")
	public ResponseEntity<?> listaEventos(){
		return new ResponseEntity<> (er.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/evento/{id}")
	public ResponseEntity<?> listaEventoUnico(@PathVariable(value="id") long id){
		return new ResponseEntity<> (er.findById(id),HttpStatus.OK);
	}
	
	@PostMapping("/evento")
	public ResponseEntity<?> cadastraEvento(@RequestBody @Valid Evento evento) {
		return new ResponseEntity<> (er.save(evento),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/evento")
	public ResponseEntity<?>  deletaEvento(@RequestBody @Valid Evento evento) {
		er.delete(evento);
		return new ResponseEntity<> (evento, HttpStatus.OK);
	}
	
	@PutMapping("/evento")
	public ResponseEntity<?> atualizaEvento(@RequestBody @Valid Evento evento) {
		return new ResponseEntity<> (er.save(evento),HttpStatus.OK);
	}
		
}
