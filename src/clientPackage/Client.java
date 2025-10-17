package clientPackage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 1234 );
            System.out.println("connecté au serveur");
            BufferedReader br =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw =new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner =new Scanner(System.in);
            System.out.println("entrez une opération");
            String op = scanner.nextLine();
            pw.println(op);
            if (valide(op).equals("valide")) {
                System.out.println("operation envoyée");
                String r = br.readLine();
                System.out.println("la resultat est = " + r);
            }
            else{
                System.out.println(valide(op));

            }
            scanner.close();
            socket.close();
            System.out.println("le client est deconnecté ");

        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static String valide(String op) {
        if (op.isEmpty()) {
            return "l'operation est vide ";
        }
        op =op.replaceAll("\\s+", "");/*pour supprimer les espaces */
        String[] p =op.split("[+\\-*/]");
        if (p.length != 2) {
            return "operation n'est pas valide ";
        }
        try {
            Integer.parseInt(p[0]);
            Integer.parseInt(p[1]);
        }catch(NumberFormatException e){
        return "format numerique invalide";
        }
        return "valide";

    }
}
