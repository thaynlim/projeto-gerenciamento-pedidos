Sistema de Gerenciamento de Pedidos

Sobre o projeto

Este projeto consiste em um sistema de gerenciamento de pedidos para um restaurante, desenvolvido em Java. O objetivo é facilitar a criação, organização e administração dos pedidos.

Funcionalidades

Criar pedidos informando o nome do cliente.

Selecionar diferentes tipos de lanches.

Adicionar ingredientes extras, como cheddar e bacon.

Remover ingredientes.

Calcular o valor total dos pedidos.

Consultar, modificar e cancelar pedidos.

Consultar o total de vendas do dia.

Tecnologias utilizadas

Java

IntelliJ IDEA

JUnit 5 (testes, caso estejam incluídos no projeto)

Conceitos e padrões de projeto

Durante o desenvolvimento foram utilizados:

Factory: responsável pela criação dos lanches.

Decorator: permite adicionar ingredientes extras sem alterar a estrutura original do lanche.

Facade: simplifica a comunicação entre as classes do sistema.

Encapsulamento e interfaces: organização e estruturação do código.

Organização do projeto

aplicativo: contém a classe principal, o menu e a fachada do sistema.

cardapio: contém as classes relacionadas aos lanches e seus adicionais.

pedido: contém as classes responsáveis pelo gerenciamento dos pedidos.

Vídeo de apresentação

Assista à apresentação do projeto