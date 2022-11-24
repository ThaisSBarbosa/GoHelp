package br.com.GoHelp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.GoHelp.model.Solicitacao;

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long>{
	
	@Query("select c from Cars c where c.brand = ?1")
    public static List<Object> getDadosSolicitacao(){
		return null;
    }
}
