import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class orderSale {
    public static void main(String[] args){
        Date data = new Date();
        //List Order = new Order();

    Scanner ler = new Scanner(System.in);

    System.out.printf("Informe o nome:\n");
    String Nome;
    Nome = ler.nextLine();

    System.out.printf("Informe o produto:\n");
    Scanner ler2 = new Scanner(System.in);
    String Produto;
    Produto = ler2.nextLine();


    System.out.printf("Informe em quantas vezes quer parcelar seu produto:\n");
    Scanner ler3 = new Scanner(System.in);
    Integer Vezes;
    Vezes = ler3.nextInt();


    System.out.printf("Informe seu Endereco:\n");
    Scanner ler4 = new Scanner(System.in);
    String Endereco;
    Endereco = ler4.nextLine();

    System.out.println("Data do Pedido: "+data);
    }
}