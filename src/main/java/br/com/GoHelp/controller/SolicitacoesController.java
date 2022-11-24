package br.com.GoHelp.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.GoHelp.model.Solicitacao;
import br.com.GoHelp.repository.SolicitacaoRepository;

@Controller
public class SolicitacoesController {
	@Autowired
	private SolicitacaoRepository _solicitacaoRepository;

	@GetMapping("/gestaoSolicitacaoDonatario")
	public String gestaoSolicitacaoDonatario(Model model) {
		List<Solicitacao> solicitacoes = _solicitacaoRepository.findAll();
		model.addAttribute("solicitacoes", solicitacoes);
		return "gestaoSolicitacaoDonatario";

	}

	@GetMapping("/gestaoSolicitacaoDoador")
	public String gestaoSolicitacaoDoador(Model model) {
		List<Solicitacao> solicitacoes = _solicitacaoRepository.findAll();
		model.addAttribute("solicitacoes", solicitacoes);
		return "gestaoSolicitacaoDoador";

	}

	@GetMapping("/gestaoSolicitacaoPrestador")
	public String gestaoSolicitacaoPrestador(Model model) {
		List<Solicitacao> solicitacoes = _solicitacaoRepository.findAll();

		model.addAttribute("solicitacoes", solicitacoes);
		return "gestaoSolicitacaoPrestador";

	}
}
