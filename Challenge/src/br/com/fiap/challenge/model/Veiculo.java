package br.com.fiap.challenge.model;

public class Veiculo {
	
	private String modelo;
	private int ano;
	private double valor;
	private int rodas;
	private int codigo;
	
	public Veiculo(String modelo, int ano, double valor, int rodas, int codigo) {
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
		this.rodas = rodas;
		this.codigo = codigo;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public int getRodas() {
		return rodas;
	}
	public void setRodas(int heixo) {
		this.rodas = heixo;
	}
	
	public double calcularSeguro() {
		return this.valor * ((0.25 * this.rodas));
		
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	//Método para exibição de informações do cliente
    public void exibirInformacoesVeiculo() {
    	System.out.println("Modelo: " + modelo);
    	System.out.println("Ano: " + ano);
    	System.out.println("Valor: " + valor);
    	System.out.println("Rodas:" + rodas);
    	System.out.println("Codigo: " + codigo);
    }
	
}