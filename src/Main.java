
import Rhullyam.AppBundle.Client;
import Rhullyam.AppBundle.Order;
import Rhullyam.AppBundle.Product;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Main {

    private static List<Order> purchaseList = new ArrayList<>();
    private static SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");


    public static void main(String[] args) throws ParseException {

        System.out.print("\n\n-- Cadastro de Pedido --\n\n");

        if (receivesValues()) {
            printValues();
        }

    }

    private static boolean receivesValues() throws ParseException {

        Order order = new Order();
        Client client = new Client();
        Product product = new Product();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Qual a data do Pedido? \n");
        order.setDateOrder(formatDate.parse(scanner.nextLine()));
        System.out.print("Qual o nome do Cliente? \n");
        client.setName(scanner.nextLine());
        System.out.print("Qual o endereço do Cliente? \n");
        client.setAddress(scanner.nextLine());
        order.setClient(client);
        System.out.print("Qual o nome do Produto? \n");
        product.setName(scanner.nextLine());
        if (validExit(product.getName())) {
            return false;
        }
        System.out.print("Qual o valor do Produto? \n");
        product.setValor(scanner.nextDouble());
        order.setProduct(product);
        System.out.print("Quantidade de Parcelas? \n");
        order.setQuota(scanner.nextInt());
        order.setAmount(product.getValor());
        purchaseList.add(order);
        System.out.print("Deseja incluir novo Pedido? (Y/N) : ");
        String code = scanner.next();
        if (code.equalsIgnoreCase("y")) {
            System.out.print("\n\n-- Novo Pedido --\n");
            receivesValues();

        }

        return true;

    }

    private static void printValues() {

        int i = 0;
        double quotaValue;

        while (i < purchaseList.size()) {

            Order order = purchaseList.get(i);
            Client client = order.getClient();
            Product product = order.getProduct();

            quotaValue = (order.getAmount()/order.getQuota());

            System.out.print("\n\nCódigo do Pedido: " + (i+1));
            System.out.print("\nData do Pedido: " + formatDate.format(order.getDateOrder()));
            System.out.print("\nNome do Cliente: " + client.getName());
            System.out.print("\nEndereço: " + client.getAddress());
            System.out.print("\nNome do Produto: " + product.getName() + " - R$ " + product.getValor());
            System.out.print("\nParcelas: " + order.getQuota());
            for(int x = 0; x < order.getQuota(); x++) {

                String maturity = validDate(order.getDateOrder(), x);


                System.out.print("\nParcela " + (x+1) + " Vencimento: " + maturity + " R$ " + quotaValue);
            }
            System.out.print("\n\nVALOR TOTAL: " + order.getAmount());
            System.out.print("\n ------------------------------------- \n\n\n");
            i++;
        }

    }

    private static boolean validExit(String nameProduct) {

        if (nameProduct.equalsIgnoreCase("exit")) {
            System.out.print("Você digitou \"" + nameProduct + "\" e encerrou a aplicação");
            return true;
        }
        return false;
    }

    private static String validDate(Date currentDate, int x){

        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MONTH, x);
        return formatDate.format(cal.getTime());

    }


}
