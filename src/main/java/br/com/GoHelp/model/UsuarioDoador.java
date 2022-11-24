package br.com.GoHelp.model;

import javax.persistence.Entity;

import br.com.GoHelp.enums.EnumTipoUsuario;

@Entity
public class UsuarioDoador extends Usuario{
	
	@Override
	protected EnumTipoUsuario setTipo() {
		return EnumTipoUsuario.DOADOR;
	}

}
