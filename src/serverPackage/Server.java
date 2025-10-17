package serverPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("le serveur attend la connexion d'un client");
            Socket socket = serverSocket.accept();
            System.out.println("un client est connecte");
            BufferedReader br =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw =new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner =new Scanner(System.in);
            String m =br.readLine();
            System.out.println("l'operation recu est : "+m);
            int r=calcul(m);
            System.out.println("la resultat est = "+r);
            pw.println(r);
            System.out.println("la resultat est envoyée ");
            socket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static int calcul(String m){
        m =m.replaceAll("\\s+", "");/*pour supprimer les espaces */
        String[] p =m.split("(?=[+\\-*/])|(?<=[+\\-*/])");
        int a = Integer.parseInt(p[0]);
        String o=p[1];
        int b = Integer.parseInt(p[2]);
        switch(o){
            case "*" :return a*b;
            case "/" :return a/b;
            case  "+" :return a+b;
            case  "-" :return a-b;
            default:return 0;
        }
    }
}
