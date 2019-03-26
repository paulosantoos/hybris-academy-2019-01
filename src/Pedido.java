
import java.math.BigDecimal;
import java.text.*;
import java.util.*;

public class Pedido {

    private Cliente cliente;
    private ArrayList<Produto> carrinhoProd;
    private int parcelas;
    private Date data;

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int p) {
        parcelas = p;
    }

    public void setcarrinhoProd(ArrayList<Produto> car) {
        carrinhoProd = car;
    }

    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    ///PRODUTO

    public Pedido(){
        carrinhoProd = new ArrayList<>();
    }

    public void setCliente(Cliente c) {
        cliente = c;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void addCarrinho(String nome, Double valor){
        carrinhoProd.add(new Produto(nome, valor));
    }

    public String parc(String vlrParcela){

        Calendar calen = Calendar.getInstance();
        calen.setTime(new Date());

        String s = "";
        System.out.println("---------------//------------------");

            for (int i = 0; i< getParcelas();i++){
                calen.add(Calendar.DATE, 30);
                String dateString = format.format(calen.getTime());
                s += "Parcela " + (i+1) + ": " + dateString + " - " +  vlrParcela  + "\n";
            }
        return s;
    }

    public String moeda(Double vlr){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return nf.format(new BigDecimal(vlr));
    }

    public void impcarrinhoProd() {
        Double total = 0.0;
        System.out.println("---------------//------------------");
        for (int i = 0; i < carrinhoProd.size(); i++) {
            System.out.println("#" + (i + 1) + " "+ carrinhoProd.get(i).getNome() + " : " + moeda(carrinhoProd.get(i).getValor()));
            total = total + carrinhoProd.get(i).getValor();
        }

        System.out.println(parc(moeda(total/getParcelas())));
        System.out.println("Total do Pedido : " + moeda(total));
    }










}
