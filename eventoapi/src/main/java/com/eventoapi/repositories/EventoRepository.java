package com.eventoapi.repositories;

import java.util.List;

/** Interface que herda os atributos e métodos relacionados ao acesso 
* ao Banco de dados (DAO) da entidade Evento.
* @author Daniel Júnior
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eventoapi.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
	
	@Query("SELECT e FROM Evento e WHERE e.adm.id = :idAdm")
	List<Evento> buscarPorId(@Param("idAdm") long idAdm);
	
	
}
