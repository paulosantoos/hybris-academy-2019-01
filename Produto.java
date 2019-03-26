
public class Produto{

    private String nome;
    private float valor;

    public Produto() {
    }

    @Override
    public String toString() {
        return String.format("%s - R$ %2.2f", this.nome, this.valor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
