package br.com.fiap.challenge.model;

public class Veiculo {
	
	private int id;
	private String modelo;
	private int ano;
	private double valor;
	private int heixo;
	
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) { 
		this.id = id;
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
	
	
	
}