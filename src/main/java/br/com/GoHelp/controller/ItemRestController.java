package br.com.GoHelp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.GoHelp.dto.RequisicaoNovoItem;
import br.com.GoHelp.dto.RequisicaoNovoUsuario;
import br.com.GoHelp.model.Item;
import br.com.GoHelp.model.Usuario;
import br.com.GoHelp.repository.ItemRepository;

@RestController
public class ItemRestController {
    @Autowired
    private ItemRepository _itemRepository;

    @RequestMapping(value = "/listarItens", method = RequestMethod.GET)
    public List<Item> Get() {
        return _itemRepository.findAll();
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<Item> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Item> item = _itemRepository.findById(id);
        if(item.isPresent())
            return new ResponseEntity<Item>(item.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/item2", method =  RequestMethod.POST)
    public String Post(@RequestBody Long cod)
    {
    	//item.setStatus(EnumStatusItem.APROVADA);
       // _itemRepository.save(item);
        return "/teste";
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Item> item = _itemRepository.findById(id);
        if(item.isPresent()){
            _itemRepository.delete(item.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
	@RequestMapping(value = "/caditem", method = RequestMethod.POST)	
	public void CadUsuario(@Valid RequisicaoNovoItem requisicao, HttpServletResponse response, BindingResult resultado) throws IOException {
		if (resultado.hasErrors()) {
			response.sendRedirect("/cadastroItem");
			return;
		}
		Item item = requisicao.toItem();
		
		_itemRepository.save(item);
		response.sendRedirect("/index");
	}
}
