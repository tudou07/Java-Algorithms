package main.java.SocketServers.OneWayCommunication;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws IOException {
        try{
            Socket s = new Socket("LocalHost", 4999);
            PrintWriter pr = new PrintWriter(s.getOutputStream());
            pr.println("Hello World ");
            pr.flush();
        } catch(IOException e){
            throw new RuntimeException();
        }
    }
}
