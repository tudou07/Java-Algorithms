package main.java.SocketServers.Basic;

import java.net.*;
import java.io.*;

public class server {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket ss = new ServerSocket(4999);
            Socket s = ss.accept();

            System.out.println("Client Connected");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
