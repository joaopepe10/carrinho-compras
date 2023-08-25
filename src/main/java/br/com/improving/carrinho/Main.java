package br.com.improving.carrinho;

import java.math.BigDecimal;

public class Main {
	public static void main(String[] args) throws Exception {
		Produto p1 = new Produto("Iphone 12");
		Produto p2 = new Produto("Iphone 13");
		Produto p3 = new Produto("Iphone 14");

		CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
		carrinhoCompras.adicionarItem(p1, new BigDecimal(2900), 10);
		carrinhoCompras.adicionarItem(p2, new BigDecimal(3700), 10);
		carrinhoCompras.adicionarItem(p3, new BigDecimal(4500), 10);

		System.out.println(carrinhoCompras.buscaPorId(2L));
	}
}
