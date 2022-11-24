package br.com.GoHelp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.GoHelp.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	
	
}
