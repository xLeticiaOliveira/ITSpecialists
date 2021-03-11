package br.com.itspecialists.projetofinal.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mtb310_usuario")
public class Usuario {
	
	@Column(name="id_usuario")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(name="nome", length=80)
	private String nome;
	
	@Column(name="racf", length=10)
	private String racf;
	
	@Column(name="email", length=80)
	private String email;
	
	@Column(name="senha", length=30)
	private String senha;
	
	@Column(name="foto", length=30)
	private String foto;

	public Usuario() {
		super();
	}

	public Usuario(int idUsuario, String nome, String racf, String email, String senha, String foto) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.racf = racf;
		this.email = email;
		this.senha = senha;
		this.foto = foto;
	}

	public int getId() {
		return idUsuario;
	}

	public void setId(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRacf() {
		return racf;
	}

	public void setRacf(String racf) {
		this.racf = racf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", racf=" + racf + ", email=" + email + ", senha=" + senha
				+ ", foto=" + foto + "]";
	}	
}
