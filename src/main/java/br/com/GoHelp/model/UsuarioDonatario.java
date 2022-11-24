package br.com.GoHelp.model;

import br.com.GoHelp.enums.EnumTipoUsuario;

public class UsuarioDonatario extends Usuario{
	
	@Override
	protected EnumTipoUsuario setTipo() {
		return EnumTipoUsuario.SOLICITANTE;
	}

}
