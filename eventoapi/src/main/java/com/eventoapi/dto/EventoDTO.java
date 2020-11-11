package com.eventoapi.dto;

import java.util.List;

public class EventoDTO {
	
	private long id;

	private String nome;
	
	private String local;
	
	private String data;
	
	private String horario;

	private String emailAdm;
	
	private List<UsuarioDTO> usuarios;
	
	public EventoDTO() {
		
	}
	
	public EventoDTO(String nome, String local, String data, String horario, String emailAdm) {
		this.nome = nome;
		this.local = local;
		this.data = data;
		this.horario = horario;
		this.emailAdm = emailAdm;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getEmailAdm() {
		return this.emailAdm;
	}

	public void setEmailAdm(String emailAdm) {
		this.emailAdm = emailAdm;
	}

	public List<UsuarioDTO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioDTO> usuarios) {
		this.usuarios = usuarios;
	}
	
}
