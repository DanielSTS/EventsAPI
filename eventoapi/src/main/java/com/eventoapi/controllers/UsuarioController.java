package com.eventoapi.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventoapi.models.Usuario;
import com.eventoapi.repository.UsuarioRepository;

@RestController
@RequestMapping(value="/api")
public class UsuarioController {
	
		@Autowired
		private UsuarioRepository ur;

		@GetMapping("/Usuarios")
		public Iterable<Usuario> listaUsuarios(){
			return  ur.findAll();
		}
		
		@GetMapping("/Usuario/{id}")
		public Optional<Usuario> listaUsuarioUnico(@PathVariable(value="id") long id){
			return  ur.findById(id);
		}
		
		@PostMapping("/Usuario")
		public Usuario cadastraUsuario(@RequestBody @Valid Usuario usuario) {
			return ur.save(usuario);
		}
		
		@DeleteMapping("/Usuario")
		public void deletaUsuario(@RequestBody @Valid Usuario usuario) {
			ur.delete(usuario);
		}
		
		@PutMapping("/Usuario")
		public Usuario atualizaUsuario(@RequestBody @Valid Usuario usuario) {
			return ur.save(usuario);
		}

}
