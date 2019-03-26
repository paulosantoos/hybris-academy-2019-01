package apptestefh;

import apptestefh.Models.Order;
import apptestefh.Models.Product;
import java.util.Scanner;

/**
 *
 * @author luiss
 */
public class AppTesteFH {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Entre com o nome do cliente");
            Order order = null;
            order = new Order(scanner.nextLine());
            scanner.reset();

            // Address
            System.out.println("Entre com o endereço do cliente");
            order.setEndereco(scanner.nextLine());
            scanner.reset();

            // parcel
            boolean erroParcela = true;
            do {
                try {
                    System.out.println("Informe a quantidade de parcelas");
                    order.setQtdParcelas(Integer.parseInt(scanner.nextLine()));
                    erroParcela = false;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (erroParcela);
            scanner.reset();
            do {
                System.out.println("Informe um produto:");
                String nameProduct = scanner.nextLine();
                scanner.reset();
                if (nameProduct.equals("exit") || nameProduct.equals("EXIT")) {
                    break;
                }
                System.out.println("Informe o valor do produto " + nameProduct);
                double value = Double.parseDouble(scanner.nextLine());
                Product product = new Product(nameProduct, value);
                order.addProduct(product);
                scanner.reset();
            } while (true);
            order.calcularParcelas();
            
            System.out.println(order);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
