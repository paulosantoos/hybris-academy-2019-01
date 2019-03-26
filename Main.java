import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

        PedidoVenda pv = new PedidoVenda();

        System.out.print("data: ");

        Date date = formatter.parse(sc.nextLine());
        pv.setDate(date);

        System.out.print("cliente nome: ");
        String nomeCliente = sc.nextLine();
        System.out.print("cliente end : ");
        String endereco = sc.nextLine();

        Cliente cliente = new Cliente();
        cliente.setNome(nomeCliente);
        cliente.setEndereco(endereco);
        pv.setCliente(cliente);

        do {
            System.out.print("prod  nome: ");
            String nomeProduto = sc.nextLine();
            if( nomeProduto.equals(new String("exit" ) ) ) {
                break;
            }
            System.out.print("prod valor: ");
            float valorProduto = Float.parseFloat(sc.nextLine());
            Produto prod = new Produto();
            prod.setNome(nomeProduto);
            prod.setValor(valorProduto);

            pv.addProduto(prod);

        } while( true );

        System.out.print("num parcelas: ");
        int numeroParcelas = Integer.parseInt(sc.nextLine());

        pv.setNumParcelas(numeroParcelas);

        System.out.println(pv.toString());
    }

}
