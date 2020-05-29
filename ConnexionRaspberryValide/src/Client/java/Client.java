package Client.java;

import java.net.*;
import java.io.*;


public class Client{
	private static Socket s;
		//Parametre de connexion au "serveur"
	public static void main(String[] args) throws IOException{
		s = new Socket("172.29.10.230", 4999);
		
		//Envoi message
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		pr.println("Hello World!");
		pr.flush();
		//Recevoir message
		InputStreamReader in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		//Afficher message console
		String str = bf.readLine();
		System.out.println("Reponse: " + str);
	}
} 