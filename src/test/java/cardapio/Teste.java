package cardapio;

import cardapio.ComCheddar;
import cardapio.ComBaconExtra;
import cardapio.ItensCardapio;
import cardapio.Lanche;
import cardapio.LancheFactory;
import pedido.Pedido;
import pedido.GerenciarPedidos;
import aplicativo.RestauranteFacade;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Teste {

    @Test
    void naoAceitaPrecoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Lanche("X-Burger", -10.00);
        });
    }

    @Test
    void factoryCriaLancheCorretamente() {
        Lanche lanche = LancheFactory.xBurger();

        assertEquals("X-Burger", lanche.getNome());
        assertEquals(16.00, lanche.getPreco(), 0.001);
    }

    @Test
    void xBaconComCheddarCusta26() {
        ItensCardapio lanche =
                new ComCheddar(LancheFactory.xBacon());

        assertEquals(26.00, lanche.getPreco(), 0.001);
    }

    @Test
    void xBaconComBaconExtraCusta28() {
        ItensCardapio lanche =
                new ComBaconExtra(LancheFactory.xBacon());

        assertEquals(28.00, lanche.getPreco(), 0.001);
    }

    @Test
    void permiteDoisAdicionais() {
        ItensCardapio lanche =
                new ComCheddar(
                        new ComBaconExtra(LancheFactory.xBacon())
                );

        assertEquals(32.00, lanche.getPreco(), 0.001);
    }

    @Test
    void adicionaItemECalculaPedido() {
        Pedido pedido = new Pedido(1, "Maria");

        pedido.adicionarItem(LancheFactory.xBurger());
        pedido.adicionarItem(LancheFactory.xBacon());

        assertEquals(38.00, pedido.calcularTotal(), 0.001);
    }

    @Test
    void removeItemDoPedido() {
        Pedido pedido = new Pedido(1, "Maria");

        pedido.adicionarItem(LancheFactory.xBurger());
        pedido.removerItem(0);

        assertEquals(0, pedido.getItens().size());
    }

    @Test
    void criaEBuscaPedido() {
        GerenciarPedidos gerenciar = new GerenciarPedidos();

        Pedido pedido = gerenciar.criarPedido("João");

        assertNotNull(gerenciar.buscarPedido(pedido.getNumero()));
    }

    @Test
    void cancelaPedido() {
        GerenciarPedidos gerenciar = new GerenciarPedidos();

        Pedido pedido = gerenciar.criarPedido("Ana");

        assertTrue(gerenciar.cancelarPedido(pedido.getNumero()));
    }

    @Test
    void facadeCriaLanche() {
        RestauranteFacade facade = new RestauranteFacade();

        ItensCardapio lanche = facade.criarLanche(1);

        assertEquals(16.00, lanche.getPreco(), 0.001);
    }
}