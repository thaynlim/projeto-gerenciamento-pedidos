package pedido;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import cardapio.ItensCardapio;

public class GerenciarPedidos {

    private HashMap<Integer, Pedido> pedidos = new HashMap<>();
    private int contadorPedidos = 1;

    public Pedido criarPedido(String nomeCliente) {
        Pedido novo = new Pedido(contadorPedidos, nomeCliente);
        pedidos.put(novo.getNumero(), novo);
        contadorPedidos++;
        return novo;
    }

    public Pedido buscarPedido(int numero) {
        if (pedidos.containsKey(numero)) {
            return pedidos.get(numero);
        }
        return null;
    }

    public boolean cancelarPedido(int numero) {
        if (pedidos.containsKey(numero)) {
            pedidos.remove(numero);
            return true;
        }
        return false;
    }

    public double calcularTotalDoDia() {
        double total = 0;

        for (Pedido pedido : pedidos.values()) {
            total += pedido.calcularTotal();
        }

        return total;
    }

    public Collection<Pedido> getPedidos() {
        return pedidos.values();
    }

    public HashSet<String> getCombinacoesDiferentes() {
        HashSet<String> combinacoes = new HashSet<>();

        for (Pedido pedido : pedidos.values()) {
            for (ItensCardapio item : pedido.getItens()) {
                combinacoes.add(item.getDescricao());
            }
        }

        return combinacoes;
    }
}