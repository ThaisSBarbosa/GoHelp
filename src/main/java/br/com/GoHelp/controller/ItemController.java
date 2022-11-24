package br.com.GoHelp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.GoHelp.dto.RequisicaoNovoItem;
import br.com.GoHelp.dto.RequisicaoNovoUsuario;
import br.com.GoHelp.repository.ItemRepository;

@Controller
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/buscaItem")
	public String buscaItem(Model model) {
		
		model.addAttribute("itens",itemRepository.findAll());
		model.addAttribute("itemCEP",itemRepository.findAll().get(0).getLocalizacao());
		return "buscaItem";
	}
	
	@GetMapping("/cadastroItem")
	public String cadastroItem(RequisicaoNovoItem requisicao, BindingResult resultado) {
		return "cadastroItem";
	}
	
}
