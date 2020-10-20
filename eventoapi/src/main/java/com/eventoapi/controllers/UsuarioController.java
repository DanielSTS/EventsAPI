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

import com.eventoapi.erros.RecursoNaoEncontrado;
import com.eventoapi.models.Usuario;
import com.eventoapi.repository.UsuarioRepository;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {
	
		@Autowired
		private UsuarioRepository usuarioDAO;

		@GetMapping("/")
		public ResponseEntity<?> listaUsuarios(){
			return new ResponseEntity<> (usuarioDAO.findAll(), HttpStatus.OK);
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<?> listaUsuarioUnico(@PathVariable(value="id") long id){
			verificaSeUsuarioExiste(id);
			return new ResponseEntity<> (usuarioDAO.findById(id), HttpStatus.OK);
		}
		
		@PostMapping
		public ResponseEntity<?> cadastraUsuario(@RequestBody @Valid Usuario usuario) {
			return new ResponseEntity<> (usuarioDAO.save(usuario), HttpStatus.CREATED);
		}
		
		@DeleteMapping
		public ResponseEntity<?>  deletaUsuario(@RequestBody @Valid Usuario usuario) {
			verificaSeUsuarioExiste(usuario.getCodigo());
			usuarioDAO.delete(usuario);
			return new ResponseEntity<> (usuario, HttpStatus.OK);
		}
		
		@PutMapping
		public ResponseEntity<?> atualizaUsuario(@RequestBody @Valid Usuario usuario) {
			return new ResponseEntity<> (usuarioDAO.save(usuario), HttpStatus.OK);
		}
		
		private void verificaSeUsuarioExiste(long id) {
			if (usuarioDAO.findById(id) == null){
				throw new RecursoNaoEncontrado("Usuário não encontrado pelo ID: " + id);
			}
		}
}
