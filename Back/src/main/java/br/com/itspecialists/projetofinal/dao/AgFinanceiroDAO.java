package br.com.itspecialists.projetofinal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.itspecialists.projetofinal.modelo.AgFinanceiro;

public interface AgFinanceiroDAO extends CrudRepository<AgFinanceiro, Integer>{
	
	@Query(value="SELECT * FROM mtb310_ag_financeiro ORDER BY volume_transacional DESC",
			nativeQuery=true)
	List<AgFinanceiro> findAllOrderedByVolTrans();
}
