package dev.aleatorio.caprichapp;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import dev.aleatorio.caprichapp.handler.QuestionarioHandler;

public class CaprichApp {
	private static final int PORTA = 8001;
	
	public static void main(String[] args) throws IOException {
		
		HttpServer server = HttpServer.create(new InetSocketAddress(PORTA), 0);
		System.out.println("Servidor rodando na porta " + PORTA);
		server.createContext("/caprichapp", new QuestionarioHandler.SemParametro());
		server.createContext("/caprichapp/", new QuestionarioHandler.ComParametro());
		server.setExecutor(null);
        server.start();
		
	}
	
}
