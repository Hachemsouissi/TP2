package clientPackage;
import operationPackage.Operation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            System.out.println("connecté au serveur");
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            System.out.print("entrez le premier nombre");
            int a = scanner.nextInt();
            System.out.print("entrez l'opérateur");
            char op = scanner.next().charAt(0);
            System.out.print("entrez le deuxieme nombre");
            int b = scanner.nextInt();
            Operation operation = new Operation(a, b, op);
            oos.writeObject(operation);
            oos.flush();
            System.out.println("object envoyée");
            String r = br.readLine();
            System.out.println("la resultat est = " + r);

            scanner.close();
            socket.close();
            System.out.println("le client est deconnecté ");

        } catch (Exception e) {
            System.out.println(e);
        }
    }}

