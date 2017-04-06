package RegistrandoVenda;

/**
 * @author Allan Roque Barbosa da Silva - 1610013738
 * 
 *         Uma classe contendo os dados de uma venda e metodos necessários para
 *         o main
 *
 */

public class Venda {

	// Atributos
	Produto produto;
	Vendedor vendedor;

	public double valor;
	public double desconto;
	public int quantidadeItens;

	/**
	 * Recebe como parâmetro a porcentagem de desconto. O desconto é sobre o
	 * valorVenda do produto. O valor de um produto após o desconto não pode
	 * ficar abaixo do valorCusto do produto.
	 * 
	 * Entendi que se ficar abaixo do valorCusto, o valor final fica o mesmo do
	 * valorCusto
	 * 
	 * @param desconto
	 *            Recebe o valor do desconto
	 * @param valor
	 *            Recebe o valor de venda
	 * @param valorCusto
	 *            Recebe o valor de custo
	 * @return O valor com o desconto, e se for menor que o custo, ele retorna o
	 *         propio valor de custo
	 */
	public double efetuarDesconto(double desconto, double valor, double valorCusto) {

		double total = valor;

		if ((valor - desconto) > valorCusto)
			total = (valor - desconto);
		else
			total = valorCusto;

		return total;

	}

	/**
	 * @param qtdItens
	 *            recebe a quantidade de itens
	 * @param valor
	 *            recebe o valor em double
	 * @return a multiplicação entre os dois
	 */
	public static double calcularValor(int qtdItens, double valor) {
		return (qtdItens * valor);
	}

	/**
	 * @param comissao
	 *            recebe o valor da porcentagem em double
	 * @param valor
	 *            recebe um valor double
	 * @param promocao
	 *            recebe um bool que diz se está na promoção ou não
	 * @return um double com o valor da comissão mult com o valor, se estiver na
	 *         promo divide por 2, se não continua a mesma coisa
	 */
	public static double calcularComissao(double comissao, double valor, boolean promocao) {

		double total = valor * (comissao / 100);

		if (promocao == true)
			total /= 2;

		return total;

	}

	/**
	 * Imprime os dados da compra, do vendedor e da venda de uma maneira estilizada como nas notas NFC-e padrão
	 * # EXISTE UM EASTER EGG NO METODO :) KKK #
	 * 
	 * @param venda recebe a variavel de venda
	 * @param comissao recebe o valor da comissão
	 */
	public static void imprimir(Venda venda, double comissao) {

		System.out.println("\n######################################################################");
		System.out.println("                            DIVISÃO DE NFC-E                            ");
		System.out.println("######################################################################\n");

		System.out.println("=========================== LOJA DO SEU ZÉ ===========================\n");
		System.out.println("CNPJ:0110011001110101                             IE: 0110101001101001");
		System.out.println("UNIPÊ - ÁGUA QUENTE KM 00111100                       JOÃO PESSOA - PB");
		System.out.println("FONE: (66) 9 0011-0011");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("                      DOCUMENTO AUXILIAR DA NFC-E                     ");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("COD |         DESCRIÇÃO         | QTD | VL UNIT | DESC UN  | VL TOTAL");
		System.out.print(" " + venda.produto.codigo + "    " + venda.produto.descricao + "    " + venda.quantidadeItens
				+ "  x  " + venda.produto.valorVenda + "      ");

		if (venda.desconto != 0)
			System.out.print((venda.produto.valorVenda - venda.desconto));
		else
			System.out.print("  0.0");

		System.out.print("      " + venda.valor);

		System.out.println("\n----------------------------------------------------------------------");
		System.out.println(
				"QUANTIDADE TOTAL DE ITENS:                                          " + venda.quantidadeItens);

		System.out.print("O PRODUTO ");
		if (venda.produto.promocao == false)
			System.out.print("NÃO ");
		System.out.println("ESTÁ NA PROMOÇÃO!");

		System.out.println("SUBTOTAL:                                                   R$ "
				+ (venda.produto.valorVenda * venda.quantidadeItens) + "0");

		if (venda.desconto != 0)
			System.out.println("DESCONTO:                                                   R$  "
					+ ((venda.produto.valorVenda - venda.desconto) * venda.quantidadeItens) + "0");
		else
			System.out.println("DESCONTO:                                                   R$   0.00");

		System.out.println("VALOR A PAGAR:                                              R$ " + venda.valor + "0");
		System.out.println("\n----------------------------------------------------------------------");
		System.out.println(
				"CÓDIGO:                                                             " + venda.vendedor.codigo);
		System.out.println("VENDEDOR:                                                       " + venda.vendedor.nome);
		System.out.println("COMISSÃO:                                                   R$  " + comissao + "0");
		System.out.println("\n----------------------------------------------------------------------\n");
		System.out.println("                OBRIGADO POR COMPRAR NA LOJA DO SEU ZÉ                ");
		System.out.println("\n----------------------------------------------------------------------\n");

	}

	//Getters e setters
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public int getQuantidadeItens() {
		return quantidadeItens;
	}

	public void setQuantidadeItens(int quantidadeItens) {
		this.quantidadeItens = quantidadeItens;
	}

}
