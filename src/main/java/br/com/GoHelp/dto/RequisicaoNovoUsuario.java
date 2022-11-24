package br.com.GoHelp.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.GoHelp.enums.EnumDiaSemana;
import br.com.GoHelp.enums.EnumPeriodo;
import br.com.GoHelp.model.Usuario;
import br.com.GoHelp.model.UsuarioDoador;
import br.com.GoHelp.model.UsuarioSolicitante;
import br.com.GoHelp.model.UsuarioPrestador;

public class RequisicaoNovoUsuario {

	@NotBlank
	private String nome;
	@NotBlank
	@Pattern(regexp = "(\\d{3}.?\\d{3}.?\\d{3}-?\\d{2})")
	private String cpf;
	@NotBlank
	private String email;
	@NotBlank
	private String emailConfirma;
	@NotBlank
	private String senha;
	@NotBlank
	private String senhaConfirma;
	@NotBlank
	private String endereco;
	@NotBlank
	@Pattern(regexp = "[0-9]{5}-[0-9]{3}")
	private String cep;
	// @Min(1)
	@NotBlank
	private String tipoUsuario;
	private String complementoEndereco;
	private String numeroEndereco;

	/*
	 * private Boolean consultaCadUnico; private Long numeroCartao; private Byte
	 * codigoSeguranca; private LocalDate validadeCartao; private String numeroCNH;
	 * private EnumPeriodo periodoDisponivel; private EnumDiaSemana diaSemana;
	 * private Boolean aceitaTermos;
	 * 
	 */

	public Usuario toUsuario() {
		Usuario user;
		switch (tipoUsuario) {
		case "doador": {
			user = new UsuarioDoador();
			break;
		}
		case "solicitante": {
			user = new UsuarioSolicitante();
			break;
		}
		case "prestador": {
			user = new UsuarioPrestador();
			break;
		}
		default:
			return null;
		}

		user.setNome(nome);
		user.setCPF(cpf);
		user.setEmail(email);
		user.setSenha(senha);
		user.setEndereco(endereco);
		user.setCEP(cep);
		user.setComplemEndereço(complementoEndereco);
		user.setNumeroEndereço(numeroEndereco);

		return user;
	}

	public boolean emailsIguais() {
		return (email.compareTo(emailConfirma) == 0);

	}
	
	public boolean senhasIguais() {
		return (senha.compareTo(senhaConfirma) == 0);

	}

	public String getEmailConfirma() {
		return emailConfirma;
	}

	public void setEmailConfirma(String emailConfirma) {
		this.emailConfirma = emailConfirma;
	}

	public String getSenhaConfirma() {
		return senhaConfirma;
	}

	public void setSenhaConfirma(String senhaConfirma) {
		this.senhaConfirma = senhaConfirma;
	}

	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getComplementoEndereco() {
		return complementoEndereco;
	}

	public void setComplementoEendereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}

	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

}
