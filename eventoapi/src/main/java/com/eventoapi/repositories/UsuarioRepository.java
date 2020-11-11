package com.eventoapi.repositories;

/** Interface que herda os atributos e métodos relacionados ao acesso 
* ao Banco de dados (DAO) da entidade Usuário.
* @author Daniel Júnior
*/

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventoapi.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByEmail(String email);
	
}
