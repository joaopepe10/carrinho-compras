
package br.com.improving.carrinho;

import static java.math.RoundingMode.HALF_EVEN;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.apache.commons.math3.util.Precision;

import br.com.improving.usuario.Cliente;


/**
 * Classe responsável pela criação e recuperação dos carrinhos de compras.
 */

public class CarrinhoComprasFactory {

	private List<Cliente> clientes = new ArrayList<>();
	private List<CarrinhoCompras> carrinhos = new ArrayList<>();
	public CarrinhoComprasFactory() {
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

    public CarrinhoCompras criar(String identificacaoCliente) throws Exception {
		if (!isCliente(identificacaoCliente)){
			throw new Exception("Id de cliente invalido!");
		}
		return buscarCarrinho(identificacaoCliente);
    }
	private Function<Cliente, CarrinhoCompras> retornaCarrinho(String identificacaoCliente){
		Function<Cliente, CarrinhoCompras> retornaCarrinho;
		retornaCarrinho = cliente -> {
			if (cliente.getCarrinho() == null){
				CarrinhoCompras carrinho = new CarrinhoCompras();
				carrinhos.add(carrinho);
				return  carrinho;
			}else {
				//carrinhos.add(cliente.getCarrinho());
				return cliente.getCarrinho();
			}
		};
		return retornaCarrinho;
		}


	private CarrinhoCompras buscarCarrinho(String identificacaoCliente) throws Exception {
			Optional<CarrinhoCompras> carrinhoCompras = clientes.stream()
					.filter(temCliente(identificacaoCliente))
					.map(retornaCarrinho(identificacaoCliente))
					.findFirst();
			return carrinhoCompras.orElseGet(CarrinhoCompras::new);
	}

	private Predicate<Cliente> temCliente(String identificacaoCliente){
		Predicate<Cliente> temCliente = cliente -> cliente.getId().equals(identificacaoCliente);
		return temCliente;
	}


	private boolean isCliente(String identificacaoCliente) throws Exception {
		boolean existeCliente = clientes.stream()
				.anyMatch(temCliente(identificacaoCliente));
		if (!existeCliente){
			throw new Exception("Identificacao de cliente invalida!");
		}
		return existeCliente;
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

    public BigDecimal getValorTicketMedio() throws Exception{
		if (carrinhos.isEmpty()){
			throw new Exception("Nao ha carrinhos de compras cadastrados");
		}
		BigDecimal total = BigDecimal.valueOf(0);
		for (CarrinhoCompras c : carrinhos){
			if (!c.getItens().isEmpty()){
				total = total.add(c.getValorTotal());
			}
		}
		return total.divide(new BigDecimal(carrinhos.size()), HALF_EVEN).setScale(2, HALF_EVEN);
    }


	/**
     * Invalida um carrinho de compras quando o cliente faz um checkout ou sua sessão expirar.
     * Deve ser efetuada a remoção do carrinho do cliente passado como parâmetro da listagem de carrinhos de compras.
     *
     * @param identificacaoCliente
     * @return Retorna um boolean, tendo o valor true caso o cliente passado como parämetro tenha um carrinho de compras e
     * e false caso o cliente não possua um carrinho.
     */

    public boolean invalidar(String identificacaoCliente) throws Exception {
		if (clientes.isEmpty()){
			throw new Exception("Nao ha nenhum cliente salvo!");
		}
		CarrinhoCompras carrinhoCliente = clientes.stream()
				.filter(temCliente(identificacaoCliente))
				.map(Cliente::getCarrinho)
				.findFirst()
				.orElseThrow(()-> new Exception("Cliente nao encontrado!"));
		carrinhos.remove(carrinhoCliente);
		return true;
    }

	private List<Cliente> getClientes() {
		return clientes;
	}

	public List<CarrinhoCompras> getCarrinhos() {
		return carrinhos;
	}

	public void addCliente(Cliente cliente) throws Exception {
		clientes.add(cliente);
		if (cliente.getCarrinho() != null){
			carrinhos.add(cliente.getCarrinho());
		}
	}
	public void setClientes(List<Cliente> clientes){this.clientes.addAll(clientes);}
}

