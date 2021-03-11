package br.com.itspecialists.projetofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itspecialists.projetofinal.dao.AgFinanceiroDAO;
import br.com.itspecialists.projetofinal.modelo.AgFinanceiro;

@RestController
@CrossOrigin("*")
public class AgFinanceiroController {
	@Autowired
	private AgFinanceiroDAO agdao;
	
	@GetMapping("/agentes")
	public ResponseEntity<List<AgFinanceiro>> getAll(){
		List<AgFinanceiro> agentes = (List<AgFinanceiro>) agdao.findAllOrderedByVolTrans();
		if(agentes == null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(agentes);
	}
	
	@PostMapping("/agente/{id}")
	public ResponseEntity<AgFinanceiro> getAgente(@PathVariable int id){
		AgFinanceiro agente = agdao.findById(id).orElse(null);
		if(agente == null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(agente);
	}
}
