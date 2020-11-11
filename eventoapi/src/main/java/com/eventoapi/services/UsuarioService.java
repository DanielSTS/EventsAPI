package com.eventoapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventoapi.dto.MensagemDTO;
import com.eventoapi.dto.UsuarioDTO;
import com.eventoapi.erros.RecursoNaoEncontrado;
import com.eventoapi.models.Usuario;
import com.eventoapi.parser.UsuarioParser;
import com.eventoapi.repositories.UsuarioRepository;

import br.com.eventoapi.utils.message.MensagemErro;
import br.com.eventoapi.utils.message.MensagemSucesso;

@Service
public class UsuarioService {
	
	private UsuarioRepository usuarioDAO;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	public MensagemDTO salvar(Usuario usuario) {
		this.usuarioDAO.save(usuario);
		return new MensagemDTO(MensagemSucesso.ADICAO_REALIZADA);
	}
	
	public MensagemDTO deletar(long id) {
		
		Usuario usuario = this.usuarioDAO.findById(id).orElseThrow(()-> new RecursoNaoEncontrado(MensagemErro.NENHUM_REGISTRO_ENCONTRADO));
		this.usuarioDAO.delete(usuario);
		
		return new MensagemDTO(MensagemSucesso.REMOCAO_REALIZADA);
	}
	
	public Usuario buscarPorId(long id) {
		return this.usuarioDAO.findById(id).get();
	}
	
	public List<UsuarioDTO> listarTodos(){
		
		List<UsuarioDTO> lista = UsuarioParser.get().listaUsuarioDTO(this.usuarioDAO.findAll());
        
		return lista;
	}

}
