package br.com.improving.usuario;

import java.util.Objects;

import br.com.improving.carrinho.CarrinhoCompras;

public class Cliente {
	private String id;
	private String nome;
	private String sobrenome;
	private CarrinhoCompras carrinho;

	public Cliente(String id, String nome, String sobrenome){
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}

	public Cliente(String id, String nome, String sobrenome, CarrinhoCompras compras){
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.carrinho = compras;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public CarrinhoCompras getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(CarrinhoCompras carrinho) {
		this.carrinho = carrinho;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Cliente)) {
			return false;
		}
		final Cliente usuario = (Cliente) o;
		return Objects.equals(getId(), usuario.getId()) && Objects.equals(getNome(), usuario.getNome()) && Objects.equals(getSobrenome(), usuario.getSobrenome()) && Objects.equals(getCarrinho(), usuario.getCarrinho());
	}


	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"id='" + id + '\'' +
				", nome='" + nome + '\'' +
				", sobrenome='" + sobrenome + '\'' +
				", carrinho=" + carrinho +
				'}';
	}
}
