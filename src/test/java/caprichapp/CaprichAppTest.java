package caprichapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dev.aleatorio.caprichapp.CaprichApp;

public class CaprichAppTest {
	
	@Test
	void resultadoParaPontuacaoIgualAZero() {
		assertEquals("☺ Você colocou seu melhor amigo na friendzone. O que é ótimo porque talvez ele seja apenas seu amigo.",
				CaprichApp.calcularResultado(0));
		
	}
	
	@Test
	void resultadoParaPontuacaoIgualATres() {
		assertEquals("Talvez haja amor, talvez seja hormônios. ☻ Vale a pena experimentar uns cinco minutos de trocação de beijo sem estragar a amizade.",
				CaprichApp.calcularResultado(3));
		
	}
	
	@Test
	void resultadoParaPontuacaoIgualASeis() {
		assertEquals("🎵 É o amor /Que mexe com minha cabeça e me deixa assim/ Que faz eu pensar em você e esquecer de mim/ Que faz eu esquecer que a vida é feita pra viver.",
				CaprichApp.calcularResultado(6));
		
	}
	
}
