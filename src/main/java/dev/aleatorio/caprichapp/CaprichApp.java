package dev.aleatorio.caprichapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;

import dev.aleatorio.caprichapp.model.FaixaDeValores;
import dev.aleatorio.caprichapp.model.Opcao;
import dev.aleatorio.caprichapp.model.Pergunta;
import dev.aleatorio.caprichapp.model.Questionario;

public class CaprichApp {
	private static final String DIRETORIO_BASE = "C:\\temp\\caprichapp";
	
	public static void main(String[] args) {
		File diretorioBase = new File(DIRETORIO_BASE);
		
		if(!diretorioBase.exists()) {
			diretorioBase.mkdirs();
		}
		

		Questionario questionario = new Questionario();
		Scanner sc = new Scanner(System.in);

		System.out.println("♥♥♥♥♥♥♥♥ 𝓒𝓪𝓹𝓻𝓲𝓬𝓱𝓐𝓹𝓹 ♥♥♥♥♥♥♥♥");
		System.out.println("(っ◔◡◔)っ CADASTRO DE QUESTIONÁRIOS");

		System.out.print("\nQual o título do questionário? ");
		questionario.setTitulo(sc.nextLine());
		
		System.out.print("Quantas perguntas você deseja fazer? ");
		questionario.setNumeroDePerguntas(Integer.valueOf(sc.nextLine()));
		
		for (int i = 1; i <= questionario.getNumeroDePerguntas(); i++) {
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
			
			questionario.adicionarPergunta(pergunta);
		}
		System.out.print("\n==============\nPerguntas e opções coletadas com sucesso!"
				+ "\nAgora insira quantas faixas de valores a questionario terá: ");
		int faixaValores = Integer.valueOf(sc.nextLine());
		for (int i = 1; i <= faixaValores; i++) {
			System.out.printf("--------\nDigite o valor MÍNIMO da %dº faixa de valores: ", i);
			int minimo = Integer.valueOf(sc.nextLine());
			System.out.printf("Digite o valor MÁXIMO da %dº faixa de valores: ", i);
			int maximo = Integer.valueOf(sc.nextLine());
			System.out.printf("Digite a resposta correspondente a %dº faixa de valores: ", i);
			String resposta = sc.nextLine();
			
			questionario.adicionarFaixaDeValores(new FaixaDeValores(minimo, maximo, resposta));
		}
		
		sc.close();
		
		questionario.setId(1);
		
		System.out.println();
		
		String json = converterQuestionarioEmJson(questionario);
		
		salvarJsonEmArquivo(json, questionario);
				
	}
	
	private static String converterQuestionarioEmJson(Questionario questionario) {
		Gson gson = new Gson();
		return gson.toJson(questionario); 
	}
	
	private static void salvarJsonEmArquivo(String json, Questionario ques) {
		String nomeDoArquivo = String.format("%s%squestionario_%d.txt", 
				DIRETORIO_BASE, File.separator, ques.getId()); 
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(nomeDoArquivo))){
			bw.write(json);
			System.out.println("Arquivo salvo com sucesso!");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
			
	} 
	
}

