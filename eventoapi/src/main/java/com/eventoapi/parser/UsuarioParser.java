package com.eventoapi.parser;

import java.util.List;
import java.util.stream.Collectors;

import com.eventoapi.dto.UsuarioDTO;
import com.eventoapi.models.Usuario;

public class UsuarioParser {
	
	public static UsuarioParser get(){
	        return  new UsuarioParser();
	}

    public UsuarioDTO mapperDto(Usuario usuario){
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        return dto;
    }
    
    
    public List<UsuarioDTO> listaUsuarioDTO(List<Usuario> usuarios){

		return usuarios.stream().map(u -> this.mapperDto(u)).collect(Collectors.toList());
    	
    }

}
