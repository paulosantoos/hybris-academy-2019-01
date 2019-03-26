import com.sun.org.apache.bcel.internal.classfile.Unknown;

import javax.swing.*;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private Scanner scanner;
    private Cliente cli;
    private Produto produto;
    private Pedido pedido;

    public static void main(String[] args) {
        Main main = new Main();
    }

    public Main(){

        cli = new Cliente();
        pedido = new Pedido();
        scanner = new Scanner(System.in);

        leitura();
        apresenta();
    }

    public void leitura(){

        System.out.print("Digite nome: ");
        cli.setNome(scanner.nextLine());

        System.out.print("Digite Endereco: ");
        cli.setAddress(scanner.nextLine());

        pedido.setCliente(cli);

        String p = "";
        Double v;

        int i = 1;
        boolean success = false;

        while(!p.equals("sair")){
            //while(!success) {
                try {
                    System.out.print("#" + i + "Produto: ");
                    p = scanner.nextLine();

                    if(!p.equals("sair")){
                        //success = true;
                        System.out.print("#" + i + "Valor: ");
                        v = Double.parseDouble(scanner.nextLine());
                        pedido.addCarrinho(p, v);
                    }
                    i++;
                } catch (Exception e) {
                    System.out.println("Inserir formato numerico");
                }
            }
        //}

        System.out.print("Parcelas: ");
        pedido.setParcelas(scanner.nextInt());
    }

    public void apresenta(){

        //System.out.println(dateString);
        System.out.println("------------PRODUTOS----------------");
        System.out.println("Codigo do pedido:" + 1);
        System.out.println("Data: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        System.out.println("Cliente: " + cli.getNome());
        System.out.println("Endereco: " +cli.getAddress());

        //imprime produtos do pedido
        System.out.println("------------PAGAMENTO----------------");
        pedido.impcarrinhoProd();
    }
}
