package dev.aleatorio.caprichapp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class CaprichApp {

	public static void main(String[] args) {
		
		List<String> bancoDePerguntas = new ArrayList<>();
		bancoDePerguntas.add("Você já sonhou em fazer uma viagem à Lua com seu melhor amigo?");
		bancoDePerguntas.add("Você acha que seu amigo é a reencarnação de um unicórnio?");
		bancoDePerguntas.add("Você já considerou mudar seu nome para Geleca apenas para combinar com o apelido do seu amigo?");
		bancoDePerguntas.add("Você acredita que seu amigo é secretamente um super-herói disfarçado?");
		bancoDePerguntas.add("Você já planejou uma festa surpresa de aniversário para o seu amigo no dia errado, só para ver a reação?");
		bancoDePerguntas.add("Você acha que seu amigo é a única pessoa capaz de decifrar porque o cocô das cabras é redondo e o do wombat é quadrado?");
		bancoDePerguntas.add("Você já pensou em criar um clube exclusivo para pessoas que usam pijamas de abacaxi nas segundas-feiras?");
		bancoDePerguntas.add("Você consegue segurar o tchan?");
		bancoDePerguntas.add("Você já considerou tatuar uma imagem de batata frita no braço em homenagem ao seu amigo?");
		bancoDePerguntas.add("Você já pensou em criar um podcast sobre teorias da conspiração envolvendo a vida secreta do seu melhor amigo?");
		bancoDePerguntas.add("Você acredita que seu amigo é a verdadeira inspiração por trás das músicas de karaokê?");
		bancoDePerguntas.add("Você acha que seu amigo possui um diploma honorário em Mímica Avançada?");
		bancoDePerguntas.add("Você acha que seu amigo é o verdadeiro criador das terríveis baratas voadas?");
		
			
		System.out.println("♥♥♥♥♥♥♥♥ CAPRICHAPP ♥♥♥♥♥♥♥♥");
		System.out.println("Você está a fim do seu melhor amigo? Para cada pergunta, responda S para sim ou N para não");
		System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");
		
		int pontuacao = 0;
		
		Set<String> perguntasSelecionadas = obterPerguntasAleatorias(bancoDePerguntas);		
		Scanner sc = new Scanner(System.in);
		
		for (String pergunta : perguntasSelecionadas) {
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
	
	public static Set<String> obterPerguntasAleatorias(List<String> bancoDePerguntas) {
		Set<String> perguntasSelecionadas = new HashSet<>();
		Random random = new Random();
        while(perguntasSelecionadas.size() != 5) {
            perguntasSelecionadas.add(bancoDePerguntas.get(random.nextInt(bancoDePerguntas.size())));
        }
        return perguntasSelecionadas;
	}
}

