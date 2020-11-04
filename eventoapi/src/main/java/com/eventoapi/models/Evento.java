package com.eventoapi.models;

/** Classe que contém os atributos e métodos relacionados a entidade Evento, contendo as propriedades
 *  relacionadas ao mapeamento no banco de dados.
* @author Daniel Júnior
*/

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Evento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String local;
	
	@NotBlank
	private String data;
	
	@NotBlank
	private String horario;
	
	@NotNull
	private long idAdm;
	
	@ManyToMany
	@JoinTable(
			name="evento_usuario",
			joinColumns = @JoinColumn(name="evento_id"),
			inverseJoinColumns = @JoinColumn(name="usuario_id")
			)
	private List<Usuario> usuarios;
	
	public Evento() {
		
	}
	
	public Evento(String nome, String local, String data, String horario, int idAdm) {
		this.nome = nome;
		this.local = local;
		this.data = data;
		this.horario = horario;
		this.idAdm = idAdm;
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

	public long getIdAdm() {
		return idAdm;
	}

	public void setIdAdm(long idAdm) {
		this.idAdm = idAdm;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
