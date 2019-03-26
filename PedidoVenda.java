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
        String s = "";
        s += "Codigo do pedido: " + this.id + '\n';
        s += "Data: " + this.date + '\n';
        s += this.cliente.toString() + '\n';
        s += "Produtos\n";
        for(Produto prod : this.itensPedido)
            s += prod.toString() + '\n';
        s += "Numero parcelas: " + this.numParcelas + "\n";

        return s;
    }

    public void addProduto(Produto prod){
        itensPedido.add(prod);
    }

    public PedidoVenda(){
        id ++;
        this.itensPedido = new ArrayList<Produto>();
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
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


}
