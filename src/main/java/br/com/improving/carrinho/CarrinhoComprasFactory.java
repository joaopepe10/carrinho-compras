
package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.improving.usuario.Cliente;


/**
 * Classe responsável pela criação e recuperação dos carrinhos de compras.
 */

public class CarrinhoComprasFactory {

	private List<Cliente> clientes = new ArrayList<>();
	private CarrinhoComprasFactory() {
	}
	public CarrinhoComprasFactory(Cliente cliente){
		this.clientes.add(cliente);
	}
	public CarrinhoComprasFactory(List<Cliente> clientes){
		this.clientes.addAll(clientes);
	}


	/**
     * Cria e retorna um novo carrinho de compras para o cliente passado como parâmetro.
     *
     * Caso já exista um carrinho de compras para o cliente passado como parâmetro, este carrinho deverá ser retornado.
     *
     * @param identificacaoCliente
     * @return CarrinhoCompras
     */

    public CarrinhoCompras criar(String identificacaoCliente) {
		isCliente(identificacaoCliente)
				.orElseThrow(()-> new RuntimeException("Id de cliente invalido!"));
		return buscaCarrinho(identificacaoCliente)
				.orElseGet(CarrinhoCompras::new);
    }

	private Optional<CarrinhoCompras> buscaCarrinho(String identificacaoCliente){
		return getClientes().stream()
				.filter(cliente -> cliente.getId().equals(identificacaoCliente))
				.filter(cliente -> cliente.getCarrinho() != null)
				.map(Cliente::getCarrinho)
				.findFirst();
	}

	private Optional<Boolean> isCliente(String identificacaoCliente){
		return Optional.of(getClientes().stream()
				.anyMatch(i -> i.getId().equals(identificacaoCliente)));
	}




	/**
     * Retorna o valor do ticket médio no momento da chamada ao método.
     * O valor do ticket médio é a soma do valor total de todos os carrinhos de compra dividido
     * pela quantidade de carrinhos de compra.
     * O valor retornado deverá ser arredondado com duas casas decimais, seguindo a regra:
     * 0-4 deve ser arredondado para baixo e 5-9 deve ser arredondado para cima.
     *
     * @return BigDecimal
     */

    public BigDecimal getValorTicketMedio() {
		return new BigDecimal(0);
    }


	/**
     * Invalida um carrinho de compras quando o cliente faz um checkout ou sua sessão expirar.
     * Deve ser efetuada a remoção do carrinho do cliente passado como parâmetro da listagem de carrinhos de compras.
     *
     * @param identificacaoCliente
     * @return Retorna um boolean, tendo o valor true caso o cliente passado como parämetro tenha um carrinho de compras e
     * e false caso o cliente não possua um carrinho.
     */

    public boolean invalidar(String identificacaoCliente) {
		return true;
    }

	private List<Cliente> getClientes() {
		return clientes;
	}

	private void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}

