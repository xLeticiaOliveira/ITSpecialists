package br.com.itspecialists.projetofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itspecialists.projetofinal.dao.UsuarioDAO;
import br.com.itspecialists.projetofinal.modelo.Usuario;

@RestController
@CrossOrigin("*")
public class UsuarioController {
	@Autowired
	private UsuarioDAO udao;
	
	@PostMapping("/loginEmail")
	public ResponseEntity<Usuario> loginEmail(@RequestBody Usuario objeto){
		Usuario usuario;
		usuario = (Usuario) udao.findByEmailAndSenha(objeto.getEmail(), objeto.getSenha());
		if(usuario == null) {
			return ResponseEntity.status(403).build();
		}
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping("/loginRacf")
	public ResponseEntity<Usuario> loginRacf(@RequestBody Usuario objeto){
		Usuario usuario;
		usuario = (Usuario) udao.findByRacfAndSenha(objeto.getRacf(), objeto.getSenha());
		if(usuario == null) {
			return ResponseEntity.status(403).build();
		}
		return ResponseEntity.ok(usuario);
	}
}
