package dev.aleatorio.caprichapp.model;

import java.util.ArrayList;
import java.util.List;

public class Enquete {
	private String titulo;
	private int numeroDePerguntas;
	private List<Pergunta> perguntas = new ArrayList<Pergunta>();
		
	public Enquete() {
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
		return perguntas;
	}
	public void adicionarPergunta(Pergunta pergunta) {
		this.perguntas.add(pergunta);
	}
	
	
}