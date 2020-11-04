package com.eventoapi.eventoapi;

/** Classe responsável por realizar um teste unitário afim de avaliar se alguns métodos de persistência
* com o Banco de Dados, estão funcionando.
* @author daniel
*/

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.eventoapi.models.Evento;
import com.eventoapi.repository.EventoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EventoRepositoryTest {
	
	@Autowired
	private EventoRepository eventoDAO;
	
	@Test
	public void testeAdiciona() {
		Evento evento = new Evento("Hackaton", "Campina Grande", "23/04/2021", "12:23:34", 0000);
		eventoDAO.save(evento);
		assertEquals(evento, eventoDAO.getOne(evento.getCodigo()));
	}
	
	@Test
	public void testeAtualiza() {
		Evento evento = new Evento("Hackaton", "Campina Grande", "23/04/2021", "12:23:34", 0000);
		eventoDAO.save(evento);
		evento.setNome("Maratona de Programação");
		eventoDAO.save(evento);
		assertEquals(evento, eventoDAO.getOne(evento.getCodigo()));
	}
	
	@Test
	public void testeDeleta() {
		Evento evento = new Evento("Hackaton", "Campina Grande", "23/04/2021", "12:23:34", 0000);
		eventoDAO.save(evento);
		eventoDAO.delete(evento);
		assertEquals(null, eventoDAO.getOne(evento.getCodigo()));
	}
}
