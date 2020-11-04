package com.eventoapi.controllers;

/** Classe que contém os métodos que compoem o CRUD relacionado a entidade Evento.
* @author Daniel Júnior
*/

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventoapi.erros.RecursoNaoEncontrado;
import com.eventoapi.models.Evento;
import com.eventoapi.repository.EventoRepository;

@CrossOrigin
@RestController
@RequestMapping(value="/eventos")
public class EventoController {
	
	@Autowired
	private EventoRepository eventoDAO;

	@GetMapping
	public ResponseEntity<?> listaEventos(){
		return new ResponseEntity<> (eventoDAO.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{idAdm}")
	public ResponseEntity<?> listaEventoUnico(@PathVariable(value="idAdm") long idAdm){
		verificaSeEventoExisteAdm(idAdm);
		return new ResponseEntity<> (eventoDAO.findByIdAdm(idAdm), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> cadastraEvento(@RequestBody @Valid Evento evento) {
		return new ResponseEntity<> (eventoDAO.save(evento), HttpStatus.CREATED);
	}
	
	@DeleteMapping
	public ResponseEntity<?>  deletaEvento(@RequestBody @Valid Evento evento) {
		verificaSeEventoExiste(evento.getId());
		eventoDAO.delete(evento);
		return new ResponseEntity<> (evento, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> atualizaEvento(@RequestBody @Valid Evento evento) {
		return new ResponseEntity<> (eventoDAO.save(evento), HttpStatus.OK);
	}
	
	private void verificaSeEventoExiste(long id) {
		if (eventoDAO.findById(id).isEmpty()){
			throw new RecursoNaoEncontrado("Evento não encontrado pelo ID: " + id);
		}
	}
	
	private void verificaSeEventoExisteAdm(long idAdm) {
		if (eventoDAO.findByIdAdm(idAdm).isEmpty()){
			throw new RecursoNaoEncontrado("Evento não encontrado pelo IDADM: " + idAdm);
		}
	}
		
}
