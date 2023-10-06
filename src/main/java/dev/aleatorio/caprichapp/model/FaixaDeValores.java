package dev.aleatorio.caprichapp.model;

public class FaixaDeValores {
	private int minimo;
	private int maximo;
	private String resposta;
	
	public FaixaDeValores() {
	}

	public FaixaDeValores(int minimo, int maximo, String resposta) {
		this.minimo = minimo;
		this.maximo = maximo;
		this.resposta = resposta;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	@Override
	public String toString() {
		return "FaixaDeValor [minimo=" + minimo + ", maximo=" + maximo + ", resposta=" + resposta + "]";
	}

}
