package br.com.fiap.challenge.model;

public class Cliente {
	//Encapsulamento
	private String nome;
	private int idade;
	private int codigo;
	private String endereco;
	
	//Construtor com parâmetros
	public Cliente(int codigo, String nome, int idade, String endereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
    	this.codigo = codigo;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
    //Método para exibição de informações do cliente
    public void exibirInformacoes() {
    	System.out.println("Nome: " + nome);
    	System.out.println("Idade: " + idade);
    	System.out.println("Codigo: " + codigo);
    	System.out.println("Endereco: " + endereco);
    }
}