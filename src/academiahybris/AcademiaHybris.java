/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiahybris;

import java.util.ArrayList;
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
        ItemPedido itemPedido = new ItemPedido();
        ArrayList itensPed = new ArrayList<ItemPedido>();
        
        System.out.println("Data:");
        String d = scanner.next();
        p.setData(d);
        
        System.out.println("Nome do Cliente:");
        String nc = scanner.next();
        p.setNomeCliente(nc);
        
        System.out.println("Endereco:");
        String ende = scanner.next();
        p.setEndereco(ende);
        
        System.out.println("Quantidade Itens:");
        Integer qtItem = scanner.nextInt();
        
        for(int i=0;i<qtItem;i++){
            System.out.println("Item do pedido:");
            String item = scanner.next();
            itemPedido.setProduto(item);
            System.out.println("Valor do Item:");
            Float valor = scanner.nextFloat();
            itemPedido.setValor(valor);
            itensPed.add(itemPedido);
        }
        
        System.out.println("Parcelas:");
        Integer parc = scanner.nextInt();
        p.setParcelas(parc);
        
        Float total = (float) 0.00;
        for(int i = 0; i < itensPed.size(); i++){
            itemPedido = (ItemPedido) itensPed.get(i);
            Float val = itemPedido.getValor();
            total = total + val;
        }
        Float valorParcelas = total/p.getParcelas();
        
        System.out.println("Código do pedido: 1\n"
                + "Data: " + p.getData() + "\n"
                + "Cliente: " + p.getNomeCliente() + "\n"
                + "Endereco: " + p.getEndereco() + "\n"
                + "Produtos:");
                for(int i=0; i<itensPed.size(); i++){
                    itemPedido = new ItemPedido();
                    itemPedido = (ItemPedido) itensPed.get(i);
                    System.out.println(itemPedido.getProduto() + "- R$ " + itemPedido.getValor());
                }
                System.out.println("Parcelas: " + "parcelas");
                System.out.println("Valor total: " + total);
    }
    
}
