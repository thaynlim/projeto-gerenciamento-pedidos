package aplicativo;

import java.util.Scanner;
import pedido.Pedido;
import java.util.Collection;
import java.util.HashSet;
import java.util.InputMismatchException;

public class MenuConsole {

    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("\n=== RESTAURANTE ===");
        System.out.println("1. Novo Pedido");
        System.out.println("2. Listar pedidos do dia");
        System.out.println("3. Fechamento do dia");
        System.out.println("4. Modificar pedido");
        System.out.println("0. Sair");
    }

    public int lerOpcao() {
        while (true) {
            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();
                return opcao;

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite apenas números.");
                scanner.nextLine();
                System.out.println("Tente novamente: ");
            }
        }
    }

    public String lerNomeCliente() {
        System.out.println("Digite o nome do cliente: ");
        return scanner.nextLine();
    }

    public int lerNumeroDoPedido() {
        System.out.println("Digite o número do pedido: ");
        return lerOpcao();
    }

    public void exibirOpcoesModificacao() {
        System.out.println("\n=== MODIFICAR PEDIDO ===");
        System.out.println("1. Acrescentar item");
        System.out.println("2. Remover item");
        System.out.println("3. Cancelar pedido");
        System.out.println("0. Voltar");
    }

    public int lerOpcaoModificacao() {
        System.out.println("Escolha uma opção: ");
        return lerOpcao();
    }

    public void exibirCardapio() {
        System.out.println("\n=== CARDÁPIO ===");
        System.out.println("1. X-Burger - R$ 16,00");
        System.out.println("2. X-Salada - R$ 18,00");
        System.out.println("3. X-Bacon - R$ 22,00");
    }

    public int lerOpcaoLanche() {
        System.out.println("Escolha um lanche: ");
        return lerOpcao();
    }

    public void exibirPersonalizacao() {
        System.out.println("\n=== PERSONALIZE SEU LANCHE ===");
        System.out.println("Deseja retirar algum ingrediente?");
        System.out.println("1. Retirar queijo");
        System.out.println("2. Retirar alface");
        System.out.println("3. Retirar tomate");
        System.out.println("4. Retirar cebola");
        System.out.println("0. Não retirar nenhum ingrediente");
    }

    public int lerOpcaoPersonalizacao() {
        System.out.println("Escolha uma opção: ");
        return lerOpcao();
    }

    public boolean desejaRetirarMaisIngrediente() {
        System.out.println("Deseja retirar outro ingrediente? (s/n)");
        String resposta = scanner.nextLine();
        return resposta.equalsIgnoreCase("s");
    }

    public void exibirAdicionais() {
        System.out.println("\n=== ADICIONAIS ===");
        System.out.println("1. Cheddar - R$ 4,00");
        System.out.println("2. Bacon extra - R$ 6,00");
        System.out.println("0. Nenhum adicional");
    }

    public int lerOpcaoAdicional() {
        System.out.println("Escolha um adicional: ");
        return lerOpcao();
    }

    public boolean desejaAdicionarItem() {
        System.out.println("Deseja adicionar mais algum lanche? (s/n)");
        String resposta = scanner.nextLine();
        return resposta.equalsIgnoreCase("s");
    }

    public void exibirItensNumerados(Pedido pedido) {
        System.out.println("\n=== ITENS DO PEDIDO ===");

        for (int i = 0; i < pedido.getItens().size(); i++) {
            System.out.println(
                    (i + 1) + ". " +
                            pedido.getItens().get(i).getDescricao() +
                            " R$ " +
                            pedido.getItens().get(i).getPreco()
            );
        }
    }

    public int lerNumeroItem() {
        System.out.println("Digite o número do item que deseja remover: ");
        return lerOpcao();
    }

    public void exibirPedido(Pedido pedido) {
        System.out.println("\n=== PEDIDO ===");
        System.out.println("Número: " + pedido.getNumero());
        System.out.println("Cliente: " + pedido.getNomeCliente());
        System.out.println("Itens:");

        pedido.getItens().forEach(iC -> {
            System.out.println(iC.getDescricao() + " R$ " + iC.getPreco());
        });

        System.out.println("Total: R$ " + pedido.calcularTotal());
    }

    public void exibirPedidos(Collection<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado.");
            return;
        }

        for (Pedido pedido : pedidos) {
            exibirPedido(pedido);
        }
    }

    public void exibirFechamentoDoDia(double total) {
        System.out.println("\n=== FECHAMENTO DO DIA ===");
        System.out.println("Total arrecadado: R$ " + total);
    }

    public void exibirCombinacoesDiferentes(HashSet<String> combinacoes) {
        System.out.println("\n=== COMBINAÇÕES DIFERENTES ===");
        System.out.println("Quantidade: " + combinacoes.size());

        for (String combinacao : combinacoes) {
            System.out.println(combinacao);
        }
    }

    public void exibirPedidoNaoEncontrado() {
        System.out.println("Pedido não encontrado!");
    }

    public void exibirMensagemOperacaoConcluida() {
        System.out.println("Operação realizada com sucesso!");
    }

    public void exibirMensagemOpcaoInvalida() {
        System.out.println("Opção inválida! Tente novamente.");
    }

    public void exibirMensagemDeSaida() {
        System.out.println("Pedidos encerrados, até logo!");
    }
}