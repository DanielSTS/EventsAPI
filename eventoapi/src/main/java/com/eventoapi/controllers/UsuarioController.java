package com.eventoapi.controllers;

/** Classe que contém os métodos que compoem o CRUD relacionado a entidade Usuário.
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
import com.eventoapi.models.Usuario;
import com.eventoapi.repository.UsuarioRepository;

@CrossOrigin
@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {
	
		@Autowired
		private UsuarioRepository usuarioDAO;

		@GetMapping
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
			verificaSeUsuarioExiste(usuario.getId());
			usuarioDAO.delete(usuario);
			return new ResponseEntity<> (usuario, HttpStatus.OK);
		}
		
		@PutMapping
		public ResponseEntity<?> atualizaUsuario(@RequestBody @Valid Usuario usuario) {
			return new ResponseEntity<> (usuarioDAO.save(usuario), HttpStatus.OK);
		}
		
		private void verificaSeUsuarioExiste(long id) {
			if (usuarioDAO.findById(id).isEmpty()){
				throw new RecursoNaoEncontrado("Usuário não encontrado pelo ID: " + id);
			}
		}
		
		private void verificaSeUsuarioExisteEmail(String email, String senha) {
			Usuario usuario = usuarioDAO.findByEmail(email);
			if (usuario.getSenha() != senha){
				throw new RecursoNaoEncontrado("Senha Incorreta, Tente Novamente");
			}
		}
}
