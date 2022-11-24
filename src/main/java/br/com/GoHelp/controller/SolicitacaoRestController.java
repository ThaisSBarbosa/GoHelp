package br.com.GoHelp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.GoHelp.enums.EnumStatusSolicitacao;
import br.com.GoHelp.model.Solicitacao;
import br.com.GoHelp.repository.SolicitacaoRepository;

@RestController
public class SolicitacaoRestController {
    @Autowired
    private SolicitacaoRepository _solicitacaoRepository;

    @RequestMapping(value = "/solicitacaoListarDoador", method = RequestMethod.GET)
    public List<Solicitacao> Get() {
        return _solicitacaoRepository.findAll();
    }

    @RequestMapping(value = "/buscaSolicitacaoPorId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Solicitacao> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Solicitacao> solicitacao = _solicitacaoRepository.findById(id);
        if(solicitacao.isPresent())
            return new ResponseEntity<Solicitacao>(solicitacao.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/solicitacao2", method =  RequestMethod.POST)
    public String Post(@RequestBody Long cod)
    {
    	//solicitacao.setStatus(EnumStatusSolicitacao.APROVADA);
       // _solicitacaoRepository.save(solicitacao);
        return "/teste";
    }

    @RequestMapping(value = "/solicitacao/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Solicitacao> solicitacao = _solicitacaoRepository.findById(id);
        if(solicitacao.isPresent()){
            _solicitacaoRepository.delete(solicitacao.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/solicitacaoAlteraStatus/{id}", method = RequestMethod.POST, params = "aprovar")
    public ModelAndView aprovaSolicitacao(@PathVariable(value = "id") long id) {
    	
    	Optional<Solicitacao> solicitacao = _solicitacaoRepository.findById(id);
    	solicitacao.get().setStatus(EnumStatusSolicitacao.APROVADA);
    	_solicitacaoRepository.save(solicitacao.get());
    	
    	return new ModelAndView("gestaoSolicitacaoDoador");
    }
    
    @RequestMapping(value = "/solicitacaoAlteraStatus/{id}", method = RequestMethod.POST, params = "rejeitar")
    public ModelAndView rejeitaSolicitacao(@PathVariable(value = "id") long id) {
    	
    	Optional<Solicitacao> solicitacao = _solicitacaoRepository.findById(id);
    	solicitacao.get().setStatus(EnumStatusSolicitacao.REJEITADA);
    	_solicitacaoRepository.save(solicitacao.get());
    	
    	return new ModelAndView("gestaoSolicitacaoDoador");
    }
}
