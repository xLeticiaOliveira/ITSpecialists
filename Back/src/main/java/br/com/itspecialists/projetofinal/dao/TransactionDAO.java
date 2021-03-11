package br.com.itspecialists.projetofinal.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.itspecialists.projetofinal.modelo.Transaction;

public interface TransactionDAO extends CrudRepository<Transaction, Integer> {

	@Query(value="SELECT SUM(valor_solic) FROM mtb310_transaction  WHERE status = :num",
			nativeQuery = true)
	float findTotalByStatus(@Param("num") int num);
}
