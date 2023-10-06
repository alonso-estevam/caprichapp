package dev.aleatorio.caprichapp.model;

public class Opcao { 
	private String texto;
	private int peso;
	
	public Opcao() {
	}
	
	public Opcao(String texto, int peso) {
		this.texto = texto;
		this.peso = peso;
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Opcao [texto=" + texto + ", peso=" + peso + "]";
	}
	

}
