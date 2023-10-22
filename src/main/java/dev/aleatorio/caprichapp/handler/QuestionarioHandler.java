package dev.aleatorio.caprichapp.handler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import dev.aleatorio.caprichapp.dao.QuestionarioDaoFileSystem;
import dev.aleatorio.caprichapp.model.Questionario;

public class QuestionarioHandler implements HttpHandler{
	private final QuestionarioDaoFileSystem DAO = new QuestionarioDaoFileSystem();
	private List<Questionario> questionarios = DAO.findAll();
	private String response = parseResponse(questionarios);

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		exchange.getRequestMethod();
		exchange.sendResponseHeaders(200, response.length());
		System.out.println("RESPONSE: \n" + response);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.flush();
        outputStream.write(response.getBytes());
        outputStream.close();
	}
	
	private String parseResponse(List<Questionario> questionarios) {
		StringBuilder sb = new StringBuilder();
		for(Questionario ques : questionarios) {
			sb.append(DAO.converterQuestionarioEmJson(ques));
		}
		return sb.toString();
	}
	

}
