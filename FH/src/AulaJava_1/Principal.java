package AulaJava_1;

import java.time.LocalDate;
import java.util.Scanner;
import java.lang.String;

public class Principal {

	public static void main(String[] args) {
		

		String[] itensPedido = new String[3];
		String[] valoresPedido = new String[3];
		
		System.out.println("Olá, seja bem-vindo ao programa de "
				+ "pedido de venda!");
		
		String produtos = "";
		String precosProdutos = "";
		Scanner respostas = new Scanner(System.in);
		
		LocalDate dataAtual = LocalDate.now();
		
		
		Cliente cliente = new Cliente();
		
		System.out.println("Digite o seu nome: ");
		cliente.setNome(respostas.nextLine());
		
		System.out.println("\nDigite o seu endereço: ");
		cliente.setEndereco(respostas.nextLine());
		

		Pedido pedido = new Pedido();

		for(int i=0;i<3;i++) {
		System.out.println("\nDigite o nome do produto: ");
		pedido.setNomeProduto(respostas.nextLine());
		itensPedido[i] = pedido.getNomeProduto();
		
		
		System.out.println("\nDigite o valor do produto: ");
		pedido.setPrecoProduto(respostas.nextLine());
		valoresPedido[i] = pedido.getPrecoProduto();
		
		}

		
		Pedido parcelas = new Pedido();
		
		System.out.println("\nEm quantas parcelas você deseja pagar?");
		System.out.println("Digite um número entre 1 até 3: ");
		System.out.println("Digite 'exit' para sair.");
		String opcao = respostas.nextLine();
		
		int numParcelas = 0;
		
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
        	return;
        default: 
            	System.out.println("Opção inválida, tente novamente!");
            	return;
		}
        	

	System.out.println("\n ==== Recibo do pedido ==== ");
	System.out.println("Código do pedido: " + pedido.getCodigoPedido());
	System.out.println("A data de hoje é: " + dataAtual);
	System.out.println("Seu nome é: " + cliente.getNome());
	System.out.println("Seu endereço é: " + cliente.getEndereco());
	System.out.println("Seu pedido foi: ");
	
	for(int i=0;i<itensPedido.length;i++) {
		for(int j=0;j<valoresPedido.length;j++) {	
		}
		System.out.println("\nProduto: " + itensPedido[i] + " R$" + valoresPedido[i]);
	}
	
	int valorTotal = 0;
	int soma = 0;
	
	for(int i=0; i<valoresPedido.length; i++) {
	valorTotal += Integer.parseInt(valoresPedido[i]); // conversao valor
	soma += valorTotal;
	}


	int valorParcela = 0;
	
	valorParcela = valorTotal / numParcelas;
	
	System.out.println("\nNúmero de parcelas: " + numParcelas);
	
	if(numParcelas == 1) {
		System.out.println("Parcela 1: " +valorParcela);
	} else if (numParcelas == 2) {
		System.out.println("Parcela 1: " +valorParcela);
		System.out.println("Parcela 2: " +valorParcela);
	} else {
		System.out.println("Parcela 1: " +valorParcela);
		System.out.println("Parcela 2: " +valorParcela);
		System.out.println("Parcela 3: " +valorParcela);
	}

	System.out.println("\nValor total do pedido R$" +valorTotal);
	}

	
}
