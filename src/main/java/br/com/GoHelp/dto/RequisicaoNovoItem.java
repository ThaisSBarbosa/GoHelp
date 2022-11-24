package br.com.GoHelp.dto;

import br.com.GoHelp.enums.EnumStatusSolicitacao;
import br.com.GoHelp.model.Item;

public class RequisicaoNovoItem {

	
	
	private String nomeItem;
	private Long idCategoria;
	private String descricaoItem;
	private String imagemItem;
	private Long idDoador;
	
	public Item toItem() {
		Item item = new Item();
		
		item.setNomeItem(nomeItem);
		item.setDescricaoItem(descricaoItem);
		item.setIdCategoria(idCategoria);
		item.setImagemItem(imagemItem);
		item.setIdDoador(1l);
		
		return item;
	}
	
	public String getNomeItem() {
		return nomeItem;
	}
	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long categoria) {
		this.idCategoria = categoria;
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
	
	
	
	
	
}
