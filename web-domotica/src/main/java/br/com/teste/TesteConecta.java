package br.com.teste;


import javax.swing.JOptionPane;

public class TesteConecta {

	public static void main(String[] args) {

		Conecta conecta = Conecta.getInstance();
System.out.println("================");
		String a = "n";
	//	do {
			//String saida = JOptionPane.showInputDialog("Digite a letra - a - para acionar ou - b - para apagar");
 
			System.out.println("");
			System.out.println(conecta.testa());

			char dado = 'a';

			conecta.enviaDados(dado);

			//a = JOptionPane.showInputDialog("Digite a letra -> s  para encerrar");

		//} while (!a.equalsIgnoreCase("s"));

	}

}
