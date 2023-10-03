package dev.aleatorio.caprichapp;

public class CaprichApp {

	public static void main(String[] args) {
		
		System.out.println("♥♥♥♥♥♥♥♥ CAPRICHAPP ♥♥♥♥♥♥♥♥");
	
	}
	
	public static String calcularResultado(int pontuacao) {
		if(pontuacao < 0) {
			throw new IllegalArgumentException("Erro: A pontuação não pode ser negativa");
		}
		if(pontuacao >= 0 && pontuacao <= 2) {
			return "☺ Você colocou seu melhor amigo na friendzone. O que é ótimo porque talvez ele seja apenas seu amigo.";
		} else if (pontuacao >= 3 && pontuacao <= 4) {
			return "Talvez haja amor, talvez seja hormônios. ☻ Vale a pena experimentar uns cinco minutos de trocação de beijo sem estragar a amizade.";
		} else {
			return "🎵 É o amor /Que mexe com minha cabeça e me deixa assim/ Que faz eu pensar em você e esquecer de mim/ Que faz eu esquecer que a vida é feita pra viver.";
		}
	}
}

