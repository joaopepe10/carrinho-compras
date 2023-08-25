package br.com.improving.carrinho;

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
		this.codigo = contador;
		this.descricao = descricao;
		contador++;
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
}