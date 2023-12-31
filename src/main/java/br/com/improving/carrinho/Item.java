package br.com.improving.carrinho;

import java.math.BigDecimal;

import br.com.improving.util.FormataReal;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item {

    private Produto produto;
    private BigDecimal valorUnitario;
    private int quantidade;
	public static int posicaoEstatica = 0;
	private int posicao;

    /**
     * Construtor da classe Item.
     * 
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */

	/*
	* QUANDO CRIAR UM NOVO CONSTRUTOR, VERIFICAR SE COLOCOU O INCREMENTO DA POSICAO.
	*
	*
	* */
	public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
		this.produto = produto;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
		posicao = posicaoEstatica;
		posicaoEstatica++;
	}
	public Item(BigDecimal valorUnitario, int quantidade){
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
		posicao = posicaoEstatica;
		posicaoEstatica++;
	}
	public Item(Item item){
		this.produto = item.produto;
		this.valorUnitario = item.valorUnitario;
		this.quantidade = item.getQuantidade();
		posicao = posicaoEstatica;
		posicaoEstatica++;
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
		return this.valorUnitario;
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

	public int getPosicao() {
		return this.posicao;
	}

	public void setPosicao() {
		this.posicao--;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "\n\tItem{" +
				"Posicao=["+ posicao +"]"+ produto +
				", valorUnitario=" + FormataReal.bigDecimalToString(valorUnitario) +
				", quantidade=" + quantidade +
				'}';
	}
}
