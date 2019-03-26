/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiahybris;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author gomes
 */
public class AcademiaHybris {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pedido p = new Pedido();
        ItemPedido itemPedido;
        Parcela parcela;
        ArrayList itensPed = new ArrayList<ItemPedido>();
        ArrayList parcelasPed = new ArrayList<Parcela>();
        
        System.out.println("Data:");
        String d = scanner.next();
        p.setData(d);
        
        System.out.println("Nome do Cliente:");
        String nc = scanner.next();
        p.setNomeCliente(nc);
        
        System.out.println("Endereco:");
        String ende = scanner.next();
        p.setEndereco(ende);
        
        String item = null;
        do{
            itemPedido = new ItemPedido();
            System.out.println("Item do pedido:");
            item = scanner.next();
            if(item.equals("exit")){
                break;
            }
            itemPedido.setProduto(item);
            System.out.println("Valor do Item:");
            Float valor = scanner.nextFloat();
            itemPedido.setValor(valor);
            itensPed.add(itemPedido);
            itemPedido = null;
        }while(!item.equals("exit"));
        
        System.out.println("Parcelas:");
        Integer qtdeParc = scanner.nextInt();
        
        Float total = (float) 0.00;
        for(int i = 0; i < itensPed.size(); i++){
            itemPedido = (ItemPedido) itensPed.get(i);
            Float val = itemPedido.getValor();
            total = total + val;
        }
        
        Float valorParcelas = total/qtdeParc;
        parcela = new Parcela();
        Date data = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(data);

        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH));
        c.set(Calendar.MONTH, c.get(Calendar.MONTH));
        c.set(Calendar.YEAR, c.get(Calendar.YEAR));

        parcela.setDataParc(new SimpleDateFormat("dd/MM/yyyy").format(c.getTime()));
        
        for(int i = 0; i< qtdeParc; i++){
            parcela = null;
            parcela = new Parcela();
            parcela.setValorParc(valorParcelas);
            c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 1);
            parcela.setDataParc(new SimpleDateFormat("dd/MM/yyyy").format(c.getTime()));
            parcelasPed.add(parcela);
        }
        
        System.out.println("Código do pedido: 1\n"
                + "Data: " + p.getData() + "\n"
                + "Cliente: " + p.getNomeCliente() + "\n"
                + "Endereco: " + p.getEndereco() + "\n"
                + "Produtos:");
                for(int i=0; i<itensPed.size(); i++){
                    itemPedido = new ItemPedido();
                    itemPedido = (ItemPedido) itensPed.get(i);
                    System.out.println(itemPedido.getProduto() + " - R$ " + itemPedido.getValor());
                }
                for(int i=0; i<parcelasPed.size(); i++){
                    parcela = new Parcela();
                    parcela = (Parcela) parcelasPed.get(i);
                    System.out.println("parcela" + (i+1) + " " + parcela.getDataParc() + " - R$ " + parcela.getValorParc());
                }
                System.out.println("Valor total: " + total);
    }
    
}
