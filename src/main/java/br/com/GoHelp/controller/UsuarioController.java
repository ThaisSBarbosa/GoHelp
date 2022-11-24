package br.com.GoHelp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.GoHelp.dto.RequisicaoNovoUsuario;

@Controller
public class UsuarioController {

    @GetMapping("/signin")
	public String signin() {
		return "signin";		
		
	}
    
    @GetMapping("/signup")
	public String signup(RequisicaoNovoUsuario requisicao, BindingResult resultado) {
		return "signup";		
		
	}
}
