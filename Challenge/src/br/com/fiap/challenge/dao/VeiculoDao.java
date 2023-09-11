package br.com.fiap.challenge.dao;

import br.com.fiap.challenge.model.Veiculo;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDao {

private List<Veiculo> veiculos;
	
	public VeiculoDao() {
		veiculos = new ArrayList<>();
	}
	
	public void cadastrarVeiculo(Veiculo veiculo) {
		veiculos.add(veiculo);
	}
	
	public List<Veiculo> listarVeiculos() {
		return veiculos;
	}
	
	public Veiculo pequisarPorCodigoVeiculo(int codigo) {
		for (Veiculo veiculo : veiculos) {
			if (veiculo.getCodigo() == codigo) {
				return veiculo;
			}
		}
		return null;
	}


public void editarVeiculo(Veiculo veiculoAtualizado) {
	for (int i = 0; i < veiculos.size(); i++) {
		if (veiculos.get(i).getCodigo() == veiculoAtualizado.getCodigo()) {
			veiculos.set(i,  veiculoAtualizado);
			break;
		}
	}
}

public void removerVeiculo(int codigo) {
	Veiculo veiculoRemover = null;
	for (Veiculo veiculo : veiculos) {
		if (veiculo.getCodigo() == codigo) {
			veiculoRemover = veiculo;
			break;
		}
	}
	if (veiculoRemover != null) {
        veiculos.remove(veiculoRemover);
	}
}


public static void main(String[] args) {
    VeiculoDao veiculoDao = new VeiculoDao();

    Veiculo veiculo1 = new Veiculo("Scania", 2000, 50000, 6, 0);
    Veiculo veiculo2 = new Veiculo("uno", 2004, 15000, 4, 1);
    
    veiculoDao.cadastrarVeiculo(veiculo1);
    veiculoDao.cadastrarVeiculo(veiculo2);
    
    System.out.println("Clientes cadastrados:");
    for (Veiculo veiculo : veiculoDao.listarVeiculos()) {
        veiculo.exibirInformacoesVeiculo();
        System.out.println();
    }
    
    Veiculo veiculoProcurado = veiculoDao.pequisarPorCodigoVeiculo(1);
    if (veiculoProcurado != null) {
        System.out.println("Cliente encontrado:");
        veiculoProcurado.exibirInformacoesVeiculo();
    } else {
        System.out.println("Cliente não encontrado.");
    }
    
    Veiculo veiculoAtualizado = new Veiculo("Saveiro", 2010, 80000, 4, 0);
    veiculoDao.editarVeiculo(veiculoAtualizado);
    
    System.out.println("Veiculos depois da Atualização:");
    for (Veiculo veiculo : veiculoDao.listarVeiculos()) {
        veiculo.exibirInformacoesVeiculo();
        System.out.println();
    }
    
    veiculoDao.removerVeiculo(2);

    System.out.println("Veiculos após remoção:");
    for (Veiculo veiculo : veiculoDao.listarVeiculos()) {
        veiculo.exibirInformacoesVeiculo();
        System.out.println();
    
    }
}
}
