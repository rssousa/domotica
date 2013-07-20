package br.com.teste;

import java.io.*;
import java.net.*;

public class Teste {

	/**
	 * @param args
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		// TODO Auto-generated method stub

		Socket clientSocket = new Socket("192.168.0.150", 80);

		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

		String a = "a";

		outToServer.writeBytes(a);

		outToServer.flush();

		clientSocket.close();

	}

}
