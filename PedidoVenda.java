import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoVenda {

    private static int id=0;
    private Date date;
    private Integer numParcelas;
    Cliente cliente;

    private List<Produto> itensPedido;
    private List<Parcela> parcelas;

    @Override
    public String toString() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String s = "";
        s += "Codigo do pedido: " + this.id + '\n';
        s += "Data: " + formatter.format(this.date) + '\n';
        s += this.cliente.toString() + '\n';
        s += "Produtos\n";

        for(Produto prod : this.itensPedido)
            s += prod.toString() + '\n';
        s += "Numero parcelas: " + this.numParcelas + "\n";

        for(Parcela p : this.parcelas)
            s += p.toString() + '\n';

        return s;
    }

    public void addProduto(Produto prod){
        itensPedido.add(prod);
    }

    public PedidoVenda(){
        id ++;
        this.itensPedido = new ArrayList<Produto>();
        this.parcelas = new ArrayList<Parcela>();

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(Integer numParcelas) {
        this.numParcelas = numParcelas;

        float valor = (float) itensPedido.stream().mapToDouble(Produto::getValor).sum() / this.numParcelas;

        for(int i = 0; i < this.numParcelas; i++){
            Parcela p = new Parcela();
            p.setValor(valor);
            p.setVencimento(date, i);
            parcelas.add(p);
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


}
