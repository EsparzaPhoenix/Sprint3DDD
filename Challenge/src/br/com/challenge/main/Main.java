package br.com.challenge.main;

import br.com.fiap.challenge.dao.*;
import br.com.fiap.challenge.model.*;
import java.util.Scanner;

public class Main {

	private static ClienteDao clienteDao = new ClienteDao();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) { 
    	boolean continuar = true;
    
    	while (continuar) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Atualizar Cliente");
            System.out.println("3. Listar Clientes");
            System.out.println("4. Remover Cliente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
            	case 1:
            		cadastrarCliente();
            		break;
            	case 2:
            		atualizarCliente();
            		break;
            	case 3:
            		listarClientes();
            		break;
            	case 4:
            		removerCliente();
            		break;
            	case 5:
            		continuar = false;
            		break;
            	default:
            		System.out.println("Opção invalida");
            }
    	}
    	
    	System.out.println("encerrando programa");
    }
    
    private static void cadastrarCliente() {
    	 System.out.print("Digite o nome do cliente: ");
         String nome = scanner.nextLine();
         System.out.print("Digite a idade do cliente: ");
         int idade = scanner.nextInt();
         scanner.nextLine();
         System.out.print("Digite o endereço do cliente: ");
         String endereco = scanner.nextLine();
         
         Cliente cliente = new Cliente(0, nome, idade, endereco);
         clienteDao.cadastrar(cliente);
         System.out.println("Cliente cadastrado com sucesso.");
    }
    
    private static void atualizarCliente() {
    	System.out.print("Digite o código do cliente a ser atualizado: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        
        Cliente clienteAtual = clienteDao.pequisarPorCodigo(codigo);
        if (clienteAtual != null) {
        	System.out.print("Digite o novo nome: ");
            String nome = scanner.nextLine();
            System.out.print("Digite a nova idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite o novo endereço: ");
            String endereco = scanner.nextLine();
            
            Cliente clienteAtualizado = new Cliente(codigo, nome, idade, endereco);
            clienteDao.editar(clienteAtualizado);
            System.out.println("Cliente atualizado com sucesso.");
        } else {
        	System.out.println("cliente nao encontrado");
        }
    }
    
    private static void listarClientes() {
    	System.out.println("clientes cadastrados");
    	 for (Cliente cliente : clienteDao.listar()) {
             cliente.exibirInformacoes();
             System.out.println();
         }
    }
    
    private static void removerCliente() {
    	System.out.println("digite o codigo do cliente a ser removido");
    	int codigo = scanner.nextInt();
    	scanner.nextLine();
    	
    	clienteDao.remover(codigo);
    	System.out.println("cliente removido");
    }
    
}