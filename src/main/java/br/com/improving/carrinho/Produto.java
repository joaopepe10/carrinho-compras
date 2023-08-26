package br.com.improving.carrinho;

import java.util.Objects;

/**
 * Classe que representa um produto que pode ser adicionado
 * como item ao carrinho de compras.
 *
 * Importante: Dois produtos são considerados iguais quando ambos possuem o
 * mesmo código.
 */
public class Produto {

    private Long codigo;
    private String descricao;
	public static long contador = 1;

    /**
     * Construtor da classe Produto.
     *
     * @param codigo
     * @param descricao
     */
    public Produto(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
    }
	public Produto(String descricao){
		this.codigo = contador;
		this.descricao = descricao;
		contador++;
	}

    /**
     * Retorna o código da produto.
     *
     * @return Long
     */
    public Long getCodigo() {
		return this.codigo;
    }

    /**
     * Retorna a descrição do produto.
     *
     * @return String
     */
    public String getDescricao() {
		return this.descricao;
    }




	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Produto)) {
			return false;
		}
		final Produto produto = (Produto) o;
		return Objects.equals(getCodigo(), produto.getCodigo()) && Objects.equals(getDescricao(), produto.getDescricao());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCodigo());
	}
	@Override
	public String toString() {
		return "\n\tProduto{" +
				"codigo=" + codigo +
				", descricao='" + descricao + '\'' +
				'}';
	}
}