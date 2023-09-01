package br.com.improving.carrinho;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

import br.com.improving.util.FormataReal;

/**
 * Classe que representa o carrinho de compras de um cliente.
 */
public class CarrinhoCompras {

    /**
     * Permite a adição de um novo item no carrinho de compras.
     *
     * Caso o item já exista no carrinho para este mesmo produto, as seguintes regras deverão ser seguidas:
     * - A quantidade do item deverá ser a soma da quantidade atual com a quantidade passada como parâmetro.
     * - Se o valor unitário informado for diferente do valor unitário atual do item, o novo valor unitário do item deverá ser
     * o passado como parâmetro.
     *
     * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao carrinho de compras.
     *
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    private Collection<Item> itens = new ArrayList<>();
	static int posicao = 0;
	public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) throws Exception {
		if (!isProduto(produto.getCodigo())){
			Item item = new Item(produto, valorUnitario, quantidade);
			itens.add(item);
			posicao++;
		}else {
			Item itemAntigo = new Item(produto, valorUnitario, quantidade);
			atualizaItem(itemAntigo);
			posicao++;
		}

    }
	private void atualizaItem(Item item){
		Long codigo = item.getProduto().getCodigo();
		Predicate<Item> temItem = i -> i.getProduto().getCodigo().equals(codigo);
		Consumer<Item> atualiza = i -> {
			i.setValorUnitario(item.getValorUnitario());
			i.setQuantidade(i.getQuantidade() + item.getQuantidade());
		};
		itens.stream()
				.filter(temItem)
				.forEach(atualiza);
	}

	public boolean isProduto(Long id){
		return itens.stream()
				.anyMatch(item -> item.getProduto().getCodigo().equals(id));
	}

    /**
     * Permite a remoção do item que representa este produto do carrinho de compras.
     *
     * @param produto
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
    public boolean removerItem(Produto produto) throws Exception {
		Long codigo = produto.getCodigo();
		if (isProduto(codigo)){
			return removerItem(codigo);
		}
		return false;
    }

    /**
     * Permite a remoção do item de acordo com a posição.
     * Essa posição deve ser determinada pela ordem de inclusão do produto na 
     * coleção, em que zero representa o primeiro item.
     *
     * @param posicaoItem
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
    public boolean removerItem(int posicaoItem) throws Exception {
		Item itemRemovido = itens.stream()
				.filter(i -> i.getPosicao() == posicaoItem)
				.findFirst()
				.orElseThrow(() -> new Exception("Posicao do item invalida!"));
		itens.stream()
				.skip(itemRemovido.getPosicao())
				.forEach(Item::setPosicao);
		itens.remove(itemRemovido);
		return true;
    }

	public boolean removerItem(long id) throws Exception {
		Item itemRemovido = itens.stream()
				.filter(i -> i.getProduto().getCodigo().equals(id))
				.findFirst()
				.orElseThrow(() -> new Exception("Codigo do item invalido!"));
		itens.stream()
				.skip(itemRemovido.getPosicao())
				.forEach(Item::setPosicao);
		itens.remove(itemRemovido);
		return true;
	}

    /**
     * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais
     * de todos os itens que compõem o carrinho.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() throws Exception {
			return itens.stream()
					.map(Item::getValorTotal)
					.reduce(BigDecimal::add)
					.orElseThrow(() -> new Exception("Adcione ao menos um item ao carrinho para ver o total!"));
    }

	public String getValorTotalToString() throws Exception {
		BinaryOperator<BigDecimal> somaTotal = BigDecimal::add;
		BigDecimal total = itens.stream()
				.map(Item::getValorTotal)
				.reduce(somaTotal)
				.orElseThrow(() -> new Exception("Adcione ao menos um item ao carrinho para ver o total!"));
		return FormataReal.bigDecimalToString(total);
	}


    /**
     * Retorna a lista de itens do carrinho de compras.
     *
     * @return itens
     */
    public Collection<Item> getItens() {
		return this.itens;
    }

	@Override
	public String toString() {
		return "CarrinhoCompras{" +
				"\n" + itens +
				'}';
	}
}