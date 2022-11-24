package br.com.GoHelp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.GoHelp.enums.EnumStatusSolicitacao;

@Entity(name = "solicitacao")
@Table(name = "solicitacao")
public class Solicitacao {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date dataCriacao;
	private Long codUsuarioDoador;
	private Long codUsuarioSolicitante;
	private Long codItem;
	@Enumerated(EnumType.STRING)
	private EnumStatusSolicitacao status;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Long getCodUsuarioDoador() {
		return codUsuarioDoador;
	}
	public void setCodUsuarioDoador(Long codUsuarioDoador) {
		this.codUsuarioDoador = codUsuarioDoador;
	}
	public Long getCodUsuarioSolicitante() {
		return codUsuarioSolicitante;
	}
	public void setCodUsuarioSolicitante(Long codUsuarioSolicitante) {
		this.codUsuarioSolicitante = codUsuarioSolicitante;
	}
	public Long getCodItem() {
		return codItem;
	}
	public void setCodItem(Long codItem) {
		this.codItem = codItem;
	}
	public EnumStatusSolicitacao getStatus() {
		return status;
	}
	public void setStatus(EnumStatusSolicitacao status) {
		this.status = status;
	}
	
	
	
	
}
