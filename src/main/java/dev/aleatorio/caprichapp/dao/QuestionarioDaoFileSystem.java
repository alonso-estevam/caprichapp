package dev.aleatorio.caprichapp.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import dev.aleatorio.caprichapp.model.Questionario;

public class QuestionarioDaoFileSystem implements QuestionarioDao {
	private static final Path DIRETORIO_BASE = Path.of("C:\\temp\\caprichapp");
	private static final String TEMPLATE_NOME_DO_ARQUIVO = 
			DIRETORIO_BASE.toString() + File.separator + "questionario_${id}.txt";
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
		Path arquivo = Path.of(TEMPLATE_NOME_DO_ARQUIVO.replace("${id}", String.valueOf(id)));
		StringBuilder sb = new StringBuilder();
		try {
			for(String linha : Files.readAllLines(arquivo)) {
				sb.append(linha);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return converterJsonEmQuestionario(sb.toString());
	}

	@Override
	public void insert(Questionario questionario) {
		salvarJsonEmArquivo(converterQuestionarioEmJson(questionario), questionario.getId());
	}

	@Override
	public void update(Integer id, Questionario questionario) {
		deleteById(id);
		questionario.setId(id);
		insert(questionario);
	}

	@Override
	public void deleteById(Integer id) {
		Path arquivo = Path.of(TEMPLATE_NOME_DO_ARQUIVO.replace("${id}", String.valueOf(id)));
		try {
			Files.deleteIfExists(arquivo);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Questionario converterJsonEmQuestionario(String conteudo) {
		return GSON.fromJson(conteudo, Questionario.class);
	}

	public static String converterQuestionarioEmJson(Questionario questionario) {
		return GSON.toJson(questionario); 
	}
	
	public static void salvarJsonEmArquivo(String json, Integer id) {
		Path arquivo = Path.of(TEMPLATE_NOME_DO_ARQUIVO.replace("${id}", String.valueOf(id)));
		try {
			if(Files.createFile(arquivo) != null) {
				Files.writeString(arquivo, json);
			}
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
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
