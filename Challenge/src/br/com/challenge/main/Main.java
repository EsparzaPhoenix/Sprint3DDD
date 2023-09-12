package br.com.challenge.main;

import br.com.fiap.challenge.dao.ClienteDao;
import br.com.fiap.challenge.dao.VeiculoDao;
import br.com.fiap.challenge.model.Cliente;
import br.com.fiap.challenge.model.Veiculo;
import java.util.Scanner;

public class Main {

	private static VeiculoDao veiculoDao = new VeiculoDao();
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
            System.out.println("5. Gerenciar Veiculos");
            System.out.println("6. Encerrar Programa");
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
            		opcaoB();
            	case 6:
            		continuar = false;
            		break;	
            	default:
            		System.out.println("Opção invalida");
            }
    	}
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
    
    private static void opcaoB() {
    	boolean continuarOpcaoB = true;
    	
    	while (continuarOpcaoB) {
    		System.out.println("Menu:");
            System.out.println("1. Cadastrar Veiculo");
            System.out.println("2. Atualizar Veiculo");
            System.out.println("3. Listar Veiculo");
            System.out.println("4. Remover Veiculo");
            System.out.println("5. Encerrar processo");
            System.out.print("Escolha uma opção: ");
            
            int opcaoB = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcaoB) {
            	case 1:
            		cadastrarVeiculo();
            		break;
            	case 2:
            		atualizarVeiculo();
            		break;
            	case 3:
            		listarVeiculos();
            		break;
            	case 4:
            		removerVeiculo();
            		break;
            	case 5:
            		continuarOpcaoB = false;
            		break;	
            	default:
            		System.out.println("Opção invalida");
            }
    	}
    	
    	System.out.print("encerrando programa");
    }
    
    private static void cadastrarVeiculo() {
    	System.out.print("Digite o modelo do veiculo: ");
    	String modelo = scanner.nextLine();
    	System.out.print("Digite o ano do veiculo: ");
    	int ano = scanner.nextInt();
    	System.out.print("digite o valor do veiculo: ");
    	double valor = scanner.nextDouble();
    	System.out.print("digite o numero de Rodas: ");
    	int rodas = scanner.nextInt();
    	
    	Veiculo veiculo = new Veiculo(modelo, ano, valor, rodas, 0);
    	veiculoDao.cadastrarVeiculo(veiculo);
    	System.out.println("Veiculo Cadastrado com sucesso. \n");
    } 
    
    private static void atualizarVeiculo() {
    	System.out.println("digite o codigo do Veiculo cadastrado a ser atualizado: ");
    	int codigo = scanner.nextInt();
    	scanner.nextLine();
    	
    	Veiculo veiculoAtual = veiculoDao.pequisarPorCodigoVeiculo(codigo);
    	if (veiculoAtual != null) {
    		System.out.println("Digite o novo modelo: ");
    		String modelo = scanner.nextLine();
    		System.out.println("Digite o novo ano: ");
    		int ano = scanner.nextInt();
    		System.out.println("Digite o novo valor do veiculo: ");
    		double valor = scanner.nextDouble();
    		System.out.println("Digite o novo numero de Rodas: ");
    		int rodas = scanner.nextInt();
    		
    		Veiculo veiculoAtualizado = new Veiculo(modelo, ano, valor, rodas, 0);
    		veiculoDao.editarVeiculo(veiculoAtualizado);
    		System.out.println("Veiculo atualizado com sucesso. \n");
    	} else {
    		System.out.println("Veiculo nao encontrado \n");
    	}
    }
    
    private static void listarVeiculos() {
    	System.out.println("Veiculos cadastrados \n");
    	for (Veiculo veiculo : veiculoDao.listarVeiculos()) {
    		veiculo.exibirInformacoesVeiculo();
    		System.out.println();
    	}
    }
    
    private static void removerVeiculo() {
    	System.out.println("Digite o codigo do veiculo a ser removido");
    	int codigo = scanner.nextInt();
    	scanner.nextLine();
    	
    	veiculoDao.removerVeiculo(codigo);
    	System.out.println("Veiculo removido com sucesso. \n");
    }
}