package br.com.pentagono.estoque.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class PerfilAcesso implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id	
	private String nome;
	private String descricao;
	
	public PerfilAcesso() {
		
	}

	public PerfilAcesso(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	@Override
	public String getAuthority() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setAuthority(String nome) {
		this.nome = nome;
	}
}
