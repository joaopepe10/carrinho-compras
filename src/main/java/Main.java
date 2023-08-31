import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

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

		Cliente c1 = new Cliente("1", "Joao", "Pires");
		Cliente c2 = new Cliente("2", "Vitor", "Santos");



	}
}
