package com.eventoapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventoapi.dto.EventoDTO;
import com.eventoapi.dto.MensagemDTO;
import com.eventoapi.dto.UsuarioDTO;
import com.eventoapi.erros.RecursoNaoEncontrado;
import com.eventoapi.models.Evento;
import com.eventoapi.models.EventoUsuario;
import com.eventoapi.models.Usuario;
import com.eventoapi.parser.EventoParser;
import com.eventoapi.parser.UsuarioParser;
import com.eventoapi.repositories.EventoRepository;
import com.eventoapi.repositories.EventoUsuarioRepository;
import com.eventoapi.repositories.UsuarioRepository;

import br.com.eventoapi.utils.message.MensagemErro;
import br.com.eventoapi.utils.message.MensagemSucesso;

@Service
public class EventoService {
	
	
	private EventoRepository dao;
	private UsuarioRepository daoUsuario;
	private EventoUsuarioRepository daoEventoUsuario;
	
	@Autowired
	public EventoService(EventoRepository er, UsuarioRepository ur, EventoUsuarioRepository eur ) {
		this.dao = er;
		this.daoUsuario = ur;
		this.daoEventoUsuario = eur;
	}
	
	public List<EventoDTO> listarTodos() {
		
		List<EventoDTO> lista = EventoParser.get().listaEventoDTO(this.dao.findAll());
		
		for(EventoDTO item : lista){
		 	List<UsuarioDTO> l = UsuarioParser.get().listaUsuarioDTO(this.daoEventoUsuario.buscarPorIdEvento(item.getId()));
	        item.setUsuarios(l);
        }
		
		return lista;
	
	}
	
	public List<EventoDTO> buscarPorIdAdm(long idAdm) {
		
		List<EventoDTO> lista = EventoParser.get().listaEventoDTO(this.dao.buscarPorId(idAdm));
		
		for(EventoDTO item : lista){
		 	List<UsuarioDTO> l = UsuarioParser.get().listaUsuarioDTO(this.daoEventoUsuario.buscarPorIdEvento(item.getId()));
	        item.setUsuarios(l);
	   }
		
		return lista;
		
	}
	
	public Evento salvar(Evento evento) {
		this.dao.save(evento);
		return evento;
	}
	
	public MensagemDTO deletar(long id, long idAdm) {
		Evento evento = this.dao.findById(id).orElseThrow(()-> new RecursoNaoEncontrado(MensagemErro.NENHUM_REGISTRO_ENCONTRADO));
		
		if (evento.getAdm().getId() == idAdm){
			this.dao.deleteById(id);
			return new MensagemDTO(MensagemSucesso.REMOCAO_REALIZADA);
		}
		return new MensagemDTO(MensagemErro.PERMISSAO_NEGADA);
	}
	
	public MensagemDTO adicionarParticipante(long id, long idEvento) {
		Evento evento = this.dao.findById(idEvento).orElseThrow(()-> new RecursoNaoEncontrado(MensagemErro.NENHUM_REGISTRO_ENCONTRADO));
		Usuario usuario = this.daoUsuario.findById(id).orElseThrow(()-> new RecursoNaoEncontrado(MensagemErro.NENHUM_REGISTRO_ENCONTRADO));
		
		EventoUsuario eventoUsuario= new EventoUsuario();
		eventoUsuario.setEvento(evento);
		eventoUsuario.setUsuario(usuario);
		
		this.daoEventoUsuario.save(eventoUsuario);
		
		return new MensagemDTO(MensagemSucesso.ADICAO_REALIZADA);
	}
	
}
