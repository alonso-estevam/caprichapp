package dev.aleatorio.caprichapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CaprichApp {

	public static void main(String[] args) {
		
		List<String> perguntas = new ArrayList<>();
		perguntas.add("Você já sonhou que seu melhor amigo era um unicórnio voando sobre arco-íris cor-de-rosa enquanto segurava um buquê de salsichas?");
		perguntas.add("Você já se viu dançando a dança do frango em homenagem ao aniversário do seu melhor amigo, vestida de pinguim?");
		perguntas.add("Se seu melhor amigo fosse um sorvete, ele seria o sorvete de pistache?");
		perguntas.add("Você pensa em patos de borracha quando olha para o seu melhor amigo?");
		perguntas.add("Você já escreveu um poema de amor épico para o seu melhor amigo usando apenas emojis de vegetais?");
		perguntas.add("Você acha que seu melhor amigo seria um bom companheiro numa luta contra zumbis alienígenas usando almofadas como armas?");

		System.out.println("♥♥♥♥♥♥♥♥ CAPRICHAPP ♥♥♥♥♥♥♥♥");
		System.out.println("Você está a fim do seu melhor amigo? Para cada pergunta, responda S para sim ou N para não");
		System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");
		
		int pontuacao = 0;
		
		Scanner sc = new Scanner(System.in);
		
		for (String pergunta : perguntas) {
			System.out.println(pergunta + " ");
			char resposta = sc.next().toLowerCase().charAt(0);
			if(resposta == 's') {
				pontuacao++;
			}
		}
		
		String resultado = calcularResultado(pontuacao);
		System.out.println("♥♥♥♥♥♥♥♥ RESULTADO ♥♥♥♥♥♥♥♥");
		System.out.println("Sua pontuação foi " + pontuacao + ". Isso significa que...\n" + resultado);
		sc.close();
	
	}
	
	public static String calcularResultado(int pontuacao) {
		if(pontuacao < 0) {
			throw new IllegalArgumentException("Erro: A pontuação não pode ser negativa");
		}
		if(pontuacao >= 0 && pontuacao <= 2) {
			return "☺ Você colocou seu melhor amigo na friendzone.\nO que é ótimo porque talvez ele seja apenas seu amigo.";
		} else if (pontuacao >= 3 && pontuacao <= 4) {
			return "Talvez haja amor, talvez seja hormônios.\n☻ Vale a pena experimentar uns cinco minutos de trocação de beijo sem estragar a amizade.";
		} else {
			return "🎵 É o amor /Que mexe com minha cabeça e me deixa assim/\nQue faz eu pensar em você e esquecer de mim/\nQue faz eu esquecer que a vida é feita pra viver.";
		}
	}
}

