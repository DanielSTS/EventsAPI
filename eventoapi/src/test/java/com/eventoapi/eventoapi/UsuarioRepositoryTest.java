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

import com.eventoapi.models.Usuario;
import com.eventoapi.repositories.UsuarioRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioDAO;
	
	@Test
	public void testeAdiciona() {
		Usuario usuario = new Usuario("Daniel", "login", "senha", 0000);
		usuarioDAO.save(usuario);
		assertEquals(usuario, usuarioDAO.getOne(usuario.getId()));
	}
	
	@Test
	public void testeAtualiza() {
		Usuario usuario = new Usuario("Daniel", "login", "senha", 0000);
		usuarioDAO.save(usuario);
		usuario.setNome("Rodrigo");
		usuarioDAO.save(usuario);
		assertEquals(usuario, usuarioDAO.getOne(usuario.getId()));
	}
	
	@Test
	public void testeDeleta() {
		Usuario usuario = new Usuario("Daniel", "login", "senha", 0000);
		usuarioDAO.save(usuario);
		usuarioDAO.delete(usuario);
		assertEquals(null, usuarioDAO.getOne(usuario.getId()));
	}
}
