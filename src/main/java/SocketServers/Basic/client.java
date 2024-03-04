package main.java.SocketServers.Basic;

import java.net.*;
import java.io.*;

public class client {

    public static void main(String[] args) throws IOException {
        try {
            Socket s = new Socket("localhost", 4999);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
