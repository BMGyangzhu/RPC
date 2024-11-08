package com.yangzhu.rpc.server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author bgmyangzhu
 * @date 2024/11/8 20:22
 */
public class Server {
    private static final Integer port = 12345;

    public static void main(String[] args) throws IOException {
        run();
    }

    public static void run() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        

        try(Socket socket = serverSocket.accept()){
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            
            String message;
            while((message = reader.readLine()) != null){
                System.out.println("Received: " + message);
            }

            System.out.println("Client disconnected");
        }finally {
            serverSocket.close();
        }
    }
}
