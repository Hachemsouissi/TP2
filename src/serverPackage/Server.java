package serverPackage;

import operationPackage.Operation;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("le serveur attend la connexion d'un client");
            Socket socket = serverSocket.accept();
            System.out.println("un client est connecte");
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            PrintWriter pw =new PrintWriter(socket.getOutputStream(), true);
            Operation op = (Operation) ois.readObject();
            System.out.println("l'object est recu");
            int r=calcul(op);
            System.out.println("la resultat est = "+r);
            pw.println(r);
            System.out.println("la resultat est envoyée ");
            socket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static int calcul(Operation m){
        char o = m.getOperateur();
        int a=m.getA();
        int b=m.getB();
        switch(o){
            case '*' :return a*b;
            case '/' :return a/b;
            case  '+' :return a+b;
            case  '-' :return a-b;
            default:return 0;
        }
    }
}
