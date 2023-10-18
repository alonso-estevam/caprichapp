package dev.aleatorio.caprichapp.model;

import java.util.ArrayList;
import java.util.List;

public class Questionario {
	
	private int id;
	private String titulo;
	private int numeroDePerguntas;
	private List<Pergunta> perguntas = new ArrayList<Pergunta>();
	private List<FaixaDeValores> faixasDeValores = new ArrayList<>();
		
	public Questionario() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getNumeroDePerguntas() {
		return numeroDePerguntas;
	}
	
	public void setNumeroDePerguntas(int numeroDePerguntas) {
		this.numeroDePerguntas = numeroDePerguntas;
	}
	
	public List<Pergunta> getPerguntas() {
		return this.perguntas;
	}
	
	public void adicionarPergunta(Pergunta pergunta) {
		this.perguntas.add(pergunta);
	}
	
	public List<FaixaDeValores> getFaixaDeValores() {
		return this.faixasDeValores;
	}
	
	public void adicionarFaixaDeValores(FaixaDeValores faixa) {
		this.faixasDeValores.add(faixa);
	}
	
	public String calcularResultado(int pontuacao) {
		String resposta = "";
		if(pontuacao < 0) {
			throw new IllegalArgumentException("Erro: A pontuação não pode ser negativa");
		}
		
		for (int i = 0; i < faixasDeValores.size(); i++) {
			if(pontuacao >= faixasDeValores.get(i).getMinimo() 
					&& pontuacao <= faixasDeValores.get(i).getMaximo()) {
				resposta = faixasDeValores.get(i).getResposta();
			}
		}
		return resposta;
	}
}