package dev.aleatorio.caprichapp.model;

import java.util.ArrayList;
import java.util.List;

public class Pergunta {
	private String enunciado;
	private List<Opcao> opcoes = new ArrayList<>();

	public Pergunta() {
	}

	public Pergunta(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public List<Opcao> getOpcoes() {
		return this.opcoes;
	}

	public void adicionarOpcao(Opcao opcao) {
		this.opcoes.add(opcao);
	}

	public void exibirOpcoes() {
		int i = 65;
		for (int index = 0; index < opcoes.size(); i++, index++) {
			char letra = (char) i;
			System.out.println("Opção " + letra + ": " + opcoes.get(index).getTexto());
		}
	}

	@Override
	public String toString() {
		return "Pergunta [enunciado=" + enunciado + ", opcoes=" + opcoes + "]";
	}

}
