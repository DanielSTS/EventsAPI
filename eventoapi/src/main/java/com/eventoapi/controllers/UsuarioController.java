package com.eventoapi.controllers;

/** EndPoint relacionado ao usuário.
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventoapi.models.Usuario;
import com.eventoapi.services.UsuarioService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {
	
		@Autowired
		private UsuarioService service;

		@GetMapping
		public ResponseEntity<?> listarUsuarios(){
			return new ResponseEntity<> (service.listarTodos(), HttpStatus.OK);
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<?> listarUsuarioUnico(@PathVariable(value="id") long id){
			return new ResponseEntity<> (service.buscarPorId(id), HttpStatus.OK);
		}
		
		@PostMapping
		public ResponseEntity<?> cadastrarUsuario(@RequestBody Usuario usuario) {
			return new ResponseEntity<> (service.salvar(usuario), HttpStatus.CREATED);
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?>  deletarUsuario(@PathVariable(value="id") long id) {
			return new ResponseEntity<> (service.deletar(id), HttpStatus.OK);
		}
		
		@PutMapping
		public ResponseEntity<?> atualizarUsuario(@RequestBody Usuario usuario) {
			return new ResponseEntity<> (service.salvar(usuario), HttpStatus.OK);
		}
		
}
