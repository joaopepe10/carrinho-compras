import java.math.BigDecimal;

import br.com.improving.carrinho.CarrinhoCompras;
import br.com.improving.carrinho.CarrinhoComprasFactory;
import br.com.improving.carrinho.Produto;
import br.com.improving.usuario.Cliente;

public class Main {
	public static void main(String[] args) throws Exception {
		CarrinhoComprasFactory cf = new CarrinhoComprasFactory();
		Produto p1 = new Produto("Iphone 12");
		Produto p2 = new Produto("Iphone 13");
		Produto p3 = new Produto("Iphone 14");

		CarrinhoCompras compras1 = new CarrinhoCompras();
		CarrinhoCompras compras2 = new CarrinhoCompras();
		compras1.adicionarItem(p1, BigDecimal.valueOf(1250.23), 1);
		compras2.adicionarItem(p1, BigDecimal.valueOf(2900.33), 1);

		Cliente c1 = new Cliente("1", "Joao", "Pires", compras1);
		cf.addCliente(c1);
		Cliente c2 = new Cliente("2", "Vitor", "Santos", compras2);
		Cliente c3 = new Cliente("3", "Arthur", "Santos");
		cf.addCliente(c2);
		cf.addCliente(c3);
		cf.criar(c3.getId());

		//System.out.println(cf.criar("2"));
		//System.out.println(cf.criar("1"));
		System.out.println(cf.getValorTicketMedio());


	}
}
