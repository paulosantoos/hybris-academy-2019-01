package AulaJava_1;

import java.time.LocalDate;
import java.util.Scanner;
import java.lang.String;

public class Principal {

	public static void main(String[] args) {

		String[] itensPedido = new String[3];
		String[] valoresPedido = new String[3];
		System.out.println("Olá, seja bem-vindo ao programa de " + "pedido de venda!");

		Scanner respostas = new Scanner(System.in);

		LocalDate dataAtual = LocalDate.now();

		Cliente cliente = new Cliente();
		System.out.println("Digite o seu nome: ");
		cliente.setNome(respostas.nextLine());

		System.out.println("\nDigite o seu endereço: ");
		cliente.setEndereco(respostas.nextLine());

		Pedido pedido = new Pedido();
		for (int i = 0; i < 3; i++) {
			System.out.println("\nDigite o nome do produto: ");
			pedido.setNomeProduto(respostas.nextLine());
			itensPedido[i] = pedido.getNomeProduto();

			System.out.println("\nDigite o valor do produto: ");
			pedido.setPrecoProduto(respostas.nextLine());
			valoresPedido[i] = pedido.getPrecoProduto();

		}

		System.out.println("\nEm quantas parcelas você deseja pagar?");
		System.out.println("Digite um número entre 1 até 3: ");
		System.out.println("Digite 'exit' para sair.");
		pedido.setOpcao(respostas.nextLine());

		pedido.defineParcelas();


		System.out.println("\n ====== Recibo do pedido ====== ");
		System.out.println("Código do pedido: " + pedido.getCodigoPedido());
		System.out.println("A data de hoje é: " + dataAtual);
		System.out.println("Seu nome é: " + cliente.getNome());
		System.out.println("Seu endereço é: " + cliente.getEndereco());
		System.out.println("Seu pedido foi: ");

		for (int i = 0; i < itensPedido.length; i++) {
			for (int j = 0; j < valoresPedido.length; j++) {
			}
			System.out.println("\nProduto: " + itensPedido[i] + " R$" + valoresPedido[i]);
		}

		System.out.println("\nNúmero de parcelas: " + pedido.getNumParcelas());

		for (int i = 0; i < valoresPedido.length; i++) {
			pedido.valorTotal += Integer.parseInt(valoresPedido[i]); // conversao valor
			pedido.soma += pedido.valorTotal;
		}

		pedido.calculaParcelas();

		System.out.println("\nValor total do pedido R$" + pedido.valorTotal);
	}

}