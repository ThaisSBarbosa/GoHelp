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
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.GoHelp.dto.RequisicaoNovoUsuario;
import br.com.GoHelp.model.Usuario;
import br.com.GoHelp.repository.UsuarioRepository;

@RestController
public class UsuarioRestController {
	@Autowired
	private UsuarioRepository _usuarioRepository;

	@RequestMapping(value = "/listarUsuarios", method = RequestMethod.GET)
	public List<Usuario> Get() {
		return _usuarioRepository.findAll();
	}

	@RequestMapping(value = "/buscaUsuarioPorId/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> GetById(@PathVariable(value = "id") long id) {
		Optional<Usuario> usuario = _usuarioRepository.findById(id);
		if (usuario.isPresent())
			return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/usuario2", method = RequestMethod.POST)
	public String Post(@RequestBody Long cod) {
		// usuario.setStatus(EnumStatusUsuario.APROVADA);
		// _usuarioRepository.save(usuario);
		return "/teste";
	}

	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
		Optional<Usuario> usuario = _usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			_usuarioRepository.delete(usuario.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/cadusuario", method = RequestMethod.POST)
	public ModelAndView CadUsuario(@Valid RequisicaoNovoUsuario requisicao, BindingResult resultado,
			HttpServletResponse response) throws IOException {
		ModelAndView mv;
		if (resultado.hasFieldErrors()) {
			mv = new ModelAndView("signup");
			mv.addObject(requisicao);
			return mv;
		}

		if (requisicao.emailsIguais() && requisicao.senhasIguais()) {
			Usuario user = requisicao.toUsuario();

			_usuarioRepository.save(user);
			mv = new ModelAndView("signin");
			return mv;
		} else {

			mv = new ModelAndView("signup");
			mv.addObject(requisicao);
			if (!requisicao.emailsIguais()) {
				resultado.rejectValue("email", "email.notEqual");
				resultado.rejectValue("emailConfirma", "email.notEqual");
			}
			if (!requisicao.senhasIguais()) {
				resultado.rejectValue("senha", "senha.notEqual");
				resultado.rejectValue("senhaConfirma", "senha.notEqual");
			}
			mv.addObject(resultado);
			return mv;
		}
	}

}
