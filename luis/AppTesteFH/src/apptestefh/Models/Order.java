package apptestefh.Models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author luiss
 */
public class Order {

    private static int number = 0;

    private final int orderNumber;

    private final ArrayList<Product> products;

    private final String clientName;

    private String address;

    private double total = 0;

    private int qtdParcelas = 1;

    private double valorParcela = 0;

    private final Date date;

    public Order(String clientName) {
        this.clientName = clientName;
        products = new ArrayList<>();
        this.orderNumber = ++Order.number;
        this.date = new Date();
    }

    public void calcularParcelas() throws Exception {
        if (products.isEmpty()) {
            throw new Exception("Não há nenhum produto solicitado no pedido!");
        }
        valorParcela = total / qtdParcelas;
    }

    public ArrayList<Product> getProdutos() {
        return products;
    }

    public Order addProduct(Product product) {
        this.products.add(product);
        this.total += product.getValue();
        return this;
    }

    public String getEndereco() {
        return address;
    }

    public void setEndereco(String endereco) {
        this.address = endereco;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas) throws Exception {
        if (qtdParcelas < 1) {
            throw new Exception("Quantidade de parcelas deve ser maior que um");
        }
        this.qtdParcelas = qtdParcelas;
    }

    public double getTotal() {
        return total;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Código do pedido ").append(orderNumber).append("\n")
                .append("Cliente ").append(clientName).append("\n")
                .append("Endereço ").append(clientName).append("\n")
                .append("produtos ").append(clientName).append("\n");
        for (Product product : products) {
            str.append(product);
        }
        str.append("Número de parcelas ").append(qtdParcelas).append("\n");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < qtdParcelas; i++) {
            c.add(Calendar.DATE, +30);
            str.append("Parcela ").append(i).append(" - ").append(format.format(c.getTime())).append(" - R$ ").append(valorParcela).append("\n");
        }
        str.append("Total do pedido R$ ").append(total).append("\n");
        return str.toString();
    }

}
