package dev.aleatorio.caprichapp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import dev.aleatorio.caprichapp.model.Enquete;
import dev.aleatorio.caprichapp.model.Opcao;
import dev.aleatorio.caprichapp.model.Pergunta;

public class CaprichApp {

	public static void main(String[] args) {
		
		Enquete enquete = new Enquete();
		Scanner sc = new Scanner(System.in);

		System.out.println("♥♥♥♥♥♥♥♥ CAPRICHAPP ENQUETES ♥♥♥♥♥♥♥♥");

//		Fase 0) O programa perguntará qual é o título do questionário.
		System.out.print("\nQual o título do questionário? ");
		enquete.setTitulo(sc.nextLine());
		
//		Fase 1) O programa perguntará quantas perguntas você deseja fazer.
		System.out.print("Quantas perguntas você deseja fazer? ");
		enquete.setNumeroDePerguntas(Integer.valueOf(sc.nextLine()));
		
		for (int i = 1; i <= enquete.getNumeroDePerguntas(); i++) {
			System.out.printf("===============\nDigite a %dº pergunta: \n", i);
			String enunciado = sc.nextLine();
			Pergunta pergunta = new Pergunta(enunciado);
			
//		Fase 2) Para cada pergunta, o programa perguntará quais são as opções 
//		e o peso da resposta de cada uma delas.
			System.out.print("Digite o número de opções: \n");
			int numeroDeOpcoes = Integer.valueOf(sc.nextLine());
			
			for (int j = 1; j <= numeroDeOpcoes; j++) {
				System.out.printf("Digite o texto da %dº opção: \n", j);
				String texto = sc.nextLine();
				System.out.printf("Digite o peso da %dº opção: \n", j);
				int peso = Integer.valueOf(sc.nextLine());
				pergunta.adicionarOpcao(new Opcao (texto, peso));
			}
			
			enquete.adicionarPergunta(pergunta);
		}
		
//		Fase 3) Em seguida, o programa perguntará quais são as respostas 
//		e quais são as faixas de valores utilizadas.

//		Fase 4) Por fim, o programa realizará a enquete ao usuário, usando como entrada os dados fornecidos nas etapas anteriores e respondendo ao que foi perguntado.
		enquete.getPerguntas().forEach(System.out::println);
		
		int pontuacao = 0;
		
//		Set<String> perguntasSelecionadas = obterPerguntasAleatorias(bancoDePerguntas);		
		
//		for (String pergunta : perguntasSelecionadas) {
//			System.out.println(pergunta + " ");
//			char resposta = sc.next().toLowerCase().charAt(0);
//			if(resposta == 's') {
//				pontuacao++;
//			}
//		}
		
//		String resultado = calcularResultado(pontuacao);
//		System.out.println("♥♥♥♥♥♥♥♥ RESULTADO ♥♥♥♥♥♥♥♥");
//		System.out.println("Sua pontuação foi " + pontuacao + ". Isso significa que...\n" + resultado);
//		sc.close();
	
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

