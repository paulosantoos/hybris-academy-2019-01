public class Cliente {

    private String nome;
    private String endereco;

    public Cliente(){

    }

    @Override
    public String toString() {
        String s = "";
        s += "Cliente: " + this.nome + '\n';
        s += "Endereco: " + this.endereco;
        return s;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
