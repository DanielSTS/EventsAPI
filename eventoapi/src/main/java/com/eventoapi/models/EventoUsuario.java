package com.eventoapi.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "evento_usuario")
public class EventoUsuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "fk_evento", foreignKey = @ForeignKey(name = "fk_evento"))
	private Evento evento;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "fk_usuario", foreignKey = @ForeignKey(name = "fk_usuario"))
	private Usuario usuario;

	public long getId() {
		return Id;
	}

	public Evento getEvento() {
		return evento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setId(long id) {
		Id = id;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
