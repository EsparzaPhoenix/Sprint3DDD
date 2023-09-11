package br.com.fiap.challenge.model;

public class Veiculo {
	
	private String modelo;
	private int ano;
	private double valor;
	private int heixo;
	private int codigo;
	
	public Veiculo(String modelo, int ano, double valor, int heixo, int codigo) {
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
		this.heixo = heixo;
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
	
	public int getHeixo() {
		return heixo;
	}
	public void setHeixo(int heixo) {
		this.heixo = heixo;
	}
	
	public double calcularSeguro() {
		return this.valor * ((0.25 * this.heixo));
		
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
    	System.out.println("Heixo:" + heixo);
    	System.out.println("Codigo: " + codigo);
    }
	
}