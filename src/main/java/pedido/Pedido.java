package pedido;

import cardapio.ItensCardapio;
import java.util.ArrayList;

public class Pedido {
    private int numero;
    private String nomeCliente;
    private ArrayList <ItensCardapio> itens = new ArrayList<>();

    public Pedido(int numero, String nomeCliente){
        this.numero = numero;
        setNomeCliente (nomeCliente);
    }
    public void setNomeCliente (String nomeCliente){
        if (nomeCliente == null ||nomeCliente.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nomeCliente = nomeCliente;
    }
    public int getNumero(){
        return numero;
    }
    public String getNomeCliente(){
        return nomeCliente;
    }
    public void adicionarItem (ItensCardapio iC) {
        itens.add(iC);
    }
    public void removerItem(int indice){
        itens.remove(indice);
    }
    public void limparItens (){
        itens.clear();
    }
    public ArrayList<ItensCardapio> getItens(){
        return itens;
    }
    public double calcularTotal (){
        double total = 0;
        for (ItensCardapio iC: itens){
            total+= iC.getPreco();
        }
        return total;
    }
}
