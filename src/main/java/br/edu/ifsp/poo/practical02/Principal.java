package br.edu.ifsp.poo.practical02;

import java.util.Scanner;

public class Principal {

    private final Scanner scanner = new Scanner(System.in);
    private  final DeclaracaoDao dao = new DeclaracaoDao();
    private static int idCount = 0;

    public static void main(String[] args) {
        Principal principal = new Principal();
        int opcao;
        do{
            opcao = principal.getOpcaoDoMenu();
            switch (opcao) {
                case 1 -> principal.adicionarDeclaracoes();
                case 2 -> principal.adicionarGasto();
                case 3 -> principal.atualizarDeclacoes();
                case 4 -> principal.atualizarGasto();
                case 5 -> principal.removerGasto();
                case 6 -> principal.calcularImposto();
                case 0 -> System.out.println("Bye bye");
                default -> System.out.println("Digite um valor válido.");
            }
        }while(opcao != 0);
    }

    private int getOpcaoDoMenu() {
        System.out.println("1 - Adicionar Declarações");
        System.out.println("2 - Adicionar Gasto");
        System.out.println("3 - Atualizar Declarações");
        System.out.println("4 - Atualizar Gasto");
        System.out.println("5 - Remover Gasto");
        System.out.println("6 - Calcular imposto");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private void adicionarDeclaracoes() {
        if(!dao.lerTodos().isEmpty()) {
            System.out.println("Já há declarações cadastradas.");
            return;
        }
        System.out.print("Ganho tributável: ");
        final double ganho = Double.parseDouble(scanner.nextLine());
        System.out.print("Valor já pago: ");
        final double valorPago = Double.parseDouble(scanner.nextLine());

        dao.salvar(new DeclaracaoCompleta(1, ganho, valorPago));
        dao.salvar(new DeclaracaoSimplificada(2, ganho, valorPago));
    }

    private void adicionarGasto() {
        final DeclaracaoCompleta completa = (DeclaracaoCompleta) dao.lerUm(1);
        if(completa == null) {
            System.out.println("Não há declaração para incluir gasto!");
            return;
        }
        final Gasto gasto = lerGastoDoConsole(++idCount);
        completa.addGasto(gasto);
        dao.editar(completa);
    }

    private Gasto lerGastoDoConsole(int newId) {
        System.out.print("CNPJ: ");
        final String cnpj = scanner.nextLine();
        System.out.print("Descrição: ");
        final String descricao = scanner.nextLine();
        System.out.print("Valor: ");
        final double valor = Double.parseDouble(scanner.nextLine());
        System.out.print("[1] Gasto Saúde | [2] Gasto Educação: ");
        final double tipo = Integer.parseInt(scanner.nextLine());
        if(tipo != 1 && tipo != 2){
            System.out.println("Valor inválido!");
            return null;
        }
        if(tipo == 1){
            System.out.print("Registro: ");
            final String registro = scanner.nextLine();
            return new GastoSaude(newId, descricao, valor, cnpj, registro);
        }else{
            System.out.print("Instituição: ");
            final String instituicao = scanner.nextLine();
            return new GastoEducacao(newId, descricao, valor, cnpj, instituicao);
        }
    }

    private void atualizarDeclacoes() {
        if(dao.lerTodos().isEmpty()){
            System.out.println("Não há declarações para editar");
            return;
        }

        System.out.print("Ganho tributável: ");
        final double ganho = Double.parseDouble(scanner.nextLine());
        System.out.print("Valor já pago: ");
        final double valorPago = Double.parseDouble(scanner.nextLine());

        dao.editar(new DeclaracaoCompleta(1, ganho, valorPago));
        dao.editar(new DeclaracaoSimplificada(2, ganho, valorPago));
    }

    private void atualizarGasto() {
        final DeclaracaoCompleta completa = (DeclaracaoCompleta) dao.lerUm(1);
        if(completa == null){
            System.out.println("Não há declaração com gasto a editar");
            return;
        }
        System.out.print("Digite o ID do gasto a atualizar: ");
        final int id = Integer.parseInt(scanner.nextLine());
        if(completa.getGasto(id) == null){
            System.out.println("Não há gasto a editar");
            return;
        }

        final Gasto gasto = lerGastoDoConsole(id);
        completa.removeGasto(gasto);
        completa.addGasto(gasto);
        dao.editar(completa);
    }

    private void removerGasto() {
        System.out.print("Digite o ID do gasto a remover: ");
        final int id = Integer.parseInt(scanner.nextLine());
        final DeclaracaoCompleta declaracao = (DeclaracaoCompleta) dao.lerUm(1);
        declaracao.removeGasto(id);
    }

    private void calcularImposto() {
        for (Declaracao declaracao : dao.lerTodos()) {
            System.out.println(declaracao);
        }
    }
}

