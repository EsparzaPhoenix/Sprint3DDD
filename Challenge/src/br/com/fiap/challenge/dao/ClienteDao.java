package br.com.fiap.challenge.dao;

import br.com.fiap.challenge.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
	
	private List<Cliente> clientes;
	
	public ClienteDao() {
		clientes = new ArrayList<>();
	}
	
	public void cadastrar(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public List<Cliente> listar() {
		return clientes;
	}
	
	public Cliente pequisarPorCodigo(int codigo) {
		for (Cliente cliente : clientes) {
			if (cliente.getCodigo() == codigo) {
				return cliente;
			}
		}
		return null;
	}
	
	public void editar(Cliente clienteAtualizado) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getCodigo() == clienteAtualizado.getCodigo()) {
				clientes.set(i,  clienteAtualizado);
				break;
			}
		}
	}
	
	public void remover(int codigo) {
		Cliente clienteRemover = null;
		for (Cliente cliente : clientes) {
			if (cliente.getCodigo() == codigo) {
				clienteRemover = cliente;
				break;
			}
		}
		if (clienteRemover != null) {
            clientes.remove(clienteRemover);
		}
	}
	
	
	public static void main(String[] args) {
        ClienteDao clienteDao = new ClienteDao();

        Cliente cliente1 = new Cliente(18, "Matheus", 1, "Rua Batata");
        Cliente cliente2 = new Cliente(19, "Bruno", 2, "Rua Churros");
        
        clienteDao.cadastrar(cliente1);
        clienteDao.cadastrar(cliente2);
        
        System.out.println("Clientes cadastrados:");
        for (Cliente cliente : clienteDao.listar()) {
            cliente.exibirInformacoes();
            System.out.println();
        }
        
        Cliente clienteProcurado = clienteDao.pequisarPorCodigo(1);
        if (clienteProcurado != null) {
            System.out.println("Cliente encontrado:");
            clienteProcurado.exibirInformacoes();
        } else {
            System.out.println("Cliente não encontrado.");
        }
        
        Cliente clienteAtualizado = new Cliente(20, "Mariana", 1, "Rua Picanha");
        clienteDao.editar(clienteAtualizado);
        
        System.out.println("Clientes depois da Atualização:");
        for (Cliente cliente : clienteDao.listar()) {
            cliente.exibirInformacoes();
            System.out.println();
        }
        
        clienteDao.remover(2);

        System.out.println("Clientes após remoção:");
        for (Cliente cliente : clienteDao.listar()) {
            cliente.exibirInformacoes();
            System.out.println();
        
        }
	}
}
