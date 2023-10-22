package dev.aleatorio.caprichapp.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import dev.aleatorio.caprichapp.model.Questionario;

public class QuestionarioDaoFileSystem implements QuestionarioDao {
	private static final Path DIRETORIO_BASE = Path.of("C:\\temp\\caprichapp");
	private static final Gson GSON = new Gson();
	

	@Override
	public List<Questionario> findAll(){
		try(var pathStream = Files.list(DIRETORIO_BASE)){
			return pathStream.map(arquivo -> extrairConteudo(arquivo))
				.map(conteudo -> converterJsonEmQuestionario(conteudo))
				.collect(Collectors.toList());
		} catch (IOException e) {
			throw new RuntimeException(e);
		} 
	}

	@Override
	public Questionario findById(Integer id) {
		return null;
	}

	@Override
	public void insert(Questionario questionario) {
		
	}

	@Override
	public void update(Questionario questionario) {
		
	}

	@Override
	public void deleteById(Integer id) {
		
	}
	
	public static Questionario converterJsonEmQuestionario(String conteudo) {
		return GSON.fromJson(conteudo, Questionario.class);
	}

	public static String converterQuestionarioEmJson(Questionario questionario) {
		return GSON.toJson(questionario); 
	}
	
	private static String extrairConteudo(Path arquivo) {
		StringBuilder sb = new StringBuilder();
		List<String> linhas;
		try {
			linhas = Files.readAllLines(arquivo);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		for(String linha : linhas) {
			sb.append(linha);
		}
		return sb.toString();
	}

}
