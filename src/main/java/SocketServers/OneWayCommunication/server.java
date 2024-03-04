package main.java.SocketServers.OneWayCommunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException {
        try{
            ServerSocket ss = new ServerSocket(4999);
            Socket s = ss.accept();
            System.out.println("Client Connected");

            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            String str = bf.readLine();
            System.out.println(" Client: " + str);
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
}
