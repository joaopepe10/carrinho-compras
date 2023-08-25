package br.com.improving.carrinho;

import java.math.BigDecimal;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item {

    private Produto produto;
    private BigDecimal valorUnitario;
    private int quantidade;

    /**
     * Construtor da classe Item.
     * 
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
	public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
		this.produto = produto;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
	}
	public Item(Item item){
		this.produto = item.produto;
		this.valorUnitario = item.valorUnitario;
		this.quantidade = item.getQuantidade();
	}

    /**
     * Retorna o produto.
     *
     * @return Produto
     */
    public Produto getProduto() {
		return this.produto;
    }

    /**
     * Retorna o valor unitário do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorUnitario() {
		return this.getValorUnitario();
    }

    /**
     * Retorna a quantidade dos item.
     *
     * @return int
     */
    public int getQuantidade() {
		return this.quantidade;
    }

    /**
     * Retorna o valor total do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {
		BigDecimal quantidade = new BigDecimal(getQuantidade());
		return getValorUnitario().multiply(quantidade);
    }

	@Override
	public String toString() {
		return "Item{" +
				"produto=" + produto +
				", valorUnitario=" + valorUnitario +
				", quantidade=" + quantidade +
				'}';
	}
}
