package atividade04;

import java.util.Scanner;

public class Main {

    public static Scanner leitor = new Scanner(System.in);
    public static Scanner leitorS = new Scanner(System.in);
    
    public static Agenda agenda = new Agenda(19);
    
    public static void main(String[] args) {

        int opcao;
        
        do {
            limparConsole();
            cabecalho();
            
            System.out.println("1- Adicionar contato");
            System.out.println("2- Remover contato");
            System.out.println("3- Buscar contato");
            System.out.println("4- Listar contatos");
            System.out.println("5- Sair");
            
            System.out.print("\nEscolha uma opção: ");
            opcao = leitor.nextInt();

            try {
                switch(opcao) {
                    case 1:
                        adicionarContato();
                        pausarConsole();
                        break;
                    case 2:
                        removerContato();
                        pausarConsole();
                        break;
                    case 3:
                        buscarContato();
                        pausarConsole();
                        break;
                    case 4:
                        listarContatos();
                        pausarConsole();
                        break;
                    case 5:
                        rodape();
                        break;
                    default:
                        System.out.println("\nDIGITE UMA OPÇÃO VÁLIDA!");
                        pausarConsole();
                        break;
                }
            } catch(Exception e) {
                System.out.println(e.getMessage());
                pausarConsole();
            }
        } while(opcao != 5);
        
    }

    public static void cabecalho() {
        System.out.println("==================");
        System.out.println("AGENDA DE CONTATOS");
        System.out.println("==================");
    }

    public static void rodape() {
        System.out.println("\n==================");
        System.out.println("PROGRAMA ENCERRADO");
        System.out.println("==================");
    }

    public static void limparConsole() {
        System.out.print("\033[H\033[2J");
		System.out.flush();
    }

    public static void pausarConsole() {
        System.out.print("\nPressione Enter para continuar...");
		leitorS.nextLine();
    }

    public static void adicionarContato() throws Exception {
        System.out.println("\nADICIONANDO CONTATO...");
        System.out.print("Digite o nome: ");
        String nomeAux = leitorS.nextLine();
        System.out.print("Digite o e-mail: ");
        String emailAux = leitorS.nextLine();
        System.out.print("Digite o telefone: ");
        long foneAux = leitor.nextLong();

        Pessoa p = new Pessoa(nomeAux, emailAux, foneAux);
        
        try {
            agenda.adicionarContato(p);
            System.out.println("\n" + p.getNome().toUpperCase() + " ADICIONADO(A) NA AGENDA!");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void removerContato() throws Exception {
        System.out.println("\nREMOVENDO CONTATO...");
        System.out.print("Digite o telefone: ");
        long foneAux = leitor.nextLong();

        Pessoa p = agenda.buscarContato(new Pessoa("", "", foneAux));
        
        agenda.removerContato(p);
        System.out.println("\n" + p.getNome().toUpperCase() + " REMOVIDO(A) DA AGENDA!");
    }

    public static void buscarContato() throws Exception {
        System.out.println("\nBUSCANDO CONTATO...");
        System.out.print("Digite o telefone: ");
        long foneAux = leitor.nextLong();

        Pessoa p = agenda.buscarContato(new Pessoa("", "", foneAux));
        System.out.println(p.toString());
    }

    public static void listarContatos() {
        System.out.println("\nTODOS OS CONTATOS:");
        System.out.print(agenda.listarContatos());
    }

}
