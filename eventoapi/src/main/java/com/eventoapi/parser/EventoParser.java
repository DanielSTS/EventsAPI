package com.eventoapi.parser;

import java.util.List;
import java.util.stream.Collectors;

import com.eventoapi.dto.EventoDTO;
import com.eventoapi.models.Evento;

public class EventoParser {
	
	public static EventoParser get(){
	        return  new EventoParser();
	}

    public EventoDTO mapperDto(Evento evento){
        EventoDTO dto = new EventoDTO();
        dto.setId(evento.getId());
        dto.setNome(evento.getNome());
        dto.setLocal(evento.getLocal());
        dto.setData(evento.getData());
        dto.setHorario(evento.getHorario());
        dto.setEmailAdm(evento.getAdm().getEmail());
        return dto;
    }
    
    public Evento maapperEvento(EventoDTO dto){
        Evento evento = new Evento();
        evento.setNome(dto.getNome());
        evento.setLocal(dto.getLocal());
        evento.setData(dto.getData());
        evento.setHorario(dto.getHorario());
        return evento;
    }
    
    public List<EventoDTO> listaEventoDTO(List<Evento> eventos){

  		return eventos.stream().map(e -> this.mapperDto(e)).collect(Collectors.toList());
      	
    }
    
    public List<Evento> listaEvento(List<EventoDTO> dto){

  		return dto.stream().map(e -> this.maapperEvento(e)).collect(Collectors.toList());
      	
     }

}