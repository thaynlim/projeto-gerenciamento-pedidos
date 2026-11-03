package aplicativo;
import cardapio.LancheFactory;
import pedido.Pedido;
import pedido.GerenciarPedidos;
import java.util.Collection;
import java.util.HashSet;
import cardapio.ComBaconExtra;
import cardapio.ComCheddar;
import cardapio.ItensCardapio;

public class RestauranteFacade {
    private GerenciarPedidos gerenciar = new GerenciarPedidos();

    public Pedido criarPedido(String nomeCliente) {
        return gerenciar.criarPedido(nomeCliente);
    }
    public ItensCardapio criarLanche(int opcao){
        switch(opcao){
            case 1:
                return LancheFactory.xBurger();
            case 2:
                return LancheFactory.xSalada();
            case 3:
                return LancheFactory.xBacon();
            default:
                throw new IllegalArgumentException("Opção de lanche inválida");
        }
    }
    public ItensCardapio adicionarAdicional(ItensCardapio iC, int opcao) {

        switch (opcao) {
            case 1:
                return new ComCheddar(iC);
            case 2:
                return new ComBaconExtra(iC);
            default:
                throw new IllegalArgumentException("Adicional inválido");
        }
    }
    public void adicionarItem (Pedido pedido, ItensCardapio iC){
        pedido.adicionarItem(iC);
    }
    public void removerItem (Pedido pedido, int indice){
        pedido.removerItem(indice);
    }
    public Pedido buscarPedido(int numero) {
        return gerenciar.buscarPedido(numero);
    }
    public boolean cancelarPedido(int numero){
        return gerenciar.cancelarPedido(numero);
    }
    public Collection<Pedido> listarPedidos() {
        return gerenciar.getPedidos();
    }
    public double calcularTotalDoDia() {
        return gerenciar.calcularTotalDoDia();
    }
    public HashSet<String> getCombinacoesDiferentes() {
        return gerenciar.getCombinacoesDiferentes();
    }
}

