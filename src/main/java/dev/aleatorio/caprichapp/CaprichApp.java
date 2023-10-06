package dev.aleatorio.caprichapp;

import java.util.Scanner;

import dev.aleatorio.caprichapp.model.Enquete;
import dev.aleatorio.caprichapp.model.FaixaDeValores;
import dev.aleatorio.caprichapp.model.Opcao;
import dev.aleatorio.caprichapp.model.Pergunta;

public class CaprichApp {

	public static void main(String[] args) {
		
		Enquete enquete = new Enquete();
		Scanner sc = new Scanner(System.in);

		System.out.println("♥♥♥♥♥♥♥♥ 𝓒𝓪𝓹𝓻𝓲𝓬𝓱𝓐𝓹𝓹 ♥♥♥♥♥♥♥♥");
		System.out.println("(っ◔◡◔)っ CADASTRO DE ENQUETES");

		System.out.print("\nQual o título do questionário? ");
		enquete.setTitulo(sc.nextLine());
		
		System.out.print("Quantas perguntas você deseja fazer? ");
		enquete.setNumeroDePerguntas(Integer.valueOf(sc.nextLine()));
		
		for (int i = 1; i <= enquete.getNumeroDePerguntas(); i++) {
			System.out.printf("===============\nDigite a %dº pergunta: ", i);
			String enunciado = sc.nextLine();
			Pergunta pergunta = new Pergunta(enunciado);
			
			System.out.print("Digite o número de opções: ");
			int numeroDeOpcoes = Integer.valueOf(sc.nextLine());
			
			for (int j = 1; j <= numeroDeOpcoes; j++) {
				System.out.printf("\tDigite o texto da %dº opção: ", j);
				String texto = sc.nextLine();
				System.out.printf("\tDigite o peso da %dº opção: ", j);
				int peso = Integer.valueOf(sc.nextLine());
				pergunta.adicionarOpcao(new Opcao (texto, peso));
			}
			
			enquete.adicionarPergunta(pergunta);
		}
		System.out.print("\n==============\nPerguntas e opções coletadas com sucesso!"
				+ "\nAgora insira quantas faixas de valores a enquete terá: ");
		int faixaValores = Integer.valueOf(sc.nextLine());
		for (int i = 1; i <= faixaValores; i++) {
			System.out.printf("--------\nDigite o valor MÍNIMO da %dº faixa de valores: ", i);
			int minimo = Integer.valueOf(sc.nextLine());
			System.out.printf("Digite o valor MÁXIMO da %dº faixa de valores: ", i);
			int maximo = Integer.valueOf(sc.nextLine());
			System.out.printf("Digite a resposta correspondente a %dº faixa de valores: ", i);
			String resposta = sc.nextLine();
			
			enquete.adicionarFaixaDeValores(new FaixaDeValores(minimo, maximo, resposta));
		}
		
		System.out.printf("\n•._.••´¯``•.¸¸.•` ENQUETE: %s •._.••´¯``•.¸¸.•`\n", enquete.getTitulo());
		int pontuacao = 0;
		
		for (Pergunta pergunta : enquete.getPerguntas()) {
			System.out.println(pergunta.getEnunciado() + " ");
			pergunta.exibirOpcoes();
			System.out.print("Digite a letra da opção escolhida: ");
			char opcaoSelecionada = sc.next().toUpperCase().charAt(0);
			int index = (int) opcaoSelecionada - 65;
			pontuacao += pergunta.getOpcoes().get(index).getPeso();
		}
		
		String resultado = enquete.calcularResultado(pontuacao);
		System.out.println("•._.••´¯``•.¸¸.•` RESULTADO ⋆ •._.••´¯``•.¸¸.•` ");
		System.out.println("Sua pontuação foi " + pontuacao + ". Isso significa que...\n" + resultado);
		sc.close();
	
	}
	
}

