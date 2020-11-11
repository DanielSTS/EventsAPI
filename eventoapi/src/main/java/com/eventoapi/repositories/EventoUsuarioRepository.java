package com.eventoapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eventoapi.models.Evento;
import com.eventoapi.models.EventoUsuario;
import com.eventoapi.models.Usuario;

public interface EventoUsuarioRepository extends JpaRepository<EventoUsuario, Long>{

	@Query("SELECT eu.evento FROM EventoUsuario eu WHERE eu.usuario.id = :idUsuario")
	List<Evento> buscarPorIdUsuario(@Param("idUsuario") long idUsuario);
	
	@Query("SELECT eu.usuario FROM EventoUsuario eu WHERE eu.evento.id = :idEvento")
	List<Usuario> buscarPorIdEvento(@Param("idEvento") long idEvento);
	
	@Query("SELECT eu.evento FROM EventoUsuario eu WHERE eu.usuario.email = :email")
	List<Evento> buscarPorEmailUsuario(@Param("email") String email);
}
