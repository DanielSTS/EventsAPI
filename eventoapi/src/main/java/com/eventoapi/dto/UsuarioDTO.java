package com.eventoapi.dto;

import java.util.List;

public class UsuarioDTO  {
	
	private String nome;
	
	private String email;
	
	private List<EventoDTO> eventos;
	
	public UsuarioDTO() {
		
	}
	
	public UsuarioDTO(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<EventoDTO> getEventos() {
		return eventos;
	}

	public void setEventos(List<EventoDTO> eventos) {
		this.eventos = eventos;
	}
	
}
