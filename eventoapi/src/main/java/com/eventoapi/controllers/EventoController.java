package com.eventoapi.controllers;

/** Classe que contém os métodos que compoem o CRUD relacionado a entidade Evento.
* @author Daniel Júnior
*/

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
import com.eventoapi.erros.RecursoNaoEncontrado;
import com.eventoapi.models.Evento;

@RestController
@RequestMapping(value="/eventos")
public class EventoController {
	
	@Autowired
	private EventoRepository eventoDAO;

	@GetMapping
	public ResponseEntity<?> listaEventos(){
		return new ResponseEntity<> (eventoDAO.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listaEventoUnico(@PathVariable(value="id") long id){
		verificaSeEventoExiste(id);
		return new ResponseEntity<> (eventoDAO.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> cadastraEvento(@RequestBody @Valid Evento evento) {
		return new ResponseEntity<> (eventoDAO.save(evento), HttpStatus.CREATED);
	}
	
	@DeleteMapping
	public ResponseEntity<?>  deletaEvento(@RequestBody @Valid Evento evento) {
		verificaSeEventoExiste(evento.getCodigo());
		eventoDAO.delete(evento);
		return new ResponseEntity<> (evento, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> atualizaEvento(@RequestBody @Valid Evento evento) {
		return new ResponseEntity<> (eventoDAO.save(evento), HttpStatus.OK);
	}
	
	private void verificaSeEventoExiste(long id) {
		if (eventoDAO.findById(id) == null){
			throw new RecursoNaoEncontrado("Usuário não encontrado pelo ID: " + id);
		}
	}
		
}
