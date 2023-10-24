package dev.aleatorio.caprichapp.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import dev.aleatorio.caprichapp.dao.QuestionarioDaoFileSystem;
import dev.aleatorio.caprichapp.model.Questionario;

public class QuestionarioHandler {
	private static final QuestionarioDaoFileSystem DAO = new QuestionarioDaoFileSystem();
	
	public static class SemParametro implements HttpHandler{
		private List<Questionario> questionarios = DAO.findAll();
		private String response = parseResponse(questionarios);

		@Override
		public void handle(HttpExchange exchange) throws IOException {
			if("POST".equals(exchange.getRequestMethod())) {
				StringBuilder requestBody = new StringBuilder();
				try(BufferedReader br = new BufferedReader(new InputStreamReader(
						exchange.getRequestBody(), StandardCharsets.UTF_8))){
					String linha = null;
					while((linha = br.readLine()) != null) {
						requestBody.append(linha);
					}
				} catch(IOException e) {
					throw new RuntimeException(e);
				}
				Questionario questionario = 
						QuestionarioDaoFileSystem.converterJsonEmQuestionario(requestBody.toString());
				
				int ultimoId = getUltimoId(questionarios);
				
				questionario.setId(++ultimoId);
				
				DAO.insert(questionario);
				
				response = "Questionario com id %d criado com sucesso!".formatted(questionario.getId());
				exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
				exchange.sendResponseHeaders(201, response.getBytes().length);
		        OutputStream outputStream = exchange.getResponseBody();
		        outputStream.write(response.getBytes());
		        outputStream.flush();
		        outputStream.close();
		        
			} else {
				exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
				exchange.sendResponseHeaders(200, response.getBytes().length);
		        OutputStream outputStream = exchange.getResponseBody();
		        outputStream.write(response.getBytes());
		        outputStream.flush();
		        outputStream.close();
			}
		}

		private Integer getUltimoId(List<Questionario> questionarios) {
			return questionarios.stream()
				.mapToInt(Questionario::getId)
				.max()
				.orElse(0);
		}
		
		private String parseResponse(List<Questionario> questionarios) {
			StringBuilder sb = new StringBuilder();
			for(Questionario ques : questionarios) {
				sb.append(QuestionarioDaoFileSystem.converterQuestionarioEmJson(ques));
			}
			return sb.toString();
		}
	}
	
	public static class ComParametro implements HttpHandler{
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			String requestURI = exchange.getRequestURI().getPath();
			Integer id = null;
			
			String[] parts = requestURI.split("/");
			if(parts.length > 0) {
				id = Integer.valueOf(parts[2]);
			}
			
			if("DELETE".equals(exchange.getRequestMethod())) {
				DAO.deleteById(id);
				String response = "Questionario com id %d deletado com sucesso!".formatted(id);
				exchange.getResponseHeaders().set("Content-Type", "text/html, application/json; charset=UTF-8");
				exchange.sendResponseHeaders(200, response.getBytes().length);
				OutputStream outputStream = exchange.getResponseBody();
				outputStream.write(response.getBytes());
				outputStream.flush();
				outputStream.close();
				
			} else if("PUT".equals(exchange.getRequestMethod())) {
				StringBuilder requestBody = new StringBuilder();
				try(BufferedReader br = new BufferedReader(new InputStreamReader(
						exchange.getRequestBody(), StandardCharsets.UTF_8))){
					String linha = null;
					while((linha = br.readLine()) != null) {
						requestBody.append(linha);
					}
				} catch(IOException e) {
					throw new RuntimeException(e);
				}
				Questionario questionario = 
						QuestionarioDaoFileSystem.converterJsonEmQuestionario(requestBody.toString());
				
				DAO.update(id, questionario);
				
				String response = "Questionario com id %d atualizado com sucesso!".formatted(questionario.getId());
				exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
				exchange.sendResponseHeaders(201, response.getBytes().length);
		        OutputStream outputStream = exchange.getResponseBody();
		        outputStream.write(response.getBytes());
		        outputStream.flush();
		        outputStream.close();
		        
			} else {
				String response = QuestionarioDaoFileSystem.converterQuestionarioEmJson(DAO.findById(id));
				exchange.getResponseHeaders().set("Content-Type", "text/html, application/json; charset=UTF-8");
				exchange.sendResponseHeaders(200, response.getBytes().length);
				OutputStream outputStream = exchange.getResponseBody();
				outputStream.write(response.getBytes());
				outputStream.flush();
				outputStream.close();
			}
		}
	}
}
