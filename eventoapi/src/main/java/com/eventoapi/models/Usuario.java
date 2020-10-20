package com.eventoapi.models;

/** Classe que contém os atributos e métodos relacionados a entidade Usuário, contendo as propriedades
* relacionadas ao mapeamento no banco de dados.
* @author Daniel Júnior
*/

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long codigo;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String login;
	
	@NotBlank
	private String senha;
	
	@NotBlank
	private int rg;
	
	@ManyToMany(mappedBy = "usuarios")
	private List<Evento> eventos;

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}
}
