import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Parcela {
    private int i = 0;
    private Date vencimento;
    private float valor;

    public  Parcela (){

    }

    @Override
    public String toString() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String s = "";
        s += "Parcela " + this.i + ": ";
        s += formatter.format(this.vencimento);
        s += String.format(" - R$ %2.2f", this.valor);
        return s;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento, int addMonth) {
        i = addMonth + 1;
        this.vencimento = this.addMonth(vencimento, i);
    }

    public Date addMonth(Date date, int i) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, i);
        return cal.getTime();
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

}
