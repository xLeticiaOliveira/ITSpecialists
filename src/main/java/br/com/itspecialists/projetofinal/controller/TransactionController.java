package br.com.itspecialists.projetofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itspecialists.projetofinal.dao.TransactionDAO;

@RestController
@CrossOrigin("*")
public class TransactionController {
	@Autowired
	private TransactionDAO tdao;
	
	@PostMapping("/totalTransacao/{statusCode}")
	public ResponseEntity<Float> getTotalTransacaoByStatus(@PathVariable int statusCode){
		try {
			float total = tdao.findTotalByStatus(statusCode);
			return ResponseEntity.ok(total);
		}
		catch(Exception e) {
			return ResponseEntity.status(404).build();
		}
	}
}
