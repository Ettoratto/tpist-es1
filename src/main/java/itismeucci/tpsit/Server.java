package itismeucci.tpsit;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 6789;
        
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Il server aspetta che il client si connetta sulla porta: " + port);
            
            Socket clientSocket = server.accept();
            
            System.out.println("Client connesso!");
            

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            String message;
            
            while ((message = in.readLine()) != null) {
                System.out.println("Client: " + message);
                
                out.println("Server: la stringa del client e': " + message.toUpperCase());
            }

            server.close();
        } catch (IOException e) {

        }
    }
}