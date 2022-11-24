package br.com.GoHelp.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.GoHelp.enums.EnumTipoUsuario;

@Entity
public abstract class Usuario {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String CPF;
	private String email;
	private String senha;
	private String CEP;
	private String endereco;
	private String numeroEndereço;
	private String complemEndereço;
	@Enumerated(EnumType.STRING)
	private EnumTipoUsuario tipo;
	
	public Usuario() {
		tipo = setTipo();
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
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
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumeroEndereço() {
		return numeroEndereço;
	}


	public void setNumeroEndereço(String numeroEndereço) {
		this.numeroEndereço = numeroEndereço;
	}


	public String getComplemEndereço() {
		return complemEndereço;
	}


	public void setComplemEndereço(String complemEndereço) {
		this.complemEndereço = complemEndereço;
	}


	public EnumTipoUsuario getTipo() {
		return tipo;
	}
	
	protected abstract EnumTipoUsuario setTipo() ;
	

}
