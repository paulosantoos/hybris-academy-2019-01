import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;


public class Produto {

    private String nomeProduto;
    private int parcelas;
    private double valor;
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public Produto(String n, Double v){
        setProduto(n, v);
    }

    public void setProduto(String n, Double v){

        valor = v;
        nomeProduto = n;
    }

    public double getValor() {
        return valor;
    }

    public String getNome() {
        return nomeProduto;
    }


}


