package itismeucci.tpsit;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 6789;
        
        try {
            Socket socket = new Socket(serverAddress, serverPort);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            out.println("Ciao server!");
            
            String response = in.readLine();
            System.out.println("Server: " + response);

            socket.close();
        } catch (IOException e) {

        }
    }
}
