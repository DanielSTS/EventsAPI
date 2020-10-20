package com.eventoapi.repository;

/** Interface que herda os atributos e métodos relacionados ao acesso 
* ao Banco de dados (DAO) da entidade Evento.
* @author Daniel Júnior
*/

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventoapi.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
