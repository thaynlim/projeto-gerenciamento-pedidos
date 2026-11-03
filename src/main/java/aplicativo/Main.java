package aplicativo;

import cardapio.Lanche;
import pedido.Pedido;
import cardapio.ItensCardapio;

import java.util.HashSet;

public class Main {

    static void main() {
        MenuConsole menu = new MenuConsole();
        RestauranteFacade rf = new RestauranteFacade();
        boolean continuar = true;

        while (continuar) {
            menu.exibirMenu();
            int opcao = menu.lerOpcao();
            switch (opcao) {
                case 1:
                    String nomeCliente = menu.lerNomeCliente();
                    Pedido pedido = rf.criarPedido(nomeCliente);
                    boolean adicionar = true;
                    while (adicionar) {
                        int opcaoLanche;

                        do {
                            menu.exibirCardapio();
                            opcaoLanche = menu.lerOpcaoLanche();

                            if (opcaoLanche < 1 || opcaoLanche > 3) {
                                menu.exibirMensagemOpcaoInvalida();
                            }

                        } while (opcaoLanche < 1 || opcaoLanche > 3);

                        Lanche lanche = (Lanche) rf.criarLanche(opcaoLanche);

                        boolean retirarMais = true;

                        while (retirarMais) {
                            menu.exibirPersonalizacao();
                            int opcaoPersonalizacao = menu.lerOpcaoPersonalizacao();

                            switch (opcaoPersonalizacao) {
                                case 1:
                                    lanche.setQueijo(false);
                                    break;

                                case 2:
                                    lanche.setAlface(false);
                                    break;

                                case 3:
                                    lanche.setTomate(false);
                                    break;

                                case 4:
                                    lanche.setCebola(false);
                                    break;

                                case 0:
                                    retirarMais = false;
                                    break;

                                default:
                                    menu.exibirMensagemOpcaoInvalida();
                                    continue;
                            }

                            if (opcaoPersonalizacao != 0) {
                                retirarMais = menu.desejaRetirarMaisIngrediente();
                            }
                        }

                        ItensCardapio iC = lanche;
                        boolean adicionarAdicional = true;

                        while (adicionarAdicional) {
                            menu.exibirAdicionais();
                            int opcaoAdicional = menu.lerOpcaoAdicional();

                            if (opcaoAdicional == 0) {
                                adicionarAdicional = false;
                            } else if (opcaoAdicional == 1 || opcaoAdicional == 2) {
                                iC = rf.adicionarAdicional(iC, opcaoAdicional);
                            } else {
                                menu.exibirMensagemOpcaoInvalida();
                            }
                        }

                        rf.adicionarItem(pedido, iC);
                        adicionar = menu.desejaAdicionarItem();
                    }

                    menu.exibirPedido(pedido);
                    break;

                case 2:
                    menu.exibirPedidos(rf.listarPedidos());
                    break;

                case 3:
                    double total = rf.calcularTotalDoDia();
                    menu.exibirFechamentoDoDia(total);

                    HashSet<String> combinacoes = rf.getCombinacoesDiferentes();
                    menu.exibirCombinacoesDiferentes(combinacoes);

                    continuar = false;
                    break;

                case 4:
                    int numeroPedido = menu.lerNumeroDoPedido();
                    Pedido pedidoModificar = rf.buscarPedido(numeroPedido);

                    if (pedidoModificar == null) {
                        menu.exibirPedidoNaoEncontrado();
                        break;
                    }

                    menu.exibirPedido(pedidoModificar);
                    menu.exibirOpcoesModificacao();

                    int opcaoModificacao = menu.lerOpcaoModificacao();

                    switch (opcaoModificacao) {

                        case 1:
                            // Acrescentar um item
                            int novoLanche;

                            do {
                                menu.exibirCardapio();
                                novoLanche = menu.lerOpcaoLanche();

                                if (novoLanche < 1 || novoLanche > 3) {
                                    menu.exibirMensagemOpcaoInvalida();
                                }

                            } while (novoLanche < 1 || novoLanche > 3);

                            Lanche lancheNovo = (Lanche) rf.criarLanche(novoLanche);

                            boolean retirarIngredientes = true;

                            while (retirarIngredientes) {
                                menu.exibirPersonalizacao();
                                int opcaoRetirada = menu.lerOpcaoPersonalizacao();

                                switch (opcaoRetirada) {
                                    case 1:
                                        lancheNovo.setQueijo(false);
                                        break;

                                    case 2:
                                        lancheNovo.setAlface(false);
                                        break;

                                    case 3:
                                        lancheNovo.setTomate(false);
                                        break;

                                    case 4:
                                        lancheNovo.setCebola(false);
                                        break;

                                    case 0:
                                        retirarIngredientes = false;
                                        break;

                                    default:
                                        menu.exibirMensagemOpcaoInvalida();
                                        continue;
                                }

                                if (opcaoRetirada != 0) {
                                    retirarIngredientes = menu.desejaRetirarMaisIngrediente();
                                }
                            }

                            ItensCardapio novoItem = lancheNovo;
                            boolean adicionarNovoAdicional = true;

                            while (adicionarNovoAdicional) {
                                menu.exibirAdicionais();
                                int opcaoNovoAdicional = menu.lerOpcaoAdicional();

                                if (opcaoNovoAdicional == 0) {
                                    adicionarNovoAdicional = false;
                                } else if (opcaoNovoAdicional == 1 || opcaoNovoAdicional == 2) {
                                    novoItem = rf.adicionarAdicional(novoItem, opcaoNovoAdicional);
                                } else {
                                    menu.exibirMensagemOpcaoInvalida();
                                }
                            }

                            rf.adicionarItem(pedidoModificar, novoItem);
                            menu.exibirMensagemOperacaoConcluida();
                            menu.exibirPedido(pedidoModificar);
                            break;

                        case 2:
                            // Remover um item
                            if (pedidoModificar.getItens().isEmpty()) {
                                System.out.println("O pedido não possui itens.");
                                break;
                            }

                            menu.exibirItensNumerados(pedidoModificar);
                            int numeroItem = menu.lerNumeroItem();

                            if (numeroItem < 1 || numeroItem > pedidoModificar.getItens().size()) {
                                menu.exibirMensagemOpcaoInvalida();
                            } else {
                                rf.removerItem(pedidoModificar, numeroItem - 1);
                                menu.exibirMensagemOperacaoConcluida();
                                menu.exibirPedido(pedidoModificar);
                            }
                            break;

                        case 3:
                            // Cancelar pedido inteiro
                            if (rf.cancelarPedido(numeroPedido)) {
                                menu.exibirMensagemOperacaoConcluida();
                            } else {
                                menu.exibirPedidoNaoEncontrado();
                            }
                            break;

                        case 0:
                            // Voltar ao menu principal
                            break;

                        default:
                            menu.exibirMensagemOpcaoInvalida();
                            break;
                    }
                    break;

                case 0:
                    menu.exibirMensagemDeSaida();
                    continuar = false;
                    break;

                default:
                    menu.exibirMensagemOpcaoInvalida();
                    break;
            }
        }
    }
}