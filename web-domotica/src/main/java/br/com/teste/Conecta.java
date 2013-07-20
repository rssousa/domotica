package br.com.teste;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Conecta {

	private static Conecta instancia = null;
	private String ip = "192.168.0.150";
	private int port = 80;
	private Socket socket;

	// Cria uma instancia da classe para armazenar os dados
	private Conecta() {
		conexao();
		System.out.println(socket.getInetAddress().getHostAddress());
		System.out.print("O cliente "
				+ socket.getLocalAddress().getHostAddress()
				+ "conectou ao servidor");

	}

	// getInstance para pegar somente uma instancia
	public static Conecta getInstance() {
		if (instancia == null) {
			instancia = new Conecta();
		}
		return instancia;

	}

	// Cria a conexão com a placa -- Não consegui fazer conectar somente uma vez
	private synchronized void conexao() {
		try {

			socket = new Socket(ip, port);

		} catch (UnknownHostException e) {
			System.out.println("Erro UnknownHost");

		} catch (IOException e) {
			System.out.println("Erro I/O");

		}
	}

	// Elimina a instancia da classe Conecta e fecha o socket
	public synchronized void setDeath() {
		try {
			socket.close();
			instancia = null;

		} catch (IOException e) {

			e.printStackTrace();
		}
		instancia = null;
	}

	// Metodo principal que envia os dados para a placa, necessitou criar a
	// conexao a cada uso. Deve ter outro jeito de fazer
	// mas eu não consegui até agora

	public synchronized void enviaDados(char dado) {

		try {
			conexao();
			new PrintStream(socket.getOutputStream()).print(dado);
			encerraSocket();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// metodo para fechar a conexao do socket

	private void encerraSocket() throws IOException {
		socket.close();
	}

	// metodo para testar a conexao
	public boolean testa() {
		return socket.isConnected();
	}

}
