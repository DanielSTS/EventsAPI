package com.eventoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventoapi.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
