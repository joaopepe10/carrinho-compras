import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;

import br.com.improving.carrinho.CarrinhoCompras;
import br.com.improving.carrinho.CarrinhoComprasFactory;
import br.com.improving.carrinho.Produto;
import br.com.improving.usuario.Cliente;

public class Main {
	public static void main(String[] args) throws Exception {

		Cliente c1 = new Cliente("1","Joao","Pires");

		CarrinhoComprasFactory carrinhoComprasFactory = new CarrinhoComprasFactory(c1);
		CarrinhoCompras carrinho = carrinhoComprasFactory.criar(c1.getId());

		Produto p1 = new Produto("Iphone 12");
		Produto p2 = new Produto("Iphone 13");
		Produto p3 = new Produto("Iphone 14");
		Produto p4 = new Produto(3L,"Iphone 14");
		Produto p5 = new Produto(2L,"Iphone 13");
		Produto p6 = new Produto("Iphone X");
		Produto p7 = new Produto("Iphone 11");

		carrinho.adicionarItem(p1, new BigDecimal(2900), 10);
		carrinho.adicionarItem(p2, new BigDecimal(3700), 10);
		carrinho.adicionarItem(p3, new BigDecimal(4500), 10);
		carrinho.adicionarItem(p6, new BigDecimal(1800), 10);
		carrinho.adicionarItem(p7, new BigDecimal(2000), 10);

		System.out.println(carrinho);

		carrinho.removerItem(1);


		System.out.println("\n\n" + carrinho);
		/*System.out.println(carrinhoCompras.getValorTotalToString());
		carrinhoCompras.adicionarItem(p4, new BigDecimal(4700), 1);
		carrinhoCompras.adicionarItem(p5, new BigDecimal(3500), 1);
		carrinhoCompras.adicionarItem(p1, new BigDecimal(2900), 1);
		carrinhoCompras.adicionarItem(p2, new BigDecimal(3700), 1);
		carrinhoCompras.adicionarItem(p3, new BigDecimal(4500), 1);
		carrinhoCompras.adicionarItem(p6, new BigDecimal(1800), 1);
		carrinhoCompras.adicionarItem(p7, new BigDecimal(2000), 1);
		System.out.println(carrinhoCompras);
		System.out.println(carrinhoCompras.getValorTotalToString());

		System.out.println(carrinhoCompras.removerItem(p2));
		System.out.println(carrinhoCompras.removerItem(p4));
		System.out.println(carrinhoCompras);
		System.out.println(carrinhoCompras.getValorTotalToString());*/



	}
}
