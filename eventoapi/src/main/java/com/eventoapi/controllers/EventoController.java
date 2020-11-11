package com.eventoapi.controllers;

/** EndPoint relacionado ao evento.
* @author Daniel Júnior
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventoapi.models.Evento;
import com.eventoapi.services.EventoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/eventos")
public class EventoController {
	
	@Autowired
	private EventoService service;

	@GetMapping
	public ResponseEntity<?> listarEventos(){
		return new ResponseEntity<> (this.service.listarTodos(), HttpStatus.OK);
	}
	
	@GetMapping("/{idAdm}")
	public ResponseEntity<?> listarEventoUnico(@PathVariable(value="idAdm") long idAdm){
		return new ResponseEntity<> (this.service.buscarPorIdAdm(idAdm), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrarEvento(@RequestBody Evento evento) {
		return new ResponseEntity<> (service.salvar(evento), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarEvento(@PathVariable(value="id") long id, @RequestHeader("idAdm") long idAdm) {
		return new ResponseEntity<>(this.service.deletar(id,idAdm), HttpStatus.OK);
	}
	
	@PutMapping("/{id}/{idEvento}")
	public ResponseEntity<?> adicionarParticipante(@PathVariable(value="id") long id, @PathVariable(value="idEvento") long idEvento) {
		return new ResponseEntity<> (this.service.adicionarParticipante(id, idEvento), HttpStatus.OK);
	}
	
	
}
