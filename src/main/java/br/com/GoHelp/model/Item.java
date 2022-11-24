package br.com.GoHelp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.GoHelp.enums.EnumStatusSolicitacao;

@Entity(name = "item")
@Table(name = "item")
public class Item {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeItem;
	private Long idCategoria;
	private String descricaoItem;
	private String imagemItem;
	private String localizacao;
	private Long idDoador;	
	

	public String getNomeItem() {
		return nomeItem;
	}
	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getDescricaoItem() {
		return descricaoItem;
	}
	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}
	public String getImagemItem() {
		return imagemItem;
	}
	public void setImagemItem(String imagemItem) {
		this.imagemItem = imagemItem;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public Long getIdDoador() {
		return idDoador;
	}
	public void setIdDoador(Long idDoador) {
		this.idDoador = idDoador;
	}
	
	
}
