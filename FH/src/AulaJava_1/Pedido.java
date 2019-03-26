package AulaJava_1;

public class Pedido {

	private String nomeProduto;
	private String precoProduto;
	private String opcao;
	private int numParcelas = 0;
	int valorParcela = 0;
	int valorTotal = 0;
	int soma = 0;
	private int codigoPedido = 1;

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(String precoProduto) {
		this.precoProduto = precoProduto;
	}

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	public int getNumParcelas() {
		return numParcelas;
	}

	public void setNumParcelas(int numParcelas) {
		this.numParcelas = numParcelas;
	}

	public int getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public int getSoma() {
		return soma;
	}

	public void setSoma(int soma) {
		this.soma = soma;
	}

	public int calculatValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void defineParcelas() {

		switch (opcao) {
		case "1":
			numParcelas = 1;
			break;
		case "2":
			numParcelas = 2;
			break;
		case "3":
			numParcelas = 3;
			break;
		case "exit":
			System.out.println("Obrigado, volte sempre!");
			System.exit(0);
		default:
				System.out.println("Opção inválida, tente novamente!");
				System.exit(0);
		}
	}

	public void calculaParcelas() {

		valorParcela = valorTotal / numParcelas;

		if (numParcelas == 1) {
			System.out.println("Parcela 1: " + valorParcela);
		} else if (numParcelas == 2) {
			System.out.println("Parcela 1: " + valorParcela);
			System.out.println("Parcela 2: " + valorParcela);
		} else {
			System.out.println("Parcela 1: " + valorParcela);
			System.out.println("Parcela 2: " + valorParcela);
			System.out.println("Parcela 3: " + valorParcela);
		}


	}

}
