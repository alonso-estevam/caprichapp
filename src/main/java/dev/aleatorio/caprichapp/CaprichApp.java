package dev.aleatorio.caprichapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

import dev.aleatorio.caprichapp.model.FaixaDeValores;
import dev.aleatorio.caprichapp.model.Opcao;
import dev.aleatorio.caprichapp.model.Pergunta;
import dev.aleatorio.caprichapp.model.Questionario;

public class CaprichApp {
	private static final String DIRETORIO_BASE = "C:\\temp\\caprichapp";
	private static final Gson GSON = new Gson();
	
	public static void main(String[] args) {
		File diretorioBase = new File(DIRETORIO_BASE);
		
		if(!diretorioBase.exists()) {
			diretorioBase.mkdirs();
		}
		
		List<Questionario> bancoDeQuestionarios = carregarBancoQuestionarios(diretorioBase);
		
		int ultimoId = getUltimoId(bancoDeQuestionarios);
	
		
		Scanner sc = new Scanner(System.in);

		System.out.println("♥♥♥♥♥♥♥♥ 𝓒𝓪𝓹𝓻𝓲𝓬𝓱𝓐𝓹𝓹 ♥♥♥♥♥♥♥♥");
		System.out.println("(っ◔◡◔)っ CADASTRO DE QUESTIONÁRIOS");
		

		
		
		sc.close();
		
				
	}

	private static int getUltimoId(List<Questionario> bancoDeQuestionarios) {
		return bancoDeQuestionarios.stream()
				.mapToInt(Questionario::getId) //IntStream
				.max() // OptionalInt
				.orElse(0); // int
	}

	private static void listarTodos(List<Questionario> bancoDeQuestionarios) {
		for(Questionario ques : bancoDeQuestionarios) {
			System.out.println("Id: " + ques.getId() + "; Título: " + ques.getTitulo());
		}
	}

	private static void cadastrar(Scanner sc, int ultimoId) {
		Questionario questionario = new Questionario();
		
		questionario.setId(ultimoId+1);
		
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
		
		String json = converterQuestionarioEmJson(questionario);
		
		salvarJsonEmArquivo(json, questionario);
		
		System.out.println("Questionário cadastrado com sucesso!");
	}
	
	private static List<Questionario> carregarBancoQuestionarios(File diretorioBase){
		List<Questionario> bancoDeQuestionarios = new ArrayList<>();
		File[] arquivos = diretorioBase.listFiles();
		if(arquivos != null) {
			for(File arquivo : arquivos) {
				String conteudo = extrairConteudo(arquivo);
				bancoDeQuestionarios.add(converterJsonEmQuestionario(conteudo));
			}
		}
		
		return bancoDeQuestionarios;
	}
	
	private static String extrairConteudo(File arquivo) {
		StringBuilder sb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
			String linha;
			while((linha = br.readLine()) != null) {
				sb.append(linha);
			}
			return sb.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static Questionario converterJsonEmQuestionario(String conteudo) {
		return GSON.fromJson(conteudo, Questionario.class);
	}

	private static String converterQuestionarioEmJson(Questionario questionario) {
		return GSON.toJson(questionario); 
	}
	
	private static void salvarJsonEmArquivo(String json, Questionario ques) {
		String nomeDoArquivo = String.format("%s%squestionario_%d.txt", 
				DIRETORIO_BASE, File.separator, ques.getId()); 
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(nomeDoArquivo))){
			bw.write(json);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
			
	} 
	
}

